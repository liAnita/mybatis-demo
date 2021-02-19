package com.dao;

import com.pojo.User1;

import java.util.HashMap;
import java.util.List;


public interface UserMapper {
    //查询所有用户的信息
    List<User1> getAllUser();

    //根据id查询用户信息
    User1 selectUserById(int id);

    //新增一个用户
    int addUser(User1 user);

    //更新用户信息
    int updateUser(HashMap user);
//    int updateUser(User user);

    //删除用户
    int deleteUser(String name);

    //模糊查询
    List<User1> selectByLike(String value);

    List<User1> selectByLimit(HashMap<String, Object> map);

    List<User1> selectRowBound();

}



