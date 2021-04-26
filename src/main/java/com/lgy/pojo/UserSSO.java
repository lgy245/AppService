package com.lgy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 *@autor
 *
 *@date 2021/4/26 14:21
 ****/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserSSO {
    private  int id;
    private String name;
    private String passworld;

}
