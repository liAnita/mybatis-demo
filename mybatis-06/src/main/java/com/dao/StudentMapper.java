package com.dao;

import com.pojo.Student;

import java.util.List;

public interface StudentMapper {

    public List<Student> selectStudent_v1();

    public List<Student> selectStudent_v2();
}
