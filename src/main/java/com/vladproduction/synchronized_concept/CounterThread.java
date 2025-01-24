package com.vladproduction.synchronized_concept;

public class CounterThread implements Runnable{

    private SharedCounter sharedCounter;

    public CounterThread(SharedCounter sharedCounter) {
        this.sharedCounter = sharedCounter;
    }

    @Override
    public void run() {
        //incrementing counter
        for (int i = 0; i < 5; i++) {
             sharedCounter.increment();
             try{
                 Thread.sleep(200); //faking delay
             } catch (InterruptedException e){
                 e.printStackTrace();
             }
        }
    }
}
