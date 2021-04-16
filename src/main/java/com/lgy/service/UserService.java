package com.lgy.service;

import com.lgy.pojo.User;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface UserService {
    /*@RequestBody String id*/
    List<User> found(int id);
/*    boolean inesrtUser(@RequestBody @Validated User user);
    List<User> foundbyUsername(String username,String passworld);
    List<User> foundbyUsernameExistence(String username);*/

}
