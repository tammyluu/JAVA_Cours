package org.example.output.repository;

import org.example.model.Expense;

import java.util.List;

public interface IExpensePersistencePort {
    void saveExpense(Expense expense);
    List<Expense> getAllExpenses();
}
