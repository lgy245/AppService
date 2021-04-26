package com.lgy.controller;

import com.lgy.pojo.User;
import com.lgy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 *@autor lgy
 *
 *@date 2021/4/8 14:30
 ****/
@RestController
@RequestMapping("/user")
public class UserLogin {
    @Autowired
    UserService userService;
    @RequestMapping("/fuck")
    public List<User> login(){
        System.out.println(1);
        return userService.found(1);
    }
   /* @RequestMapping("/login")
    public String login(HttpServletRequest request){
        String username = request.getParameter("username");
        String passworld = request.getParameter("password");
        System.out.println(username);
        System.out.println(passworld);
        List<User> list = userService.foundbyUsername(username,passworld);
        System.out.println(list.size());
        if(list.size()==0){

            return "views/login";
        }else {
            return "index";
        }
    }
    @RequestMapping("/userRegister")
    public String userRegister(HttpServletRequest request){
        String username = request.getParameter("username");
        String passworld = request.getParameter("password");
        String age = request.getParameter("age");
        int id = Until.MathRodem();
        List<User> findByUserName = userService.foundbyUsernameExistence(username);
        System.out.println(MD5Encoder.encode(passworld.getBytes()));
        if(findByUserName.size()!=0){
            return "views/login";
        }else{
            boolean insertUser =   userService.inesrtUser(new User(id,username,Integer.valueOf(age),MD5Encoder.encode(passworld.getBytes())));
            return "views/login";
        }
         }

*/




}
