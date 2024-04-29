package org.example;

import org.example.utils.DataBaseManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MultipleRows {
    public static void main(String[] args) {
        Connection connection = DataBaseManager.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            String request = "INSERT INTO  person(first_name,last_name) VALUES (?,?)";
            preparedStatement = connection.prepareStatement(request);
            String[][] stagaires = {
                    {"Remi","Jospin"} ,
                    {"Clémence","Petite"} ,
                    {"Olivia","Dubois"}
            };
            // insertion des stagiaires en BDD
            for (String[] stagaire : stagaires){
                preparedStatement.setString(1,stagaire[0]);
                preparedStatement.setString(2,stagaire[1]);
                // ajouter la rêquete au Batch (plusieurs requete même temps)
                preparedStatement.addBatch();
            }
            // execution de la rêquete Batch
            int[] nbRows = preparedStatement.executeBatch();
            System.out.println("Nombres de lignes insérées : " + nbRows.length);
            preparedStatement.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }finally {
            DataBaseManager.closeConnection();
        }
    }
}
