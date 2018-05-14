package edu.wctc.jrauch2.advancedjava.unit4project.IO;

import edu.wctc.jrauch2.advancedjava.unit4project.Interface.Closeable;
import edu.wctc.jrauch2.advancedjava.unit4project.Interface.Output;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * This class writes out to a file and implements Output and Closeable
 * @author Joshua Rauch
 * @version 1.0
 * @see edu.wctc.jrauch2.advancedjava.unit4project.Interface.Output
 * @see edu.wctc.jrauch2.advancedjava.unit4project.Interface.Closeable
 */
public class FileOutput implements Output, Closeable {
    private final Logger LOGGER = LoggerFactory.getLogger(FileOutput.class);
    private String fileName;
    private Writer out;

    /**
     * The constructor for <b>FileOutput</b>
     * @param fileName A String containing the name of the file to be written to
     */
    public FileOutput(String fileName) {
        setFileName(fileName);
    }

    /**
     * Set the name of the file
     * @param fileName A String containing the name of the file to be written to
     */
    private void setFileName(String fileName) {
        this.fileName = fileName;
        try{
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName)));
        } catch (FileNotFoundException e) {
            LOGGER.error(e.getLocalizedMessage());
        }
    }

    /**
     * Write the data out
     * @param string The String to be written out to the file
     */
    @Override
    public void dataOut(String string) {
        try {
            out.write(string + "\n");
        }
        catch(Exception e) {
           LOGGER.error("File Write Error: " + fileName + " "  + e);
        }
    }

    /**
     * Close the file being written to
     */
    @Override
    public void close() {
        if (out != null) {
            try {
                out.close();
            } catch (IOException e) {
                LOGGER.error(e.getMessage());
            }
        }
    }
}
