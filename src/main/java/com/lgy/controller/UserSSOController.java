package com.lgy.controller;

import com.lgy.customAnnotation.UserLoginToken;
import com.lgy.pojo.UserSSO;
import com.lgy.service.UserSSOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
 *@autor lgy
 *
 *@date 2021/4/26 14:25
 ****/
@RestController
@RequestMapping("/api")
public class UserSSOController {
    @Autowired
    UserSSOService userSSOService;
    @RequestMapping("/find")
    public List<UserSSO> find(@RequestParam(value = "userName") String userName,@RequestParam(value = "passWorld") String passWorld){
        return userSSOService.find(userName,passWorld);
    }
    @RequestMapping("/login")
    public Object findbyO(@RequestParam(value = "userName") String userName,@RequestParam(value = "passWorld") String passWorld){
        return userSSOService.findByIdOb(userName,passWorld);
    }
    @UserLoginToken
    @RequestMapping("/getMessage")
    public String getMessage(){
        return "通过验证";
    }
}
