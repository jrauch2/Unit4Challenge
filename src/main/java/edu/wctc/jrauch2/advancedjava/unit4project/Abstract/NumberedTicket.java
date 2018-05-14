package edu.wctc.jrauch2.advancedjava.unit4project.Abstract;

import edu.wctc.jrauch2.advancedjava.unit4project.Enum.TicketType;

/**
 * This abstract class is to be extended by tickets that can have a ticket number
 * @author Joshua Rauch
 * @version 1.0
 * @see edu.wctc.jrauch2.advancedjava.unit4project.Abstract.Ticket
 * @see edu.wctc.jrauch2.advancedjava.unit4project.Interface.Closeable
 * @see edu.wctc.jrauch2.advancedjava.unit4project.Interface.Feeable
 */
public abstract class NumberedTicket extends Ticket {
    private final int TICKET_NUMBER;

    /**
     * The constructor for the abstract class <b>NumberedTicket</b>
     * @param ticketType The <b>TicketType</b> enum from the garage program
     * @param TICKET_NUMBER The <b>int</b> TICKET_NUMBER
     */
    public NumberedTicket(TicketType ticketType, int TICKET_NUMBER) {
        super(ticketType);
        this.TICKET_NUMBER = TICKET_NUMBER;
    }

    /**
     * Get ticket number
     * @return the int TICKET_NUMBER
     */
    public int getTicketNumber() {
        return TICKET_NUMBER;
    }
}
