package com.epam.data;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static java.lang.Thread.sleep;

public class WriteThread implements Runnable {
    private static final Logger LOGGER = LogManager.getLogger(WriteThread.class);

    public void run() {
        while (true) {
            MainCollection.getInstance().writeToCollection();
            MainCollection.getInstance().showCollection();
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                LOGGER.error(e.toString());
            }
        }
    }

}
