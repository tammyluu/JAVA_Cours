package com.example.blog_app.controller.restApi;

import com.example.blog_app.model.Comment;
import com.example.blog_app.service.CommentServiceImpl;
import com.example.blog_app.service.PostServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import java.util.UUID;

import static org.springframework.http.ResponseEntity.*;

@RestController
@RequestMapping("/api/v1/blog")
public class CommentRestController {
    private final CommentServiceImpl commentService;
    private final PostServiceImpl postService;

    public CommentRestController(CommentServiceImpl commentService, PostServiceImpl postService) {
        this.commentService = commentService;
        this.postService = postService;
    }

    @PostMapping("/posts/{postId}/comments")
    public ResponseEntity<String> addCommentToPost(@PathVariable UUID postId, @Valid @RequestBody Comment comment, BindingResult result) {
        if (result.hasErrors()) {

            StringBuilder errors = new StringBuilder();
            result.getAllErrors().forEach(error -> errors.append(error.getDefaultMessage()).append("\n"));
            return badRequest().body(errors.toString());
        }  else {
            // If no validation errors, try to add the comment to the post
            boolean added = commentService.addCommentToPost(postId, comment);
            if (added) {
                return ResponseEntity.status(HttpStatus.CREATED).body("Comment added successfully");
            } else {
                // If the post is not found, return a not found response with an error message
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Post not found");
            }
        }
    }
}
