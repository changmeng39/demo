package com.application;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;

@RestController
public class getBeanController {

    @RequestMapping("getBean")
    public Bean getBean(Bean bean, HttpServletRequest request){
        return bean;
    }

    @RequestMapping(value = "getId/{id}",method = RequestMethod.POST)
    public String getId(@PathVariable int id){
        System.out.println(id);
        return "获取id" + id;
    }
}
