package org.example.utils;

import java.sql.*;
import java.util.Date;
import java.util.Scanner;

public class Etudiant {
    private int id;
    private String firstName;
    private String lastName;
    private String numClass;
    private Date dateDiplome;
    public static int count = 0;
    public Scanner sc = new Scanner(System.in);
    public Connection conn = null;

    public Etudiant() {
        this.id = ++count;
    }

    public Etudiant(String firstName, String lastName, String numClass, Date dateDiplome) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.numClass = numClass;
        this.dateDiplome = dateDiplome;

    }

    public String getNumClass() {
        return numClass;
    }

    public void setNumClass(String numClass) {
        this.numClass = numClass;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateDiplome() {
        return dateDiplome;
    }

    public void setDateDiplome(Date dateDiplome) {
        this.dateDiplome = dateDiplome;
    }

    @Override
    public String toString() {
        return "Etudiant{" +
                "id = " + id +
                ", firstName = '" + firstName + '\'' +
                ", lastName = '" + lastName + '\'' +
                ", numClass = '" + numClass + '\'' +
                ", dateDiplome = " + dateDiplome +
                '}';
    }

    public void ajouterEtudiant() throws SQLException {
        try {
            conn = ConnectionUtils.getMySQLConnection();
            String request = "INSERT INTO etudiant (first_Name, last_Name, num_class, date_diplome)" +
                    " VALUES ('" + firstName + "', '" + lastName + "' , '" + numClass + "', '" + dateDiplome + "' )";
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public  void afficherTous () {
        try {
            conn = ConnectionUtils.getMySQLConnection();
            System.out.println("Connection OK");
            String request = "SELECT * FROM etudiant";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(request);
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id") + " | " + resultSet.getString("first_Name") + "  " + resultSet.getString("last_Name")
                        + " | " + resultSet.getString("num_class") + " | " + resultSet.getDate("date_diplome"));

            }
            statement.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            // Fermer la connexion à la BDD
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.out.println((e.getMessage()));
                }

            }
        }
    }
    public void afficherEtudiantByClass() {
        try {
            conn = ConnectionUtils.getMySQLConnection();
            System.out.print("Merci de saisir le nom de classe : ");
            String numClass = sc.nextLine();
            String request = "SELECT * FROM etudiant WHERE num_class = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(request);
            preparedStatement.setString(1, numClass);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id") + " | " +
                        resultSet.getString("first_Name") + "  " +
                        resultSet.getString("last_Name") + " | " +
                        resultSet.getString("num_class") + " | " +
                        resultSet.getDate("date_diplome"));
            }

            preparedStatement.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void deleteEtudiantByID () {
        try {
            conn = ConnectionUtils.getMySQLConnection();
            System.out.print("Merci de saisir id: ");
            String id = sc.nextLine();
            String request = "DELETE FROM etudiant WHERE id =?";
            PreparedStatement preparedStatement = conn.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, id);
            int nbRowsDelete = preparedStatement.executeUpdate(); // retour int
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            System.out.println("Nombre de ligne: " + nbRowsDelete);
            if (nbRowsDelete > 0) {
                System.out.println("Étudiant supprimé avec succès.");
            }else {
                System.out.println("Aucun étudiant trouvé avec le nom spécifié.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
    }


}