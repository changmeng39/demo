package com.test;

public class SingletonTest1 {

    public static class Singleton {
        private static Singleton instance;
        private Singleton (){}
        public static Singleton getInstance() {
            if (instance == null) {
                instance = new Singleton();
            }
                return instance;
        }
    }
}
