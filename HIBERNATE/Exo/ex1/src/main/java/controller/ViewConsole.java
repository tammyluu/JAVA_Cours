package controller;

import models.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import services.CommandeService;
import services.ImageService;
import services.ProduitService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ViewConsole {
    private static SessionFactory sessionFactory;
    private static ProduitService produitService;
    private static ImageService imageService;
    private  static CommandeService commandeService;
    private static Scanner scanner;

    public static void menu() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        produitService = new ProduitService();
        imageService = new ImageService();
        commandeService = new CommandeService();


        scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("################ Produits ###################");
            System.out.println(" 1. Ajouter un produit");
            System.out.println(" 2. Afficher les informations d'un produit");
            System.out.println(" 3. Supprimer un produit");
            System.out.println(" 4. Modifier les informations du produit");
            System.out.println(" 5. Afficher la totalité des produits");
            System.out.println(" 6. Afficher les produits dont le prix est supérieur au montant précisé");
            System.out.println(" 7. Afficher les produits achetés entre deux dates");
            System.out.println(" 8. Afficher les produits dont le stock est inférieur au montant précisé");
            System.out.println(" 9. Afficher la valeur du stock d'une marque");
            System.out.println("10. Afficher le prix moyen des produits");
            System.out.println("11. Afficher la liste des produits d'une marque choisie");
            System.out.println("12. Supprimer les produits d'une marque choisie");
            System.out.println("13. Ajouter une image à un produit ");
            System.out.println("14. Ajouter un commentaire à un produit. ");
            System.out.println("15. Afficher les produits avec une note de 4 ou plus ");
            System.out.println("16. Ajouter une commande avec un ou plusieurs produits. ");
            System.out.println("17. Afficher la totalité des commandes. ");
            System.out.println("18. Afficher uniquement les commandes du jour. ");
            System.out.println(" 0. Quitter l'application");
            System.out.println("################ ************ ###################");
            System.out.print("Choix : ");

            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    addNewProduct(scanner);
                    break;
                case 2:
                    showDetailOneProduct(scanner);
                    break;
                case 3:
                    removeOneProduct(scanner);
                    break;
                case 4:
                    updateOneProduct(scanner);
                    break;
                case 5:
                    showAllProducts();
                    break;
                case 6:
                    showProductsByPriceSupInput();
                    break;
                case 7:
                    showProductsByDate();
                    break;
                case 8:
                    showProductsByStock();
                    break;
                case 9:
                    displayAmountOfStockByBrand();
                    break;
                case 10:
                    displayPriceAveragePriceProducts();
                    break;
                case 11:
                    showProductsByBrand();
                    break;
                case 12:
                    deleteProductsByBrand();
                    break;
                case 13:
                    addImagesByProduct();
                    break;
                case 14:
                    addCommentsByProduct();
                    break;
                case 15:
                    showAllProductsByRanking();
                case 16:
                    addProductsByOrder();
                    break;
                case 17:
                    showAllOrders();
                    break;
                case 18:
                     showOrdersPerDay();
                    break;
                case 19:

                    break;
                case 20:

                    break;
                case 21:

                    break;

                case 0:
                    System.out.println("Bye");

                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }

        } while (choice != 0);

    }

    private static void showAllOrders() {

    }

    private static void showOrdersPerDay() {
    }

    private static void addProductsByOrder() {
        Date date = new Date();

        try {
            System.out.println("Combien de produits souhaitez vous ajouter à la commande ");
            int nombreProduit = scanner.nextInt();
            scanner.nextLine();
            List<Produit> productList = new ArrayList<>();
            List<Commande> ordersList = new ArrayList<>();
            Double total = 1.0;
            for (int i = 0; i < nombreProduit; i++) {
                System.out.println("Veuillez indiquer l'id des produits que vous souhaitez ajouter à la commande : ");
                int idProduct = scanner.nextInt();
                System.out.println("Veuillez indiquer la quantité à ajouter : ");
                int quantity = scanner.nextInt();
                Produit product = produitService.selectById(idProduct);
                product.setStock(product.getStock()-quantity);
                produitService.update(product, idProduct);
                Double price = product.getPrix();
                productList.add(product);
                total += quantity*price;
            }
            System.out.println("Adresse de la commande");
            System.out.println("Veuillez saisir la ville de la commande");
            String ville = scanner.next();
            System.out.println("Veuillez saisir le numéro");
            int numero = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Veuillez saisir la rue");
            String rue = scanner.nextLine();
            System.out.println("Veuillez saisir le codePostal");
            int codePostal = scanner.nextInt();
            Adresse adress = new Adresse(numero,rue,ville,codePostal);
            commandeService.ad();

            Commande order = new Commande(total,new Date(),productList,adress);
            order.setAdress(adress1);
            ordersList.add(order);
            commandeService.addNew(order);
            commandeService.update(order,order.getId());
            for (Produit p: order.getProduits()
            ) { p.setOrdersList(ordersList);
                produitService.update(p,p.getId());
            }
            System.out.println(order);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void showAllProductsByRanking() {
        System.out.println("List des produits avec une note de 4 ou plus: ");
        List<Produit> produits = produitService.selectProductByRanking();
        for ( Produit p : produits ) {
            System.out.println(p);
        }
    }

    private static void addCommentsByProduct() {
        try {
                System.out.print("Entrer l'Id du produit que vour désirez ajouter les commentaires : ");
                int idprod = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Saisir vos commentaires : ");
                String contenu = scanner.nextLine();
                System.out.print("Donner leur notes : ");
                int note = scanner.nextInt();
                scanner.nextLine();
                Comment comment = new Comment(contenu,new Date(),note);
                produitService.addCommentsByProduit(comment,idprod);
        }catch ( Exception e){
            System.out.println(e.getMessage());
        }
    }

    private static void addImagesByProduct() {
        try {
            System.out.print("Combiens images vous allez ajouter pour ce produit: ");
            int nbr = scanner.nextInt();
            for (int i = 0; i < nbr; i++) {
                System.out.print("Entrer l'Id du produit que vour désirez ajouter les images : ");
                int idprod = scanner.nextInt();
                scanner.nextLine();
                System.out.print(" Entrer le lien de l'image: ");
                String url = scanner.nextLine();
                Image image = new Image(url);
                produitService.addImageByProduct(image,idprod);
            }

        }catch ( Exception e){
            System.out.println(e.getMessage());
        }
    }

    private static void deleteProductsByBrand() {
        try {
            System.out.print("Entrer la marque que vour désirez  supprimer les produits : ");
            String marque = scanner.next();
            produitService.removeProductByBrand(marque);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void showProductsByBrand() {
        try {
            System.out.print("Entrer la marque que vour désirez  l' afficher: ");
            String marque = scanner.next();
            List<Produit> produits = produitService.selectAllByBrand(marque);
            for (Produit p : produits
            ) {
                System.out.println("List de produits que vous souhaitez afficher: \n" + p);
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void displayPriceAveragePriceProducts() {
        Double prixMoyen = produitService.calculPriceAverage();
        System.out.print("Le prix moyen des produits est de " + prixMoyen);
    }

    private static void showProductsByStock() {
            System.out.print("Entrer  pour afficher les produits dont le stock est inférieur : ");
            int stock = scanner.nextInt();
            List<Produit> produits = produitService.getByStock(stock);
            for (Produit p : produits
            ) {
                System.out.println("L'info  du stock de ce produit est:  " + p);

            }
    }

    private static void displayAmountOfStockByBrand() {
        try {
            System.out.print("Entrer la marque pour afficher la valeur des stocks que vous désirez : ");
            String marque = scanner.next();
            List<Double> productList = produitService.amountOfStockByBrand(marque);
            int totalStock = 0;
            for (Double i : productList
            ) {
                System.out.println("La valeur du stock pour le produit de la marque  " + marque + " est : " + i);
                totalStock += i;
            }
            System.out.println("La valeur du stock totale est de " + totalStock);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void showProductsByDate() {
        try {
            System.out.print("Entrer la date au début(format dd-MM-yyyy) ? :");
            String startDate= scanner.next();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            Date  min = dateFormat.parse(startDate);
            System.out.print("Entrer la date à la fin (format dd-MM-yyyy) ? :");
            String endDate = scanner.next();
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
            Date max = format.parse(endDate);
            List<Produit> productList = produitService.filterByDate(min, max);
            for (Produit p : productList
            ) {
                System.out.println("Les produits dont l'achat est compris entre les date " + min + " et " + max + " sont:\n " + p);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void showProductsByPriceSupInput() {
        System.out.print("Entrer un prix initial: ");
        Double prix = scanner.nextDouble();
        List<Produit> produits = produitService.searchByPrice(prix);
        for ( Produit p: produits ) {
            System.out.println("Les produits dont le prix est supérieur à votre prix initial " + prix + " sont :" + p);
        }
    }

    private static void showAllProducts() {
        for ( Produit p :produitService.selectAll()) {
            System.out.println(p);
        }
    }


    private static void updateOneProduct(Scanner scanner) {
        try {
            System.out.print("Entrez l'ID du produit à modifier : ");
            Integer prodId = scanner.nextInt();
            scanner.nextLine();
            Produit produit = produitInfosInput();
            produitService.update(produit,prodId );
            } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    private static void removeOneProduct(Scanner scanner) {
        System.out.print("Entrez l'ID du produit à supprimer : ");
        Integer prodId = scanner.nextInt();
        scanner.nextLine();
        produitService.delete(prodId);
        System.out.println("Produit supprimé");

    }

    private static void showDetailOneProduct(Scanner scanner) {
        System.out.print("Entrez l'ID du produit à afficher : ");
        int prodId = scanner.nextInt();
        scanner.nextLine();
        Produit produit = produitService.selectById(prodId);
        System.out.println(produit);
    }

    private static void addNewProduct(Scanner scanner) {
            Produit produit = produitInfosInput();
            produitService.addNew(produit);
            System.out.println("Produit  bien ajouté !!!!");

    }

    public static Produit produitInfosInput() {
        try {
            System.out.print(" Entrer la marque du produit: ");
            String marque = scanner.nextLine();
            System.out.print(" Entrer la reférence du produit: ");
            String ref = scanner.nextLine();
            System.out.print(" Entrer la date de l'achat en format (dd-MM-yyyy): ");
            String dateInput = scanner.nextLine();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            Date date = dateFormat.parse(dateInput);
            System.out.print(" Entrer le prix d'un produit: ");
            double prix = scanner.nextDouble();
            scanner.nextLine();
            System.out.print(" Entrer le stock du produit: ");
            int stock = scanner.nextInt();
            Produit produit = new Produit();
            produit.setMarque(marque);
            produit.setReference(ref);
            produit.setDateAchat(date);
            produit.setPrix(prix);
            produit.setStock(stock);
            return produit;

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}