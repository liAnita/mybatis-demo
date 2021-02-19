package com.dao;

import com.pojo.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherMapper {

   public List<Teacher> selectTeacher(@Param("tid") int id);
}
