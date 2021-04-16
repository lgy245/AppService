package com.lgy.pojo;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class User {
    @NotNull(message = "id不能为空")
    private int id;
    @NotNull(message = "姓名不能为空")
    private String name;
    @NotNull(message = "年龄不能为空")
    @Max(value = 100)
    @Min(value = 1)
    private int age;
    private String passworld;

    public User(@NotNull(message = "id不能为空") int id, @NotNull(message = "姓名不能为空") String name, @NotNull(message = "年龄不能为空") @Max(value = 100) @Min(value = 1) int age, String passworld) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.passworld = passworld;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassworld() {
        return passworld;
    }

    public void setPassworld(String passworld) {
        this.passworld = passworld;
    }
}
