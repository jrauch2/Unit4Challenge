package edu.wctc.jrauch2.advancedjava.unit4project.Enum;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This enum store the various types of tickets
 * @author Joshua Rauch
 * @version 1.0
 * @see java.io.Serializable
 * @see java.lang.Comparable
 * @see java.lang.Enum
 */
public enum TicketType {
    EVENT_TICKET, LOST_TICKET, STANDARD_TICKET;

    private final Logger LOGGER = LoggerFactory.getLogger(TicketType.class);
}