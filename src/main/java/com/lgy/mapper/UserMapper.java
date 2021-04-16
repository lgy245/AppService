package com.lgy.mapper;

import com.lgy.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface UserMapper {
   /* Boolean inesrtUser(User user);
    List<User> foundbyUsername(String username,String passworld);
    List<User> foundbyUsernameExistence(String username);int id*/
    List<User> found(int id);

    /**
     * 查询当前所有检查项根据当前人员
     */
}
