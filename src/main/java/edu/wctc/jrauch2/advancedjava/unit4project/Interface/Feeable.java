package edu.wctc.jrauch2.advancedjava.unit4project.Interface;

/**
 * Inteface for things that are feeable
 * @author Joshua Rauch
 * @version 1.0
 */
public interface Feeable {
    /**
     * Calculate a fee
     * @return A double representing the fee calculated
     */
    double calculateFee();

    /**
     * Is the feeable thing paid?
     * @return A boolean representing if the feeable thing is paid
     */
    boolean isPaid();
}
