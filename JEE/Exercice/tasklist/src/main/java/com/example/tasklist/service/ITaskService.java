package com.example.tasklist.service;



import com.example.tasklist.entity.Task;

import java.util.List;

public interface ITaskService {
    Task save(String content, boolean status );
    Task findById(int id);
    Task update(int id);
    Task delete(int id);
     List<Task> findAll();

}
