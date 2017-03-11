package com.epam.data;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MainCollection {
    private static final Logger LOGGER = LogManager.getLogger(MainCollection.class);

    private static MainCollection instance;
    private static List<Integer> listOfData;
    private static Lock lock = new ReentrantLock();
    private static AtomicBoolean isCreated = new AtomicBoolean(false);


    private MainCollection() {
        listOfData = new ArrayList<>();
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
        int random = 0;
        try {
            lock.lock();
            random = (int) (Math.random() * 10);
            listOfData.add(random);
        } finally {
            LOGGER.debug("Add element to the list: " + random);

        }


    }

//    public void removeFromCollection() {
//        int random = (int) (Math.random() * 10);
//        listOfData.remove(listOfData.size()-1);
//        LOGGER.debug("Remove element from the list: " + random);
//    }

    public void getSquareRoot() {
        int sum = 0;
        try {
            lock.lock();
            for (Integer number : listOfData) {
                sum += Math.pow(number, 2);
            }
        } finally {
            LOGGER.debug("Current square root  of sum of squares of all numbers in the collection = " + Math.sqrt(sum));
            lock.unlock();
        }
    }

    public void getSumOfCollection() {
        int sum = 0;
        try {
            lock.lock();
            for (Integer number : listOfData) {
                sum += number;
            }
        } finally {
            LOGGER.debug("Current sum of the numbers in the collection = " + sum);
            lock.unlock();
        }
    }

    public void showCollection() {
        try {
            LOGGER.debug("Items of collection");
            LOGGER.debug(listOfData.toString());
        } finally {
            lock.unlock();
        }
    }


}
