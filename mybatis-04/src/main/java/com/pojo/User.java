package com.pojo;

import lombok.Data;
import org.apache.ibatis.type.Alias;

//给实体类取别名
@Alias("user")
@Data
public class User {
    private int id;
    private String name;
    private String password;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }


}

