package com.dao;

import com.pojo.Teacher;
import org.apache.ibatis.annotations.Param;

public interface TeacherMapper {

   public Teacher selectTeacher(@Param("tid") int id);
   public Teacher selectTeacher2(@Param("tid") int id);
}
