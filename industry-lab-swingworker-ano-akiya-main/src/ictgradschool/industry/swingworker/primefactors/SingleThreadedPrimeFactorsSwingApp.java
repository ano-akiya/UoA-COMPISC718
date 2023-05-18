package ictgradschool.industry.swingworker.primefactors;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Simple application to calculate the prime factors of a given number N.
 * 
 * The application allows the user to enter a value for N, and then calculates 
 * and displays the prime factors. This is a very simple Swing application that
 * performs all processing on the Event Dispatch thread.
 *
 */
public class SingleThreadedPrimeFactorsSwingApp extends JPanel {

	private JButton _startBtn;        // Button to start the calculation process.
	private JTextArea _factorValues;  // Component to display the result.
	
	public SingleThreadedPrimeFactorsSwingApp() {
		// Create the GUI components.
		JLabel lblN = new JLabel("Value N:");
		final JTextField tfN = new JTextField(20);
		
		_startBtn = new JButton("Compute");
		_factorValues = new JTextArea();
		_factorValues.setEditable(false);
		
		// Add an ActionListener to the start button. When clicked, the 
		// button's handler extracts the value for N entered by the user from 
		// the textfield and find N's prime factors.
		_startBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				String strN = tfN.getText().trim();
				long n = 0;
				
				try {
					n = Long.parseLong(strN);
				} catch(NumberFormatException e) {
					System.out.println(e);
				}
				System.out.println("n: " + n);
				
				// Disable the Start button until the result of the calculation is known.
				_startBtn.setEnabled(false);
				
				// Clear any text (prime factors) from the results area.
				_factorValues.setText(null);
				
				// Set the cursor to busy.
				setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
				
				// Start the computation in the Event Dispatch thread.
				 for (long i = 2; i*i <= n; i++) {

			            // If i is a factor of N, repeatedly divide it out
			            while (n % i == 0) {
							System.out.println("i: "+ i);
							System.out.println("n%i: " +n%i);
			                _factorValues.append(i + "\n");
			                n = n / i;
							System.out.println("n2: "+ n);
			            }
			     }

			     // if biggest factor occurs only once, n > 1
			     if (n > 1) {
			    	 _factorValues.append(n + "\n");
			     }
			     
			     // Re-enable the Start button.
				_startBtn.setEnabled(true);
				
				// Restore the cursor.
				setCursor(Cursor.getDefaultCursor());
			}
		});
		
		// Construct the GUI. 
		JPanel controlPanel = new JPanel();
		controlPanel.add(lblN);
		controlPanel.add(tfN);
		controlPanel.add(_startBtn);
		
		JScrollPane scrollPaneForOutput = new JScrollPane();
		scrollPaneForOutput.setViewportView(_factorValues);
		
		setLayout(new BorderLayout());
		add(controlPanel, BorderLayout.NORTH);
		add(scrollPaneForOutput, BorderLayout.CENTER);
		setPreferredSize(new Dimension(500,300));
	}

	private static void createAndShowGUI() {
		// Create and set up the window.
		JFrame frame = new JFrame("Prime Factorisation of N");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create and set up the content pane.
		JComponent newContentPane = new SingleThreadedPrimeFactorsSwingApp();
		frame.add(newContentPane);

		// Display the window.
		frame.pack();
        frame.setLocationRelativeTo(null); 
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
}

