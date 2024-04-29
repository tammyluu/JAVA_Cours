package org.example.utils;

import org.example.entity.Student;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class IHM {
    private Scanner scanner;

    public IHM() {
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        String choix;
        do {
            menu();
            choix = scanner.nextLine();
            switch (choix) {
                case "1":
                    addStudent();
                    break;
                case "2":
                    getAllStudent();
                    break;
                case "3":
                    getAllStudentByCLass();
                    break;
                case "4":
                    deleteStudent();
                    break;

            }

        } while (!choix.equals("0"));
    }
    private void menu(){
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
        }

    private  void  addStudent(){
        System.out.println("Saisir le prénom: ");
        String firstName = scanner.nextLine();
        System.out.println("Saisir le nom: ");
        String lasttName = scanner.nextLine();
        System.out.println("Saisir le numéro de class: ");
        int nbClass = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Saisir la date du diplome: ");
        String dateDegreeString = scanner.nextLine();
        // servir pour parse
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date dateDegree = null;
        try{
            dateDegree = dateFormat.parse(dateDegreeString); // date vient d'objet java util
        }catch (ParseException e){
            dateDegree = new Date("01/01/2005");
        }
        Student student = new Student(firstName,lasttName,nbClass,dateDegree);
        // l'envoie à BDD et grâce à méthode save()
        try {
            if (student.save()){
                System.out.println("Etudiant ajouté avec l'id: " + student.getId());
            }else {
                System.out.println("Erreur d'engistrement en BDD!!!");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    private  void getAllStudent(){
        try {
            //n'a pas besoins de l'instancer car dans la classe de Student a methode static
            Student.getAll().forEach(e -> System.out.println(e));
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    private  void getAllStudentByCLass(){
        try {
            System.out.println("Saisir le numéro de class: ");
            int nbClass = scanner.nextInt();
            scanner.nextLine();
            //n'a pas besoins de l'instancé car dans la classe de Student a methode static
            Student.getByClass(nbClass).forEach(e -> System.out.println(e));
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    private  void deleteStudent(){
        System.out.println("Saisir l'id d'étudiant': ");
        int idStudent = scanner.nextInt();
        scanner.nextLine();
        try {
            // besoins de l'instancé obj car il n'est pas méthode static
            Student student = Student.getById(idStudent);
            // à la fin renvoye un student null  ou un student avec data
            if (student != null){
                // si not null, renvoyer data de student: passe bien -> nbrRow envoyé
                if (student.delete()){
                    System.out.println("Etudiant supprimé!");
                }
            }else {
                System.out.println("pas d'étudiant avec ce id");
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}