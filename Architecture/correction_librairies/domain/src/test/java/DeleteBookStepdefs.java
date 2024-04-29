import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.domain.entity.Book;
import org.example.domain.port.BookRepository;
import org.example.domain.service.BookService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class DeleteBookStepdefs {

    private BookService bookService;
    private Book firstBook;
    private Book secondBook;

    private List<Book> resultSearch;

    private final BookRepository bookRepository;
    public DeleteBookStepdefs() {
        bookRepository = Mockito.mock(BookRepository.class);
        bookService = new BookService(bookRepository);

    }
    @Given("there are two books, one with id {int}")
    public void thereAreTwoBooksOneWithId(int id) {
        firstBook = new Book.Builder().title("toto").author("tata").build();
        Mockito.doAnswer(invocationOnMock -> {
            Book b = invocationOnMock.getArgument(0);
            b.setId(id);
            return null;
        }).when(bookRepository).create(firstBook);
        bookService.createBook("toto", "tata");
    }

    @And("second with id {int} in the library")
    public void secondWithIdInTheLibrary(int id) {
        secondBook = new Book.Builder().title("lolo").author("lala").id(id).build();
        Mockito.doAnswer(invocationOnMock -> {
            Book b = invocationOnMock.getArgument(0);
            b.setId(id);
            return null;
        }).when(bookRepository).create(secondBook);
        bookService.createBook("lolo", "lala");
    }

    @When("I delete the book with id {int}")
    public void iDeleteTheBookWithId(int id) {
        Mockito.when(bookRepository.findById(id)).thenReturn(firstBook);
        bookService.deleteBook(id);
    }

    @Then("list with one book with id {int} should be returned")
    public void listWithOneBookWithIdShouldBeReturned(int id) {
        Mockito.when(bookRepository.searchBook("toto")).thenReturn(List.of(secondBook));
        resultSearch = bookService.searchBook("toto");
        Assertions.assertEquals(id, resultSearch.get(0).getId());
    }
}
