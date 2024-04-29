package org.example;


import org.example.utils.Etudiant;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static Connection conn = null;

    public static void main(String[] args) throws SQLException {
        Etudiant etudiant = new Etudiant();
        while (true) {
            System.out.println("______________________________________");
            System.out.println("********** Student - JDBC*************");
            System.out.println("______________________________________");
            System.out.println("1. Ajouter un étudiant");
            System.out.println("2. Afficher tous les étudiants");
            System.out.println("3. Afficher les étudiants d'une classe");

            System.out.println("4. Supprimer un étudiant");
            System.out.println("0. Quitter");
            System.out.print("Choix : ");
            System.out.println("______________________________________");
            int choice = sc.nextInt();
            sc.nextLine(); // Clear the newline character

            switch (choice) {
                case 1:

                    etudiant.ajouterEtudiant();

                    break;
                case 2:
                   etudiant.afficherTous();
                    break;
                case 3:
                  etudiant.afficherEtudiantByClass();
                    break;
                case 4:
                 etudiant.deleteEtudiantByID();
                    break;
                case 0:
                    System.out.println("Au revoir !");
                    System.exit(0);
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        }
       public static void inputProfile () {
            String firstName = null;
            String lastName = null;
            String numClass = null;
            String dateDiplome = null;
            try {
                System.out.print("Merci de saisir le prénom: ");
                firstName = sc.nextLine();
                System.out.print("Merci de saisir le nom: ");
                lastName = sc.nextLine();
                System.out.print("Merci de saisir le nom de la classe : ");
                numClass = sc.nextLine();
                System.out.print("Merci de saisir la date du diplome: ");
                dateDiplome = sc.nextLine();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            Etudiant e = new Etudiant();
            etudiant.setFirstName(firstName);
            etudiant.setLastName(lastName);
            etudiant.setNumClass(numClass);
            //etudiant.setDateDiplome(dateDiplome);
            //etudiant.ajouterEtudiant(e);

        }

    }
}