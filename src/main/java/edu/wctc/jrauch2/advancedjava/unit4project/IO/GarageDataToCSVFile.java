package edu.wctc.jrauch2.advancedjava.unit4project.IO;

import edu.wctc.jrauch2.advancedjava.unit4project.Abstract.GarageDataOut;
import edu.wctc.jrauch2.advancedjava.unit4project.Interface.Closeable;
import edu.wctc.jrauch2.advancedjava.unit4project.Interface.TicketTracker;
import edu.wctc.jrauch2.advancedjava.unit4project.Singleton.Sales;
import edu.wctc.jrauch2.advancedjava.unit4project.Singleton.TicketFactory;

/**
 * This class writes garage data out to a CSV file
 * @author Joshua Rauch
 * @version 1.0
 * @see edu.wctc.jrauch2.advancedjava.unit4project.Abstract.GarageDataOut
 */
public class GarageDataToCSVFile extends GarageDataOut {
    private final TicketFactory TICKET_FACTORY;
    private final TicketTracker TICKET_TRACKER;
    private final FileOutput GARAGE_DATA_OUT_FILE;

    /**
     * The constructor for <b>GarageDataToCSVFile</b>
     * @param sales The instance of <b>Sales</b> for the garage program
     * @param garageDataFileName A String contaning the name of the CSV file to be written to
     * @param ticketFactory The instance of <b>TicketFactory</b> for the garage program
     * @param ticketTracker THe instance of <b>TicketTracker</b> for the garage program
     */
    public GarageDataToCSVFile(Sales sales, String garageDataFileName, TicketFactory ticketFactory, TicketTracker ticketTracker) {
        super(sales);
        TICKET_FACTORY = ticketFactory;
        TICKET_TRACKER = ticketTracker;
        GARAGE_DATA_OUT_FILE = new FileOutput(garageDataFileName);
    }

    /**
     * Output the garage data to a CSV file
     */
    @Override
    public void outputGarageData() {
        String outLine = TICKET_FACTORY.getMostRecentTicketNumber() + "," +
                TICKET_TRACKER.getNumberOfStandardTicketsClosed() + "," +
                TICKET_TRACKER.getNumberOfEventTicketsClosed() + "," +
                TICKET_TRACKER.getNumberOfLostTicketsClosed() + "," +
                getSALES().getTotalCheckInRevenue() + "," +
                getSALES().getTotalSpecialEventRevenue() + "," +
                getSALES().getTotalLostTicketRevenue();
        GARAGE_DATA_OUT_FILE.dataOut(outLine);
        Closeable closeGarageDataOutFile = GARAGE_DATA_OUT_FILE;
        closeGarageDataOutFile.close();
    }
}
