package com.example.exo_todo.controller;

import com.example.exo_todo.models.Todo;
import com.example.exo_todo.service.TodoService;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Locale;

@Controller
public class TodoController {
    private TodoService todoService;
    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public String home(){
        return "home";
    }
    @RequestMapping(value = "/todo")
    public String getOneTodo(Model model) {
        Todo todo = new Todo(6,"test", "tes1", true);
        model.addAttribute("name",todo.getName());
        model.addAttribute("description",todo.getDescription());
        if(todo.isDone()){
            model.addAttribute("done","finished");
        }
        model.addAttribute("todo", new Todo(10,"test 8", "description 8", false));

        return "home";
    }


}
