package com.test;


import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HashMap {
    public static void main(String[] args) {

        Set<String> hashSet = new HashSet<String>();
        hashSet.add("语文");
        hashSet.add("数学");
        hashSet.add("英语");
        hashSet.add("历史");
        hashSet.forEach(u -> System.err.println(u));



        Map<String, Integer> map = new java.util.HashMap<String, Integer>();
        map.put("语文", 1);
        map.put("数学", 2);
        map.put("英语", 3);
        map.put("历史", 4);
        map.put("政治", 5);
        map.put("地理", 6);
        map.put("生物", 7);
        map.put("化学", 8);
        Map<String, Integer> m = Collections.synchronizedMap(map);
        for(Map.Entry<String, Integer> entry : m.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
