package edu.wctc.jrauch2.advancedjava.unit4project.Singleton;

import edu.wctc.jrauch2.advancedjava.unit4project.Abstract.Ticket;
import edu.wctc.jrauch2.advancedjava.unit4project.Enum.TicketType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test the Ticket Factory
 */
public class TicketFactoryTest {
    TicketFactory ticketFactory;
    Ticket standardTicket;
    Ticket eventTicket;
    Ticket lostTicket;

    /**
     * Before each test, create tickets of each type
     */
    @Before
    public void setUp() {
        ticketFactory = TicketFactory.INSTANCE;
        standardTicket = ticketFactory.getTicket(TicketType.STANDARD_TICKET);
        eventTicket = ticketFactory.getTicket(TicketType.EVENT_TICKET);
        lostTicket = ticketFactory.getTicket(TicketType.LOST_TICKET);
    }

    /**
     * Test that a standard ticket was created
     */
    @Test
    public void getStandardTicket() {
        assertEquals("Ticket type should match", TicketType.STANDARD_TICKET, standardTicket.getTicketType());
    }

    /**
     * Test that an event ticket was created
     */
    @Test
    public void getEventTicket() {
        assertEquals("Ticket type should match", TicketType.EVENT_TICKET, eventTicket.getTicketType());
    }

    /**
     * Test that a lost ticket was created
     */
    @Test
    public void getLostTicket() {
        assertEquals("Ticket type should match", TicketType.LOST_TICKET, lostTicket.getTicketType());
    }
}