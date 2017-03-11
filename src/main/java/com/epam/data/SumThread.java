package com.epam.data;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static java.lang.Thread.sleep;

public class SumThread implements Runnable {
    private static final Logger LOGGER = LogManager.getLogger(SumThread.class);

    public void run() {
        while (true) {
            Integer integer = MainCollection.getInstance().getSumOfCollection();
            LOGGER.debug("Current sum of the numbers in the collection = " + integer);
            try {
                sleep(5000);
            } catch (InterruptedException e) {
                LOGGER.error(e.toString());
            }
        }
    }
}
