package controller;

import daoImpl.ToDoDAOImpl;
import entity.ToDo;

import java.sql.SQLException;
import java.util.List;

public class ToDoController {
    private ToDoDAOImpl toDoDAO;
    private ToDo todo;
    public ToDo createAndSaveTodo(String title, boolean status) throws SQLException {
        ToDo toDo = new ToDo(title, status);
        if (toDoDAO.addAndSaveTask(title,status)){
            System.out.println("One task is already added: ");
        }
        return toDo;
    }
    public  boolean modifyById(int id) throws SQLException {
        toDoDAO.upDateATask(id, todo.getTitle(), todo.isStatus());
        return  true;
    }
    public boolean deleteOneTaskById(int id){
        todo = toDoDAO.getTaskById(id);
        if (todo != null){
            toDoDAO.deleteATask(id);
        }
        return true;
    }
    public List<ToDo> getAll() throws SQLException {
        return  toDoDAO.getAllTask();
    }

}
