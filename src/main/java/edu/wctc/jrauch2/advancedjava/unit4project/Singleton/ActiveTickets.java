package edu.wctc.jrauch2.advancedjava.unit4project.Singleton;

import edu.wctc.jrauch2.advancedjava.unit4project.Enum.TicketType;
import edu.wctc.jrauch2.advancedjava.unit4project.Interface.TicketTracker;
import edu.wctc.jrauch2.advancedjava.unit4project.Abstract.NumberedTicket;
import edu.wctc.jrauch2.advancedjava.unit4project.Abstract.Ticket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * This enum follows the singleton pattern and tracks all tickets for the garage program
 * @author Joshua Rauch
 * @version 1.0
 * @see edu.wctc.jrauch2.advancedjava.unit4project.Interface.TicketTracker
 * @see java.lang.Enum
 * @see java.lang.Comparable
 * @see java.io.Serializable
 */
public enum ActiveTickets implements TicketTracker {
    INSTANCE;

    private final Logger LOGGER = LoggerFactory.getLogger(ActiveTickets.class);
    private List<Ticket> nonNumberedTickets;
    public List<NumberedTicket> numberedTickets;
    private int mostRecentNumberOfStandardTicketsClosed;
    private int mostRecentNumberOfEventTicketsClosed;
    private int mostRecentNumberOfLostTicketsClosed;

    /**
     * The constructor for <b>ActiveTickets</b>
     */
    ActiveTickets() {
        nonNumberedTickets = new ArrayList<>();
        numberedTickets = new ArrayList<>();
        mostRecentNumberOfStandardTicketsClosed = 0;
        mostRecentNumberOfEventTicketsClosed = 0;
        mostRecentNumberOfLostTicketsClosed = 0;
    }

    /**
     * Add a ticket to the tracker
     * @param ticket the ticket in question
     */
    @Override
    public void addTicket(Ticket ticket) {
        NumberedTicket numberedTicket;
        switch (ticket.getTicketType()) {
            case LOST_TICKET:
                nonNumberedTickets.add(ticket);
                break;
            case EVENT_TICKET:
                numberedTicket = (NumberedTicket) ticket;
                numberedTickets.add(numberedTicket);
                break;
            case STANDARD_TICKET:
                numberedTicket = (NumberedTicket) ticket;
                numberedTickets.add(numberedTicket);
        }
    }

    /**
     * Get a ticket from the tracker
     * @param ticketNumber The number of the ticket to be retrieved
     * @return The ticket in question
     */
    @Override
    public Ticket getTicket(int ticketNumber) {
        Ticket ticket = null;
        for (NumberedTicket tempTicket: numberedTickets) {
            if (tempTicket.getTicketNumber() == ticketNumber) {
                ticket = tempTicket;
            }
        }
        return ticket;
    }

    /**
     * Get the number of standard tickets that have been issued and closed
     * @return an int representing the number of closed standard tickets. Open tickets are not counted because the
     * ticket may have been lost and paid for as a lost ticket
     */
    @Override
    public int getNumberOfStandardTicketsClosed() {
        int count = 0;
        for (Ticket ticket: numberedTickets) {
            if (ticket.getTicketType() == TicketType.STANDARD_TICKET) {
                if(ticket.isPaid()){
                    count++;
                }
            }
        }
        return count + mostRecentNumberOfStandardTicketsClosed;
    }

    /**
     * get the number of event tickets that have been issued and closed
     * @return An int representing the number of event tickets closed. Open tickets are not counted because the
     * ticket may have been lost and paid for as a lost ticket
     */
    @Override
    public int getNumberOfEventTicketsClosed() {
        int count = 0;
        for (Ticket ticket: numberedTickets) {
            if (ticket.getTicketType() == TicketType.EVENT_TICKET) {
                if(ticket.isPaid()){
                    count++;
                }
            }
        }
        return count + mostRecentNumberOfEventTicketsClosed;
    }

    /**
     * Get number of lost tickets issued and closed
     * @return an int representing the number of lost tickets closed
     */
    @Override
    public int getNumberOfLostTicketsClosed() {
        int count = 0;
        for (Ticket ticket: nonNumberedTickets) {
            if (ticket.getTicketType() == TicketType.LOST_TICKET) {
                if(ticket.isPaid()){
                    count++;
                }
            }
        }
        return count + mostRecentNumberOfLostTicketsClosed;
    }

    /**
     * Set the most recent number of standard tickets closed
     * @param mostRecentNumberOfStandardTicketsClosed An int representing the most recent number of standard tickets closed
     */
    public void setMostRecentNumberOfStandardTicketsClosed(int mostRecentNumberOfStandardTicketsClosed) {
        this.mostRecentNumberOfStandardTicketsClosed = mostRecentNumberOfStandardTicketsClosed;
    }

    /**
     * Set the most recent number of event tickets closed
     * @param mostRecentNumberOfEventTicketsClosed An int representing the most recent number of event tickets closed
     */
    public void setMostRecentNumberOfEventTicketsClosed(int mostRecentNumberOfEventTicketsClosed) {
        this.mostRecentNumberOfEventTicketsClosed = mostRecentNumberOfEventTicketsClosed;
    }

    /**
     * Set the most recent number of lost tickets closed
     * @param mostRecentNumberOfLostTicketsClosed An int representing the most recent number of lost tickets closed
     */
    public void setMostRecentNumberOfLostTicketsClosed(int mostRecentNumberOfLostTicketsClosed) {
        this.mostRecentNumberOfLostTicketsClosed = mostRecentNumberOfLostTicketsClosed;
    }
}
