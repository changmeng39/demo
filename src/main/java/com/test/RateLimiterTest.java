package com.test;

import com.google.common.util.concurrent.RateLimiter;

public class RateLimiterTest {
    //速率是每秒两个许可
    private static RateLimiter rateLimiter = RateLimiter.create(2.0);

    final private static String str = "0";

    public static void a(){
        double acquire = rateLimiter.acquire();
        System.out.println(acquire);
    }

    public static void main(String[] args) {
        for(int i=1;i<=10;i++){
            a();
        }
    }
}
