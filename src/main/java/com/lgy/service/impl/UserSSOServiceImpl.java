package com.lgy.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lgy.mapper.UserSSOMapper;
import com.lgy.pojo.User;
import com.lgy.pojo.UserSSO;
import com.lgy.service.UserSSOService;
import com.lgy.until.Until;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Map;

/*
 *@autor
 *
 *@date 2021/4/26 14:24
 ****/
@Service
public class UserSSOServiceImpl implements UserSSOService {
    @Autowired(required = false)
    UserSSOMapper userSSOMapper;
    Jedis jedis = new Jedis("192.168.18.130",6380);
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
            String str = JSON.toJSONString(list.get(0));
            UserSSO userSS = JSON.parseObject(str,UserSSO.class);

            if(!userSS.getPassworld().equals(passWorld)){
                jsonObject.put("message","密码错误，请重新登录");
                return jsonObject;
            }else{
                // 用get token方法  获取token
                UserSSO userSSO = new UserSSO();
                userSSO.setName(userName);
                userSSO.setPassworld(passWorld);
                String token = Until.getToken(userSSO);//生成token
                 //判断 token 是否存在
                String getToke = jedis.get(token);
                if(getToke!="null"){
                    String json = JSONArray.toJSON(userSSO).toString();
                    System.out.println(json);
                    jedis.set(token, json);
                    System.out.println(0);
                    String getRedisToken = jedis.get(token);
                    System.out.println(getRedisToken);
                    UserSSO userSSO1 = JSONArray.parseObject(json, UserSSO.class);
                    System.out.println(userSSO1.getName());

                    System.out.println(1);

                }

                //放入并返回
                jsonObject.put("token",token);
                jsonObject.put("user",list);
                return jsonObject;
            }
        }
    }



}
