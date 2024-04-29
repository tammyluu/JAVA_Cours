import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.model.Expense;
import org.example.repository.IExpenseRepository;
import org.example.service.ExpenseService;
import org.junit.jupiter.api.Assertions;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;



public class ExpenseStepdefs {
    @Mock
    private IExpenseRepository expenseRepository;

    private Expense expense;

    private List<Expense> expenseList ;

    @InjectMocks
    private ExpenseService expenseService;
    public void ExpenseTest() {
        expenseRepository = Mockito.mock(IExpenseRepository.class);
        expenseService = new ExpenseService(expenseRepository);
        expense = new Expense.Builder().title("shopping").sum(500).build();

    }
    @Given("that a user wants to retrieve all expenses")
    public void thatAUserWantsToRetrieveAllExpenses() {
        expense = new Expense.Builder().title("shopping").sum(500).build();
        Mockito.doAnswer(invocationOnMock -> {
            Expense e = invocationOnMock.getArgument(0);
            e.setId(1L);
            return null;
        }).when(expenseRepository).addExpense(expense);
        expenseService.addExpense("shopping", 500);
    }

    @When("the user requests the list of all expenses")
    public void theUserRequestsTheListOfAllExpenses() {
        Mockito.when(expenseRepository.listAllExpenses().iterator());
        expenseList = expenseService.listAllExpenses();
    }

    @Then("the list of all expenses is returned successfully")
    public void theListOfAllExpensesIsReturnedSuccessfully(int size) {
        Assertions.assertEquals(size,expenseList.size());
    }
}
