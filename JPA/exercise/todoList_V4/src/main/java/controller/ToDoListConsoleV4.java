package controller;



import dao.TaskDAO;
import dao.UserDAO;
import entity.Category;
import entity.Task;
import entity.TaskInfo;
import entity.User;
import impl.TaskDAOImpl;
import impl.UserDAOImpl;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;



public class ToDoListConsoleV4 {
    private static EntityManagerFactory entityManagerFactory;
    private static TaskDAOImpl taskDAO;
    private static UserDAO userDAO;

    public static void main() {
        entityManagerFactory = Persistence.createEntityManagerFactory("todo_List");
        taskDAO = new TaskDAOImpl(entityManagerFactory);
        userDAO = new UserDAOImpl(entityManagerFactory);

        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("################ To Do List ###################");
            System.out.println(" 1. Ajouter une personne");
            System.out.println(" 2. Afficher les tâches d'une personne");
            System.out.println(" 3. Ajouter une tâche à la liste");
            System.out.println(" 4. Afficher toutes les tâches de la liste");
            System.out.println(" 5. Marquer une tâche comme terminée");
            System.out.println(" 6. Supprimer une personne et ses tâches associées");
            System.out.println(" 7. Supprimer une tâche");
            System.out.println(" 8. Ajouter une catégorie");
            System.out.println(" 9. Supprimer une catégorie");
            System.out.println("10. Afficher les tâches d'une catégorie");
            System.out.println("11. Ajouter une taches à une catégorie");
            System.out.println("12. Supprimer une taches à une catégorie");
            System.out.println(" 0. Quitter l'application");
            System.out.println("################ ************ ###################");
            System.out.print("Choix : ");

            choice = scanner.nextInt();
            scanner.nextLine(); // Consomme la nouvelle ligne

            switch (choice) {
                case 1:
                    addUser(scanner);
                    break;
                case 2:
                    displayTasksUser(scanner);
                    break;
                case 3:
                    addTask(scanner);
                    break;
                case 4:
                    displayTasks();
                    break;
                case 5:
                    markTaskAsCompleted(scanner);
                    break;
                case 6:
                    deleteUser(scanner);
                    break;
                case 7:
                    deleteTask(scanner);
                    break;
                case 8:
                    addCategory(scanner);
                    break;
                case 9:
                   deleteCategory(scanner);
                    break;
                case 10:
                    displayTasksCategory(scanner);
                    break;
                case 11:
                  addTaskByCategory(scanner);
                    break;
                case 12:
                    deleteTaskByCategory(scanner);
                    break;

                case 0:
                    System.out.println("Bye");
                    entityManagerFactory.close();
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        } while (choice != 0);
    }

    private static void deleteTaskByCategory(Scanner scanner) {

        System.out.print("Entrez l'ID de la  categorie  : ");
        Long catId  = scanner.nextLong();
        System.out.print("Entrez l'ID de la tâche à supprimer : ");
        Long taskId  = scanner.nextLong();
        scanner.nextLine();
        if (taskDAO.deleteTaskByCategoryId(catId,taskId)){
            System.out.println("Suppression OK");
        }else {
            System.out.println("Erreur");
        }
    }

    private static void addTaskByCategory(Scanner scanner) {
        System.out.println("Entrez l'ID de la categorie  : ");
        Long catId  = scanner.nextLong();
        scanner.nextLine();
        Task task = new Task();
        if(taskDAO.addTask(task,catId)){
            System.out.println("Tâche ajoutée avec succès !");
        }else {
            System.out.println("Erreur");
        }
    }

    private static void displayTasksCategory(Scanner scanner) {
        System.out.println("Entrez l'ID de la categorie  : ");
        Long catId  = scanner.nextLong();
        scanner.nextLine();
        List<Task> tasks = taskDAO.getTasksByCategoryId(catId);
        System.out.println("Tâches de la categorie avec l' ID : "+ catId + " : ");
        for (Task t : tasks){
            System.out.println(t.getId() + ". " + t.getTitle() + " (" + (t.isCompleted() ? "Terminée" : "En cours") + ")");
        }
    }

    private static void deleteCategory(Scanner scanner) {
        System.out.println("Entrez l'ID de la catégorie à supprimer : ");
        Long catId  = scanner.nextLong();
        scanner.nextLine();
        taskDAO.deleteCategory(catId);
        System.out.println(" Cette catégorie supprimée");
    }

    private static void addCategory(Scanner scanner) {
        System.out.println("Entrer le nom de la catégorie : ");
        String catName = scanner.nextLine();
        Category  category = new Category();
        category.setNameCat(catName);
        taskDAO.addCategory(category);
        System.out.println("Une catégorie ajoutée");

    }

    private static void addTask(Scanner scanner){
        System.out.println("Entrer le titre de la tâche : ");
        String title = scanner.nextLine();

        System.out.println("Entrer la description de la tâche : ");
        String description = scanner.nextLine();

        System.out.println("Date limite de la tâche : (dd.MM.yyyy)");
        String dueDateStr = scanner.nextLine();

        LocalDate dueDate = LocalDate.parse(dueDateStr, DateTimeFormatter.ofPattern("dd.MM.yyyy"));

        System.out.println("Priorité de la tâche : ");
        int priority = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Entrez l'ID de la personne pour cette tâche : ");
        Long userId = scanner.nextLong();

        // Creation de la tache
        Task task = new Task();
        task.setTitle(title);
        task.setCompleted(false);

        //Creation de la taskinfo
        TaskInfo taskInfo = new TaskInfo(description,dueDate,priority);

        // Mise en relation
        task.setTaskInfo(taskInfo);
        taskInfo.setTask(task);

        if(taskDAO.addTask(task,userId)){
            System.out.println("Tâche ajoutée avec succès !");
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
                System.out.println("###########");
                System.out.println(task.getId() + ". " + task.getTitle() + " (" + (task.isCompleted() ? "Terminée" : "En cours") + ")");
                System.out.println(task.getTaskInfo().toString());
                System.out.println("###########");
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

    private static void addUser(Scanner scanner){
        System.out.println("Entrer le nom de la personne : ");
        String userName = scanner.nextLine();
        User user = new User(userName);
        userDAO.addUser(user);
        System.out.println("Personne ajoutée");
    }

    private static void displayTasksUser(Scanner scanner){
        System.out.println("Entrez l'ID de la personne  : ");
        Long userId  = scanner.nextLong();
        scanner.nextLine();

        List<Task> tasks = taskDAO.getTasksByUseId(userId);
        System.out.println("Tâches de la personne avec l' ID : "+ userId + " : ");
        for (Task t : tasks){
            System.out.println(t.getId() + ". " + t.getTitle() + " (" + (t.isCompleted() ? "Terminée" : "En cours") + ")");
        }
    }

    private static void deleteUser(Scanner scanner){
        System.out.println("Entrez l'ID de la personne à supprimer : ");
        Long userId  = scanner.nextLong();
        scanner.nextLine();
        userDAO.deleteUser(userId);
        System.out.println("Personne supprimée");

    }


}
