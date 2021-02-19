package com.dao;

import com.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.HashMap;
import java.util.List;


public interface UserMapper {
    //查询所有用户的信息
    @Select("select * from user")
    List<User> getAllUser();

    //根据id查询用户信息
    @Select("select * from user where id = #{id}")
    User selectUserById(@Param("id") int id);

    //新增一个用户
    @Insert("insert into user (name,pwd) values (#{name},#{password})")
    int addUser(User user);

    //更新用户信息
    @Update("update user set name = #{name} where id = #{id}")
    int updateUser(HashMap user);
//    int updateUser(User user);

    //删除用户
    @Delete("delete from user where name = #{name}")
    int deleteUser(String name);

    //模糊查询
    List<User> selectByLike(String value);

    List<User> selectByLimit(HashMap<String, Object> map);

    List<User> selectRowBound();

}



