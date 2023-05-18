package ictgradschool.industry.designpatterns.examples.filestore;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * Class to represent a composite file which may contain children. A Directory
 * instance may contain children that are instances of any classes derived
 * from File. Directories are thus polymorphic collections. Class Directory
 * conforms to the Composite class in the Composite design pattern.
 * 
 */
public class Directory extends File {
	private List<File> _children;
	
	/**
	 * Creates a Directory object.
	 * @param name the name on disk of the file represented by this directory.
	 * @param hidden the hidden status of this directory.
	 * @param lastModified the creation time of the directory.
	 * @param canRead true if this directory can be read, false otherwise.
	 * @param canWrite true if this directory can be written, false otherwise.
	 */
	public Directory( String name,
					  boolean hidden,
					  long lastModified, 
					  boolean canRead,
					  boolean canWrite ) {
		super( name, hidden, lastModified, canRead, canWrite, 0 );
		_children = new ArrayList<File>();
	}
	
	/**
	 * Returns the size of this directory by visiting all descendants and 
	 * summing their sizes. The resulting size is thus that for all direct and
	 * indirect children of this Directory object.
	 */
	public long getSize() {
		long size = 0;

		for( Iterator<File> i = _children.iterator(); i.hasNext(); ) {
			size += i.next().getSize();
		}
		return size;
	}
	
	public Iterator<File> getIterator() {
		return _children.iterator();
	}
	
	/**
	 * Returns the index position of a particular File contained within
	 * this Directory object. 
	 * @param child the File within this Directory instance to locate.
	 * @return the index position, in the range 0 to n-1 children. If the File
	 * object referenced by the child parameter is not contained within this 
	 * Directory object, -1 is returned.
	 */
	public int getChildIndex( File child ) {
		return _children.indexOf( child );
	}
	
	/**
	 * Returns the number of children contained within this Directory object. 
	 */
	public int getNumberOfChildren() {
		return _children.size();
	}
	

	/**
	 * Returns the File that is contained at a specified position within this
	 * Directory object.
	 * @param index the index position of the File to return.
	 * @return the File object located at the position identified by the index
	 * parameter, or null if the value for index is outside of the range 0 to 
	 * n-1, where n is the number of children. 
	 */
	public File getFile( int index ) {
		File result = null;
		try {
			result = _children.get( index );
		}
		catch( IndexOutOfBoundsException e ) {
			// No action necessary other than to catch the exception.
		}
		return result;
	}
	
	/**
	 * Adds a specified File to this Directory object. Calling this method 
	 * establishes a two-way link between this Directory object and the File
	 * being added. Following this method call, the added File will have as its
	 * parent this Directory object. add() also maintains alphabetical ordering
	 * of a Directory's children by inserting files in their correct order. This
	 * operation can fail for several reasons, resulting in a 
	 * IllegalArgumentException being thrown:
	 * <ul>
	 *  <li>The name of the File argument is already taken by an existing child
	 *  of the Directory object. Files should thus be uniquely named within 
	 *  their parent directory.
	 *  <li>The File argument already has a parent. It is illegal for a file to
	 *  have more than one parent; otherwise a file could be a member of 
	 *  multiple directories.
	 *  <li>The File argument is the root node of the filestore. If the root 
	 *  were allowed to be added to other directories, cycles in the filestore
	 *  structure would occur. Cycles are not permitted.
	 * </ul> 
	 * @param file a reference to the File object to add.
	 * @throws IllegalArgumentException if the name of the file argument is
	 * already taken by an existing child of the Directory object.
	 */
	public void add( File file ) throws IllegalArgumentException {
		Iterator<File> i = _children.iterator();
		int insertionPoint = 0;
		boolean insertionPointFound = false;
		
		/* Check first that the file argument does not yet have a parent. */
		if( file.getParent() != null ) {
			throw new IllegalArgumentException( "File " + file.getName() + 
					" is a member of " + file.getParent().getName() +
					" and cannot be added to " + this.getName() );
		}
		
		/* Check that the file to be added is not the root node. */
		List<File> fullPath = this.getFullPath();
		File root = fullPath.get( 0 );
		if( root == file ) {
			throw new IllegalArgumentException( "File " + file.getName() + 
					" is the root node and cannot be added to " +
					this.getName() );
		}
		
		/* Calculate the index position to insert file. */		
		while( i.hasNext() && ( ! insertionPointFound ) ) {
			File current = i.next();
			int compare = file.getName().compareTo( current.getName() );
			if( compare == 0 ) {
				/* File of the same name is already a child. */
				throw new IllegalArgumentException( this.getName() +
						" already has a file named " + file.getName() );
			}
			else if( compare > 0 ) {
				/* file's name is greater than current's - keep going. */
				insertionPoint++;
			}
			else {
				insertionPointFound = true;
			}
		}
		
		/* Add file to children, maintaining alphabetical ordering. */
		if( insertionPointFound ) {
			/* Insert file within the children collection. */
			_children.add( insertionPoint, file );
		}
		else {
			/* Append the file to the end of the children collection. */
			_children.add( file );
		}
		
		/* 
		 * Update file's parent reference to point to this Directory
		 * object.
		 */
		file.setParent( this );
	}
	
	/**
	 * Removes a particular File object from this Directory object.
	 * @return a reference to the removed file, or null if the file parameter
	 * is not contained within this Directory object.
	 */
	public File remove( File file ) {
		File result = null;
		
		if( _children.remove( file ) )
			result = file;
		file.setParent( null );
		return result;
	}

}