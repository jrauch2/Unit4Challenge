package edu.wctc.jrauch2.advancedjava.unit4project.IO;

import edu.wctc.jrauch2.advancedjava.unit4project.Abstract.GarageDataIn;
import edu.wctc.jrauch2.advancedjava.unit4project.Interface.Closeable;
import edu.wctc.jrauch2.advancedjava.unit4project.Interface.Input;
import edu.wctc.jrauch2.advancedjava.unit4project.Interface.TicketTracker;
import edu.wctc.jrauch2.advancedjava.unit4project.Singleton.Sales;
import edu.wctc.jrauch2.advancedjava.unit4project.Singleton.TicketFactory;

/**
 * This class extends the <b>GarageDataIn</b> class
 * @author Joshua Rauch
 * @version 1.0
 * @see edu.wctc.jrauch2.advancedjava.unit4project.Abstract.GarageDataIn
 */
public class CSVInput extends GarageDataIn {
    private final Input GARAGE_DATA_IN_FILE;

    /**
     * The constructor for <b>CSVInput</b>
     * @param sales the instance of the <b>Sales</b> singleton class
     * @param ticketFactory the instance of the <b>TicketFactory</b> singleton class
     * @param ticketTracker the instance of the <b>TicketTracker</b> singleton class
     * @param garageDataFileName a String containing the name of the garage data file
     */
    public CSVInput(Sales sales, TicketFactory ticketFactory, TicketTracker ticketTracker, String garageDataFileName) {
        super(sales, ticketFactory, ticketTracker);
        GARAGE_DATA_IN_FILE = new FileInput(garageDataFileName);
    }

    /**
     * This method loads the data from a CSV file. Garage data in the CSV should be in the order of
     * <i>most recent ticket number</i>, <i>most recent number of check ins</i>,
     * <i>most recent number of event tickets</i>, and <i>most recent number of lost tickets</i>
     */
    public void loadGarageDataFromCSV() {
        String line;
        String[] lineArray;
        line = GARAGE_DATA_IN_FILE.dataIn();
        if ((line == null) || line.equals("")) {
            getTICKET_FACTORY().setMostRecentTicketNumber(0);
            getTICKET_TRACKER().setMostRecentNumberOfStandardTicketsClosed(0);
            getTICKET_TRACKER().setMostRecentNumberOfEventTicketsClosed(0);
            getTICKET_TRACKER().setMostRecentNumberOfLostTicketsClosed(0);
            getSALES().addToTotalCheckInRevenue(0);
            getSALES().addToTotalSpecialEventRevenue(0);
            getSALES().addToLostTicketRevenue(0);
        } else {
            lineArray = line.split(",");
            getTICKET_FACTORY().setMostRecentTicketNumber(Integer.parseInt(lineArray[0]));
            getTICKET_TRACKER().setMostRecentNumberOfStandardTicketsClosed(Integer.parseInt(lineArray[1]));
            getTICKET_TRACKER().setMostRecentNumberOfEventTicketsClosed(Integer.parseInt(lineArray[2]));
            getTICKET_TRACKER().setMostRecentNumberOfLostTicketsClosed(Integer.parseInt(lineArray[3]));
            getSALES().addToTotalCheckInRevenue(Double.parseDouble(lineArray[4]));
            getSALES().addToTotalSpecialEventRevenue(Double.parseDouble(lineArray[5]));
            getSALES().addToLostTicketRevenue(Double.parseDouble(lineArray[6]));
        }
        Closeable closeGarageDataInFile = (Closeable) GARAGE_DATA_IN_FILE;
        closeGarageDataInFile.close();
    }
}