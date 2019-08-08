package com.application;

public class MyException extends RuntimeException {

    // 提供一个有参数的构造方法，可自动生成
    public MyException(String message) {
        super(message);// 把参数传递给Throwable的带String参数的构造方法
    }
}
