package com.vladproduction.deadlock;

/**
 * A deadlock occurs when two or more threads are waiting indefinitely for each other to release locks.
 * In this example, Thread 1 acquires lock1 and then attempts to acquire lock2,
 * while Thread 2 acquires lock2 before trying to acquire lock1.
 * This circular wait condition leads to a deadlock situation,
 * where both threads are stuck waiting for each other to release their respective locks.
 *
 * Here:
 * To resolve deadlocks, a common approach is to impose an order on the lock acquisition
 * (such as always acquiring lock1 before lock2) or to use a timeout when trying to acquire a lock.
 */
class DeadlockExample {
    public static void main(String[] args) {
        final Object lock1 = new Object();
        final Object lock2 = new Object();

        // Thread 1 tries to lock lock1 then lock2
        Thread thread1 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println("Thread 1: Holding lock 1...");
                try {
                    // Simulate some work with lock1
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread 1: Waiting for lock 2...");

                synchronized (lock2) {
                    System.out.println("Thread 1: Acquired lock 2!");
                }
            }
        });

        // Thread 2 tries to lock lock2 then lock1
        Thread thread2 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println("Thread 2: Holding lock 2...");
                try {
                    // Simulate some work with lock2
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread 2: Waiting for lock 1...");

                synchronized (lock2) {
                    System.out.println("Thread 2: Acquired lock 1!");
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
