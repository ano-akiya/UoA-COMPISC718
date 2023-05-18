package ictgradschool.industry.designpatterns.examples.filestore;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.concurrent.ExecutionException;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.SwingWorker;
import javax.swing.tree.TreeModel;

/**
 * Simple application class to demonstrate class TreeModelAdapter. A
 * TreeModelAdapter class is used to display the contents of a Directory/File
 * hierarchical structure in a JTree component.
 * 
 */
public class FileStoreViewer extends JFrame {
	private Directory _root;
	
	private JDialog _dialog;

	public FileStoreViewer() {
		super("FileStoreViewer");
		
		// Display a dialog containing a progress bar while the SwingWorker is
		// in progress.
		buildProgressDialog();

		// Create and execute a SwingWorker to read the directory structure in
		// a background thread.
		Worker worker = new Worker();
		worker.execute();
	}

	public static void main(String[] args) {
		new FileStoreViewer();
	}

	private void buildProgressDialog() {
		JTextArea msgLabel;
		JProgressBar progressBar;
		final int MAXIMUM = 100;
		JPanel panel;

		progressBar = new JProgressBar(0, MAXIMUM);
		progressBar.setIndeterminate(true);
		msgLabel = new JTextArea("Reading directory structure");
		msgLabel.setEditable(false);

		panel = new JPanel(new BorderLayout(5, 5));
		panel.add(msgLabel, BorderLayout.PAGE_START);
		panel.add(progressBar, BorderLayout.CENTER);
		panel.setBorder(BorderFactory.createEmptyBorder(11, 11, 11, 11));

		_dialog = new JDialog();
		_dialog.add(panel);
		_dialog.setResizable(false);
		_dialog.pack();
		_dialog.setSize(500, _dialog.getHeight());
		_dialog.setLocationRelativeTo(null);
		_dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		_dialog.setAlwaysOnTop(false);
		_dialog.setVisible(true);
		msgLabel.setBackground(panel.getBackground());
	}

	private void buildGUI() {
		// Create adapter to be used between the root Directory object and the
		// JTree view.
		TreeModel model = new FileStoreTreeModelAdapter(_root);

		// Create the view component (a JTree).
		JTree view = new JTree(model);

		// Layout the GUI, enabling dynamic scroll bars.
		JScrollPane treeScrollPane = new JScrollPane(view);
		this.add(treeScrollPane);

		// Quit the application when the window is closed. 
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	/*
	 * SwingWorker class to handle reading of the user's directory structure in
	 * a background thread.
	 */
	private class Worker extends SwingWorker<Directory, Void> {
		
		@Override
		protected Directory doInBackground() {
			// Build a representation of the directory structure.
			return FileFactory.makeFileStore();
		}

		@Override
		protected void done() {
			try {
				// Retrieve the representation of the directory structure.
				_root = get();
				
				// Destroy the dialog box containing the progress bar.
				_dialog.dispose();
				
				// Display the JTree to show the directory structure.
				buildGUI();
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
	}
}