package com.epam.data;

import static java.lang.Thread.sleep;

public class SquareThread implements Runnable {

    public void run() {
        while (true) {
            MainCollection.getInstance().getSquareRoot();
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
