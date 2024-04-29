package dao;

import entity.ToDo;

import java.util.List;

public interface ITodoDAO {
   public boolean addAndSaveTask(String title, boolean status);
   public List<ToDo> getAllTask();
   public  ToDo getTaskById(int id);


   public ToDo upDateATask(int id, String title, boolean status);

   public  boolean deleteATask(int id);
}
