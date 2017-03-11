package com.epam.data;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MainCollection {
    private static final Logger LOGGER = LogManager.getLogger(MainCollection.class);

    private static MainCollection instance;
    private static CopyOnWriteArrayList<Integer> listOfData;
    private static Lock lock = new ReentrantLock();
    private static AtomicBoolean isCreated = new AtomicBoolean(false);


    private MainCollection() {
        listOfData = new CopyOnWriteArrayList<>();
    }

    public static MainCollection getInstance() {
        if (!isCreated.get()) {
            lock.lock();
            if (instance == null) {
                try {
                    instance = new MainCollection();
                    isCreated.getAndSet(true);
                } finally {
                    lock.unlock();
                }
            }
        }
        return instance;

    }

    public void writeToCollection() {
        int random = (int) (Math.random() * 10);
        listOfData.add(random);
        LOGGER.debug("Add element to the list: " + random);
    }

    public double getSquareRoot() {
        int sum = 0;
        for (Integer number : listOfData) {
            sum += Math.pow(number, 2);
        }
        return Math.sqrt(sum);
    }

    public int getSumOfCollection() {
        int sum = 0;
        for (Integer number : listOfData) {
            sum += number;
        }
        return sum;
    }

    public void showCollection() {
        LOGGER.debug("Items of collection");
        LOGGER.debug(listOfData.toString());

    }


}
