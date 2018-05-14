package edu.wctc.jrauch2.advancedjava.unit4project;

import edu.wctc.jrauch2.advancedjava.unit4project.Interface.Garage;
import edu.wctc.jrauch2.advancedjava.unit4project.Singleton.BestValueParkingGarage;
import edu.wctc.jrauch2.advancedjava.unit4project.Ticket.StandardTicket;

import java.time.LocalDateTime;

/**
 * @author Joshua Rauch
 * @version 1.0
 */
public class ParkingGarageProgram {

    public static void main(String[] args) {
        Garage bestValue = BestValueParkingGarage.INSTANCE;
        bestValue.openGarage();
    }
}