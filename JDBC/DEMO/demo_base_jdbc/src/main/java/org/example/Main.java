package org.example;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        // connection à bdd demo_jdbc mySQL
    String url = "jdbc:mysql://localhost:3306/demo_jdbc";

        try {
            Connection conn = DriverManager.getConnection(url,"root", "admin");
            if (conn != null){
            System.out.println(" Connection OK");
        }else {
            System.out.println("Connection KO !!!!!! ");
        }
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    // Meilleur pratique mettre la connection dans une classe a part
    }

}