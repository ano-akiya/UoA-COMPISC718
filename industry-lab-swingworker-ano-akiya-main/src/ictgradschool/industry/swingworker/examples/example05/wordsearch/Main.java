package ictgradschool.industry.swingworker.examples.example05.wordsearch;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * Create a GUI that is properly thread safe and responsive. The main JVM thread
 * is only responsible for adding the creation of a custom JFrame to the Event
 * Dispatcher Thread's queue (accessed via the SwingUtilities library).
 * 
 * Years of experience and many failed GUI models taught programmers that you
 * need to follow special rules and conventions when using concurrent techniques
 * in GUI applications otherwise things go wrong very fast. With Java this boils
 * down to two important rules. The first rule is that GUI components should
 * only ever be updated by one thread---the Event Dispatcher Thread (EDT). The
 * second rule is that long running processes should never be done in the EDT...
 * instead you spin them out into SwingWorker threads.
 * 
 * See the URL for some nice visuals about why we bother doing all this extra
 * work.
 * 
 * @author Albert Attard @ Java Creed
 * @version 2013
 * @see http://www.javacreed.com/swing-worker-example/
 */
public class Main {

	/**
	 * Main entry point for JVM
	 * 
	 * @param args
	 */
	public static void main(final String[] args) {
		// We use invokeLater to add an 'anonymous runnable' to processed by the
		// Event Dispatch Thread (EDT) at some point (in this case, straight
		// away because the there can't be any other events in the queue without
		// some Swing component being on screen).
		// Rather than an anonymous class you could have created an instance of
		// some class that implemented Runnable just like you did yesterday with
		// normal threads.
		// Note that invokeLater doesn't block... so it might seem strange that
		// your code doesn't get to the end of the main() method and prematurely
		// exit. However, invokeLater wraps the runnable in a thread, and until
		// the EDT runs it and join()s it back to the main thread the JVM can't
		// exit.
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				final JFrame frame = new Application();
				frame.setTitle("Swing Worker Demo");
				frame.setSize(600, 400);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				// At this point the Frame is rendered on screen
				frame.setVisible(true);
			}
		});
		// JVM has to wait here for the Runnable above to end and join the
		// main thread.
	}
}
