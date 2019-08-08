package com.entity;


/**
 * 所有的枚举类型隐性地继承自java.lang.Enum 。
 * 枚举实质上还是类！而每个枚举的成员实质就是一个枚举类型的实例，
 * 他们默认都是public static final 修饰的。可以直接通过枚举类型名使用它们。
 * 建议：
 *      1.当你需要定义一组常量时，可以使用枚举类型
 *      2.尽量不要使用枚举的高级特性，事实上高级特性都可以使用普通类来实现，没有必要引入枚举，增加程序的复杂性
 */
public enum Color {
    RED,

    GREEN,

    BLUE;

    private static int number = Color.values().length;

    public static Color getRandomColor() {

        long random = System.currentTimeMillis() % number;

        switch ((int) random) {

            case 0:
                return Color.RED;
            case 1:
                return Color.GREEN;
            case 2:
                return Color.BLUE;
            default:
                return Color.RED;
        }
    }

    public static void main(String[] args) {
        System.out.println(getRandomColor());
        String a = "a_" + Color.RED;
        System.out.println(a);
        System.out.println("a_RED".equals(a));
    }
}
