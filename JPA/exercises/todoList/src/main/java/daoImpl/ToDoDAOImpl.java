package daoImpl;

import dao.ITodoDAO;
import entity.ToDo;

import javax.persistence.*;
import java.util.List;

public class ToDoDAOImpl implements ITodoDAO {
    public  EntityManagerFactory emf;

    public EntityManager em ;
    public EntityTransaction transac ;


    List<ToDo> toDoList = null;
    @Override
    public boolean addAndSaveTask(String title, boolean status) {
        emf = Persistence.createEntityManagerFactory("todo_List");
        em = emf.createEntityManager();
        transac = em.getTransaction();
        transac.begin();

        ToDo toDo = new ToDo();
        em.persist(toDo);
        System.out.println("New Task added: " + toDo.getId() +" "+ toDo.getTitle());
        em.getTransaction().commit();
        em.close();
        emf.close();
        return true;
    }

    @Override
    public List<ToDo> getAllTask() {
        em = emf.createEntityManager();
        em.getTransaction().begin();

        toDoList = em.createQuery("select  t from ToDo t ", ToDo.class).getResultList();
        em.close();
        emf.close();
        return toDoList;
    }

    @Override
    public ToDo getTaskById(int id) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        ToDo toDo = em.find(ToDo.class, id);
        System.out.println("The task with id: " + toDo.getId() + " is: " + toDo.getTitle());
        return toDo;
    }

    @Override
    public ToDo upDateATask(int id, String title, boolean status) {
       transac.begin();
       ToDo updateToDo = em.find(ToDo.class, id);
        updateToDo.setTitle(title);
        updateToDo.setStatus(status);
        return updateToDo;
    }

    @Override
    public boolean deleteATask(int id) {
        transac.begin();
        ToDo toDo = null;
        try{
           toDo = em.getReference(ToDo.class, id);

        }catch (EntityNotFoundException e){
            System.out.println("Task nit found: " + e.getMessage());
        }
        em.remove(toDo);
        return false;
    }


}
