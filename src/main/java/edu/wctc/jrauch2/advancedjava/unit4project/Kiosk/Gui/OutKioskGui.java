package edu.wctc.jrauch2.advancedjava.unit4project.Kiosk.Gui;

import edu.wctc.jrauch2.advancedjava.unit4project.Abstract.NumberedTicket;
import edu.wctc.jrauch2.advancedjava.unit4project.Abstract.Ticket;
import edu.wctc.jrauch2.advancedjava.unit4project.Enum.TicketType;
import edu.wctc.jrauch2.advancedjava.unit4project.Interface.TicketTracker;
import edu.wctc.jrauch2.advancedjava.unit4project.Abstract.OutKiosk;
import edu.wctc.jrauch2.advancedjava.unit4project.Interface.UserInterface;
import edu.wctc.jrauch2.advancedjava.unit4project.Singleton.TicketFactory;
import edu.wctc.jrauch2.advancedjava.unit4project.Ticket.StandardTicket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;

/**
 * This class is the GUI for an out kiosk and extends <b>OutKiosk</b> while implementing <b>UserInterface</b> and <b>Runnable</b>
 * @author Joshua Rauch
 * @version 1.0
 * @see edu.wctc.jrauch2.advancedjava.unit4project.Abstract.Kiosk
 * @see edu.wctc.jrauch2.advancedjava.unit4project.Abstract.OutKiosk
 * @see edu.wctc.jrauch2.advancedjava.unit4project.Interface.UserInterface
 * @see java.lang.Runnable
 */
public class OutKioskGui extends OutKiosk implements UserInterface, Runnable{
    private final Logger LOGGER = LoggerFactory.getLogger(OutKioskGui.class);
    private JPanel mainPanel;
    private JButton checkOutButton;
    private JButton lostTicketButton;

    /**
     * The constructor for <b>OutKioskGui</b>. Attaches action listeners to GUI buttons
     * @param TICKET_TRACKER The <b>TicketTracker</b> singleton class for the garage program
     * @param TICKET_FACTORY The <b>TicketFactory</b> singleton class for the garage program
     * @param GARAGE_NAME A String containing the name of the garage
     */
    public OutKioskGui(TicketTracker TICKET_TRACKER, TicketFactory TICKET_FACTORY, String GARAGE_NAME) {
        super(TICKET_TRACKER, TICKET_FACTORY, GARAGE_NAME);

        checkOutButton.addActionListener(e -> {
            int ticketNumber = -1;
            String input = JOptionPane.showInputDialog(mainPanel, "Enter your ticket number:");
            try {
                ticketNumber = Integer.parseInt(input);
            } catch (NumberFormatException ex) {
                LOGGER.error(ex.getLocalizedMessage() +"\nUser did not enter a number.");
                JOptionPane.showMessageDialog(mainPanel, getINVALID_TICKET_ERROR_MESSAGE());
            }
            if (ticketNumber > 0) {
                Ticket ticket = TICKET_TRACKER.getTicket(ticketNumber);
                if (ticket == null) {
                    JOptionPane.showMessageDialog(mainPanel, getINVALID_TICKET_ERROR_MESSAGE());
                } else if (isPaid(ticket)) {
                    JOptionPane.showMessageDialog(mainPanel, "Ticket already paid.");
                } else {
                    checkOutNumberedTicket(ticket);
                }
            }
        });
        lostTicketButton.addActionListener(e -> checkOutLostTicket());
    }

    /**
     * Check out a numbered ticket, display receipt
     * @param ticket The ticket in question
     */
    @Override
    protected void checkOutNumberedTicket(Ticket ticket) {
        closeTicket(ticket);
        JOptionPane.showMessageDialog(mainPanel, getHEADER() +
                "Receipt for ticket number: " +
                getTicketNumber((NumberedTicket) ticket) +
                "\n" +
                ((getTicketType(ticket) == TicketType.EVENT_TICKET) ? "Event Ticket" : (getTimeParked((StandardTicket) ticket).toHours() +
                        " hours parked") +
                        "\n" +
                        getTimeIn((StandardTicket)ticket).format(getHOUR_MINUTE_FORMATTER()) +
                        " - " +
                        getTimeOut((StandardTicket) ticket).format(getHOUR_MINUTE_FORMATTER())) +
                "\n" +
                getCURRENCY_FORMATTER().format(calculateFee(ticket)));
    }

    /**
     * Check out a lost ticket. generates a lost ticket and displays receipt information
     */
    @Override
    protected void checkOutLostTicket() {
        Ticket ticket = getTICKET_FACTORY().getTicket(TicketType.LOST_TICKET);
        getTICKET_TRACKER().addTicket(ticket);
        closeTicket(ticket);
        JOptionPane.showMessageDialog(mainPanel, getHEADER() + "Receipt for lost ticket\n" + getCURRENCY_FORMATTER().format(calculateFee(ticket)));
    }

    /**
     * Display the GUI menu
     */
    @SuppressWarnings("Duplicates")
    @Override
    public void Menu() {
        JFrame frame = new JFrame(getGARAGE_NAME());
        frame.setContentPane(mainPanel);
        frame.setPreferredSize( new Dimension( 640, 480 ) );
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Run the class in a thread
     */
    @Override
    public void run() {
        this.Menu();
    }
}