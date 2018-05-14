package edu.wctc.jrauch2.advancedjava.unit4project.Interface;

/**
 * Interface for Garages
 * @author Joshua Rauch
 * @version 1.0
 */
public interface Garage {
    /**
     * Get the name of the garage
     * @return A string containing the name of the garage
     */
    String getGARAGE_NAME();

    /**
     * Get the name of the file where the garage data is stored
     * @return A string containing the name of the file where the garage data is stored
     */
    String getGARAGE_DATA_FILE_NAME();

    /**
     * Is the garage open?
     * @return A boolean representing if the garage is open
     */
    boolean isGarageOpen();

    /**
     * Set if the garage is open
     * @param garageOpen A boolean representing if the garage is open
     */
    void setGarageOpen(boolean garageOpen);

    /**
     * Open the garage
     */
    void openGarage();

    /**
     * Close the garage
     */
    void closeGarage();
}
