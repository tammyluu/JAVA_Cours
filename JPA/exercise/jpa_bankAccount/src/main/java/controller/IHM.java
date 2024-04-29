package controller;

import entity.Account;
import entity.BranchBank;
import entity.Customer;
import impl.AccountDAO;
import impl.BranchDAO;
import impl.CustomerDAO;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class IHM {
    private static EntityManagerFactory entityManagerFactory;
    private static BranchDAO branchDAO;
    private static AccountDAO accountDAO;
    private static CustomerDAO customerDAO;
    public static void Menu()  {
        entityManagerFactory = Persistence.createEntityManagerFactory("banque_bdd");
        branchDAO = new BranchDAO(entityManagerFactory);
        customerDAO = new CustomerDAO(entityManagerFactory);
        accountDAO = new AccountDAO(entityManagerFactory);

        Scanner scanner = new Scanner(System.in);
        int choice;
        do{
            System.out.println("\n################ Gestion de Banque ###################");
            System.out.println(" 1. Créer une banque");
            System.out.println(" 2. Afficher les infos d'une banque");
            System.out.println(" 3. Créer un client");
            System.out.println(" 4. Afficher les infos d'un client");
            System.out.println(" 5. Créer un compte");
            System.out.println(" 6. Afficher les infos d'un compte");
            System.out.println(" 7. Supprimer un compte");
            System.out.println(" 8. Supprimer un client");
            System.out.println(" 0. Quitter l'application");
            System.out.println("#################### ************ ####################");
            System.out.print(" Votre Choix : ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:
                    createABank(scanner);
                    break;
                case 2:

                    break;
                case 3:
                    createCustomer(scanner);
                    break;
                case 4:

                    break;
                case 5:
                    createAccount(scanner);
                    break;
                case 6:

                    break;
                case 7:
                    deleteAccount(scanner);
                    break;
                case 8:
                    deleteCustomer(scanner);
                    break;
                case 0:
                    System.out.println("Bye");
                    entityManagerFactory.close();
                    break;
                default:
                    System.out.println("\nChoix invalide. Veuillez entrer une valeur numérique!.");
            }

        }while (choice!= 0);

    }

    private static void deleteCustomer(Scanner scanner) {
        System.out.println("Veuillez indiquer l'id  à quelle  client supprimé:");
        Long idCustomer = scanner.nextLong();
        scanner.nextLine();
        accountDAO.deleteById(idCustomer);
        System.out.println("Ce client supprimé\n");

    }

    private static void deleteAccount(Scanner scanner) {
        System.out.print("Indiquer l'id  à quelle  compte bancaire supprimé:");
        Long idAcccount = scanner.nextLong();
        scanner.nextLine();
        accountDAO.deleteById(idAcccount);
        System.out.println("Ce compte supprimé\n");

    }

    private static void createAccount(Scanner scanner) {
        System.out.print("A quelle agence souhaitez- vous : ");
        Long id = scanner.nextLong();
        BranchBank bank = branchDAO.getById(id);
        System.out.print("À quel client désirez-vous associer ce compte: ");
        Long customerId = scanner.nextLong();
        System.out.print("Quel est le libelle : ");
        String label = scanner.nextLine();
        System.out.print("Quel est l'IBAN (longueur maximale : 27 caractères): ");
        String iban = scanner.nextLine();
        Account account = new Account(label,iban,bank);
        accountDAO.createAndSave(account);
        System.out.print("Un compte de banque créé\n");

    }

    private static void createCustomer(Scanner scanner) {
           try {
               System.out.print("Entrer votre nom : ");
               String lastName = scanner.next();
               System.out.print("Entrer votre prenom : ");
               String firstName = scanner.next();
               System.out.print("Entrert votre date de naissance en format dd-MM-yyyy");
               String date_string = scanner.next();
               SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
               Date date = formatter.parse(date_string);
               Customer customer = new Customer(lastName,firstName,date);
               customerDAO.createAndSave(customer);
           }catch (ParseException e){
               System.out.println(  e.getMessage());
                        }

    }

    private static void createABank(Scanner scanner) {
        System.out.print("Entrer l'address de l'argence: ");
        String address = scanner.nextLine();
        BranchBank bank = new BranchBank();
        bank.setAddress(address);
        branchDAO.createAndSave(bank);
        System.out.println("Une agence de banque créé\n");

    }
}
