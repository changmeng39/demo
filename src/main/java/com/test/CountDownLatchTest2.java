package com.test;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest2 {

    private static int count = 110;

    private static CountDownLatch countDownLatch = new CountDownLatch(count);

    static class player extends Thread{
        @Override
        public void run() {
            try {
                System.out.println("选手姓名:"+this.getName()+"选手编号:"+this.getId()+ "到达终点`````````时间: " + System.currentTimeMillis());
            }catch (Exception e){
                e.fillInStackTrace();
            }finally {
                countDownLatch.countDown();
            }
        }
    }

    static class referee extends Thread{
        @Override
        public void run() {
            System.out.println("发令员编号:"+this.getId()+"名称:"+this.getName()+"各就各位....预备.....砰````````" + System.currentTimeMillis());
            try {
                //等待
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("发令员编号:"+this.getId()+"名称:"+this.getName()+"宣布:比赛结束````````````````````" + System.currentTimeMillis());
        }
    }

    public static void main(String[] args) {
        new referee().start();

        for(int i=0;i<count;i++){
            new player().start();
        }
    }
}
