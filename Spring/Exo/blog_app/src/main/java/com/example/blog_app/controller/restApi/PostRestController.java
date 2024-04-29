package com.example.blog_app.controller.restApi;

import com.example.blog_app.model.Comment;
import com.example.blog_app.model.Post;
import com.example.blog_app.service.CommentServiceImpl;
import com.example.blog_app.service.PostServiceImpl;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/blog")
@AllArgsConstructor
public class PostRestController {
    private final PostServiceImpl postService;
    private final CommentServiceImpl commentService;

    @GetMapping("/posts") // http://localhost:8080/api/blog/posts
    public List<Post> getAllPost() {
        return postService.getAll();
    }

    @GetMapping("/post/{id}")  // http://localhost:8080/api/blog/post/xxx
    public Post getPostById(@PathVariable("id") UUID id){
        return postService.getById(id);
        }
    @PostMapping("add") // http://localhost:8080/api/blog/add
    public boolean createPost(@RequestBody  Post post){
        return postService.add(post);
    }
    @PostMapping("/addComment/{postId}") // http://localhost:8080/api/blog/addComment/x
    public ResponseEntity<String> createCommentValid(@Valid @RequestBody Comment comment, BindingResult result, @PathVariable("postId") UUID id){
        if(result.hasErrors()){
            StringBuilder errors = new StringBuilder();
            result.getAllErrors().forEach(objectError -> errors.append(objectError.toString() + " , "));

            return new ResponseEntity<>(errors.toString(), HttpStatus.BAD_REQUEST);
        }
        boolean isCommentAdded = commentService.addCommentToPost(id, comment);
        if (isCommentAdded) {
            return new ResponseEntity<>("Commentaire créé succès avec id: " + comment.getId(), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("L'article spécifié n'existe pas", HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/post/{id}") // http://localhost:8080/api/blog/post/x
    public void deletePost(@PathVariable UUID id){
        Post post = postService.getById(id);
        postService.deleteById(id);
    }
    @PutMapping("/update/{id}") // http://localhost:8080/api/v1/blog/update/x
    public Post updatePost(@PathVariable UUID id,@RequestBody Post updatePost){
        return postService.update(id,updatePost);
    }
    @PutMapping("/updateComment/{id}") // http://localhost:8080/api/v1/blog/updateComment/x
    public ResponseEntity<String> updatePostValid(@PathVariable UUID id,@Valid @RequestBody Post updatePost,BindingResult result){
        if(result.hasErrors()){
            StringBuilder errors = new StringBuilder();
            result.getAllErrors().forEach(objectError -> errors.append(objectError.toString() + " , "));

            return new ResponseEntity<>(errors.toString(), HttpStatus.BAD_REQUEST);
        }
        postService.update(id,updatePost);
        return new  ResponseEntity<>("modif post ok", HttpStatus.ACCEPTED);
    }


}

