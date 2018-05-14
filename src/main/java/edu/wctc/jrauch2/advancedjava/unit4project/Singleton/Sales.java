package edu.wctc.jrauch2.advancedjava.unit4project.Singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This enum follows the singleton pattern and tracks the sales for the garage program
 * @author Joshua Rauch
 * @version 1.0
 * @see java.lang.Comparable
 * @see java.lang.Enum
 * @see java.io.Serializable
 */
public enum Sales {
    INSTANCE;

    private final Logger LOGGER = LoggerFactory.getLogger(Sales.class);
    private double totalCheckInRevenue;
    private double totalSpecialEventRevenue;
    private double totalLostTicketRevenue;

    /**
     * The private constructor for <b>Sales</b> sets the default values of the variables within <b>Sales</b>
     */
    Sales() {
        totalCheckInRevenue = 0;
        totalLostTicketRevenue = 0;
        totalSpecialEventRevenue = 0;
    }

    /**
     * Get the total check in revenue
     * @return a double representing total check in revenue
     */
    public double getTotalCheckInRevenue() {
        return totalCheckInRevenue;
    }

    /**
     * Get the total special event revenue
     * @return a double representing total special event revenue
     */
    public double getTotalSpecialEventRevenue() {
        return totalSpecialEventRevenue;
    }

    /**
     * Get the total lost ticket revenue
     * @return a double representing total lost ticket revenue
     */
    public double getTotalLostTicketRevenue() {
        return totalLostTicketRevenue;
    }

    /**
     * Add to total check in revenue
     * @param fee A double representing the fee to add to total check in revenue
     */
    public void addToTotalCheckInRevenue(double fee) {
        totalCheckInRevenue += fee;
    }

    /**
     * Add to total special event revenue
     * @param fee A double representing the fee to add to total special event revenue
     */
    public void addToTotalSpecialEventRevenue(double fee) {
        totalSpecialEventRevenue += fee;
    }

    /**
     * Add to total lost ticket revenue
     * @param fee A double representing the fee to add to total lost ticket revenue
     */
    public void addToLostTicketRevenue(double fee) {
        totalLostTicketRevenue += fee;
    }

    /**
     * Get total revenue
     * @return A double representing the total revenue from all ticket categories
     */
    public double getTotalRevenue() {
        return totalCheckInRevenue + totalSpecialEventRevenue + totalLostTicketRevenue;
    }
}
