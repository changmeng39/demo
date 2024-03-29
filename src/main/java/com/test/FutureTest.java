package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;


public class FutureTest {
    public static class Task implements Callable<String> {
        @Override
        public String call() {
            String tid = String.valueOf(Thread.currentThread().getId());
            System.out.printf("Thread#%s : in call\n", tid);
            return tid;
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Future<String>> results = new ArrayList<Future<String>>();
        ExecutorService es = Executors.newCachedThreadPool();
        for(int i=0; i<100;i++)
            results.add(es.submit(new Task()));

        for(Future<String> res : results)
            System.out.println(res.get());
    }
}
