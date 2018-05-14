package edu.wctc.jrauch2.advancedjava.unit4project.Abstract;

import edu.wctc.jrauch2.advancedjava.unit4project.Interface.TicketTracker;
import edu.wctc.jrauch2.advancedjava.unit4project.Singleton.TicketFactory;

import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;

/**
 * The abstract Kiosk class is meant to be extended by InKiosk and OutKiosk abstract classes
 * @author Joshua Rauch
 * @version 1.0
 */
public abstract class Kiosk {
    private final TicketTracker TICKET_TRACKER;
    private final TicketFactory TICKET_FACTORY;
    private final String HEADER;
    private final String INVALID_TICKET_ERROR_MESSAGE;
    private final DateTimeFormatter HOUR_MINUTE_FORMATTER;
    private final NumberFormat CURRENCY_FORMATTER;
    private final String GARAGE_NAME;

    /**
     * The constructor for the Kiosk abstract class
     * @param TICKET_TRACKER The instance of the singleton class <b>TicketTracker</b> for the garage program
     * @param TICKET_FACTORY The instance of the singleton class <b>TicketFactory</b> for the garage program
     * @param GARAGE_NAME A String containing the name of the garage program
     */
    public Kiosk(TicketTracker TICKET_TRACKER, TicketFactory TICKET_FACTORY, String GARAGE_NAME) {
        this.TICKET_TRACKER = TICKET_TRACKER;
        this.TICKET_FACTORY = TICKET_FACTORY;
        this.GARAGE_NAME = GARAGE_NAME;
        this.HEADER = GARAGE_NAME + "\n=========================\n";
        this.INVALID_TICKET_ERROR_MESSAGE = "Not a valid ticket number. Try again.";
        this.HOUR_MINUTE_FORMATTER = DateTimeFormatter.ofPattern("H:m");
        this.CURRENCY_FORMATTER = NumberFormat.getCurrencyInstance();
    }

    /**
     * Get the ticket number
     * @param numberedTicket A numbered ticket
     * @return The ticket number of the <b>NumberedTicket</b>
     */
    protected int getTicketNumber(NumberedTicket numberedTicket) {
        return numberedTicket.getTicketNumber();
    }

    /**
     * Get the ticket tracker
     * @return The <b>TicketTracker</b> instance
     */
    protected TicketTracker getTICKET_TRACKER() {
        return TICKET_TRACKER;
    }

    /**
     * Get the ticket factory
     * @return The <b>TicketFactory</b> instance
     */
    protected TicketFactory getTICKET_FACTORY() {
        return TICKET_FACTORY;
    }

    /**
     * Get the header
     * @return The header String
     */
    protected String getHEADER() {
        return HEADER;
    }

    /**
     * Get the invalid ticket error message
     * @return The invalid ticket error message String
     */
    protected String getINVALID_TICKET_ERROR_MESSAGE() {
        return INVALID_TICKET_ERROR_MESSAGE;
    }

    /**
     * Get the hour minute formatter
     * @return The <b>DateTimeFormatter</b> that formats hours and minutes
     */
    protected DateTimeFormatter getHOUR_MINUTE_FORMATTER() {
        return HOUR_MINUTE_FORMATTER;
    }

    /**
     * Get the currency formatter
     * @return The <b>NumberFormat</b> currency formatter
     */
    protected NumberFormat getCURRENCY_FORMATTER() {
        return CURRENCY_FORMATTER;
    }

    /**
     * Get the name of the garage
     * @return The garage name as a String
     */
    protected String getGARAGE_NAME() {
        return GARAGE_NAME;
    }
}
