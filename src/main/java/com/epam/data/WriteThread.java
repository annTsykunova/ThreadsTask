package com.epam.data;

import static java.lang.Thread.sleep;

public class WriteThread implements Runnable {

    public void run() {
        while (true) {
            MainCollection.getInstance().writeToCollection();
            MainCollection.getInstance().showCollection();
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
