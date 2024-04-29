package org.example.port;

import java.util.List;

public interface IBaseRepository<T> {
    void create(T element);
    void delete(T element);
    <T> void findById(int id);
    List<T> findAll(String search);
    void update(T element);


}
