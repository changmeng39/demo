package com.controller;

import org.springframework.web.bind.annotation.RequestMapping;

public abstract class AbsController {

    @RequestMapping({""})
    //@RequestMapping("fulei")
    public void aaa(){
        System.out.println("我是父类");
    }

    @RequestMapping("ccc")
    public abstract void ccc();
}
