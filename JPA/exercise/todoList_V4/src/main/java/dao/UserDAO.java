package dao;

import entity.Task;
import entity.User;

import java.util.List;

public interface UserDAO  {
    public  void addUser(User user);

    public  void deleteUser(Long id);

    public  List<User> getAllTasksByUser();

}
