package org.example.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {
    public  static Connection getMySQLConnection() throws SQLException{
        // avec MySQL
        String url = "jdbc:mysql://localhost:3306/demo_jdbc";
        String userName = "root";
        String password = "admin";
        Connection conn = DriverManager.getConnection(url,userName, password);
        return conn;
    }
}
