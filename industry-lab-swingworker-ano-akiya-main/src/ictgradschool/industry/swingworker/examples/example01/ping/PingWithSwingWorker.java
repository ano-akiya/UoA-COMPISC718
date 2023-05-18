package ictgradschool.industry.swingworker.examples.example01.ping;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.net.HttpURLConnection;
import java.util.concurrent.ExecutionException;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingWorker;

/**
 * Class for a simple program to allow a user to ping a Web server for 
 * availability. The user enters a string (URL) to identify the Web server, 
 * plus a timeout period in milliseconds. A timeout value of 0 means that there
 * is no timeout limit for pinging the server. In response to clicking the 
 * "PingWithSwingWorker!" button, the application attempts to ping the given server. The
 * programme displays a message as to whether the server was successfully 
 * pinged within any given timeout period.
 * 
 * Class PingWithSwingWorker is a subclass of JPanel, meaning that a PingWithSwingWorker object can be added
 * to a Swing GUI application.
 * 
 * PingWithSwingWorker contains an internal class, PingWorker, which handles the network
 * communication using a separate thread. This ensures that the application 
 * remains responsive to user input, including window moving/re-sizing 
 * operations.
 *
 */
public class PingWithSwingWorker extends JPanel {

    // GUI components which need to be accessed in multiple places.
    private JButton btnPing;
    private JLabel lblHostStatus;

    /**
     * Internal class that implements the logic to make a network call to a Web server. An instance of PingWorker
     * stores the URL for the server to ping, a timeout value, and a JLabel component to update once the task has
     * finished.
     */
	private class PingWorker extends SwingWorker<Boolean, Void> {
		private String _targetUrl;
		private int _timeout;

		public PingWorker(String targetUrl, int timeout) {
			_targetUrl = targetUrl;
			_timeout = timeout;
		}

        /**
         * Overrides doInBackground(). This methods runs in a separate (worker) thread that is managed by the
         * Swing framework. Being executed by a background thread, the code in this method does not block or
         * interfere with the GUI Event Dispatch thread that processes user input.
         *
         * @return true if the ping was successful, false otherwise.
         */
		@Override
		public Boolean doInBackground() {
			return ping(_targetUrl, _timeout);
		}
		
        /**
         * Overrides done(). This method is called automatically by the Swing framework's Event Dispatch thread after
         * the task has finished (i.e. after doInBackground() has completed executing). Since it's called from the
         * Event Dispatch thread, this method can safely update any GUI components (e.g. _lblHostStatus). In this case
         * this JLabel object is updated with the outcome of pinging the Web server.
         */
		@Override
		public void done() {
			boolean result = false;

            btnPing.setEnabled(true);

			try {
				result = get();
				if(result == true) {
					lblHostStatus.setText("Successfully pinged " + _targetUrl);
				} else {
					lblHostStatus.setText("Unable to ping " + _targetUrl);
				}
				
			} catch (InterruptedException | ExecutionException e) {
				// No action required.
			}
		}
	}

    /**
     * Attempts to ping the requested URL. Returns a value indicating whether the ping was successful within the
     * given timeout period.
     *
     * @param targetUrl the URL to ping
     * @param timeout the number of milliseconds to wait for the response
     * @return true if the ping was successful within the given timeout, false otherwise
     */
    private boolean ping(String targetUrl, int timeout) {
        boolean success = false;

        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(targetUrl).openConnection();
            connection.setConnectTimeout(timeout);
            connection.setReadTimeout(timeout);
            connection.setRequestMethod("HEAD");

            int responseCode = connection.getResponseCode();
            success =  (200 <= responseCode && responseCode <= 399);
        } catch (IOException exception) {
            // No action required.
        }
        return success;
    }

    /**
     * Creates and shows the GUI.
     */
	private static void createAndShowGUI() {
        // Create and set up the window.
        JFrame frame = new JFrame("Web Server PingWithSwingWorker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create and set up the content pane.
        JComponent newContentPane = new PingWithSwingWorker();
        frame.add(newContentPane);
        
        // Display the window, centered on the screen.
        frame.pack();
        frame.setLocationRelativeTo(null); 
        frame.setResizable(false);
        frame.setVisible(true);
    }

    /**
     * Program entry point. Schedules the createAndShowGUI() method to be run on the ED thread.
     */
    public static void main(String[ ] args) {
        // Schedule a job for the event-dispatching thread: creating and showing
    	// this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
    
    /**
     * Constructor method to create the PingWithSwingWorker application's GUI.
     */
    public PingWithSwingWorker() {
    	// Create basic GUI components.
    	JLabel lblHost = new JLabel("Web server host");
    	JLabel lblTimeout = new JLabel("Timeout period (ms)");
    	JTextField tfHost = new JTextField(20);
    	tfHost.setText("http://");
    	JTextField tfTimeout = new JTextField(5);
    	tfTimeout.setText("0");
    	btnPing = new JButton("PingWithSwingWorker!");
    	lblHostStatus = new JLabel(" ");
    	
    	// Set the layout of this JPanel to be GridBagLayout.
    	GridBagLayout layoutMgr = new GridBagLayout();
    	setLayout(layoutMgr);
    	
    	// Add components using the GridBagLayout manager.
    	addComponent(lblHost, layoutMgr, 0, 0, 1, 1, GridBagConstraints.EAST);
    	addComponent(tfHost, layoutMgr, 0, 1, 1, 1, GridBagConstraints.WEST);
    	addComponent(lblTimeout, layoutMgr, 1, 0, 1, 1, GridBagConstraints.EAST);
    	addComponent(tfTimeout, layoutMgr, 1, 1, 1, 1, GridBagConstraints.WEST);
    	addComponent(btnPing, layoutMgr, 1, 2, 1, 1, GridBagConstraints.CENTER);
    	addComponent(lblHostStatus, layoutMgr, 2, 0, 3, 1, GridBagConstraints.WEST);
    	
    	// Add an ActionListener to respond to button clicks.
    	btnPing.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Extract the target URL and timeout period from the GUI.
				String inputUrl = tfHost.getText();
				int inputTimeout = Integer.parseInt(tfTimeout.getText());

                btnPing.setEnabled(false);

				// Create and start a new SwingWorker to ping the server.
				PingWorker pingWorker = new PingWorker(inputUrl, inputTimeout);
				pingWorker.execute();
			}
    	});
    }

    /**
     * Utility method to add a GUI Component to a Container whose layout is managed by a GridBagLayout manager.
     */
    private void addComponent(Component c, GridBagLayout layout, int row, int col, int width, int height, int alignment) {
    	GridBagConstraints constraints = new GridBagConstraints();
    	constraints.gridx = col;
    	constraints.gridy = row;
    	constraints.gridwidth = width;
    	constraints.gridheight = height;
    	constraints.insets = new Insets(10, 10, 10, 10);
    	constraints.anchor = alignment;

    	layout.setConstraints(c,  constraints);
    	add(c);
    }
}
