package com.dao;

import com.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;


public interface UserMapper {
    @Select("select * from user")
    List<User> getAllUser();

//    @Select("select * from user where id = #{id}")
//    User selectById(@Param("id") int id);
//
//    @Insert("insert into user(name,pwd) values (#{name,password})")
//    int insert(User user);
//
//    @Update("update user where name = #{name}")
//    int update(@Param("name") String name);
//
//    @Delete("delete from user where id = #{id}")
//    int delete(@Param("id") int id);
}



