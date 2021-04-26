package com.lgy.service;

import com.lgy.pojo.UserSSO;

import java.util.List;

public interface UserSSOService {
    List<UserSSO> find(String userName,String passWorld);
    List<UserSSO> findById(String userName);
    Object findByIdOb(String userName,String passWorld);
}
