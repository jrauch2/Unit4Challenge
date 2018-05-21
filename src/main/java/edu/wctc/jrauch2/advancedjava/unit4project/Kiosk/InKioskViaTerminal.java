package edu.wctc.jrauch2.advancedjava.unit4project.Kiosk;

import edu.wctc.jrauch2.advancedjava.unit4project.Abstract.InKiosk;
import edu.wctc.jrauch2.advancedjava.unit4project.Abstract.NumberedTicket;
import edu.wctc.jrauch2.advancedjava.unit4project.Abstract.Ticket;
import edu.wctc.jrauch2.advancedjava.unit4project.Interface.TicketTracker;
import edu.wctc.jrauch2.advancedjava.unit4project.Interface.UserInterface;
import edu.wctc.jrauch2.advancedjava.unit4project.Singleton.TicketFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

/**
 * This class is an in kiosk that displays to the terminal. It extends <b>InKiosk</b>  and implements
 * <b>UserInterface</b> and <b>Runnable</b>
 * @author Joshua Rauch
 * @version 1.0
 * @see edu.wctc.jrauch2.advancedjava.unit4project.Abstract.Kiosk
 * @see edu.wctc.jrauch2.advancedjava.unit4project.Abstract.InKiosk
 * @see edu.wctc.jrauch2.advancedjava.unit4project.Interface.UserInterface
 * @see java.lang.Runnable
 */
public class InKioskViaTerminal extends InKiosk implements UserInterface, Runnable {
    private final Logger LOGGER = LoggerFactory.getLogger(InKioskViaTerminal.class);
    private Scanner keyboard = new Scanner(System.in);
    private boolean open;

    /**
     * The constructor for <b>InKioskViaTerminal</b>
     * @param TICKET_TRACKER The <b>TicketTracker</b> instance for the garage program
     * @param TICKET_FACTORY The <b>TicketFactory</b> instance for the garage program
     * @param GARAGE_NAME A String containing the name of the garage
     * @param open boolean open. Is the garage open?
     */
    public InKioskViaTerminal(TicketTracker TICKET_TRACKER, TicketFactory TICKET_FACTORY, String GARAGE_NAME, boolean open) {
        super(TICKET_TRACKER, TICKET_FACTORY, GARAGE_NAME);
        this.open = open;
    }

    /**
     * Print the ticket
     * @param ticket Accepts a <b>Ticket</b> as a parameter
     */
    @Override
    public void printTicket(Ticket ticket) {
        System.out.println("\n\n\n\n");
        System.out.println("Take your ticket.\nTicket number: " + getTicketNumber((NumberedTicket) ticket));
        keyboard.nextLine();
    }

    /**
     * The in menu, printed to the terminal
     */
    @Override
    public void Menu() {
        System.out.println("\n\n\n\n");
        System.out.println(getHEADER());
        System.out.println("1 - Check/In");
        System.out.println("2 - Special Event");
        System.out.println("3 - Close Garage");
        int input = keyboard.nextInt();
        keyboard.nextLine();

        try {
            switch (input) {
                case 1:
                    printTicket(addStandardTicketToTicketTracker());
                    break;
                case 2:
                    printTicket(addEventTicketToTicketTracker());
                    break;
                case 3:
                    closeGarage();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid selection");
            }
        } catch(IllegalArgumentException e) {
            LOGGER.error(e.getLocalizedMessage());
        }
    }

    /**
     * Run the class in a thread
     */
    @Override
    public void run() {
       while (open) {
           Menu();
       }
    }
}