package com.epam.data;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static java.lang.Thread.sleep;

public class SquareThread implements Runnable {
    private static final Logger LOGGER = LogManager.getLogger();

    public void run() {
        while (true) {
            double square = MainCollection.getInstance().getSquareRoot();
            LOGGER.debug("Current square root  of sum of squares of all numbers in the collection = " + square);
            try {
                sleep(5000);
            } catch (InterruptedException e) {
                LOGGER.error(e.toString());
            }
        }
    }
}
