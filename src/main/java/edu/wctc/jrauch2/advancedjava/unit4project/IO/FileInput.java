package edu.wctc.jrauch2.advancedjava.unit4project.IO;

import edu.wctc.jrauch2.advancedjava.unit4project.Interface.Closeable;
import edu.wctc.jrauch2.advancedjava.unit4project.Interface.Input;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * This class reads input from files and implements <b>Input</b> and <b>Closeable</b>
 * @author Joshua Rauch
 * @version 1.0
 * @see edu.wctc.jrauch2.advancedjava.unit4project.Interface.Input
 * @see edu.wctc.jrauch2.advancedjava.unit4project.Interface.Closeable
 */
public class FileInput implements Input, Closeable {
    private final Logger LOGGER = LoggerFactory.getLogger(FileInput.class);
    private String fileName;
    private BufferedReader in;

    /**
     * The constructor for <b>FileName</b>
     * @param fileName a String containing the name of the file to be read
     */
    public FileInput(String fileName) {
        this.fileName = fileName;
        try {
            in = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            LOGGER.error("File Open Error: " + fileName + " " + e);
        }
    }

    /**
     * <i>dataIn</i> reads a line from the file
     * @return The string that was read from the file
     */
    @Override
    public String dataIn() {
        try {
            return in.readLine();
        } catch (Exception e) {
            LOGGER.error("File Read Error: " + fileName + " " + e);
            return null;
        }
    }

    /**
     * <i>close</i> closes the file being read from
     */
    @Override
    public void close() {
        if (in != null) {
            try {
                in.close();
            } catch (IOException e) {
                LOGGER.error(e.getMessage());
            }
        }
    }
}
