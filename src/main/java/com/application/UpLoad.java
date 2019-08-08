package com.application;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UpLoad {

    @RequestMapping("upLoad")
    public String upLoad(){
        return "打包上传````````````````````";
    }
}
