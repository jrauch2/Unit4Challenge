package edu.wctc.jrauch2.advancedjava.unit4project.Abstract;

import edu.wctc.jrauch2.advancedjava.unit4project.Interface.TicketTracker;
import edu.wctc.jrauch2.advancedjava.unit4project.Singleton.Sales;
import edu.wctc.jrauch2.advancedjava.unit4project.Singleton.TicketFactory;

/**
 * This abstract class is meant to be extended by classes designed to read garage data into the program,
 * i.e. from a CSV file or a database.
 * @author Joshua Rauch
 * @version 1.0
 */
public abstract class GarageDataIn {
    private final Sales SALES;
    private final TicketFactory TICKET_FACTORY;
    private final TicketTracker TICKET_TRACKER;

    /**
     * The constructor for <b>GarageDataIn</b>
     * @param sales The <b>Sales</b> enum from the garage program
     * @param ticketFactory The <b>TicketFactory</b> enum from the garage program
     * @param ticketTracker the <b>TicketTracker</b> enum from the garage program
     */
    public GarageDataIn(Sales sales, TicketFactory ticketFactory, TicketTracker ticketTracker) {
        this.SALES = sales;
        this.TICKET_FACTORY = ticketFactory;
        this.TICKET_TRACKER = ticketTracker;
    }

    /**
     * returns a variable referencing the <b>Sales</b> enum
     * @return a reference to the <b>Sales</b> enum
     */
    protected Sales getSALES() {
        return SALES;
    }

    /**
     * returns a variable referencing the <b>TicketFactory</b> enum
     * @return a reference to the <b>TicketFactory</b> enum
     */
    protected TicketFactory getTICKET_FACTORY() {
        return TICKET_FACTORY;
    }

    /**
     * returns a variable reference the <b>TicketTracker</b> enum
     * @return a reference to the <b>TicketTracker</b> enum
     */
    protected TicketTracker getTICKET_TRACKER() {
        return TICKET_TRACKER;
    }
}
