package com.dao;

import com.pojo.User;

import java.util.HashMap;
import java.util.List;


public interface UserMapper {
    //查询所有用户的信息
    List<User> getAllUSer();

    //根据id查询用户信息
    User selectUserById(int id);

    //新增一个用户
    int addUser(User user);

    //更新用户信息
    int updateUser(HashMap user);
//    int updateUser(User user);

    //删除用户
    int deleteUser(String name);

    //模糊查询
    List<User> selectByLike(String value);

}


