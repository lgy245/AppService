package com.lgy.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lgy.mapper.UserSSOMapper;
import com.lgy.pojo.User;
import com.lgy.pojo.UserSSO;
import com.lgy.service.UserSSOService;
import com.lgy.until.Until;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 *@autor
 *
 *@date 2021/4/26 14:24
 ****/
@Service
public class UserSSOServiceImpl implements UserSSOService {
    @Autowired(required = false)
    UserSSOMapper userSSOMapper;

    @Override
    public List<UserSSO> find(String userName, String passWorld) {
        return userSSOMapper.find(userName,passWorld);
    }

    @Override
    public List<UserSSO> findById(String userName) {

        return userSSOMapper.findById(userName);
    }

    @Override
    public Object findByIdOb(String userName,String passWorld) {
        JSONObject jsonObject = new JSONObject();
        //判断当前用户是否能登录成功

        List<UserSSO> list = userSSOMapper.findById(userName);
        if (list.size()==0){
            jsonObject.put("message","用户不存在");
            return jsonObject;
        }else{
            System.out.println(list.get(0));
            String str = JSON.toJSONString(list.get(0));
            UserSSO userSS = JSON.parseObject(str,UserSSO.class);
            System.out.println(userSS.getName());
            if(!userSS.getPassworld().equals(passWorld)){
                jsonObject.put("message","密码错误，请重新登录");
                return jsonObject;
            }else{
                // 用get token方法  获取token
                UserSSO userSSO = new UserSSO();
                userSSO.setName(userName);
                userSSO.setPassworld(passWorld);
                String token = Until.getToken(userSSO);//生成token
                //放入并返回
                jsonObject.put("token",token);
                jsonObject.put("user",list);
                return jsonObject;
            }
        }
    }



}
