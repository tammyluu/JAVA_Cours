package impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import dao.TaskDAO;
import entity.Category;
import entity.Task;
import entity.User;


import entity.TaskInfo;

public class TaskDAOImpl implements TaskDAO {

  private EntityManagerFactory entityManagerFactory;

  public TaskDAOImpl(EntityManagerFactory entityManagerFactory) {
    this.entityManagerFactory = entityManagerFactory;
  }


  @Override
  public boolean addTask(Task task) {
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    EntityTransaction transaction = entityManager.getTransaction();
    try {
      transaction.begin();
      entityManager.persist(task);
      transaction.commit();
      return true;
    }catch (Exception e){
      if(transaction.isActive()){
        transaction.rollback();
      }
      e.printStackTrace();
      return false;
    }finally {
      entityManager.close();
    }
  }

  @Override
  public List<Task> getAllTasks() {
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    List<Task> tasks = entityManager.createQuery("SELECT t FROM Task t",Task.class).getResultList();
    entityManager.close();
    return tasks;
  }

  @Override
  public boolean deleteTask(Long taskId) {
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    EntityTransaction transaction = entityManager.getTransaction();
    try {
      transaction.begin();
      Task task = entityManager.find(Task.class,taskId);
      if(task != null){
        entityManager.remove(task);
        transaction.commit();
        return true;
      } else {
        return false;
      }
    }catch (Exception e){
      if(transaction.isActive()){
        transaction.rollback();
      }
      e.printStackTrace();
      return false;
    }finally {
      entityManager.close();
    }
  }

  @Override
  public boolean markTaskAsCompleted(Long taskId) {
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    EntityTransaction transaction = entityManager.getTransaction();
    try {
      transaction.begin();
      Task task = entityManager.find(Task.class,taskId);
      if(task != null){
        task.setCompleted(true);
        transaction.commit();
        return true;
      } else {
        return false;
      }
    }catch (Exception e){
      if(transaction.isActive()){
        transaction.rollback();
      }
      e.printStackTrace();
      return false;
    }finally {
      entityManager.close();
    }
  }

  @Override
  public List<Task> getTasksByUseId(Long userId) {
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    List<Task> tasks = entityManager.createQuery("SELECT t FROM Task t WHERE t.user.id = :userId")
            .setParameter("userId",userId)
            .getResultList();
    return tasks;

  }

  @Override
  public List<Task> getTasksByCategoryId(Long catId) {
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    try {
      return entityManager.createQuery("SELECT t FROM Task t JOIN t.categoryList c WHERE c.id = :catId", Task.class)
              .setParameter("catId", catId)
              .getResultList();
    } finally {
      entityManager.close();
    }
  }

  @Override
  public boolean addCategory(Category category) {
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    EntityTransaction transaction = entityManager.getTransaction();
    try {
      transaction.begin();
      entityManager.persist(category);
      transaction.commit();
      return true;
    }catch (Exception e){
      if(transaction.isActive()){
        transaction.rollback();
      }
      e.printStackTrace();
      return false;
    }finally {
      entityManager.close();
    }
  }

  @Override
  public boolean deleteCategory(Long catId) {
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    EntityTransaction transaction = entityManager.getTransaction();
    try {
      transaction.begin();
      Category category = entityManager.find(Category.class,catId);
      if(category != null){
        entityManager.remove(category);
        transaction.commit();
        return true;
      } else {
        return false;
      }
    }catch (Exception e){
      if(transaction.isActive()){
        transaction.rollback();
      }
      e.printStackTrace();
      return false;
    }finally {
      entityManager.close();
    }
  }

  @Override
  public boolean addTaskByCategory(Task task,Long catId) {
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    EntityTransaction transaction = entityManager.getTransaction();
    transaction.begin();
    Category category = entityManager.find(Category.class,catId);
    task.setCategoryList((List<Category>) category);
    category.getTaskList().add(task);
    entityManager.persist(task);
    transaction.commit();
    entityManager.close();
    return true;
  }


  public boolean addTask(Task task,Long personId){
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    EntityTransaction transaction = entityManager.getTransaction();
    transaction.begin();
    User user= entityManager.find(User.class,personId);
    task.setUser(user);
    user.getTaskList().add(task);
    entityManager.persist(task);
    transaction.commit();
    entityManager.close();
    return true;
  }
  public boolean deleteTaskByCategoryId(Long catId, Long taskId){
    EntityManager em = entityManagerFactory.createEntityManager();
    EntityTransaction transaction = em.getTransaction();

    try {
      transaction.begin();

      Task task = em.find(Task.class, taskId);
      Category category = em.find(Category.class, catId);
      category.getTaskList().remove(task);
      em.merge(category);

      transaction.commit();
      System.out.println("La tâche a été supprimée de la catégorie avec succès");

      return true;
    } catch (Exception e) {
      if (transaction.isActive()) {
        transaction.rollback();
      }
      e.printStackTrace();
      return false;
    } finally {
      if (em != null && em.isOpen()) {
        em.close();
      }
    }
  }


}
