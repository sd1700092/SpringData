package com.imooc.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtil {
  public static Connection getConnection() throws ClassNotFoundException, SQLException, IOException {

  
    InputStream inputStream = JDBCUtil.class.getClassLoader().getResourceAsStream("db.properties");
    
    Properties properties = new Properties();
    properties.load(inputStream);
  
    String driverClass = properties.getProperty("jdbc.driverClass");
    String url = properties.getProperty("jdbc.url");
    String user = properties.getProperty("jdbc.user");
    String password = properties.getProperty("jdbc.password");
    
    Class.forName(driverClass);
    Connection connection = DriverManager.getConnection(url, user, password);
    return connection;
  }
  
  public static void release(ResultSet resultSet, Statement statement, Connection connection){
    if(resultSet!=null){
      try {
        resultSet.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    if(statement!=null){
      try {
        statement.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    if(connection!=null){
      try {
        connection.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }
}
