package com.example.adapterrest.resource;

import com.example.adapterrest.dto.BookDTO;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.example.entity.Book;
import org.example.service.BookService;
import org.example.spi.port.IBookRepository;

import java.util.List;

@Path("books")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookResource {
    private final BookService bookService;
    @Inject
    public BookResource() {
        bookService =new BookService(new IBookRepository {
            @Override
            public boolean create(Book book) {
                return false;
            }

            @Override
            public boolean delete(Long id) {
                return false;
            }

            @Override
            public boolean update(Book book) {
                return false;
            }

            @Override
            public Book findById(Long id) {
                return null;
            }

            @Override
            public List<Book> findAll() {
                return null;
            }
        }kResipototyIpml(new BookEntityRepository()));
    }
    @GET
    @Path("{id}")
    public BookDTO get(@PathParam("id") Long id) {
        return bookService.findBoookById(id);
    }

    @POST
    public BookDTO post(BookDTO bookDTO) {
        return BookDTO.toDTO(bookService.createBook(bookDTO));
    }
    @DELETE
    @Path("{id}")
    public boolean delete(@PathParam("id") Long id) {
        return bookService.deleteBook(id);
    }


}