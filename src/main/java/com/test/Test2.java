package com.test;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Test2 implements Test<List<Map<String, String>>> {

    @Override
    public List<Map<String, String>> isT() {
        String str = "abcdef";
        return new ArrayList<Map<String, String>>();
    }

    public static <T> T ttt(Class<T> clazz) {
        return null;
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        String a = ttt(String.class);

        List ttt = ttt(List.class);

//        String a1 = "A";
//        System.out.println(a1.getBytes().length);
//
//        String a2 = "1";
//        System.out.println(a2.getBytes().length);

        final String UTF_8 = "UTF-8";

        final String unicode = "unicode";

        String a3 = "中国";
        System.out.println(a3.getBytes(UTF_8));

        System.out.println("|".getBytes(UTF_8));

        System.out.println("丨".getBytes(UTF_8));

        System.out.println("丨".getBytes(UTF_8));

        System.out.println("丨".getBytes(unicode));

        System.out.println("丨".getBytes(unicode));

        System.out.println("|".equals("丨"));

        System.out.println("|".hashCode());

        System.out.println("丨".hashCode());
        System.out.println("丨".hashCode());
        System.out.println("丨".hashCode());

    }
}