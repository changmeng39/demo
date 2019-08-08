package com.entity;

public enum Langues {

    CHINESE("1","汉语"),

    ENGLISH("2", "英语");

    private String value;
    private String name;

    private Langues(String value, String name) {
        this.value = value;
        this.name = name;
    }

    public static void main(String[] args) {
        Langues chinese = Langues.CHINESE;
        System.out.println("CHINESE".equals(chinese.toString()));
        System.out.println(chinese.value);
        System.out.println(chinese.name);
        System.err.println("////////////////////////////////////////");
        Langues english = Langues.ENGLISH;
        System.out.println("ENGLISH".equals(english.toString()));
        System.out.println(english.value);
        System.out.println(english.name);
    }
}
