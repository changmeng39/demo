//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.entity;

import java.util.HashMap;
import java.util.Map;

public enum Category {
    SYSTEM(1, "系统"),
    ALARM(2, "告警"),
    SERVICE(3, "服务"),
    OPERATION(4, "运营");

    private static Map<Integer, Category> enumMap = new HashMap();
    private int code;
    private String msg;

    Category(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public static Category of(int value) {
        return (Category)enumMap.get(value);
    }

    static {
        Category[] var0 = values();
        int var1 = var0.length;

        for(int var2 = 0; var2 < var1; ++var2) {
            Category e = var0[var2];
            enumMap.put(e.getCode(), e);
        }

    }
}
