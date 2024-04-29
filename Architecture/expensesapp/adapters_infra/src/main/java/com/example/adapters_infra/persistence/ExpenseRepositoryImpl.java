package com.example.adapters_infra.persistence;

import org.example.model.Expense;
import org.example.output.repository.IExpensePersistencePort;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class ExpenseRepositoryImpl implements IExpensePersistencePort {
    private final SessionFactory sessionFactory;

    public ExpenseRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void saveExpense(Expense expense) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(expense);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Expense> getAllExpenses() {
        Session session = sessionFactory.openSession();
        List<Expense> expenses = session.createQuery("FROM ExpenseEntity ", Expense.class).list();
        session.close();
        return expenses;
    }
}
