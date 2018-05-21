package edu.wctc.jrauch2.advancedjava.unit4project.Abstract;

import edu.wctc.jrauch2.advancedjava.unit4project.Enum.TicketType;
import edu.wctc.jrauch2.advancedjava.unit4project.Interface.TicketTracker;
import edu.wctc.jrauch2.advancedjava.unit4project.Singleton.TicketFactory;
import edu.wctc.jrauch2.advancedjava.unit4project.Ticket.StandardTicket;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * This abstract class is meant to be extended by <i>out</i> kiosks and extends <b>Kiosk</b>
 * @author Joshua Rauch
 * @version 1.0
 * @see edu.wctc.jrauch2.advancedjava.unit4project.Abstract.Kiosk
 */
public abstract class OutKiosk extends Kiosk {
    /**
     * The constructor for <b>OutKiosk</b>
     * @param TICKET_TRACKER The TicketTracker instance for the garage program
     * @param TICKET_FACTORY The TicketFactory instance for the garage program
     * @param garageName A String containing the name of the garage
     */
    public OutKiosk(TicketTracker TICKET_TRACKER, TicketFactory TICKET_FACTORY, String garageName) {
        super(TICKET_TRACKER, TICKET_FACTORY, garageName);
    }

    /**
     * Closes the ticket and marks it as paid
     * @param ticket The ticket to be closed
     */
    public void closeTicket(Ticket ticket) {
        ticket.close();
    }

    /**
     * Calculate the fee for the ticket
     * @param ticket The ticket to be calculated
     * @return A double containing the fee for the ticket
     */
    public double calculateFee(Ticket ticket) {
        return ticket.calculateFee();
    }

    /**
     * Get if the ticket id paid
     * @param ticket The ticket in question
     * @return if <i>Paid</i> is <i>true</i>
     */
    public boolean isPaid(Ticket ticket) {
        return ticket.isPaid();
    }

    /**
     * Get the type of ticket
     * @param ticket The ticket in question
     * @return The <b>TicketType</b>
     */
    public TicketType getTicketType(Ticket ticket) {
        return ticket.getTicketType();
    }

    /**
     * Get the ammount of time parked
     * @param standardTicket The standard ticket in question. The ticket must have an <i>In</i> time and
     * <i>Out</i> time. The ticket must be closed.
     * @return The <b>Duration</b> between <i>timeIn</i> and <i>timeOut</i>
     */
    public Duration getTimeParked(StandardTicket standardTicket) {
        return standardTicket.getTimeParked();
    }

    /**
     * Get the the time the ticket was issued
     * @param ticket The ticket in question
     * @return The <b>LocalDateTime</b> reflecting when the ticket was issued
     */
    public LocalDateTime getTimeIn(StandardTicket ticket) {
        return ticket.getTimeIn();
    }

    /**
     * Get the time the ticket was checked out
     * @param ticket The ticket in question
     * @return The <b>LocalDateTime</b> reflecting when the ticket was checked out
     */
    public LocalDateTime getTimeOut(StandardTicket ticket) {
        return ticket.getTimeOut();
    }

    /**
     * Check out a numbered ticket. <i>checkOutNumberedTicket</i> is abstract and must be overridden by the
     * extending class
     * @param ticket The ticket in question
     */
    public abstract void checkOutNumberedTicket(Ticket ticket);

    /**
     * Check out a lost ticket. <i>checkOutLostTicket</i> is abstract and must be overridden by the extending class
     */
    public abstract void checkOutLostTicket();
}
