package com.epam.data;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Main {
    private static final Logger LOGGER = LogManager.getLogger();
    public static void main(String[] args) {
        LOGGER.info("Start program!");

        Thread a = new Thread(new WriteThread());
        Thread b = new Thread(new SquareThread());
        Thread c = new Thread(new SumThread());

        ExecutorService executor = Executors.newFixedThreadPool(3);
        executor.submit(new WriteThread());
        executor.submit(new SquareThread());
        executor.submit(new SumThread());

    }
}
