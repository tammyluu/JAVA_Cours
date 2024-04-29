package org.example.service;

import org.example.model.Expense;
import org.example.repository.IExpenseRepository;

import java.util.ArrayList;
import java.util.List;

public class ExpenseService implements IExpenseRepository {
    private final IExpenseRepository expenseRepository;

    public ExpenseService(IExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    @Override
    public void addExpense(Expense expense) {

    }

    @Override
    public void addExpense(String title, double sum) {
        Expense expense = new Expense.Builder().title(title).sum(sum).build();
        expenseRepository.addExpense(expense);
        
    }

    @Override
    public List<Expense> listAllExpenses() {
        return expenseRepository.listAllExpenses();
    }

    @Override
    public List<Expense> searchExpenses(String search) {
        List<Expense> allExpenses = expenseRepository.listAllExpenses();
        List<Expense> filteredExpenses = new ArrayList<>();

        if (search == null || search.isEmpty()) {
            return allExpenses;
        }

        // Filtrer les dépenses qui correspondent au critère de recherche
        for (Expense expense : allExpenses) {
            if (expense.getTitle().toLowerCase().contains(search.toLowerCase())) {
                filteredExpenses.add(expense);
            }
        }

        return filteredExpenses;
    }

  
}
