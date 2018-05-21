package edu.wctc.jrauch2.advancedjava.unit4project.Ticket;

import edu.wctc.jrauch2.advancedjava.unit4project.Abstract.Ticket;
import edu.wctc.jrauch2.advancedjava.unit4project.Enum.TicketType;
import edu.wctc.jrauch2.advancedjava.unit4project.Singleton.Sales;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LostTicket extends Ticket {

    private final Logger LOGGER = LoggerFactory.getLogger(LostTicket.class);

    public LostTicket() {
        super(TicketType.LOST_TICKET);
    }

    @Override
    public double calculateFee() {
        return 25;
    }

    @Override
    public void close() {
        Sales.INSTANCE.addToLostTicketRevenue(calculateFee());
        setPaid(true);
    }
}
