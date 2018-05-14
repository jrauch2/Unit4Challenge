package edu.wctc.jrauch2.advancedjava.unit4project.IO;

import edu.wctc.jrauch2.advancedjava.unit4project.Abstract.GarageDataOut;
import edu.wctc.jrauch2.advancedjava.unit4project.Interface.TicketTracker;
import edu.wctc.jrauch2.advancedjava.unit4project.Singleton.Sales;

import java.text.NumberFormat;

/**
 * This class writes the garage data out to the console and extends GarageDataOut
 * @author Joshua Rauch
 * @version 1.0
 * @see edu.wctc.jrauch2.advancedjava.unit4project.Abstract.GarageDataOut
 */
public class GarageDataToConsole extends GarageDataOut {
    private final String HEADER;
    private final NumberFormat CURRENCY_FORMATTER;
    private final TicketTracker TICKET_TRACKER;

    /**
     * The constructor for <b>GarageDataToConsole</b>
     * @param sales The instance of the <b>Sales</b> singleton for the garage program
     * @param garageName The name of the garage as a String
     * @param ticketTracker The instance of the <b>TicketTracker</b> singleton for the garage program
     */
    public GarageDataToConsole(Sales sales, String garageName, TicketTracker ticketTracker) {
        super(sales);
        this.TICKET_TRACKER = ticketTracker;
        HEADER = garageName + "\n=========================\n";
        CURRENCY_FORMATTER = NumberFormat.getCurrencyInstance();
    }

    /**
     * Output the garage data to the console
     */
    @Override
    public void outputGarageData() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n");
        System.out.println(HEADER + "Activity to Date");
        System.out.println(CURRENCY_FORMATTER.format(getSALES().getTotalCheckInRevenue()) +
                " was collected from " + TICKET_TRACKER.getNumberOfStandardTicketsClosed() + " Check Ins");
        System.out.println(CURRENCY_FORMATTER.format(getSALES().getTotalSpecialEventRevenue()) +
                " was collected from " + TICKET_TRACKER.getNumberOfEventTicketsClosed() + " Check Ins");
        System.out.println(CURRENCY_FORMATTER.format(getSALES().getTotalLostTicketRevenue()) +
                " was collected from " + TICKET_TRACKER.getNumberOfLostTicketsClosed() + " Check Ins");
        System.out.println("\n" + CURRENCY_FORMATTER.format(getSALES().getTotalRevenue()) +
                " was collected overall");
    }
}
