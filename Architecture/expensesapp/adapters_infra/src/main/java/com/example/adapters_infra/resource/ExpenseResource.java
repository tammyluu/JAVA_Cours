package com.example.adapters_infra.resource;




import com.example.adapters_infra.dto.ExpenseDTO;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.model.Expense;
import org.example.service.ExpenseService;

import java.util.List;
import java.util.stream.Collectors;

@Path("expenses")
public class ExpenseResource {

    private final ExpenseService expenseService;
    @Inject
    public ExpenseResource(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ExpenseDTO> getAllExpenses() {
        List<Expense> expenses = expenseService.listAllExpenses();
        return expenses.stream()
                .map(expense -> new ExpenseDTO(expense.getId(), expense.getTitle(), expense.getSum()))
                .collect(Collectors.toList());
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addExpense(ExpenseDTO expenseDTO) {
        try {
            expenseService.addExpense(expenseDTO.getTitle(),expenseDTO.getSum());
            return Response.ok().build();
        } catch (Exception ex) {
            return Response.status(500, "Erreur serveur").build();
        }
    }
}