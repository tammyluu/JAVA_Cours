package org.example;

import org.example.utils.DataBaseManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Transaction {
    // transaction marche dès qu'on démare Statement
    public static void main(String[] args) {
        Connection connection = DataBaseManager.getConnection();
        try {
            // Désactive l'autocommit pour les transactions
            // par default , commit is auto commit : true
            connection.setAutoCommit(false);
            Statement statement = connection.createStatement();
            // execute 1 une fois
            statement.executeUpdate("INSERT INTO  person(first_name,last_name) VALUES ('Mohamed','Aijjou')");
            // modifier return 1 nbRows
            int nbRows = statement.executeUpdate("UPDATE person SET last_name = 'Aijou' WHERE first_name = 'Mohamed' ");
            //nbRows = 1 true -> commit
            /*if (nbRows == 1 ){
                connection.commit();
                System.out.println("Transaction validée");
            }else {

                    connection.rollback();
                    System.out.println("Transaction annulée");
            }*/
            connection.commit();

        }catch (SQLException e){
            System.out.println(e.getMessage());
            try {
                connection.rollback();
                System.out.println("Transaction annullée");
            }catch (SQLException er){
                System.out.println("Erreur lors de l'annulation de la transaction : "+er.getMessage());
            }
        }finally {
            // Close la connection
            DataBaseManager.closeConnection();
        }

    }
}
