package org.example.repository;

import org.example.entity.Book;
import org.example.entity.BookEntity;
import org.example.spi.port.IBookRepository;

import java.util.List;

public class BookRepositoryImpl implements IBookRepository {
    public  BookEntityRepository bookEntityRepository;
    @Override
    public boolean create(Book book) {
       try {
           BookEntity bookEntity = BookEntity.builder()
                   .title(book.getTitle())
                   .available(book.getAvailable())
                   .build();
           bookEntityRepository.create(bookEntity);
           book.setId(bookEntity.getId());
           return true;
       }catch (Exception e){
           return false;
       }
    }


    @Override
    public boolean update(Book book) {
        return false;
    }

    @Override
    public Book findById(Long id) {
        try {
            // Utiliser le repository pour rechercher un livre par son identifiant
            Book bookEntity = bookEntityRepository.findById(id);
            if (bookEntity != null) {
                // Si le livre est trouvé, convertir l'entité en objet Book et le retourner
                return new Book(bookEntity.getId(), bookEntity.getTitle(), bookEntity.getAvailable());
            } else {
               return null;
            }
        } catch (Exception e) {
           return null;
        }
    }

    @Override
    public List<Book> findAll() {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        try {
            return bookEntityRepository.delete(id);
        } catch (Exception e) {
            return false;
        }
    }

}
