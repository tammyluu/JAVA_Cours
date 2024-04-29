package org.example.output.repository;

import org.example.model.Expense;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class ExpensePersistencePortImpl implements  IExpensePersistencePort{
    private final SessionFactory sessionFactory;

    public ExpensePersistencePortImpl(SessionFactory sessionFactory) {
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
