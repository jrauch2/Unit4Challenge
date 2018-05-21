package edu.wctc.jrauch2.advancedjava.unit4project.IO;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;

import static org.junit.Assert.assertEquals;

/**
 * This class tests the class <b>FileOutput</b>
 */
public class FileOutputTest {
    private FileOutput testFileOutput;
    private File testFile;
    private BufferedReader in;
    private String testWriteString;
    private String testReadString;

    /**
     * JUnit rule to allow temporary folder.
     */
    @Rule
    public TemporaryFolder folder= new TemporaryFolder();

    /**
     * Before each test, create a test file, write to test file, close test file, read test file to string
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        testWriteString = "test line one";
        testFile = folder.newFile("test.txt");
        testFileOutput = new FileOutput(testFile.getAbsolutePath());
        testFileOutput.dataOut(testWriteString);
        testFileOutput.close();
        in = new BufferedReader(new FileReader(testFile));
        testReadString = in.readLine();
        }

    /**
     * After each test, close test file
     * @throws Exception
     */
    @After
    public void tearDown() throws Exception {
        in.close();
    }

    /**
     * Test that the data written to the test file is written accurately.
     */
    @Test
    public void dataOut() {
        assertEquals("The line read should be the same as the test line.", testWriteString, testReadString);
    }
}