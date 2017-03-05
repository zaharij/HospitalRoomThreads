package com.company;

import java.util.Random;

public class Main {
    private final static double PROBABILITY_DOCTOR = 0.2;
    private final static double PROBABILITY_VISITOR = 0.3;

    public static void main(String[] args) throws InterruptedException {
        Room room = new Room();
        new Display(room);

        Random random = new Random();

        while(true){
            if (random.nextDouble() < PROBABILITY_DOCTOR) {
                new Doctor(room);
            }
            if (random.nextDouble() < PROBABILITY_VISITOR) {
                new Visitor(room);
            }
            Thread.sleep(300);
        }
    }
}