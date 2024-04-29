package org.example.utils;

import org.example.exception.CustomerFormatException;
import org.example.exception.InputManagement;
import org.example.models.Event;
import org.example.models.EventLocation;
import org.example.service.CustomerService;
import org.example.service.EventService;
import org.example.service.LocationService;
import org.example.service.TicketService;

import java.sql.SQLException;
import java.util.Scanner;

public class IHM {
    private Scanner scanner = new Scanner(System.in);
    private LocationService  locationService = new LocationService();
    private CustomerService customerService = new CustomerService();
    private EventService eventService = new EventService();
    private TicketService ticketService = new TicketService();


    private String choix;

    public IHM() throws SQLException {
    }

    public void start() throws CustomerFormatException {
        do {
            menu();
            choix = scanner.nextLine();
            switch (choix){
                case "1" :
                    addNewEventLocation();
                    break;
                case "2" :
                    modifyAnEventLocation();
                    break;
                case "3" :
                    deleteALocation();
                    break;
                case "4" :
                    addNewEvent();
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
        System.out.println("\n########## Menu Principal ##########");
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
        System.out.println("---------------------------------------------------------\n");
        System.out.print(" Votre choix : ");
    }
    public void addNewEventLocation() throws CustomerFormatException {

        String iName = InputManagement.getString("Entrez le nom du lieu: ", "Nom de lieu est obligatoire!!");

        String iAddress = InputManagement.getString("Entrez l'adresse' du lieu: ","Adresse de lieu est obligatoire!!");

        int iCapacity= InputManagement.getAnInteger("Entrez le capacité du lieu: ","Capacité de ce lieu est obligatoire!!");
        EventLocation eventLocation = locationService.createAndSaveLocation(iName,iAddress,iCapacity);
    }

    public void modifyAnEventLocation() throws CustomerFormatException {
        int idInput = InputManagement.getAnInteger("Donnez un id du lieux Où voulez-vous modifier: ", "id de lieu est obligatoire!!");
        EventLocation eventLocation = locationService.getById(idInput);
        if (eventLocation != null){
            String iName = InputManagement.getString("Entrez le nom du lieu: ", "Nom de lieu est obligatoire!!");

            String iAddress = InputManagement.getString("Entrez l'adresse' du lieu: ","Adresse de lieu est obligatoire!!");

            int iCapacity= InputManagement.getAnInteger("Entrez le capacité du lieu: ","Capacité de ce lieu est obligatoire!!");
            EventLocation updatedLocation = new EventLocation(eventLocation.getId(),iName,iAddress,iCapacity);
            locationService.modifyById(updatedLocation);
        }
    }
    public void deleteALocation(){
        int idInput = InputManagement.getAnInteger("Donnez un id du lieux Où voulez-vous modifier: ", "id de lieu est obligatoire!!");
        EventLocation location = locationService.getById(idInput);

        if ( location != null){
            locationService.deleteById(location.getId());
            System.out.println("Votre choix a bien supprimé !!!");
        }else {
            System.out.println("Votre choix ne peut pas supprimer !!");
        }
    }
    public void addNewEvent() throws CustomerFormatException {

        String iName = InputManagement.getString("Entrez le nom de l'evenement: ", "Nom de lieu est obligatoire!!");

        String iDate = InputManagement.getString("Entrez  la Date l'evenement en format (yyyy-MM-dd): ","Adresse de lieu est obligatoire!!");
        double iPrice= InputManagement.getADouble("Entrez le prix d'un ticket: ","prix en bon format est obligatoire!!");
        int iTickeSoldNum= InputManagement.getAnInteger("Entrez le nombre de tickets vendus: ","nombre de tickets vendus est obligatoire!!");
        int iIDLocation= InputManagement.getAnInteger("Entrez l'identifiant du lieu: ","l'identifiant du lieu est obligatoire!!");

        Event event = eventService.createAndSaveEvent(iName,iDate, (int) iPrice,iTickeSoldNum,iIDLocation);
    }

}
