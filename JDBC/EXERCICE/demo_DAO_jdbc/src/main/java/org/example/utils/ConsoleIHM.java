package org.example.utils;

import org.example.models.Person;
import org.example.service.PersonService;

import java.util.List;
import java.util.Scanner;

public class ConsoleIHM {
    private static PersonService personService = new PersonService();
    private static Scanner scanner = new Scanner(System.in);

    public static void start() {
        boolean running = true;
        while (running) {
            System.out.println("1. Créer utilisateur");
            System.out.println("2. Modifier utilisateur");
            System.out.println("3. Supprimer utilisateur");
            System.out.println("4. Afficher tous les utilisateurs");
            System.out.println("5. Quitter");
            System.out.print("Choix : ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear the newline character

            switch (choice) {
                case 1:
                    createUser();
                    break;
                case 2:
                    updateUser();
                    break;
                case 3:
                    deleteUser();
                    break;
                case 4:
                    displayAllUsers();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Choix invalide !");
            }
        }
        System.out.println("Au revoir !");
    }

    private static void createUser() {
        System.out.print("Nom  : ");
        String firstName = scanner.nextLine();
        System.out.print("Prenom : ");
        String lastName = scanner.nextLine();


        personService.createPerson(firstName,lastName);
    }

    private static void updateUser() {
        System.out.print("ID de l'utilisateur à modifier : ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Clear the newline character

        Person person = personService.getPerson(id);
        if (person == null) {
            System.out.println("Utilisateur non trouvé !");
            return;
        }

        System.out.print("Nouveau nom d'utilisateur : ");
        String newFirstName = scanner.nextLine();
        System.out.print("Nouveau prenom : ");
        String newLastName = scanner.nextLine();

        person.setFirstName(newFirstName);
        person.setLastName(newLastName);

        personService.updatePerson(person);
        System.out.println("Utilisateur mis à jour avec succès !");
    }

    private static void deleteUser() {
        System.out.print("ID de l'utilisateur à supprimer : ");
        int id = scanner.nextInt();
        scanner.nextLine();

        personService.deletePerson(id);
        System.out.println("Utilisateur supprimé avec succès !");
    }

    private static void displayAllUsers() {
        List<Person> persons = personService.getALLperson();
        for (Person person : persons) {
            System.out.println(person);
        }
    }
}
