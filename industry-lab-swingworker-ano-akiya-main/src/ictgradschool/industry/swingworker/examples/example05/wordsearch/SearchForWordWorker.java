package ictgradschool.industry.swingworker.examples.example05.wordsearch;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

import javax.swing.JTextArea;
import javax.swing.SwingWorker;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.SuffixFileFilter;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.apache.commons.lang3.StringUtils;

/**
 * Searches the text files under the given directory and counts the number of
 * instances a given word is found in these file. Will occasionally publish
 * the progress as a String, and returns the final result as an Integer (not
 * a primitive int... watch out for that).
 * 
 * @author Albert Attard @ Java Creed
 * @see http://www.javacreed.com/swing-worker-example/
 *
 * @author John Thompson, UoW, PGCInfoTech
 */
public class SearchForWordWorker extends SwingWorker<Integer, String> {

	/** The word that is searched for */
	private final String word;

	/** The directory under which the search occurs. All text files found under
	 *  the given directory are searched. */
	private final File directory;

	/** The text area where messages are written. */
	private final JTextArea messagesTextArea;

	/**
	 * Creates an instance of the worker
	 * 
	 * @param word
	 *          The word to search
	 * @param directory
	 *          the directory under which the search will occur. All text files
	 *          found under the given directory are searched
	 * @param messagesTextArea
	 *          The text area where messages are written
	 */
	public SearchForWordWorker(final String word, final File directory, final JTextArea messagesTextArea) {
		this.word = word;
		this.directory = directory;
		this.messagesTextArea = messagesTextArea;
	}
	/** SearchForWordWorker(String, File, JTextArea) => SearchForWordWorker **/


	/**
	 * Since there are several places where we would essentially like to test
	 * whether the searching has been interrupted, we put this as a method.
	 * Basically if we are interrupted we immediately 'quit' by throwing
	 * an exception that the caller (whomever created the worker) will need
	 * to catch and handle.
	 * 
	 * @throws InterruptedException
	 */
	private static void failIfInterrupted() throws InterruptedException {
		if (Thread.currentThread().isInterrupted()) {
			throw new InterruptedException("Interrupted while searching files");
		}
	}
	/** failIfInterrupted(void) => void **/
	
	
	@Override
	/**
	 * All SwingWorkers implement this method to do the actual 'work' of the 
	 * processing. The equivalent to Runnable.run(). Also note the "throws
	 * Exception" - if this worker is cancelled/interrupted, then we throw
	 * an InterruptedException back to whomever called execute() on this
	 * worker.
	 */
	protected Integer doInBackground() throws Exception {
		// The number of instances the word is found
		int matches = 0;

		// List all text files under the given directory using the Apache IO 
		// library. This process cannot be interrupted (stopped through
		// cancellation). That is why we are checking right after the process
		// whether it was interrupted or not.
		// - publish intermediate results (Strings) so users know something is
		//   happening
		publish("Listing all text files under the directory: " + directory);
		final List<File> textFiles = new ArrayList<>(FileUtils.listFiles(directory, new SuffixFileFilter(".txt"), TrueFileFilter.TRUE));
		publish("Found " + textFiles.size() + " text files under the directory: " + directory);

		// Check if we've been cancelled during that file search above
		SearchForWordWorker.failIfInterrupted();
		
		// We now have a list of files we can loop through searching for the
		// target word. This is also the first time we can reasonably report
		// progress as a percentage, as we know the total number of files to
		// be searched. Of course bigger files will take longer than shorter
		// ones.
		for (int i = 0, size = textFiles.size(); i < size; i++) {
			// In order to respond to the cancellations, we need to check
			// whether this thread (the worker thread) was interrupted or not.
			// If the thread was interrupted, then we simply throw an
			// InterruptedException to indicate that the worker thread was
			// cancelled.
			SearchForWordWorker.failIfInterrupted();

			// Update the status and indicate which file is being searched.
			final File file = textFiles.get(i);
			publish("Searching file: " + file);

			// Read the file content into a string, and count the matches
			// using the Apache common IO and Lang libraries respectively.
			final String text = FileUtils.readFileToString(file);
			matches += StringUtils.countMatches(text, word);

			// Update the progress
			setProgress((i + 1) * 100 / size);
		}

		// Return the number of matches found
		return matches;
	}

	@Override
	protected void process(final List<String> chunks) {
		// Updates the messages text area
		for (final String string : chunks) {
			messagesTextArea.append(string);
			messagesTextArea.append("\n");
		}
	}
	
	@Override
	/**
	 * Once we are done, update the TestArea with the final result. 
	 */
	protected void done() {
		// Whatever was 'returned' by doInBackground() is now available via
		// the worker's get() method. However, if doInBackground() was 
		// prematurely exited by an Exception (in our case an
		// InterruptedException triggered by clicking the Stop button) then
		// the worker is in a state where is knows its execution was 
		// interrupted. Calling get() in this state throws an
		// ExecutionException. This exception has a method, getCause(), that
		// you can use to retrieve the original Exception that broke out of
		// the Worker (as I said, most likely an InterruptedException).
		try {
			Integer totalNumberWords = this.get();
			messagesTextArea.append("Search complete. Found " + totalNumberWords + " occurances of the word \"" + word + "\".\n");
		}
		// not all the time, but sometimes this is the exception thrown if the
		// user quit while the execution was in the Apache libraries
		catch (CancellationException e) {
			messagesTextArea.append("Search aborted by user.");
		} 
		// We know that the most likely cause of execution not completing is a
		// click on our "Stop" button, which would have caused our code above
		// to throw an InterruptedException. We can test for that.
		catch (ExecutionException e) {
			Throwable originalException = e.getCause();
			if (originalException instanceof InterruptedException) {
				messagesTextArea.append("Search aborted by user.");
			}
			// something else happened, beyond out control or understanding
			// so have a good whinge about it....
			else {
				e.printStackTrace();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
