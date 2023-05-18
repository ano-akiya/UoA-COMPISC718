package ictgradschool.industry.designpatterns.examples.filestore;

import ictgradschool.industry.designpatterns.examples.filestore.Directory;
import ictgradschool.industry.designpatterns.examples.filestore.File;
import ictgradschool.industry.designpatterns.examples.filestore.FileStoreTreeModelAdapter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.tree.TreeModel;

import static org.junit.jupiter.api.Assertions.*;

/**
 * A class that defines test cases for determining whether an implementation of
 * Swing's TreeModel interface meets the TreeModel specification.
 */
public class TestFileStore {

    private Directory _filestore;

    private Directory _emptyDirectory;

    private File _simpleFile;

    private TreeModel _model;

    /**
     * Creates a simple filestore hierarchy as the common fixture for all test
     * case methods.
     */
    @BeforeEach
    void setUp() {
        try {
            /* Create File objects. */
            _filestore = new Directory("root", false, 0, false, false);
            _emptyDirectory = new Directory("empty", false, 0, false, false);
            _simpleFile = new File("simple", false, 0, false, false, 0);

            /* Bind File objects. */
            _filestore.add(_emptyDirectory);
            _filestore.add(_simpleFile);

            /* Create the model. */
            _model = new FileStoreTreeModelAdapter(_filestore);
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    /**
     * Checks whether getRoot() returns the root directory of a filestore as
     * expected.
     */
    @Test
    public void test_getRoot() {
        File root = (File) _model.getRoot();
        assertSame(root, _filestore);
    }

    /**
     * Checks whether getChildCount() returns zero for an empty composite file.
     */
    @Test
    public void test_getChildCount_OnEmptyDirectory() {
        int numberOfChildren = _model.getChildCount(_emptyDirectory);
        assertEquals(numberOfChildren, _emptyDirectory.getNumberOfChildren());
    }

    /**
     * Checks whether getChildCount() returns the actual number of children
     * contained in a composite file.
     */
    @Test
    public void test_getChildCount_OnNonEmptyDirectory() {
        int expectedNumberOfChildren = _model.getChildCount(_filestore);
        int actualNumberOfChidren = _filestore.getNumberOfChildren();

        assertEquals(expectedNumberOfChildren, actualNumberOfChidren);
    }

    /**
     * Checks whether getChildCount() returns zero when invoked with an argument
     * that refers to a simple file.
     */
    @Test
    public void test_getChildCount_OnSimpleFile() {
        int expectedNumberOfChildren = _model.getChildCount(_simpleFile);
        assertEquals(expectedNumberOfChildren, 0);
    }

    /**
     * Checks whether isLeaf() returns false, as required, when supplied with an
     * empty composite file as argument.
     */
    @Test
    public void test_isLeaf_OnEmptyDirectory() {
        assertFalse(_model.isLeaf(_emptyDirectory));
    }

    /**
     * Checks whether isLeaf() returns false, as required, when supplied with an
     * composite file that contains children..
     */
    @Test
    public void test_isLeaf_OnNonEmptyDirectory() {
        assertFalse(_model.isLeaf(_filestore));
    }

    /**
     * Checks whether isLeaf() returns true, as required, when supplied with a
     * simple file as argument.
     */
    @Test
    public void test_isLeaf_OnSimpleFile() {
        assertTrue(_model.isLeaf(_simpleFile));
    }

    /**
     * Checks whether getChild() correctly returns a reference to a particular
     * child file object. The arguments supplied to getChild() are a reference
     * to a composite file and the index position within the composite's
     * collection of children that identifies the child file sought. This
     * particular test supplies a valid index argument.
     */
    @Test
    public void test_getChild_OnDirectoryWithInRangeIndex() {
        assertSame(_model.getChild(_filestore, 0), _emptyDirectory);
    }

    /**
     * Checks whether getChild() returns null, as specified, when an index
     * argument value is supplied that is out of range. The argument is out of
     * range if it is negative or >= the number of children contained in the
     * composite file, which is the first argument).
     */
    @Test
    public void test_getChild_OnDirectoryWithOutOfRangeIndex() {
        assertNull(_model.getChild(_filestore, 2));
    }

    /**
     * Checks whether getChild() returns null, as it should when supplied with a
     * reference to a simple file object as the first argument.
     */
    @Test
    public void test_getChild_OnSimpleFile() {
        assertNull(_model.getChild(_simpleFile, 0));
    }

    /**
     * Checks whether getIndexOfChild() returns -1 as specified when supplied
     * with a reference to a file (the second argument) which is not a child of
     * the file supplied as the first argument.
     */
    @Test
    public void test_getIndexOfChild_OnDirectoryWithNonChild() {
        File newFile = new File("new", false, 0, false, false, 0);
        assertEquals(-1, _model.getIndexOfChild(_filestore, newFile));
    }

    /**
     * Checks whether getIndexOfChild() returns the correct index position of a
     * file (second argument) that is a child of a composite (the first
     * argument).
     */
    @Test
    public void test_getIndexOfChild_OnDirectoryWithChild() {
        assertEquals(1, _model.getIndexOfChild(_filestore, _simpleFile));
    }

    /**
     * Checks whether getIndexOfChild() returns -1 when the first argument
     * refers to a simple file.
     */
    @Test
    public void test_getIndexOfChild_OnSimpleFile() {
        assertEquals(-1, _model.getIndexOfChild(_simpleFile, _filestore));
    }
}