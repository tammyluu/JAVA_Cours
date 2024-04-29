package dao;



import entity.Info;
import entity.Task;

import java.util.List;

public interface TaskDAO {

    public boolean addTask(Task task);

    public List<Task> getAllTasks();

    public boolean deleteTask(Long taskId);

    public boolean markTaskAsCompleted(Long taskId);

}
