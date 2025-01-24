package com.vladproduction.states;

import java.util.Random;

class ThreadSchedulerDemo {
    public static void main(String[] args) {
        ThreadWorker worker = new ThreadWorker();
        Thread thread = new Thread(worker);

        System.out.println("Thread is initially in the Ready state.");
        thread.start();
    }
}

