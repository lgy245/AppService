package com.lgy.mapper;


import com.lgy.pojo.UserSSO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface UserSSOMapper {
    List<UserSSO> find(String userName,String passWorld);
    List<UserSSO> findById(String userName);
    List<UserSSO> findByIdOb(String userName,String passWorld);

}
