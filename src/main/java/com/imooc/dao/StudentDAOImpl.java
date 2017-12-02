package com.imooc.dao;

import com.imooc.domain.Student;
import com.imooc.util.JDBCUtil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {
  @Override
  public List<Student> query() {
    List<Student> studentList = new ArrayList<>();
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    String sql = "SELECT id, name, age FROM spring_data.student";
    try {
      connection = JDBCUtil.getConnection();
      preparedStatement = connection.prepareStatement(sql);
      resultSet = preparedStatement.executeQuery();
      Student student;
      while(resultSet.next()){
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        int age = resultSet.getInt("age");
        student = new Student();
        student.setId(id);
        student.setName(name);
        student.setAge(age);
        studentList.add(student);
      }
    } catch (ClassNotFoundException | SQLException | IOException e) {
      e.printStackTrace();
    } finally {
      JDBCUtil.release(resultSet, preparedStatement, connection);
    }
  
    return studentList;
  }
  
  @Override
  public void save(Student student) {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    String sql = "INSERT INTO spring_data.student(name, age) VALUES (?,?)";
    try {
      connection = JDBCUtil.getConnection();
      preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setString(1, student.getName());
      preparedStatement.setInt(2, student.getAge());
      preparedStatement.executeUpdate();
    } catch (ClassNotFoundException | SQLException | IOException e) {
      e.printStackTrace();
    } finally {
      JDBCUtil.release(null, preparedStatement, connection);
    }
  }
}
