package org.example;

import org.example.utils.ConnectionUtils;

import java.sql.*;
import java.util.Scanner;

public class Demo2 {
    public static void main(String[] args) {
        /*try {
            Connection connection = ConnectionUtils.getMySQLConnection();
            if (connection != null){
                System.out.println("Connection Ok !!!");
            }else {
                System.out.println("Connection KO !!!!!");
            }
        }catch (SQLException e){
            throw new RuntimeException();
        }*/
        Scanner sc = new Scanner(System.in);
        Connection conn = null;
        try {
            conn = ConnectionUtils.getMySQLConnection();
            System.out.println("Connection OK");
            /*System.out.print("Merci de saisir le prénom: ");
            String firstName = sc.nextLine();
            System.out.print("Merci de saisir le nom: ");
            String lastName = sc.nextLine();*/
            // Une requete ppour l'insertin de données
            //String request = "INSERT INTO person (first_Name, last_Name) VALUES ('"+firstName+"', '"+lastName+"')";

            // premier solution => execution d'unr requete sans retour
           /* Statement statement = conn.createStatement();
             boolean res = statement.execute(request);
            System.out.println("Requête executée");
            System.out.println(res);*/

            // 2ème solution => avec une requêt préparée
           // String request = "INSERT INTO person (first_Name, last_Name) VALUES (?,?)";

            // version sans recuparation de l'id

            /* PreparedStatement preparedStatement = conn.prepareStatement(request);
            preparedStatement.setString(1,firstName);
            preparedStatement.setString(2,lastName);
            preparedStatement.execute(); // retour boolean
            int nbRows = preparedStatement.executeUpdate(); // retour int
            // sur DB il effecte 2 ligne : execute et executeUpdate. Mais sur le programme il execut 1 ligne
            System.out.println("Nombre de ligne: " + nbRows); // par raport ce qu'il execute : 1 ligne*/

            // version avec recuparation de l'id
            /*PreparedStatement preparedStatement = conn.prepareStatement(request,Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,firstName);
            preparedStatement.setString(2,lastName);
            int nbRows = preparedStatement.executeUpdate(); // retour int
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            System.out.println("Nombre de ligne: " + nbRows);
            if (resultSet.next()){
                System.out.println(resultSet.getInt(1));
            }*/

            /*---------- Avec requête de lecture-----------------  */
            String request = "SELECT * FROM person";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(request);
            while (resultSet.next()){
                System.out.println(resultSet.getInt("id")+ " , " + resultSet.getString("first_Name")+" , " +resultSet.getString("last_Name"));
            }
            statement.close();

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }finally {
            // Fermer la connexion à la BDD
            if (conn != null) {
                try{
                    conn.close();
                }catch (SQLException e){
                    System.out.println((e.getMessage()));
                }

            }
        }

    }
}
