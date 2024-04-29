package com.example.blog_app.service;

import java.util.List;
import java.util.UUID;

public interface IBlogServcie <T> {
    List<T> getAll();
    T getById(UUID id);
    Boolean add(T element);
    Boolean deleteById(UUID id);
    T update(UUID id, T element);
}
