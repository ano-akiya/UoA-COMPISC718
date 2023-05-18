package ictgradschool.industry.swingworker.examples.example01.ping;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Class for a simple program to allow a user to ping a Web server for 
 * availability. The user enters a string (URL) to identify the Web server, 
 * plus a timeout period in milliseconds. A timeout value of 0 means that there
 * is no timeout limit for pinging the server. In response to clicking the 
 * "PingNoSwingWorker!" button, the application attempts to ping the given server. The
 * programme displays a message as to whether the server was successfully
 * pinged within any given timeout period.
 *
 * Class PingNoSwingWorker is a subclass of JPanel, meaning that a PingNoSwingWorker object can be added
 * to a Swing GUI application.
 *
 * PingNoSwingWorker performs the ping on the ED thread, causing it to hang while the web request is in progress.
 * This provides poor usability.
 *
 */
public class PingNoSwingWorker extends JPanel {

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

	private static void createAndShowGUI() {
        // Create and set up the window.
        JFrame frame = new JFrame("Web Server PingNoSwingWorker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create and set up the content pane.
        JComponent newContentPane = new PingNoSwingWorker();
        frame.add(newContentPane);

        // Display the window, centered on the screen.
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public static void main(String[ ] args) {
        // Schedule a job for the event-dispatching thread: creating and showing
    	// this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    /**
     * Constructor method to create the PingNoSwingWorker application's GUI.
     */
    public PingNoSwingWorker() {
    	// Create basic GUI components.
    	JLabel lblHost = new JLabel("Web server host");
    	JLabel lblTimeout = new JLabel("Timeout period (ms)");
    	JTextField tfHost = new JTextField(20);
    	tfHost.setText("http://");
    	JTextField tfTimeout = new JTextField(5);
    	tfTimeout.setText("0");
    	JButton btnPing = new JButton("PingNoSwingWorker!");
    	JLabel lblHostStatus = new JLabel(" ");
    	
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

				boolean success = ping(inputUrl, inputTimeout);

                btnPing.setEnabled(true);

				if(success) {
					lblHostStatus.setText("Successfully pinged " + inputUrl);
				} else {
					lblHostStatus.setText("Unable to ping " + inputUrl);
				}
			}
    	});
    }

    /*
     * Utility method to add a GUI Component to a Container whose layout is 
     * managed by a GridBagLayout manager. 
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
