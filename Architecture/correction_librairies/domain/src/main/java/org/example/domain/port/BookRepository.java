package org.example.domain.port;

import org.example.domain.entity.Book;

import java.util.List;

public interface BookRepository {
    void create(Book book);
    void delete(Book book);
    Book findById(int id);
    List<Book> searchBook(String search);


}
