package com.vladproduction.synchronized_concept;

public class SharedCounter {

    private int counter = 0;

    // synchronized method to ensure thread-safe incrementing a common shared data:
    public synchronized void increment(){
        counter++;                       // incrementing counter
        System.out.printf("Counter incremented to: %d\n", counter);
    }

    // getter for access counter value:
    public synchronized int getCounter(){
        return counter;
    }

}
