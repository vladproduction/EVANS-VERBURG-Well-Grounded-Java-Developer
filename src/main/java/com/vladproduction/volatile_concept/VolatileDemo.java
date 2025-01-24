package com.vladproduction.volatile_concept;

/**
 * rules govern a volatile field:
 * ■ The value seen by a thread is always reread from main memory before use.
 * ■ Any value written by a thread is always flushed through to main memory before the instruction completes.
 *
 * a volatile variable should only be used to model a variable where writes to the
 * variable don’t depend on the current state (the read state) of the variable. For cases
 * where the current state matters, you must always introduce a lock to be completely safe.
 * */
public class VolatileDemo {
    //create a volatile variable
    private static volatile boolean isRunning = true;

    public static void main(String[] args) {

        System.out.println("MainThread has started...");

        // Create a new thread that will stop after a condition is met
        Thread thread = new Thread(()->{
            while (isRunning){
                //simulating work
                System.out.println("Worker thread is running...");
                try{
                    Thread.sleep(1000); //simulating processing
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println("Worker thread is finished.");
        });

        //start the worker thread
        thread.start();

        // Main thread sleeps for a short time then stops the worker thread
        try {
            Thread.sleep(5000);   // Main thread sleeps for 500 ms
            isRunning = false;         // Changing the volatile variable
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Wait for the worker thread to finish
        try {
            thread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("MainThread has finished.");

    }
}
