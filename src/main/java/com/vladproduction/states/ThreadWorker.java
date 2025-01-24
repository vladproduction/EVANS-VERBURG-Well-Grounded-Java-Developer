package com.vladproduction.states;

import java.util.Random;

class ThreadWorker implements Runnable {
    private static final Random random = new Random();

    @Override
    public void run() {
        try {
            // Simulate being in the Running state
            System.out.println("Thread is now in the Running state.");
            // Simulate thread consuming time allocation
            Thread.sleep(random.nextInt(3000)); // Sleep for a random amount of time (0-3 seconds)
            System.out.println("Thread has completed its time slice and is being placed back to Ready state.");

            // Simulate another time allocation
            for (int i = 0; i < 3; i++) {
                // Check if the thread should wait (simulate wait condition)
                if (random.nextBoolean()) {
                    System.out.println("Thread is going to Wait state due to some condition.");
                    waitForCondition();
                } else {
                    System.out.println("Thread is back in the Running state.");
                    Thread.sleep(random.nextInt(3000));
                }
            }

            System.out.println("Thread has finished execution.");
        } catch (InterruptedException e) {
            System.out.println("Thread was interrupted.");
        }
    }

    private void waitForCondition() throws InterruptedException {
        // Simulate waiting for some external condition
        Thread.sleep(2000); // Wait for 2 seconds
        System.out.println("Thread has been notified and is returning to Ready state.");
    }
}
