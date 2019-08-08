package com.test;

import org.hibernate.validator.constraints.EAN;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class sortTest {

    public static void main(String[] args) {
        char a = 65;
        List<Integer> list = new ArrayList<Integer>();
        list.add(5);
        list.add(4);
        list.add(2);
        list.add(1);
        list.add(3);
        Collections.sort(list);
        list.forEach(l -> System.out.println(l));

        for(final Integer l : list){
            System.out.println(l);
        }

        List<String> listS = new ArrayList<String>();
        listS.add("e");
        listS.add("a");
        listS.add("d");
        listS.add("b");
        listS.add("c");
        Collections.sort(listS);
        listS.forEach(l -> System.err.println(l));
    }
}
