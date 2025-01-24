package com.vladproduction.synchronized_concept;

/**
 * To demonstrate the concept of synchronization in Java, we'll create a simple example involving a shared object that multiple threads access.
 * This example will highlight how data consistency is maintained through the synchronized keyword.
 *
 * In this example, we have a shared counter class that is accessed by multiple threads.
 * The changes to the counter are synchronized to ensure that concurrent access does not lead to inconsistent data.
 * */
public class SynchronizedConceptApp {
    public static void main(String[] args) {

        //one thread running in the main thread
        /*Thread thread = new Thread(new CounterThread(new SharedCounter()));
        thread.start();*/

        //two threads trying to increment a common object (SharedCounter)
        SharedCounter sharedCounter = new SharedCounter(); //object

        Thread thread1 = new Thread(new CounterThread(sharedCounter)); //creating thread and task
        Thread thread2 = new Thread(new CounterThread(sharedCounter)); //creating thread and task
        Thread thread3 = new Thread(new CounterThread(sharedCounter)); //creating thread and task

        //starting threads:
        thread1.start();
        thread2.start();
        thread3.start();

        //wait for both threads to finish:
        try{
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("Get total result after two threads finished execution: " + sharedCounter.getCounter());



    }
}
