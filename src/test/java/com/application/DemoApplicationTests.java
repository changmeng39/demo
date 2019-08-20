package com.application;

import com.DemoApplication;
import com.controller.UserController;
import com.entity.User;
import com.service.UserService;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private UserService userService;

    @Resource
    private UserController userController;

    @Before
    public void init(){
        System.out.println("初始化````````````");
    }

    @Test
    public void test1() {
        List<User> all = userService.findAll();
        System.err.println("test1```"+all.size());
    }

    @Test
    public void test2(){
        List<User> all = userService.findAll();
        System.err.println("tset2```"+all.size());
    }

    @Test
    public void controllerTest(){
        List<User> all = userController.findAll();
        System.out.println("controllerTest``````" + all.size());
    }

    @After
    public void destroy(){
        System.out.println("销毁```````````````````");
    }

}
