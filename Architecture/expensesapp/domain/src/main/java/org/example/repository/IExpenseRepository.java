package org.example.repository;

import org.example.model.Expense;

import java.util.List;

public interface IExpenseRepository {
    void addExpense(Expense expense);

    void addExpense(String title, double sum);

    List<Expense> listAllExpenses();

    List<Expense> searchExpenses(String search);


}

