package com.example.blog_app.controller.web;

import com.example.blog_app.model.Post;
import com.example.blog_app.service.IBlogServcie;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller

public class PostController {
    private IBlogServcie<Post> postService;
    @Value("IT-Edu")
    private String blogName;
    @Value("it_edu@edublog.edu")
    private String blogContact;

    public PostController(IBlogServcie<Post> postService) {
        this.postService = postService;
    }

    @GetMapping("/")  // http://localhost:8080
    public String home(Model model){
        model.addAttribute("name",blogName);
        model.addAttribute("contact",blogContact);
        return "home";
    }
    @GetMapping("/posts") // http://localhost:8080/posts
    public String showAllPosts( Model model){
       model.addAttribute("posts", postService.getAll());
        System.out.println(postService.getAll());
        return "list";
    }
    @GetMapping("/post/{postId}")  // http://localhost:8080/post/x
    public String showPost(@PathVariable("postId") UUID id, Model model){
        model.addAttribute("post",postService.getById(id));
        System.out.println(postService.getById(id));
        return "detail";
    }
    @GetMapping("/form") // http://localhost:8080/form
    public String formAddPost(Model model){
        model.addAttribute("post",new Post());
        return "post-form";
    }
    @PostMapping(value = "/add")
    public String addPost(@Valid @ModelAttribute("post") Post post, BindingResult result) {
        if (result.hasErrors()) {
            return "post-form";
        } else {
            if (post.getId() != null) {
                postService.update(post.getId(), post);
            } else {
                postService.add(post);
            }

            return "redirect:/posts";
        }
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("postId") UUID id){
        postService.deleteById(id);
        return "redirect:/posts";
    }
    @GetMapping("/update/{postId}")
    public String formUpdatePost(@RequestParam("postId") UUID id,Model model){
        Post post = postService.getById(id);
        model.addAttribute("post",post);
        return "post-form";
    }

}

