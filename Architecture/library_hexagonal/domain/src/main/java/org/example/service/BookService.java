package org.example.service;

import org.example.entity.Book;
import org.example.spi.port.IBookRepository;

public class BookService {
    private IBookRepository bookRepository;

    public BookService(IBookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    public Book createBook(String title, boolean available){
        Book book =new Book(title,available);
        if (bookRepository.create(book)){
            return book;
        }
        throw  new RuntimeException("Failed to create book.");
    }
 public Book findBoookById(Long id){
        return bookRepository.findById(id);
 }
    public boolean deleteBook(Long id) {
        if (!bookRepository.delete(id)) {
            throw new RuntimeException("Failed to delete book with ID: " + id);
        }
        return false;
    }


}
