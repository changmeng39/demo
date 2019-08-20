package com.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ccc")
public class ClassController extends AbsController{

    @RequestMapping("abs")
    public void abs(){
        //super.aaa();
        System.out.println("我是子类");
    }

    @Override
    public void ccc() {
        System.out.println("ccc");
    }
}
