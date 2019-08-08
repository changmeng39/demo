package com.test;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest1 {

    private static int count = 10;

    private static CountDownLatch countDownLatch = new CountDownLatch(count);

    static class BossThread implements Runnable{

        @Override
        public void run() {
            System.out.println("老板在会议室等待，总共有" + count + "个人开会...");
            try {
                //老板等待
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("都到齐了,开会吧````````````````" +System.currentTimeMillis());
        }
    }

    static class EmpThread implements Runnable{

        @Override
        public void run() {
            //try {
                Thread thread = Thread.currentThread();
                System.out.println(thread.getName() + "到达: " +System.currentTimeMillis() + "还剩余" + (countDownLatch.getCount() - 1)  + "人");
            //}catch (Exception e){
                //System.out.println(e);
            //}finally {
                countDownLatch.countDown();
            //}
        }
    }
    public static void main(String[] args) throws InterruptedException {

        BossThread bossThread = new BossThread();
        EmpThread empThread = new EmpThread();

        new Thread(bossThread).start();

        for(int i = 0;i < count; i++){
            Thread.sleep(1000);
            new Thread(empThread).start();
        }

    }
}
