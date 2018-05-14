package edu.wctc.jrauch2.advancedjava.unit4project.Interface;

import edu.wctc.jrauch2.advancedjava.unit4project.Abstract.Ticket;

/**
 * Interface for a ticket tracker
 * @author Joshua Rauch
 * @version 1.0
 */
public interface TicketTracker {
    /**
     * Add a ticket to the ticket tracker
     * @param ticket The ticket to add to the ticket tracker
     */
    void addTicket(Ticket ticket);

    /**
     * Get a ticket from the ticket tracker
     * @param ticketNumber An int representing the number of the ticket
     * @return The ticket that matches the ticket number
     */
    Ticket getTicket(int ticketNumber);

    /**
     * Get the number of standard tickets that have been issued and closed
     * @return an int representing the number of closed standard tickets
     */
    int getNumberOfStandardTicketsClosed();

    /**
     * get the number of event tickets that have been issued and closed
     * @return An int representing the number of event tickets closed
     */
    int getNumberOfEventTicketsClosed();

    /**
     * Get number of lost tickets issued and closed
     * @return an int representing the number of lost tickets closed
     */
    int getNumberOfLostTicketsClosed();

    /**
     * Set the most recent number of standard tickets closed
     * @param mostRecentNumberOfStandardTicketsClosed An int representing the most recent number of standard tickets closed
     */
    void setMostRecentNumberOfStandardTicketsClosed(int mostRecentNumberOfStandardTicketsClosed);

    /**
     * Set the most recent number of event tickets closed
     * @param mostRecentNumberOfEventTicketsClosed An int representing the most recent number of event tickets closed
     */
    void setMostRecentNumberOfEventTicketsClosed(int mostRecentNumberOfEventTicketsClosed);

    /**
     * Set the most recent number of lost tickets closed
     * @param mostRecentNumberOfLostTicketsClosed An int representing the most recent number of lost tickets closed
     */
    void setMostRecentNumberOfLostTicketsClosed(int mostRecentNumberOfLostTicketsClosed);
}
