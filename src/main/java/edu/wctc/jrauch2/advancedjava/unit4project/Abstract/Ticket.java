package edu.wctc.jrauch2.advancedjava.unit4project.Abstract;

import edu.wctc.jrauch2.advancedjava.unit4project.Enum.TicketType;
import edu.wctc.jrauch2.advancedjava.unit4project.Interface.Closeable;
import edu.wctc.jrauch2.advancedjava.unit4project.Interface.Feeable;

/**
 * This abstract class implements Feeable and Closeable
 * @author Joshua Rauch
 * @version 1.0
 * @see edu.wctc.jrauch2.advancedjava.unit4project.Interface.Closeable
 * @see edu.wctc.jrauch2.advancedjava.unit4project.Interface.Feeable
 */
public abstract class Ticket implements Feeable, Closeable {
    private final TicketType ticketType;
    private boolean paid;

    /**
     * The constructor for <b>Ticket</b>
     * @param ticketType The type of the ticket in the <b>TicketType</b> enum
     */
    public Ticket(TicketType ticketType) {
        this.ticketType = ticketType;
        paid = false;
    }

    /**
     * Get the ticket type
     * @return The <b>TicketType</b> of the ticket
     */
    public TicketType getTicketType() {
        return ticketType;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }
}
