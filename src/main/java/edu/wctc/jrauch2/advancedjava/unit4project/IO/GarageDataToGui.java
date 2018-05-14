package edu.wctc.jrauch2.advancedjava.unit4project.IO;

import edu.wctc.jrauch2.advancedjava.unit4project.Abstract.GarageDataOut;
import edu.wctc.jrauch2.advancedjava.unit4project.Interface.TicketTracker;
import edu.wctc.jrauch2.advancedjava.unit4project.Singleton.Sales;

import javax.swing.*;
import java.text.NumberFormat;

/**
 * This class outputs garage data to a GUI and extends <b>GarageDataOut</b>
 * @author Joshua Rauch
 * @version 1.0
 * @see edu.wctc.jrauch2.advancedjava.unit4project.Abstract.GarageDataOut
 */
public class GarageDataToGui extends GarageDataOut {
    private final String HEADER;
    private final NumberFormat CURRENCY_FORMATTER;
    protected final TicketTracker TICKET_TRACKER;

    /**
     * The constructor for <b>GarageDataOut</b>
     * @param sales The instance of the <b>Sales</b> singleton for the garage program
     * @param garageName The name of the garage as a String
     * @param ticketTracker The instance of the <b>TicketTracker</b> singleton for the garage program
     */
    public GarageDataToGui(Sales sales, String garageName, TicketTracker ticketTracker) {
        super(sales);
        this.TICKET_TRACKER = ticketTracker;
        HEADER = garageName + "\n=========================\n";
        CURRENCY_FORMATTER = NumberFormat.getCurrencyInstance();
    }

    /**
     * Output the garage data to a GUI
     */
    @Override
    public void outputGarageData() {
        JOptionPane.showMessageDialog(null, HEADER +
                CURRENCY_FORMATTER.format(getSALES().getTotalCheckInRevenue()) + " was collected from " + TICKET_TRACKER.getNumberOfStandardTicketsClosed() + " Check Ins\n" +
                CURRENCY_FORMATTER.format(getSALES().getTotalSpecialEventRevenue()) + " was collected from " + TICKET_TRACKER.getNumberOfEventTicketsClosed() + " Special Events\n" +
                CURRENCY_FORMATTER.format(getSALES().getTotalLostTicketRevenue()) + " was collected from " + TICKET_TRACKER.getNumberOfLostTicketsClosed() + " Lost Tickets\n" +
                CURRENCY_FORMATTER.format(getSALES().getTotalRevenue()) + " was collected overall");
    }
}
