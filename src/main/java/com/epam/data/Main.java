package com.epam.data;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        executor.submit(new WriteThread());
        executor.submit(new SumThread());
        executor.submit(new SquareThread());
    }
}
