package com.test;

import java.math.BigDecimal;
import java.util.Vector;

public class BigDecimalTest {
    public static void main(String[] args) {
        System.out.println(BigDecimal.ZERO);
        BigDecimal zero = BigDecimal.ZERO;
        BigDecimal one = BigDecimal.ONE;
        BigDecimal ten = BigDecimal.TEN;
        System.out.println(one.compareTo(zero));
        System.out.println(BigDecimal.ZERO.compareTo(zero));
        System.out.println(one.compareTo(zero));
        System.out.println(zero.compareTo(one));
        System.out.println(ten.compareTo(one));

        Vector<String> vector = new Vector<String>();
        vector.add("a");
        System.out.println("vector" + vector.size());

    }
}
