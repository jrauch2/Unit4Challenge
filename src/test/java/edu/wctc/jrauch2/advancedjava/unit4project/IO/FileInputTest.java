package edu.wctc.jrauch2.advancedjava.unit4project.IO;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;

import static org.junit.Assert.*;

/**
 * This class tests the <b>FileInput</b> class
 */
public class FileInputTest {
    private Writer out;
    private FileInput testFileInput;
    private File testFile;

    /**
     * JUnit rule to allow temporary folder.
     */
    @Rule
    public TemporaryFolder folder= new TemporaryFolder();

    /**
     * Before running each test, create a test file, write to the file, close the file, open the file in an instance
     * of <b>FileInput</b>
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        testFile = folder.newFile("test.txt");
        out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(testFile)));
        out.write("test line one\ntest line two\ntest line three\ntest line four");
        out.close();
        testFileInput = new FileInput(testFile.getAbsolutePath());
    }

    /**
     * After each test, close the file
     */
    @After
    public void tearDown() {
        testFileInput.close();
    }

    /**
     * Test that the file is being read from accurately
     */
    @Test
    public void dataIn() {
        assertEquals("The line read should be the same as the test line.", "test line one", testFileInput.dataIn());
    }
}