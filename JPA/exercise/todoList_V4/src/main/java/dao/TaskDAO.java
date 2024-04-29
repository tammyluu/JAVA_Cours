package dao;

import entity.Category;
import entity.Task;


import java.util.List;

public interface TaskDAO {


    public boolean addTask(Task task);

    public List<Task> getAllTasks();

    public boolean deleteTask(Long taskId);

    public boolean markTaskAsCompleted(Long taskId);
    public List<Task> getTasksByUseId(Long userId);
    public  List<Task> getTasksByCategoryId(Long catId);
    public  boolean addCategory(Category category);
    public boolean deleteCategory(Long catId);
    public  boolean addTaskByCategory(Task task,Long catId);

}
