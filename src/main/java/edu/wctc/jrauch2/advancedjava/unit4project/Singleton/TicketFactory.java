package edu.wctc.jrauch2.advancedjava.unit4project.Singleton;

import edu.wctc.jrauch2.advancedjava.unit4project.Abstract.Ticket;
import edu.wctc.jrauch2.advancedjava.unit4project.Ticket.EventTicket;
import edu.wctc.jrauch2.advancedjava.unit4project.Ticket.LostTicket;
import edu.wctc.jrauch2.advancedjava.unit4project.Ticket.StandardTicket;
import edu.wctc.jrauch2.advancedjava.unit4project.Enum.TicketType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This enum follows the singleton pattern as is the ticket factory for the garage program.
 * <b>!IMPORTANT!</b> The factory cannot generate tickets until <i>setMostRecentTicketNumber(int)</i> is called and
 * an int greater than -1 is passed to it
 * @author Joshua Rauch
 * @version 1.0
 * @see java.lang.Comparable
 * @see java.lang.Enum
 * @see java.io.Serializable
 */
public enum TicketFactory {
    INSTANCE;

    private final Logger LOGGER = LoggerFactory.getLogger(TicketFactory.class);
    private int mostRecentTicketNumber;

    /**
     * The private constructor for <b>TicketFactory</b>. <i>mostRecentTicketNumber</i> is initialized to -1,
     * the sentinal value. <i>setMostRecentTicketNumber(int)</i> must be called and <i>mostRecentTicketNumber</i>
     * set to an int grater than -1 for the factory to generate tickets
     */
    TicketFactory() {
        mostRecentTicketNumber = -1;
    }

    /**
     * set the most recent ticket number
     * @param mostRecentTicketNumber An int representing the most recent ticket number
     */
    public void setMostRecentTicketNumber(int mostRecentTicketNumber) {
        this.mostRecentTicketNumber = mostRecentTicketNumber;
    }

    /**
     * Get the most recent ticket number
     * @return An int representing the most recent ticket number
     */
    public int getMostRecentTicketNumber() {
        return mostRecentTicketNumber;
    }

    /**
     * Get a ticket
     * @param ticketType the type of ticket to generate
     * @return A Ticket oof the specified type
     */
    public Ticket getTicket(TicketType ticketType) {
        Ticket ticket = null;

        if (mostRecentTicketNumber != -1) {
            switch (ticketType) {
                case EVENT_TICKET:
                    ticket = new EventTicket(++mostRecentTicketNumber);
                    break;
                case LOST_TICKET:
                    ticket = new LostTicket();
                    break;
                case STANDARD_TICKET:
//                    The following line is how the program should operate
//                    ticket = new StandardTicket(++mostRecentTicketNumber, LocalDateTime.now());
//                    The following line generates a time for testing purposes and should be removed after testing
                    ticket = new StandardTicket(++mostRecentTicketNumber, RandomLocalDateTimeGenerator
                            .INSTANCE
                            .getRandomLocalDateTimeDateToday(7,12,0,59));
                    break;
            }
        } else {
            throw new IllegalArgumentException("mostRecentTicketNumber not set");
        }
        return ticket;
    }
}