package edu.wctc.jrauch2.advancedjava.unit4project.Singleton;

import edu.wctc.jrauch2.advancedjava.unit4project.Abstract.NumberedTicket;
import edu.wctc.jrauch2.advancedjava.unit4project.Interface.TicketTracker;
import edu.wctc.jrauch2.advancedjava.unit4project.Ticket.StandardTicket;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class ActiveTicketsTest {
    TicketTracker ticketTracker;
    NumberedTicket ticket;

    @Before
    public void setUp() {
        ticketTracker = ActiveTickets.INSTANCE;
        ticket = new StandardTicket(1, LocalDateTime.now());
        ticketTracker.addTicket(ticket);
    }

    @Test
    public void getTicket() {
        assertEquals("The ticket added should equal the ticket gotten", ticket, ticketTracker.getTicket(ticket.getTicketNumber()));
    }
}