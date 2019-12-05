package com.test;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrenthashmapTest {

    public static void main(String[] args) {
        ConcurrentHashMap map = new ConcurrentHashMap();
        map.putIfAbsent("map", "map1");
        map.putIfAbsent("map", "map2");
        System.out.println(map.get("map"));
        Set set = map.entrySet();
        System.out.println(set.size());
        System.out.println(map.isEmpty());
    }
}
