package edu.wctc.jrauch2.advancedjava.unit4project.IO;

import edu.wctc.jrauch2.advancedjava.unit4project.Interface.TicketTracker;
import edu.wctc.jrauch2.advancedjava.unit4project.Singleton.ActiveTickets;
import edu.wctc.jrauch2.advancedjava.unit4project.Singleton.Sales;
import edu.wctc.jrauch2.advancedjava.unit4project.Singleton.TicketFactory;
import org.junit.*;
import org.junit.rules.TemporaryFolder;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import static org.junit.Assert.*;

/**
 *
 */
public class GarageDataToCSVFileTest {
    private Sales sales;
    private TicketTracker ticketTracker;
    private TicketFactory ticketFactory;
    private GarageDataToCSVFile testGarageDataToCSVFile;
    private File testFile;
    BufferedReader in;
    String lineIn;

    /**
     * JUnit rule to allow temporary folder.
     */
    @Rule
    public TemporaryFolder folder= new TemporaryFolder();

    /**
     * Before each test, create a test file, create a <b>GarageDataToCSVFile</b>, output the garage data, create a <b>BufferedReader</b>
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        sales = Sales.INSTANCE;
        ticketTracker = ActiveTickets.INSTANCE;
        ticketFactory = TicketFactory.INSTANCE;
        testFile = folder.newFile("test.txt");
        ticketTracker.setMostRecentNumberOfStandardTicketsClosed(1);
        ticketTracker.setMostRecentNumberOfEventTicketsClosed(2);
        ticketTracker.setMostRecentNumberOfLostTicketsClosed(3);
        ticketFactory.setMostRecentTicketNumber(4);
        testGarageDataToCSVFile = new GarageDataToCSVFile(sales, testFile.getAbsolutePath(), ticketFactory, ticketTracker);
        testGarageDataToCSVFile.outputGarageData();
        in = new BufferedReader(new FileReader(testFile));
        lineIn = in.readLine();
    }

    /**
     * Affter each test close the <b>BufferedReader</b>
     * @throws Exception
     */
    @After
    public void tearDown() throws Exception {
        in.close();
    }

    /**
     * Test that the data that was written to the CSV file matches the String
     */
    @Test
    public void outputGarageData() {
        assertEquals("The data in the file should match this string.", "4,1,2,3,0.0,0.0,0.0", lineIn);
    }
}