package controller;

import dao.InfoDAO;
import entity.Info;
import entity.Task;
import entity.Type;
import impl.InfoDAOImpl;
import impl.TaskDAOImpl;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import javax.persistence.Persistence;
import java.util.List;
import java.util.Scanner;

public class ToDoListAppConsole {

    private static TaskDAOImpl taskDAO;
    private static InfoDAOImpl infoDAO;

    public static void main() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("todo_List");
        EntityManager em = emf.createEntityManager();

        taskDAO = new TaskDAOImpl(emf);
        infoDAO = new InfoDAOImpl(emf);
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("#### To Do List ####");
            System.out.println("1. Ajouter une tâche à la liste");
            System.out.println("2. Afficher toutes les tâches de la liste");
            System.out.println("3. Marquer une tâche comme terminée");
            System.out.println("4. Supprimer une tâche de la liste");
            System.out.println("5. Ajouter ls infos à la tâche");
            System.out.println("4. Afficher toutes les infos de la tâches ");
            System.out.println("4. Supprimer une infos de la tâches ");
            System.out.println("0. Quitter l'application");
            System.out.println("Choix : ");

            choice = scanner.nextInt();
            scanner.nextLine(); // Consomme la nouvelle ligne

            switch (choice){
                case 1:
                    addTask(scanner);
                    break;
                case 2:
                    displayTasks();
                    break;
                case 3:
                    markTaskAsCompleted(scanner);
                    break;
                case 4:
                    deleteTask(scanner);
                    break;
                case 5:
                   addInfo(scanner);
                    break;
                case 6:
                    showTaskDetail(scanner);
                    break;
                case 0:
                    System.out.println("Bye");
                    emf.close();
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");

            }

        }while (choice != 5);
    }

    private static void showTaskDetail(Scanner scanner) {
    }
    private  static void addTask(Scanner scanner){
        System.out.println("Entrer le titre de la tâche : ");
        String title = scanner.nextLine();

        Task task = new Task();
        task.setTitle(title);
        task.setCompleted(false);

        if(taskDAO.addTask(task)){
            System.out.println("Tâche ajoutée avec succès !");
        }else {
            System.out.println("Erreur");
        }
    }
    private static void addInfo(Scanner scanner){
        System.out.println("Entrez l'ID de la tâche à supprimer : ");
        Long taskId  = scanner.nextLong();
        scanner.nextLine();
        System.out.println("Entrer le description de la tâche : ");
        String description = scanner.nextLine();
        System.out.println("Entrer la Date d'echéance de la tâche en format (yyyy-MM-dd) : ");
        String date = scanner.nextLine();
        System.out.println("Entrer la Priorité de la tâche: ");
        String type = scanner.nextLine();

        Info info = new Info();
        info.setDescription(description);
        info.setDate(date);
        info.setType(Type.valueOf(type));

        if(infoDAO.addInfo(info)){
            System.out.println("Info ajouté avec succès !");
        }else {
            System.out.println("Erreur");
        }
    }

    private static void displayTasks() {
        List<Task> tasks = taskDAO.getAllTasks();

        if (tasks.isEmpty()) {
            System.out.println("Aucune tâche trouvée.");
        } else {
            System.out.println("=== Liste des tâches ===");
            for (Task task : tasks) {
                System.out.println(task.getId() + ". " + task.getTitle() + " (" + (task.isCompleted() ? "Terminée" : "En cours") + ")");
            }
        }
    }

    private static void deleteTask(Scanner scanner){
        System.out.println("Entrez l'ID de la tâche à supprimer : ");
        Long taskId  = scanner.nextLong();
        scanner.nextLine();

        if (taskDAO.deleteTask(taskId)){
            System.out.println("Suppression OK");
        }else {
            System.out.println("Erreur");
        }
    }

    private static void markTaskAsCompleted(Scanner scanner){
        System.out.println("Entrez l'ID de la tâche à supprimer : ");
        Long taskId  = scanner.nextLong();
        scanner.nextLine();

        if (taskDAO.markTaskAsCompleted(taskId)){
            System.out.println("Modification OK");
        }else {
            System.out.println("Erreur");
        }
    }
}
