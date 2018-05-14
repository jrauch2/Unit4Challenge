package edu.wctc.jrauch2.advancedjava.unit4project.Kiosk.Gui;

import edu.wctc.jrauch2.advancedjava.unit4project.Abstract.InKiosk;
import edu.wctc.jrauch2.advancedjava.unit4project.Abstract.NumberedTicket;
import edu.wctc.jrauch2.advancedjava.unit4project.Abstract.Ticket;
import edu.wctc.jrauch2.advancedjava.unit4project.Interface.TicketTracker;
import edu.wctc.jrauch2.advancedjava.unit4project.Interface.UserInterface;
import edu.wctc.jrauch2.advancedjava.unit4project.Singleton.TicketFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;

/**
 * This class is the GUI for an in kiosk and extends <b>InKiosk</b> while implementing <b>UserInterface</b> and <b>Runnable</b>
 * @author Joshua Rauch
 * @version 1.0
 * @see edu.wctc.jrauch2.advancedjava.unit4project.Abstract.Kiosk
 * @see edu.wctc.jrauch2.advancedjava.unit4project.Abstract.InKiosk
 * @see edu.wctc.jrauch2.advancedjava.unit4project.Interface.UserInterface
 * @see java.lang.Runnable
 */
public class InKioskGui extends InKiosk implements UserInterface, Runnable {
    private final Logger LOGGER = LoggerFactory.getLogger(InKioskGui.class);
    private JPanel mainPanel;
    private JButton checkInButton;
    private JButton specialEventButton;
    private JButton closeGarageButton;

    /**
     * The constructor for <b>InKioskGui</b>. The constructor attaches action listeners to the buttons
     * @param TICKET_TRACKER The instance of the singleton class <b>TicketTracker</b> for the garage program
     * @param TICKET_FACTORY The instance of the singleton class <b>TicketFactory</b> for the garage program
     * @param GARAGE_NAME A String containing the name of the garage program
     */
    public InKioskGui(TicketTracker TICKET_TRACKER, TicketFactory TICKET_FACTORY, String GARAGE_NAME) {
        super(TICKET_TRACKER, TICKET_FACTORY, GARAGE_NAME);

        checkInButton.addActionListener(e -> printTicket(addStandardTicketToTicketTracker()));
        specialEventButton.addActionListener(e -> printTicket(addEventTicketToTicketTracker()));
        closeGarageButton.addActionListener(e -> closeGarage());
    }

    /**
     * Print the ticket that has been generated
     * @param ticket Accepts a <b>Ticket</b> as a parameter
     */
    @Override
    protected void printTicket(Ticket ticket) {
        JOptionPane.showMessageDialog(mainPanel, "Take your ticket.\nTicket number: " + getTicketNumber((NumberedTicket) ticket));
    }

    /**
     * Generate the GUI
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
     * run the class in a thread
     */
    @Override
    public void run() {
        Menu();
    }
}