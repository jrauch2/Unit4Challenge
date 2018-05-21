package edu.wctc.jrauch2.advancedjava.unit4project.Kiosk.Gui;

import edu.wctc.jrauch2.advancedjava.unit4project.Abstract.NumberedTicket;
import edu.wctc.jrauch2.advancedjava.unit4project.Singleton.ActiveTickets;
import edu.wctc.jrauch2.advancedjava.unit4project.Singleton.TicketFactory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit tests for <b>InKioskGui</b>
 */
public class InKioskGuiTest {
    InKioskGui inKioskGui;
    NumberedTicket standardTicket;
    NumberedTicket eventTicket;

    /**
     * Set the most recent ticket number in the ticket factory,
     * before all tests, instantiate a <b>StandardTicket</b> and an <b>EventTicket</b>
     */
    @Before
    public void setUp() {
        inKioskGui = new InKioskGui(ActiveTickets.INSTANCE, TicketFactory.INSTANCE, "Garage");
        inKioskGui.getTICKET_FACTORY().setMostRecentTicketNumber(0);
        standardTicket = (NumberedTicket) inKioskGui.addStandardTicketToTicketTracker();
        eventTicket = (NumberedTicket) inKioskGui.addEventTicketToTicketTracker();
    }

    /**
     * Test that the ticket returned by 'addStandardTicketToTicketTracker' is the same as the ticket in the tracker
     */
    @Test
    public void addStandardTicketToTicketTracker() {
        assertEquals("The ticket returned by 'addStandardTicketToTicketTracker' should be the same as the ticket in the tracker",
                standardTicket,
                inKioskGui.getTICKET_TRACKER().getTicket(standardTicket.getTicketNumber()));
    }

    /**
     * Test that the ticket returned by 'addEventTicketToTicketTracker' is the same as the ticket in the tracker
     */
    @Test
    public void addEventTicketToTicketTracker() {
        assertEquals("The ticket returned by 'addEventTicketToTicketTracker' should be the same as the ticket in the tracker",
                eventTicket,
                inKioskGui.getTICKET_TRACKER().getTicket(eventTicket.getTicketNumber()));
    }
}