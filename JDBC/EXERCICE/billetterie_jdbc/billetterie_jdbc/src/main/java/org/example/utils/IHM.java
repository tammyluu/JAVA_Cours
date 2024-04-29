package org.example.utils;

import java.util.Scanner;

public class IHM {
    private Scanner scanner;

    private String choix;
    public void start(){
        do {
            menu();
            choix = scanner.nextLine();
            switch (choix){
                case "1" :

                    break;
                case "2" :

                    break;
                case "3" :

                    break;
                case "4" :

                    break;
                case "5" :

                    break;
                case "6" :

                    break;
                case "7" :

                    break;
                case "8" :

                    break;
                case "9" :

                    break;
                case "10" :

                    break;
                case "11" :

                    break;
                case "12" :

                    break;
                case "13" :

                    break;
                case "14" :

                    break;

            }


        }while (!choix.equals("0"));
    }
    private void menu(){
        System.out.println("########## Menu Principal ##########");
        System.out.println(" 1- Ajouter un lieu");
        System.out.println(" 2- Modifier un lieu");
        System.out.println(" 3- Supprimer un lieu");
        System.out.println(" 4- Ajouter un événement");
        System.out.println(" 5- Modifier  un événement");
        System.out.println(" 6- Supprimer un événement");
        System.out.println(" 7- Ajouter un client");
        System.out.println(" 8- Modifier un client");
        System.out.println(" 9- Supprimer un client");
        System.out.println("10- Ajouter un'un client");
        System.out.println("10- Ajouter un'un client");
        System.out.println("11- Acheter des billets pour un événement");
        System.out.println("12- Annuler un achat de billet");
        System.out.println("13- Afficher la liste des événements disponibles");
        System.out.println("14- Afficher la liste des billets achetés par un client\n");
        System.out.println("0- Quitter");
        System.out.println(" Votre choix : ");
    }

}
