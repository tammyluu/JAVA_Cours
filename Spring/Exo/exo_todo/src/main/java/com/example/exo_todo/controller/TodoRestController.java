package com.example.exo_todo.controller;

import com.example.exo_todo.models.Todo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/")
public class TodoRestController {

    @GetMapping("todo")
    public Todo getTodo(){
        return new Todo(1, "Travel", "Asie", false);
    }

    @GetMapping(value = "todos")
    public List<Todo> getTodos(){
        List<Todo> todos = List.of(
                new Todo(2, "Shopping", "description1", true),
                new Todo(3, "Gym", "description2", false),
                new Todo(4, "Date Mate", "description3", false)
        );
        return todos;
    }
}
