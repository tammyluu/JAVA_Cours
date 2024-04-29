package org.example.utils;

import org.example.models.BankAccount;
import org.example.models.Client;
import org.example.models.Operation;
import org.example.service.BankAccountService;
import org.example.service.ClientService;
import org.example.service.IBankService;
import org.example.service.OperationService;

import java.awt.color.ICC_ColorSpace;
import java.util.List;
import java.util.Scanner;

public class IHM {
    private IBankService _bankService;
    private String choix;
     public   Scanner sc = new Scanner(System.in);
    private  ClientService clientService = new ClientService();
    private   BankAccountService bankAccountService = new BankAccountService();
    private   OperationService operationService = new OperationService();

    public IHM(IBankService bankService){
        Scanner sc = new Scanner(System.in);
        _bankService = bankService;
    }
    public static void startMenu(){
        boolean running = true;
        while (running) {
            System.out.println("\n--------------Menu Principal-----------------");
            System.out.println(" 1. Créer d'un nouveau client et son compte");
            System.out.println(" 2. Dépôt d'argent pour son compte");
            System.out.println(" 3. Retrait d'argent de son compte");
            System.out.println(" 4. Affichage compte");
            System.out.println(" 5. Affichage de tous les comptes d'un client");
            System.out.println(" 6. Ajouter un compte à un client");
            System.out.println(" 7. Créer d'un nouveau client");
            System.out.println(" 0. Quitter");
            System.out.println("---------------------------------------------\n");
            System.out.print("Choix : ");

            int choice = sc.nextInt();
            sc.nextLine(); // Clear the newline character

            switch (choice) {
                case 1:
                    createAccountAndCustomer();
                    break;
                case 2:
                     deposit();
                    break;
                case 3:
                    withDrawal();
                    break;
                case 4:
                    getAccountOperation();
                    break;
                case 5:
                    showAllAccountAndClient();
                    break;
                case 6:
                    addAccountToClient();
                    break;
                case 7:
                    createClient();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Choix invalide !");
            }
        }
        System.out.println("Au revoir !");
    }

    private  void showAllClients(){
        List<Client> clients = clientService.getAllClients();
        for (Client c: clients
             ) {
            System.out.println(c);
        }
    }
    private void updateClient() {
        System.out.print("ID de l'utilisateur à modifier : ");
        int id = sc.nextInt();
        sc.nextLine(); // Clear the newline character

        Client client = clientService.getPerson(id);
        if (client == null) {
            System.out.println("Utilisateur non trouvé !");
            return;
        }
    }
    private  void deleteAClient() {
        System.out.print("ID de l'client à supprimer : ");
        int id = sc.nextInt();
        sc.nextLine();

        clientService.deleteOneClient(id);
        System.out.println("Un(e) client supprimé avec succès !");
    }
    private  void createAccountAndCustomer(){
        System.out.println("************** choix 1 ************");
        int id_Client = createClient();
        BankAccount bankAccount = _bankService.createAndSaveAccount(id_Client);
        System.out.println("Client et compte créer (id du compte : " + bankAccount.getIdAccount() + ")");
    }
    private  void deposit(){
        System.out.println("************** choix 2 ************");
        System.out.print("Merci de saisir le numéro de compte (id): ");
        String id = sc.nextLine();
        sc.nextLine();
        System.out.print("Merci de saisir le montant du dépôt de compte (id): ");
        double amount = sc.nextDouble();
        sc.nextLine();
        if (_bankService.makeperationDepopsit(amount*-1,id)){
            System.out.println("dépôt réussi ");
        }else {
            System.out.println("erreur");
        }
    }
    private  void withDrawal(){
        System.out.println("************** choix 3 ************");
        System.out.print("Merci de saisir le numéro de compte (id): ");
        String id = sc.nextLine();
        sc.nextLine();
        System.out.print("Merci de saisir le montant du retrait de votre compte : ");
        double amount = sc.nextDouble();
        sc.nextLine();
        if (_bankService.makeperationWithdrawal(amount*-1,id)){
            System.out.println("retrait réussi ");
        }else {
            System.out.println("erreur");
        }

    }
    private void getAccountOperation(){
        System.out.println("************** choix 4 ************");
        System.out.print("Merci de saisir le numéro de compte (id): ");
        String id = sc.nextLine();
        sc.nextLine();
        BankAccount bankAccount = _bankService.getAccount(id);
        if (bankAccount != null){
            for (Operation o: _bankService.getAllOperationsById()
                 ) {

            }
        }
    }
    private  void showAllAccountAndClient(){
        System.out.println("************** choix 5  ************");
        System.out.print("Merci de saisir le numéro de client (id): ");
        int id = sc.nextInt();
        sc.nextLine();
        _bankService.getAccountsByIdClient(id).forEach(e -> System.out.println(e));
    }
    private  void addAccountToClient(){
        System.out.println("************** choix 6 ************");
        System.out.print("Merci de saisir le numéro de client (id): ");
        int id = sc.nextInt();
        sc.nextLine();
        Client client = _bankService.getClientById(id);
        if (client != null){
            BankAccount bankAccount = _bankService.createAndSaveAccount(client.getIdClient());
            if(bankAccount != null){
                System.out.println("compte crée avce l'id : " + bankAccount.getIdAccount()+ " pour client " + client.getFirstName().toUpperCase());
            }
        }
    }
    private int createClient() {
        int id_Client = 0;
        System.out.println("************** choix 7 ************");
        System.out.print("Nom  : ");
        String firstName = sc.nextLine();
        System.out.print("Prenom : ");
        String lastName = sc.nextLine();
        System.out.print("Numéro de téléphone : ");
        String  phoneNumber = sc.nextLine();

        Client client =  _bankService.createAClient(firstName,lastName,phoneNumber);
        return  id_Client;
    }

}
