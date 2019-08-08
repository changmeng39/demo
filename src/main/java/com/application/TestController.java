package com.application;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    int a = 0;

    @RequestMapping("add")
    public int add (int num){
        a = a + num;
        return a;
    }
}
