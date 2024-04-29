package com.example.blog_app.service;

import com.example.blog_app.model.Comment;
import com.example.blog_app.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PostServiceImpl implements IBlogServcie<Post> {

    private final Map<UUID, Post> posts;

    public PostServiceImpl() {
        posts = new HashMap<>();
        Post post1 = Post.builder()
              .id(UUID.randomUUID())
              .title("Cobol")
              .description("Bank and Assurance")
              .content("Step by step")
              .comments(new ArrayList<>())
              .build();
         Post post2 = Post.builder()
                .id(UUID.randomUUID())
                .title("Python")
                .description("Data Science")
                .content("News")
                .comments(new ArrayList<>())
                .build();
        Post post3 = Post.builder()
                .id(UUID.randomUUID())
                .title("Java")
                .description("Application web, API Rest")
                .content(" Backend with Framework Spring MVC")
                .comments(new ArrayList<>())
                .build();
        Post post4 = Post.builder()
                .id(UUID.randomUUID())
                .title("C++")
                .description("Game programming")
                .content("Workshop")
                .comments(new ArrayList<>())
                .build();

        posts.put(post1.getId(),post1);
        posts.put(post2.getId(),post2);
        posts.put(post3.getId(),post3);
        posts.put(post4.getId(),post4);


    }


    @Override
    public List<Post> getAll() {
       return posts.values().stream().toList();

    }

    @Override
    public Post getById(UUID id) {
        return posts.values().stream().filter(s -> s.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public Boolean add(Post post) {
        if (post.getId() ==null){
            post.setId(UUID.randomUUID());
            posts.put(post.getId(),post);
            return true;
        }else {
            return false;
        }

    }

    @Override
    public Boolean deleteById(UUID id) {
        posts.remove(id);
        System.out.println("delete");
        return true;
    }

    @Override
    public Post update(UUID id, Post element) {
        Post postExist = getById(id);
        if (postExist != null) {
            postExist.setTitle(element.getTitle());
            postExist.setDescription(element.getDescription());

        }

        return postExist;
    }
    public boolean addComment(Post post, Comment comment) {
        List<Comment> comments = post.getComments();
        comments.add(comment);
        return true;
    }
}
