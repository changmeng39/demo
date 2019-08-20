package com.test;

public class Class1 extends Class2{

    public void class1(){
        super.c2();
        System.out.println("我是class1");
    }


    public static void main(String[] args) {
        Class1 c = new Class1();
        c.class1();
    }
}
