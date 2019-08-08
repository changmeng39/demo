package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.entity.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/userList")
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("insertUser")
    public int insert(User user){
        user.setName("哎哎哎");
        return userService.insert(user);
    }

    @RequestMapping("getJson")
    public String getJson(JSONObject jsonObject){
        System.out.println(jsonObject.toString());
        return jsonObject.toJSONString();
    }
}
