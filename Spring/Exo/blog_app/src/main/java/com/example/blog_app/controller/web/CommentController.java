package com.example.blog_app.controller.web;

import com.example.blog_app.model.Comment;
import com.example.blog_app.model.Post;
import com.example.blog_app.service.CommentServiceImpl;
import com.example.blog_app.service.PostServiceImpl;
import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller

public class CommentController {
    private final CommentServiceImpl commentService;
    private final PostServiceImpl postService;

    public CommentController(CommentServiceImpl commentService, PostServiceImpl postService) {
        this.commentService = commentService;
        this.postService = postService;
    }
    @GetMapping("/add/{postId}")
    public String showCommentForm(@PathVariable UUID postId, Model model) {
        model.addAttribute("postId", postId);
        model.addAttribute("comment", new Comment());
        return "comment-form";
    }
    @PostMapping("/add/{postId}")
    public String addComment(@Valid @ModelAttribute("comment") Comment comment, BindingResult result,@PathVariable("postId") UUID id) {
        if (result.hasErrors()) {
            return "comment-form";
        } else {
            Post post = postService.getById(id);
            if (post != null) {
                postService.addComment(post, comment);
                System.out.println("bien ajouté");
                return "redirect:/";
            }
        }
        return "comment-form";

    }

}
