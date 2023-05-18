package ictgradschool.industry.swingworker.examples.example05.wordsearch;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingWorker.StateValue;

/**
 * The window that displays our controls for searching.
 * 
 * @author Albert Attard @ Java Creed
 * @see http://www.javacreed.com/swing-worker-example/
 *
 * @author John Thompson, UoW, PGCInfoTech
 */
public class Application extends JFrame implements ActionListener, PropertyChangeListener {

	/** Version ID all serializable objects have. */
	private static final long serialVersionUID = -8668818312732181049L;

	/** Click this button to start/stop a search */
	private JButton searchButton;
	
	/** Click this button to open the filechooser dialog */
	private JButton browseButton;

	/** The word to search for. */
	private JTextField wordTextField;

	/**
	 * The directory in which to search for txt files containing the target
	 * word.
	 */
	private JTextField directoryPathTextField;

	/** The large text area used for feedback from out search process. */
	private JTextArea messagesTextArea;

	/**
	 * Swing provides a built-in progress bar component that we will use to
	 * measure progress (we know how many files we have to search, so can use
	 * that to determine a rough number for percent complete).
	 */
	private JProgressBar searchProgressBar;

	private SearchForWordWorker searchWorker;

	/**
	 * Constructor.
	 */
	public Application() {
		// we haven't done GridBagLayouts, but rest assured it's a pretty
		// complex layout scheme...
		setLayout(new GridBagLayout());
		// ...where you set up 'constraints' (think subpanels)...
		GridBagConstraints constraints = new GridBagConstraints();
		// ...that have some fixed width grid...
		constraints.gridx = 0;
		constraints.gridy = 0;
		// ...and margin...
		constraints.insets = new Insets(2, 2, 2, 2);
		// ...and then when you add the component you 'anchor' it with the
		// constraint.
		add(new JLabel("Word: "), constraints);

		wordTextField = new JTextField();
		wordTextField.setText("Hello");
		constraints = new GridBagConstraints();
		constraints.gridx = 1;
		constraints.gridy = 0;
		constraints.gridwidth = 2;
		constraints.insets = new Insets(2, 2, 2, 2);
		constraints.weightx = 1;
		constraints.fill = GridBagConstraints.BOTH;
		add(wordTextField, constraints);

		constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.insets = new Insets(2, 2, 2, 2);
		add(new JLabel("Path: "), constraints);

		directoryPathTextField = new JTextField();
		directoryPathTextField.setText("C:\\");
		constraints = new GridBagConstraints();
		constraints.gridx = 1;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.insets = new Insets(2, 2, 2, 2);
		constraints.weightx = 1;
		constraints.fill = GridBagConstraints.BOTH;
		add(directoryPathTextField, constraints);

		constraints = new GridBagConstraints();
		constraints.gridx = 2;
		constraints.gridy = 1;
		constraints.insets = new Insets(2, 2, 2, 2);
		browseButton = new JButton("Browse");
		browseButton.addActionListener(this); // Listen for click events
		add(browseButton, constraints); 

		messagesTextArea = new JTextArea();
		messagesTextArea.setEditable(false);
		constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 2;
		constraints.gridwidth = 3;
		constraints.insets = new Insets(2, 2, 2, 2);
		constraints.weightx = 1;
		constraints.weighty = 1;
		constraints.fill = GridBagConstraints.BOTH;
		add(new JScrollPane(messagesTextArea), constraints);

		// @see javax.swing.JProgressBar()
		searchProgressBar = new JProgressBar();
		searchProgressBar.setStringPainted(true);
		searchProgressBar.setVisible(false);
		constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 3;
		constraints.gridwidth = 2;
		constraints.insets = new Insets(2, 2, 2, 2);
		constraints.weightx = 1;
		constraints.fill = GridBagConstraints.BOTH;
		add(searchProgressBar, constraints);

		constraints = new GridBagConstraints();
		constraints.gridx = 2;
		constraints.gridy = 3;
		constraints.insets = new Insets(2, 2, 2, 2);
		constraints.weightx = 0;
		searchButton = new JButton("Search");
		searchButton.addActionListener(this); // Listen for click events
		add(searchButton, constraints); 

	}
	/** Application(void) => Application **/

	
	@Override
	/**
	 * Process the button clicks.
	 * 
	 * @param e
	 *           an ActionEvent describing the event that occurred
	 */
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		// Open a file browser to choose the directory to search
		if (source == browseButton) {
			// might as well open the dialog to whatever directory is already
			// chosen
			final File dir = new File(directoryPathTextField.getText()).getAbsoluteFile();
			final JFileChooser fileChooser = new JFileChooser(dir.getParentFile());
			// configure the file chooser to only allow directories to be
			// chosen
			fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			// showOpenDialog() blocks until the user selects a directory and
			// 'approves' by clicking the Ok button
			final int option = fileChooser.showOpenDialog(Application.this);
			if (option == JFileChooser.APPROVE_OPTION) {
				final File selected = fileChooser.getSelectedFile();
				// update the textfield in the GUI. Note that, since this
				// action has come from the EDT there is no need to use
				// invoke later.
				directoryPathTextField.setText(selected.getAbsolutePath());
			}
		}
		// The search button doubles as the cancel button. If there is
		// no searchWorker create one and start searching, otherwise
		// stop searching.		
		else if (source == searchButton) {
			if (searchWorker == null) {
				this.search();
			} else {
				this.cancel();
			}	
		}
	}
	/** actionPerformed(ActionEvent) => void **/
	
	
	/**
	 * Called from a searchCancelAction, this action stops a currently running
	 * search.
	 */
	private void cancel() {
		// SwingWorkers have a method cancel() that can be used to immediately
		// stop them. The argument specifies if the method should trigger an
		// interrupt if the SwingWorker thread is running.
		searchWorker.cancel(true);
	}
	/** cancel(void) => void **/

	/**
	 * Create a SearchForWordWorker to do the actual (long running) search.
	 * Since this is called from the EDT we need to make this method as
	 * short-lived as possible.
	 */
	private void search() {
		// The word we will search for...
		final String word = wordTextField.getText();
		
		// The directory we'll search in...
		final File directory = new File(directoryPathTextField.getText());

		// It is thread-safe to update the TextArea has as we are already in
		// the EDT (and no other events can be processed, i.e. updates,
		// repaints etc)
		messagesTextArea.setText("Searching for word '" + word + "' in text files under: " + directory.getAbsolutePath() + "\n");

		// Create our new worker passing in references to all the things it
		// needs to do its job
		searchWorker = new SearchForWordWorker(word, directory, messagesTextArea);
		searchWorker.addPropertyChangeListener(this);
		// Execute() is what actually creates a new Thread and then calls the
		// doInBackground() method of the worker. It will also automatically
		// call the done() method once the doInBackground() is complete.
		searchWorker.execute();
		// Execute() doesn't block, so it will immediately return and then
		// return from the search() method (which, in turn, returns from the
		// actionPerformed() and allows the EDT to continue).
	}
	/** search(void) => void **/
	

	@Override
	/**
	 * We register ourselves as being interested when the properties of the
	 * SwingWorker change and in particular when the 'progress' property
	 * is updated.
	 * 
	 * @param event
	 */
	public void propertyChange(final PropertyChangeEvent event) {
		switch (event.getPropertyName()) {
		// We talked about the property "progress" in the lecture
		case "progress":
			searchProgressBar.setIndeterminate(false);
			// - note that the number coming out of the progress event is of
			//   the Integer class, not an int primitive
			searchProgressBar.setValue((Integer) event.getNewValue());
			break;
		// I mentioned "state" in passing, but there is an enumeration of
	    // values (DONE, STARTED, PENDING etc) that can be used to determine
		// what the SwingWorker is currently doing. Most of these are automat-
		// ically set by Java.
		case "state":
			switch ((StateValue) event.getNewValue()) {
			case DONE:
				searchProgressBar.setVisible(false);
				searchButton.setText("Search");
				searchWorker = null;
				break;
			// In practice you can't tell which of these states you'll see as
			// you have no control over how quickly your worker actually gets
		    // started.
			case STARTED: // Once the Worker starts
			case PENDING: // Before the Worker starts
				searchButton.setText("Cancel");
				searchProgressBar.setVisible(true);
				// an 'intederminate' progress bar just has a coloured in bit
				// that bounces back and forth... this is useful for when you
				// can't measure progress (the first thing the Worker does is
				// count the txt files in the directory, whereupon we can
				// have an idea of how far through we are)
				searchProgressBar.setIndeterminate(true);
				break;
			}
			break;
		}
	}
	/** propertyChange(PropertyChangeEvent) => void **/

}
