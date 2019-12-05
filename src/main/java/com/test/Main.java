package com.test;

import com.application.MyException;
import com.entity.Color;
import com.entity.User;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        System.out.println(3*0.1==0.3);

        float a1 = 3.88084E7f * 1000000;

        //float b1 = a1 * 1000000;

        System.out.println(a1);
        //System.out.println(b1);

        int aa = 26 * 8 - 3 - 1;
        int bb = 28 * 8 - 4;

//        aa = aa + bb; // 15
//        bb = aa - bb; // 5
//        aa = aa - bb; // 10
//
        System.out.println(aa);
//
        System.out.println(bb);


        Map<String, Object> map = new HashMap<String, Object>();
        map.put("1", "a");

        System.out.println(map.entrySet());

        System.out.println("abcd".compareTo("abcd"));

        int id = 1;

        System.out.println(id == 0x01);

        System.out.println(id);

        User user = new User();
        if (user==null){
            System.out.println("new 出来的 user为null");
        }else if (user.equals(new User())){
            System.out.println("new 出来的 user不为null");
        }else {
            System.out.println("都不对");
        }

        String str = "abcdef";
        if(null == str) { // 空指针判定
            System.out.println(0);
        }
        System.out.println(str.length());

        System.out.println(Optional.ofNullable(str).map(String::length).orElse(0));

        SingletonDemo.INSTANCE.otherMethods();

        System.out.println(Color.RED + "");

        System.out.println(Color.BLUE.name());

        int a = -5;
        if (a > 0){
            System.out.println("此处正常");
        }else {
            throw new MyException("自定义异常");
        }
    }
}
