package com.example.exo_todo.service;

import com.example.exo_todo.models.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

public interface ITodoService {


    List<Todo> getAllTodos();

    Todo getTodoById(int id);

    Todo createTodo(Todo todo);

    Todo updateTodo(int id, Todo todo);

    void deleteTodoById(int id);
}
