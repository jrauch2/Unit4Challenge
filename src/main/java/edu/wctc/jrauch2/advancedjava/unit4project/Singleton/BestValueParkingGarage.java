package edu.wctc.jrauch2.advancedjava.unit4project.Singleton;

import edu.wctc.jrauch2.advancedjava.unit4project.Abstract.GarageDataOut;
import edu.wctc.jrauch2.advancedjava.unit4project.IO.CSVInput;
import edu.wctc.jrauch2.advancedjava.unit4project.IO.GarageDataToCSVFile;
import edu.wctc.jrauch2.advancedjava.unit4project.IO.GarageDataToConsole;
import edu.wctc.jrauch2.advancedjava.unit4project.IO.GarageDataToGui;
import edu.wctc.jrauch2.advancedjava.unit4project.Interface.Garage;
import edu.wctc.jrauch2.advancedjava.unit4project.Interface.TicketTracker;
import edu.wctc.jrauch2.advancedjava.unit4project.Kiosk.Gui.InKioskGui;
import edu.wctc.jrauch2.advancedjava.unit4project.Kiosk.Gui.OutKioskGui;
import edu.wctc.jrauch2.advancedjava.unit4project.Kiosk.InKioskViaTerminal;
import edu.wctc.jrauch2.advancedjava.unit4project.Kiosk.OutKioskViaTerminal;
import edu.wctc.jrauch2.advancedjava.unit4project.ParkingGarageProgram;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;

/**
 * This enum follows the singleton pattern and is an instance of a <b>Garage</b>. This instance drives the garage
 * program and all configurations are configured here
 * @author Joshua Rauch
 * @version 1.0
 * @see edu.wctc.jrauch2.advancedjava.unit4project.Interface.Garage
 * @see java.lang.Comparable
 * @see java.lang.Enum
 * @see java.io.Serializable
 */
public enum BestValueParkingGarage implements Garage {
    INSTANCE;

    private final Logger LOGGER;
    private final String GARAGE_NAME;
    private final TicketTracker TICKET_TRACKER;
    private final TicketFactory TICKET_FACTORY;
    private final Sales SALES;
    private final CSVInput CSV_INPUT;
    private final String GARAGE_DATA_FILE_NAME;
    private Runnable inKioskViaTerminal;
    private Runnable outKioskViaTerminal;
    private Runnable inKioskGuiForm;
    private Runnable outKioskGuiForm;
    private boolean garageOpen;

    /**
     * The private constructor for the enum <b>BestValueParkingGarage</b>. This private constructor instantiates all
     * final variables within this enum
     */
    BestValueParkingGarage() {
        LOGGER = LoggerFactory.getLogger(ParkingGarageProgram.class);
        GARAGE_NAME = "Best Value Parking Garage";
        SALES = Sales.INSTANCE;
        TICKET_TRACKER = ActiveTickets.INSTANCE;
        TICKET_FACTORY = TicketFactory.INSTANCE;
        GARAGE_DATA_FILE_NAME = "BestValueParkingGarageData.csv";
        CSV_INPUT = new CSVInput(SALES, TICKET_FACTORY, TICKET_TRACKER, GARAGE_DATA_FILE_NAME);
    }

    /**
     * Load the garage data.
     * Configure this method to use an appropriate class to load data into the garage program
     * i.e. from a CSV file or database
     */
    private void loadGarageData() {
        CSV_INPUT.loadGarageDataFromCSV();
    }

    /**
     * Output the garage data.
     * Configure this method to use an appropriate class to output data from the garage program. this can be
     * configured to save to a CSV, a database, print to terminal, display in a GUi, etc.
     */
    private void outputGarageData() {
        GarageDataOut garageDataToCSVFile = new GarageDataToCSVFile(SALES, GARAGE_DATA_FILE_NAME, TICKET_FACTORY, TICKET_TRACKER);
        GarageDataOut garageDataToConsole = new GarageDataToConsole(SALES, GARAGE_NAME, TICKET_TRACKER);
        GarageDataOut garageDataToGui = new GarageDataToGui(SALES, GARAGE_NAME, TICKET_TRACKER);

        garageDataToCSVFile.outputGarageData();
        garageDataToConsole.outputGarageData();
        garageDataToGui.outputGarageData();
    }

    /**
     * Open the garage.
     * set the boolean <b>GarageOpen</b> to <i>true</i>.
     * Load the garage data from its stored location
     * Instantiate kiosks for the garage program
     */
    public void openGarage() {
        setGarageOpen(true);
        loadGarageData();

        inKioskViaTerminal = new InKioskViaTerminal(TICKET_TRACKER, TICKET_FACTORY, GARAGE_NAME, garageOpen);
        Thread thread0 = new Thread(inKioskViaTerminal);
        thread0.start();
//
//        outKioskViaTerminal = new OutKioskViaTerminal(TICKET_TRACKER, TICKET_FACTORY, GARAGE_NAME);
//        Thread thread1 = new Thread(outKioskViaTerminal);
//        thread1.start();

        inKioskGuiForm = new InKioskGui(TICKET_TRACKER, TICKET_FACTORY, GARAGE_NAME);
        SwingUtilities.invokeLater(inKioskGuiForm);

        outKioskGuiForm = new OutKioskGui(TICKET_TRACKER, TICKET_FACTORY, GARAGE_NAME);
        SwingUtilities.invokeLater(outKioskGuiForm);

        inKioskGuiForm = new InKioskGui(TICKET_TRACKER, TICKET_FACTORY, GARAGE_NAME);
        SwingUtilities.invokeLater(inKioskGuiForm);

        outKioskGuiForm = new OutKioskGui(TICKET_TRACKER, TICKET_FACTORY, GARAGE_NAME);
        SwingUtilities.invokeLater(outKioskGuiForm);
    }

    /**
     * Close the garage
     * Set the boolean <b>GarageOpen</b> to <i>false</i>
     * Output the garage data
     * exit the program (System.exit(0))
     */
    public void closeGarage() {
        setGarageOpen(false);
        outputGarageData();
        System.exit(0);
    }

    /**
     * Get the name of the garage
     * @return A String containing the name of the garage
     */
    @Override
    public String getGARAGE_NAME() {
        return GARAGE_NAME;
    }

    /**
     * Is the garage open?
     * @return A boolean representing if the garage is open
     */
    @Override
    public boolean isGarageOpen() {
        return garageOpen;
    }

    /**
     * Set the boolean <b>GarageOpen</b>
     * @param garageOpen Is the garage open? true or false
     */
    @Override
    public void setGarageOpen(boolean garageOpen) {
        this.garageOpen = garageOpen;
    }

    /**
     * Get the name of the file that contains the garage data
     * @return A String containing the name of the file that holds the garage data
     */
    public String getGARAGE_DATA_FILE_NAME() {
        return GARAGE_DATA_FILE_NAME;
    }
}