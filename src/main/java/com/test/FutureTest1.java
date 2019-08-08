package com.test;

import java.util.concurrent.Callable;

public class FutureTest1 {

    public static class Task implements Callable<String> {
        @Override
        public String call() {
            String tid = String.valueOf(Thread.currentThread().getId());
            System.out.printf("Thread#%s : in call\n", tid);
            return tid;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Task().call());
    }
}
