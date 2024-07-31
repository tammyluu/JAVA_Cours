package org.example.utils;

import org.example.models.BankAccount;

import org.example.models.Customer;
import org.example.models.Operation;
import org.example.service.IBankService;

import java.util.Scanner;

public class IHM {
    private Scanner scanner;

    private String choix;

    private IBankService _bankService;

    public IHM(IBankService bankService){
        scanner = new Scanner(System.in);
        _bankService = bankService;
    }

    public void start(){
        do {
            menu();
            choix = scanner.nextLine();
            switch (choix){
                case "1" :
                    createAccountAndCustomer();
                    break;
                case "2" :
                    deposit();
                    break;
                case "3" :
                    withDrawal();
                    break;
                case "4" :
                    getAccountOperation();
                    break;
                case "5" :
                    showAllAccountCustomer();
                    break;
                case "6" :
                    addAccountToClient();
                    break;
                case "7" :
                    createCustomer();
                    break;

            }


        }while (!choix.equals("0"));
    }

    private void menu(){
        System.out.println("########## Menu Principal ##########");
        System.out.println("1- Création d'un client et son compte");
        System.out.println("2- Dépôt");
        System.out.println("3- Retrait");
        System.out.println("4- Affichage compte");
        System.out.println("5- Affichage de tous les compte d'un client");
        System.out.println("6- Ajouter un compte à un client");
        System.out.println("7- Création d'un client");
        System.out.println("0- Quitter");
        System.out.println(" Votre choix : ");
    }

    private void createAccountAndCustomer(){
        int idClient = createCustomer();
        BankAccount bankAccount = _bankService.createAndSaveAccount(idClient);
        System.out.println("Client et compte crée (id du compte : "+ bankAccount.getId() +" ) ");

    }
    private void deposit(){
        System.out.println("##### Choix 2 #####");
        System.out.println("Merci de saisir le numéro de compte (id) :");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Merci de saisir le montant du dépôt :");
        double montant = scanner.nextDouble();
        scanner.nextLine();
        if(_bankService.makeOperationDeposit(montant,id)){
            System.out.println("dépot réussi");
        }else {
            System.out.println("erreur");
        }

    }
    private void withDrawal(){
        System.out.println("##### Choix 3 #####");
        System.out.println("Merci de saisir le numéro de compte (id) :");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Merci de saisir le montant du retrait :");
        double montant = scanner.nextDouble();
        scanner.nextLine();
        if(_bankService.makeOperationWithDraw(montant*-1,id)){
            System.out.println("retrait réussi");
        }else {
            System.out.println("erreur");
        }
    }
    private void getAccountOperation(){
        System.out.println("##### Choix 4 #####");
        System.out.println("Merci de saisir le numéro de compte (id) :");
        int id = scanner.nextInt();
        scanner.nextLine();
        BankAccount bankAccount = _bankService.getAccount(id);
        if(bankAccount != null){
            for (Operation op : _bankService.getAllOperationsByIdAccount(bankAccount.getId())){
                System.out.println(op);
            }
            System.out.println("Solde actuelle du compte : "+bankAccount.getTotalAmount());
        }

    }
    private void showAllAccountCustomer(){
        System.out.println("##### Choix 5 #####");
        System.out.println("Merci de saisir le numéro du client (id) :");
        int id = scanner.nextInt();
        scanner.nextLine();
        _bankService.getAccountsByIdCustomer(id).forEach(e -> System.out.println(e));

    }
    private void addAccountToClient(){
        System.out.println("##### Choix 6 #####");
        System.out.println("Merci de saisir le numéro du client (id) :");
        int id = scanner.nextInt();
        scanner.nextLine();
        Customer customer = _bankService.getCustomerById(id);
        if(customer != null){
            BankAccount bankAccount = _bankService.createAndSaveAccount(customer.getId());
            if(bankAccount != null) {
                System.out.println("Compte crée avec l'id : "+bankAccount.getId()+" pour le client : "+customer.getLastName().toUpperCase());
            }
        }
    }
    private int createCustomer(){
        System.out.println("##### Choix 7 #####");
        System.out.println("##### Choix 1 #####");
        System.out.println("Merci de saisir le nom : ");
        String lastName = scanner.nextLine();
        System.out.println("Merci de saisir le prénom : ");
        String firstName = scanner.nextLine();
        System.out.println("Merci de saisir le téléphone : ");
        String phone = scanner.nextLine();
        Customer customer = _bankService.createAndSaveCustomer(firstName,lastName,phone);
        return customer.getId();
    }
}
