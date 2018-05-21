package edu.wctc.jrauch2.advancedjava.unit4project.Abstract;

import edu.wctc.jrauch2.advancedjava.unit4project.Singleton.Sales;

/**
 * This abstract class is meant to be extended by classes designed to write garage data out from the program,
 *  * i.e. to a CSV file or a database.
 *  @author Joshua Rauch
 *  @version 1.0
 */
public abstract class GarageDataOut {
    private final Sales SALES;

    /**
     * The constructor for <b>GarageDataOut</b> accepts the parameter <b>Sales</b>.
     * @param sales The <b>Sales</b> enum from the Garage program
     */
    public GarageDataOut(Sales sales) {
        this.SALES = sales;
    }

    /**
     * returns a variable referencing the <b>Sales</b> enum
     * @return a reference to the <b>Sales</b> enum
     */
    public Sales getSALES() {
        return SALES;
    }

    /**
     * abstract method to be overridden in child classes
     */
    public abstract void outputGarageData();
}
