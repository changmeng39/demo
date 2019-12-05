package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.entity.Category;
import com.entity.Color;
import com.entity.Langues;
import com.entity.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/userList/**")
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("insertUser")
    public int insert(User user){
        user.setName("哎哎哎");
        return userService.insert(user);
    }

    @RequestMapping("Category")
    public Category color(Category category){
        System.out.println(category);
        return category;
    }

    @RequestMapping("getJson")
    public String getJson(JSONObject jsonObject){
        System.out.println(jsonObject.toString());
        return jsonObject.toJSONString();
    }

    @RequestMapping("req")
    public void req(HttpServletRequest req){
        String requestURL = req.getRequestURL().toString();
        String s = requestURL.split("/")[requestURL.split("/").length-2];
        System.out.println(requestURL);
        System.out.println(s);
        String s1 = requestURL.split("/")[requestURL.split("/").length-1];
        System.out.println(s1);
        String param = urlParameters(req);
        System.out.println(param);
    }

    public static String urlParameters(HttpServletRequest httpServletRequest) {
        String parameters = "";
        Enumeration enu = httpServletRequest.getParameterNames();
        while (enu.hasMoreElements()) {
            String paraName = (String) enu.nextElement();
            parameters += paraName + "=" + httpServletRequest.getParameter(paraName) +"&";
        }
        return parameters;
    }
}
