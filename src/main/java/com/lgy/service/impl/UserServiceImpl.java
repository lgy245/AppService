package com.lgy.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.lgy.mapper.UserMapper;
import com.lgy.pojo.User;
import com.lgy.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class UserServiceImpl implements UserService {
    @Autowired(required = false)
    private UserMapper userMapper;

    @Override
    public List<User> found(int id) {
       /* System.out.println(id);
        Map map = JSONObject.parseObject(id);
        System.out.println(map.get("id").toString());
       // JSONArray json = JSONArray.fromObject(id);
        int ids = Integer.valueOf(map.get("id").toString()).intValue();
        System.out.println(ids);
        System.out.println(list);*/
        System.out.println(1);
        List<User>  list = userMapper.found(id);
        System.out.println(list);

        return  list ;
    }

/*    @Override
    public boolean inesrtUser(User user) {
        return userMapper.inesrtUser(user);
    }

    @Override
    public List<User> foundbyUsername(String username, String passworld) {
        System.out.println(username+"======="+passworld);
        List<User> list =  userMapper.foundbyUsername(username,passworld);
        return list;
    }

    @Override
    public List<User> foundbyUsernameExistence(String username) {
        return userMapper.foundbyUsernameExistence(username);
    }*/
}
