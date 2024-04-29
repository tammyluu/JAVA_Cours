import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.model.Expense;
import org.example.repository.IExpenseRepository;
import org.example.service.ExpenseService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ExpenseTest {
    @Mock
    private IExpenseRepository expenseRepository;

    private Expense expense;

    private Expense resultSearch;

    @InjectMocks
    private ExpenseService expenseService;
    public void ExpenseTest() {
        expenseRepository = Mockito.mock(IExpenseRepository.class);
        expenseService = new ExpenseService(expenseRepository);
        expense = new Expense.Builder().title("gift").sum(50).build();

    }
    @Given("that a user wants to add an expense with title {string} and amount {int}")
    public void that_a_user_wants_to_add_an_expense_with_title_and_amount(String title, double sum) {
        expense = new Expense.Builder().title("gift").sum(50).build();
        Mockito.doAnswer(invocationOnMock -> {
            Expense e = invocationOnMock.getArgument(0);
            e.setId(1L);
            return null;
        }).when(expenseRepository).addExpense(Mockito.any());
        expenseService.addExpense("gift", 50);
    }
    @When("the user adds the expense")
    public void the_user_adds_the_expense() {
        expenseService.addExpense(expense);
    }
    @Then("the expense is successfully added")
    public void the_expense_is_successfully_added() {
        Assertions.assertNotNull(expense.getId(), "Expense should have an ID after being added");
    }

}
