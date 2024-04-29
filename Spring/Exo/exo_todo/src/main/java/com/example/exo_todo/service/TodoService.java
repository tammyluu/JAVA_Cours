package com.example.exo_todo.service;

import com.example.exo_todo.models.Todo;

import java.util.ArrayList;

public class TodoService {
    private ArrayList<Todo> todos;
    public TodoService(){
        this.todos = new ArrayList<>();
        this.todos.add( new Todo(10, "Shopping", "description1", true));
        this.todos.add(new Todo(11, "Gym", "description2", false));
        this.todos.add(new Todo(12, "Date Mate", "description3", false));
    }

    public ArrayList<Todo> getTodos() {
        return todos;
    }

    public void setTodos(ArrayList<Todo> todos) {
        this.todos = todos;
    }
}
