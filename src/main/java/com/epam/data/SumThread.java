package com.epam.data;

import static java.lang.Thread.sleep;

public class SumThread implements Runnable {

    public void run() {
        while (true) {
            MainCollection.getInstance().getSumOfCollection();
            try {
                sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
