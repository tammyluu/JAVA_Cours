package org.example.domain.service;

import org.example.domain.entity.Book;
import org.example.domain.port.BookRepository;

import java.util.List;

public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book createBook(String title, String author) {
        //Logique de contrôle
        if(title.length() < 3) {
            throw new RuntimeException("Title length must be gt 3 char");
        }
        //...
        Book book = new Book.Builder().title(title).author(author).build();
        bookRepository.create(book);
        return book;
    }

    public void deleteBook(int id) {
        Book book = bookRepository.findById(id);
        if(book == null) {
            throw new RuntimeException("Book not found");
        }
        bookRepository.delete(book);
    }

    public List<Book> searchBook(String search) {
        if(search.length() < 3) {
            throw new RuntimeException("search word length must be gt 3 char");
        }
        List<Book> list = bookRepository.searchBook(search);
        return list;
    }

}
