package com.example.tasklist.service;



import com.example.tasklist.entity.Task;

import java.util.List;

public class TaskServiceImpl implements ITaskService {
    @Override
    public Task save(String content, boolean status) {
        return  new Task(content,status);
    }

    @Override
    public Task findById(int id) {
        return null;
    }

    @Override
    public Task update(int id) {
        return null;
    }

    @Override
    public Task delete(int id) {
        return null;
    }

    @Override
    public List<Task> findAll() {
        return null;
    }
}
