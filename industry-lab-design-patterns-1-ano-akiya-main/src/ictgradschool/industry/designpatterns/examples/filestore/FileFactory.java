package ictgradschool.industry.designpatterns.examples.filestore;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * A utility class which provides a factory method to build a representation of
 * a filestore using Directory and File objects.
 * 
 */
public class FileFactory {
	
	// HOME_KEY is a key that identifies the user's home directory.
	private static final String HOME_KEY = "user.home";
	
	/**
	 * Creates and returns a hierarchical representation of a file store. The
	 * root of the filestore is the user's login directory.
	 * 
	 * @return a Directory object representing the root of the file store. 
	 */
	public static Directory makeFileStore() {
		// Get user's home directory path.
		String home = System.getProperty( HOME_KEY );
		java.io.File root = new java.io.File(home);
		return buildHierarchy( root );
	}
	
	/**
	 * Helper method to recursively traverse a directory structure represented 
	 * by a java.io.File object and build the structure of File and Directory
	 * objects.
	 */
	private static Directory buildHierarchy( java.io.File file ) {
		List<QueueElement> queue = new ArrayList<QueueElement>();
		Directory root = null;

		try {
			root = makeDirectory( file, null );
			
			// Initialise queue with root entities for processing.
			queue.add( new QueueElement( file, root ));
			
			while( ! queue.isEmpty()) {
				QueueElement elem = (QueueElement)queue.remove(0);
				java.io.File parent = elem.file;
				Directory parentNode = (Directory)elem.node;
				java.io.File[] children = parent.listFiles();
				
				// If children is null, the directory doesn't allow access.
				if( children == null ) {
					continue;
				}
				for (int i = 0; i < children.length; i++) {
					java.io.File child = children[i];
					File childNode = null;
					if (child.isDirectory()) {
						childNode = makeDirectory(child, parentNode);
						queue.add(new QueueElement(child, childNode));
					} 
					else {
						childNode = makeFile(child, parentNode);
					}
				}
			} 
		} 
		catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		return root;
	}
	
	/** 
	 * Helper method to create a Directory instance.
	 */
	private static Directory makeDirectory( java.io.File file, Directory parent ) 
		throws IllegalArgumentException {
		Directory result = new Directory(
			file.getName(),
			file.isHidden(),
			file.lastModified(),
			file.canRead(),
			file.canWrite() );
		if( parent != null ) {
			parent.add( result );
		}
		return result;
	}
	
	/**
	 * Helper method to create a simple File object.
	 */
	private static File makeFile( java.io.File file, Directory parent ) 
		throws IllegalArgumentException {
		File result = new File(
			file.getName(),
			file.isHidden(),
			file.lastModified(),
			file.canRead(),
			file.canWrite(),
			file.length() );
		parent.add( result );
		return result;
	}
	
	/**
	 * Main program method to give a simple demonstration of building a 
	 * filestore representation in terms of File and Directory objects.
	 */
	public static void main(String[] args) {
		Directory root = makeFileStore();
		
		System.out.println("Disk space used: " + root.getSize() + " bytes");
		System.out.println("Top level directories: ");
		Iterator<File> i = root.getIterator();
		while(i.hasNext()) {
			File f = i.next();
			if(f instanceof Directory) {
				System.out.println("\t" + f.getName());
			}
		}
	}
}


/**
 * Helper class whose instances are used to implement the buildHierarchy method.
 */
class QueueElement {
	java.io.File file;
	File node;

    QueueElement( java.io.File f, File n ) {
    	file = f;
    	node = n;
    }
}	
	