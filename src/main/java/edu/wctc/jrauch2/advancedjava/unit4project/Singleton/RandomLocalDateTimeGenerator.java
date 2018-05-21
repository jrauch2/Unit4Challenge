package edu.wctc.jrauch2.advancedjava.unit4project.Singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Random;

/**
 * This enum follows the singleton pattern and is used to generate a LocalDateTime
 * @author Joshua Rauch
 * @version 1.0
 * @see java.io.Serializable
 * @see java.lang.Enum
 * @see java.lang.Comparable
 */
public enum RandomLocalDateTimeGenerator {
    INSTANCE;

    private final Logger LOGGER = LoggerFactory.getLogger(RandomLocalDateTimeGenerator.class);

    /**
     * Get a <b>LocalDateTime</b> of date today and time randomly generated within the range set by the parameters
     * @param hourMin An int representing the inclusive minimum range for the hour
     * @param hourMax An int representing the inclusive maximum range for the hour
     * @param minuteMin An int representing the inclusive minimum range for the minute
     * @param minuteMax An int representing the inclusive maximum range for the minute
     * @return A <b>LocalDateTime</b> from today with a randomly generated time between the given range
     */
    public LocalDateTime getRandomLocalDateTimeDateToday(int hourMin, int hourMax, int minuteMin, int minuteMax) {
        if (hourMin < 0 || hourMin > 23) {
            throw new IllegalArgumentException("The minimum hour range cannot be less than 0 or more than 23");
        } else if (hourMax < 0 || hourMax > 23) {
            throw new IllegalArgumentException("The maximum hour range cannot be less than 0 or more than 23");
        }
        return LocalDateTime.of(LocalDate.now(), LocalTime.of(getRandomNumberInRange(hourMin,hourMax), getRandomNumberInRange(minuteMin, minuteMax)));
    }

    /**
     * Get a random number within a given range. the minimum and maximum are both inclusive
     * @param min An int representing the inclusive minimum for the range
     * @param max An int representing the inclusive maximum for the range
     * @return
     */
    private int getRandomNumberInRange(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("min must be less than max");
        }
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}
