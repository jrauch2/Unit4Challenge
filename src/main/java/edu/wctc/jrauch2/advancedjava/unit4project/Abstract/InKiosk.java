package edu.wctc.jrauch2.advancedjava.unit4project.Abstract;

import edu.wctc.jrauch2.advancedjava.unit4project.Enum.TicketType;
import edu.wctc.jrauch2.advancedjava.unit4project.Interface.TicketTracker;
import edu.wctc.jrauch2.advancedjava.unit4project.Singleton.BestValueParkingGarage;
import edu.wctc.jrauch2.advancedjava.unit4project.Singleton.TicketFactory;

/**
 * This abstract class is meant to be extended by <i>in</i> kiosks and extends <b>Kiosk</b>
 * @author Joshua Rauch
 * @version 1.0
 * @see edu.wctc.jrauch2.advancedjava.unit4project.Abstract.Kiosk
 */
public abstract class InKiosk extends Kiosk {
    /**
     * The constructor for <b>InKiosk</b>
     * @param TICKET_TRACKER The instance of the singleton class <b>TicketTracker</b> for the garage program
     * @param TICKET_FACTORY The instance of the singleton class <b>TicketFactory</b> for the garage program
     * @param GARAGE_NAME A String containing the name of the garage
     */
    public InKiosk(TicketTracker TICKET_TRACKER, TicketFactory TICKET_FACTORY, String GARAGE_NAME) {
        super(TICKET_TRACKER, TICKET_FACTORY, GARAGE_NAME);
    }

    /**
     * Adds a <b>StandardTicket</b> to the <b>TICKET_TRACKER</b>
     * @return The ticket that was created
     */
    public final Ticket addStandardTicketToTicketTracker() {
        Ticket ticket = getTICKET_FACTORY().getTicket(TicketType.STANDARD_TICKET);
        getTICKET_TRACKER().addTicket(ticket);
        return ticket;
    }

    /**
     * Adds an <b>EventTicket</b> to the <b>TICKET_TRACKER</b>
     * @return The ticket that was created
     */
    public final Ticket addEventTicketToTicketTracker() {
        Ticket ticket = getTICKET_FACTORY().getTicket(TicketType.EVENT_TICKET);
        getTICKET_TRACKER().addTicket(ticket);
        return ticket;
    }

    /**
     * Closes the garage
     */
    public final void closeGarage() {
        BestValueParkingGarage.INSTANCE.closeGarage();
    }

    /**
     * Abstract method <i>printTicket</i> to be overridden by child classes
     * @param ticket Accepts a <b>Ticket</b> as a parameter
     */
    public abstract void printTicket(Ticket ticket);
}