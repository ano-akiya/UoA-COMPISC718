package ictgradschool.industry.designpatterns.examples.filestore;

import java.util.List;
import java.util.ArrayList;

/**
 * Class to represent a simple file. A simple file is one which cannot have 
 * children. This class corresponds to Leaf in the Composite design pattern.
 * 
 */
public class File implements Cloneable {
	private String _name;               /* File name, as stored on disk.      */
	private long _size;                 /* File size in bytes.                */
	private boolean _isHidden;          /* Hidden status.                     */
	private long _lastModificationTime; /* Last time the file was written to. */
	private boolean _isReadable;        /* True if readable, false otherwise. */
	private boolean _isWriteable;       /* True if writable, false otherwise. */
	private File _parent;               /* The file's parent. Null for root.  */
	
	/**
	 * Creates a File object.
	 * @param name the name on disk of the file represented by this File object.
	 * @param hidden the hidden status of this file.
	 * @param lastModified the time this file was last written to.
	 * @param canRead true if this file can be read, false otherwise.
	 * @param canWrite true if this file can be written, false otherwise.
	 * @param size the number of bytes this file takes up on disk.
	 */
	public File( String name,
				 boolean hidden,
				 long lastModified,
				 boolean canRead,
				 boolean canWrite,
				 long size ) {
		this._name = name;
		this._isHidden = hidden;
		this._lastModificationTime = lastModified;
		this._isReadable = canRead;
		this._isWriteable = canWrite;
		this._size = size;
	}
	
	/**
	 * Returns the name of this File object.
	 */
	public String getName() {
		return _name;
	}
	
	/**
	 * Returns the size of this File object.
	 */
	public long getSize() {
		return _size;
	}
	
	/**
	 * Returns a String containing the full path of this File object. The path
	 * contains the ordered set of directory names, starting with the root, that
	 * leads to this File. The set of names are separated by "/" characters. For
	 * example, if the root directory is named "root" and this contains a file
	 * named "file", the full path of the file is "root/file".
	 */
	public String getFullPathName() {
		String fullPathName = _name;
		if( _parent != null ) {
			fullPathName = _parent.getFullPathName() + "/" + fullPathName;
		}
		return fullPathName;
	}
	
	/**
	 * Returns an ordered List of File objects representing the path from the 
	 * root to this File object. The first File object in the List is thus the 
	 * root of the filestore.
	 */
	public List<File> getFullPath() {
		List<File> fullPath = null;
		if( _parent != null ) {
			fullPath = _parent.getFullPath();
			fullPath.add( this );
		}
		else {
			fullPath = new ArrayList<File>();
			fullPath.add( this );
		}
		return fullPath;
	}
	
	/**
	 * Returns the hidden status of this File object.
	 * @return true if the file is hidden, false otherwise.
	 */
	public boolean isHidden() {
		return _isHidden;
	}
	
	/**
	 * Returns the last time that this file object was written.
	 * @return the difference, measured in milliseconds, between the current 
	 * time and midnight, January 1, 1970 UTC. 
	 * @see java.util.Date
	 */
	public long getLastModificationTime() {
		return _lastModificationTime;
	}

	/**
 	 * Returns true if this File object is readable, false otherwise.
	 */
	public boolean isReadable() {
		return _isReadable;
	}

	/**
	 * Returns true is this File object can be written, false otherwise.
	 */
	public boolean isWriteable() {
		return _isWriteable;
	}
	
	/**
	 * Returns the parent File object for this File instance.
	 * @return the parent file object if this File object is not the root; 
	 * null if this File object is the root of the hierarchy.
	 */
	public File getParent() {
		return _parent;
	}
	
	/**
	 * Sets the parent of this File object.
	 * @param parent the parent File instance to set as this File object's 
	 * parent.
	 */
	protected void setParent( File parent ) {
		this._parent = parent;
	}
	
	/**
	 * Returns the name of this File object.
	 */
	public String toString() {
		return _name;
	}
}