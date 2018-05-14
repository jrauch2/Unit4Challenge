package edu.wctc.jrauch2.advancedjava.unit4project.Kiosk;

import edu.wctc.jrauch2.advancedjava.unit4project.Abstract.NumberedTicket;
import edu.wctc.jrauch2.advancedjava.unit4project.Enum.TicketType;
import edu.wctc.jrauch2.advancedjava.unit4project.Interface.TicketTracker;
import edu.wctc.jrauch2.advancedjava.unit4project.Interface.UserInterface;
import edu.wctc.jrauch2.advancedjava.unit4project.Abstract.OutKiosk;
import edu.wctc.jrauch2.advancedjava.unit4project.Singleton.TicketFactory;
import edu.wctc.jrauch2.advancedjava.unit4project.Abstract.Ticket;
import edu.wctc.jrauch2.advancedjava.unit4project.Ticket.StandardTicket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

/**
 * This class is an out kiosk that prints to the terminal
 * @author Joshua Rauch
 * @version 1.0
 * @see edu.wctc.jrauch2.advancedjava.unit4project.Abstract.Kiosk
 * @see edu.wctc.jrauch2.advancedjava.unit4project.Abstract.OutKiosk
 * @see edu.wctc.jrauch2.advancedjava.unit4project.Interface.UserInterface
 * @see java.lang.Runnable
 */
public class OutKioskViaTerminal extends OutKiosk implements UserInterface, Runnable {
    private final Logger LOGGER = LoggerFactory.getLogger(OutKioskViaTerminal.class);
    private Scanner keyboard = new Scanner(System.in);

    /**
     * The constructor for <b>OutKioskViaTerminal</b>
     * @param TICKET_TRACKER The <b>TicketTracker</b> instance fpor the garage program
     * @param TICKET_FACTORY The <b>TicketFactory</b> instance for the garage program
     * @param garageName A String containing the name of the garage
     */
    public OutKioskViaTerminal(TicketTracker TICKET_TRACKER, TicketFactory TICKET_FACTORY, String garageName) {
        super(TICKET_TRACKER, TICKET_FACTORY, garageName);
    }

    /**
     * Display the menu in the terminal
     */
    @Override
    public void Menu() {
        int input;
        Ticket ticket;
        System.out.println("\n\n\n\n");
        System.out.println(getHEADER());
        System.out.println("1 - Check/Out");
        System.out.println("2 - Lost Ticket");
        input = keyboard.nextInt();
        keyboard.nextLine();

        switch (input) {
            case 1:
                System.out.println("\n\n\n\n");
                System.out.println(getHEADER());
                System.out.println("Enter your ticket number: ");
                input = keyboard.nextInt();
                keyboard.nextLine();
                ticket = getTICKET_TRACKER().getTicket(input);
                if (ticket == null) {
                    System.out.println(getINVALID_TICKET_ERROR_MESSAGE());
                    break;
                }else if (isPaid(ticket)) {
                    System.out.println("Ticket already paid. Press Enter to continue.");
                    keyboard.nextLine();
                } else {
                    checkOutNumberedTicket(ticket);
                }
                break;
            case 2:
                checkOutLostTicket();
        }
    }

    /**
     * Check out a numbered ticket.
     * @param ticket The ticket in question
     */
    @Override
    protected void checkOutNumberedTicket(Ticket ticket) {
        closeTicket(ticket);
        System.out.println("\n\n\n\n");
        System.out.println(getHEADER());
        System.out.println("Receipt for ticket number: " + getTicketNumber((NumberedTicket) ticket));
        System.out.println(((getTicketType(ticket) == TicketType.EVENT_TICKET) ? "Event Ticket" : (getTimeParked((StandardTicket) ticket).toHours() +
                " hours parked") +
                "\n" +
                getTimeIn((StandardTicket)ticket).format(getHOUR_MINUTE_FORMATTER()) +
                " - " +
                getTimeOut((StandardTicket) ticket).format(getHOUR_MINUTE_FORMATTER())) +
                "\n" +
                getCURRENCY_FORMATTER().format(calculateFee(ticket)));
        keyboard.nextLine();
    }

    /**
     * Check out a lost ticket
     */
    @Override
    protected void checkOutLostTicket() {
        Ticket ticket = getTICKET_FACTORY().getTicket(TicketType.LOST_TICKET);
        getTICKET_TRACKER().addTicket(ticket);
        closeTicket(ticket);
        System.out.println("\n\n\n\n");
        System.out.println(getHEADER() + "Receipt for lost ticket\n" + getCURRENCY_FORMATTER().format(calculateFee(ticket)));
        keyboard.nextLine();
    }

    /**
     * Run the class in a thread
     */
    @Override
    public void run() {
        while(true) {
            Menu();
        }
    }
}