package com.dao;

import com.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;

public interface UserMapper {

    User selectUserById(@Param("id") int id);


    int updateUser(HashMap map);
}
