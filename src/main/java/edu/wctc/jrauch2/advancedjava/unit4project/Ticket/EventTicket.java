package edu.wctc.jrauch2.advancedjava.unit4project.Ticket;

import edu.wctc.jrauch2.advancedjava.unit4project.Abstract.NumberedTicket;
import edu.wctc.jrauch2.advancedjava.unit4project.Enum.TicketType;
import edu.wctc.jrauch2.advancedjava.unit4project.Singleton.Sales;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EventTicket extends NumberedTicket {

    private final Logger LOGGER = LoggerFactory.getLogger(EventTicket.class);

    public EventTicket(int TICKET_NUMBER) {
        super(TicketType.EVENT_TICKET, TICKET_NUMBER);
    }

    @Override
    public double calculateFee() {
        return 20;
    }

    @Override
    public boolean isPaid() {
        return paid;
    }

    @Override
    public void close() {
        Sales.INSTANCE.addToTotalSpecialEventRevenue(calculateFee());
        paid = true;
    }
}
