package ictgradschool.industry.designpatterns.examples.filestore;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

/**
 * Class that implements the TreeModel interface by delegating to Directory
 * and File objects that form a hierarchical representation of a filestore.
 * This class is an object adapter.
 *
 */
public class FileStoreTreeModelAdapter implements TreeModel {

	private Directory _adaptee;

	private List<TreeModelListener> _treeModelListeners;

	/**
	 * Creates a TreeModelAdapter object with the adaptee parameter, root.
	 */
	public FileStoreTreeModelAdapter(Directory root) {
		_adaptee = root;
		_treeModelListeners = new ArrayList<TreeModelListener>();
	}

	/**
	 * Returns a reference to the root of the filestore.
	 */
	public Object getRoot() {
		return _adaptee;
	}

	/**
	 * Returns the number of children (File/Directory objects) parameter parent
	 * has. parent is expected to point to a Directory object contained within 
	 * the adaptee (root) Directory.
	 */
	public int getChildCount(Object parent) {
		int result = 0;
		File file = (File) parent;

		if (file instanceof Directory) {
			Directory directory = (Directory) file;
			result = directory.getNumberOfChildren();
		}
		return result;
	}

	/**
	 * Returns true if node refers to a Directory object, false otherwise.
	 */
	public boolean isLeaf(Object node) {
		return !(node instanceof Directory);
	}

	/**
	 * Adds the TreeModelListener parameter to this TreeModel's list of 
	 * listeners.
	 */
	public void addTreeModelListener(TreeModelListener l) {
		_treeModelListeners.add(l);
	}

	/**
	 * Removes the TreeModelListener parameter from this TreeModel's list of
	 * listeners.
	 */
	public void removeTreeModelListener(TreeModelListener l) {
		_treeModelListeners.remove(l);
	}

	/**
	 * Returns child File/Directory object that is stored within the parent
	 * parameter at the position specified by the index parameter.
	 */
	public Object getChild(Object parent, int index) {
		Object result = null;

		if (parent instanceof Directory) {
			Directory dir = (Directory) parent;
			result = dir.getFile(index);
		}
		return result;
	}

	/**
	 * Returns the index position at which the child File/Directory parameter
	 * is stored within the Directory object that parameter parent is expected 
	 * to refer. This method returns -1 if the object pointed to by the child
	 * parameter is not actually a child of parent.
	 */
	public int getIndexOfChild(Object parent, Object child) {
		int indexOfChild = -1;

		if (parent instanceof Directory) {
			Directory dir = (Directory) parent;
			Iterator<File> i = dir.getIterator();
			boolean found = false;

			int index = 0;
			while (!found && i.hasNext()) {
				File current = i.next();
				if (child == current) {
					found = true;
					indexOfChild = index;
				} else {
					index++;
				}
			}
		}
		return indexOfChild;
	}

	public void valueForPathChanged(TreePath path, Object newValue) {
		/* No implementation required. */
	}
}