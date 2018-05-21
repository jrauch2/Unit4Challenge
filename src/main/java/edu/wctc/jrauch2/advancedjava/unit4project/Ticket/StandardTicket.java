package edu.wctc.jrauch2.advancedjava.unit4project.Ticket;

import edu.wctc.jrauch2.advancedjava.unit4project.Abstract.NumberedTicket;
import edu.wctc.jrauch2.advancedjava.unit4project.Enum.TicketType;
import edu.wctc.jrauch2.advancedjava.unit4project.Singleton.Sales;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.time.LocalDateTime;

public class StandardTicket extends NumberedTicket {

    private final Logger LOGGER = LoggerFactory.getLogger(StandardTicket.class);
    private final double MINIMUM_FEE = 5;
    private final double MAXIMUM_FEE = 15;
    private final double PER_HOUR_FEE = 1;
    private final int HOURS_INCLUDED_IN_MINIMUM_FEE = 3;
    private final LocalDateTime timeIn;
    private LocalDateTime timeOut;

    public StandardTicket(int TICKET_NUMBER, LocalDateTime timeIn) {
        super(TicketType.STANDARD_TICKET, TICKET_NUMBER);
        this.timeIn = timeIn;
    }

    @Override
    public double calculateFee() {
        double fee = 0;
        try {
            if (timeOut != null) {

                long hours = getTimeParked().toHours();
                if (hours <= HOURS_INCLUDED_IN_MINIMUM_FEE) {
                    fee = MINIMUM_FEE;
                } else {
                    hours -= HOURS_INCLUDED_IN_MINIMUM_FEE;
                    fee = MINIMUM_FEE + (hours * PER_HOUR_FEE);
                }
                if (fee >= MAXIMUM_FEE) {
                    fee = MAXIMUM_FEE;
                }
            }
        } catch (IllegalArgumentException e) {
            LOGGER.error(e.getLocalizedMessage());
        }
        return fee;
    }

    public LocalDateTime getTimeIn() {
        return timeIn;
    }

    public LocalDateTime getTimeOut() {
        return timeOut;
    }

    public Duration getTimeParked() {
        return Duration.between(timeIn, timeOut);
    }

    @Override
    public void close() {
        timeOut = LocalDateTime.now();
        Sales.INSTANCE.addToTotalCheckInRevenue(calculateFee());
        setPaid(true);
    }
}
