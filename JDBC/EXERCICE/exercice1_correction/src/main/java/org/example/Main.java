package org.example;


import org.example.utils.DataBaseManager;
import org.example.utils.IHM;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        // test de la connection
        /*
        try{
            DataBaseManager dataBaseManager = new DataBaseManager();
            Connection connection = dataBaseManager.getConnection();
            if (connection != null){
                System.out.println("connexion ok !");
            }else {
                System.out.println("connexion nok !!!");
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

         */
        new IHM().start();
    }
}