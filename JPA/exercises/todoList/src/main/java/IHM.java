import org.hibernate.boot.archive.scan.spi.*;

import java.util.Scanner;

public class IHM {
   
        
   public  static Scanner sc = new Scanner(System.in);
    public static void startMenu(){
        boolean running = true;
        while (running) {
            System.out.println("\n--------------Menu Principal-----------------");
            System.out.println(" 1. Ajouter une tâche à la liste");
            System.out.println(" 2. Afficher toutes les tâches de la liste");
            System.out.println(" 3. Marquer une tâche comme terminée");
            System.out.println(" 4. Supprimer une tâche de la liste");
            System.out.println(" 0. Quitter l'application");
            System.out.println("---------------------------------------------\n");
            System.out.print("Choix : ");

            int choice = sc.nextInt();
            sc.nextLine(); // Clear the newline character

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                   showTaskList();
                    break;
                case 3:
                    endStatus();
                    break;
                case 4:
                   deleteTask();
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

    private static void deleteTask() {
    }

    private static void endStatus() {
    }

    private static void showTaskList() {
    }

    private static void addTask() {
        System.out.println("************** choix 1 ************");

    }
}
