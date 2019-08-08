package com.test;

public class SingletonTest {
        private static SingletonTest instance;
        private SingletonTest (){

        }
        public static synchronized SingletonTest getInstance() {
            if (instance == null) {
                instance = new SingletonTest();
            }
            return instance;
    }

    public static void main(String[] args) {
        getInstance();
        final SingletonTest instance1 = SingletonTest.instance;
    }
}
