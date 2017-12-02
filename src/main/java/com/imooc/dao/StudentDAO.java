package com.imooc.dao;

import com.imooc.domain.Student;

import java.util.List;

public interface StudentDAO {
  
  List<Student> query();
  
  void save(Student student);
}
