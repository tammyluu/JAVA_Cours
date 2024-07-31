package org.example.service;

import org.example.dao.AccountDAO;
import org.example.dao.CustomerDAO;
import org.example.dao.OperationDAO;


import org.example.models.BankAccount;
import org.example.models.Customer;

import org.example.models.Operation;
import org.example.utils.DataBaseManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BankService implements IBankService{

    private AccountDAO accountDAO;
    private CustomerDAO customerDAO;
    private OperationDAO operationDAO;
    private Connection connection;

    public BankService(){
        try {
            connection = new DataBaseManager().getConnection();
            accountDAO = new AccountDAO(connection);
            customerDAO = new CustomerDAO(connection);
            operationDAO = new OperationDAO(connection);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }


    @Override
    public Customer createAndSaveCustomer(String firstName, String lastName, String phone) {
        Customer customer = new Customer(firstName,lastName,phone);
        try {
            if(customerDAO.save(customer)){
                return customer;
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public BankAccount createAndSaveAccount(int customerId) {
        BankAccount bankAccount = new BankAccount(getCustomerById(customerId),0);
        try {
            if(accountDAO.save(bankAccount)){
                return bankAccount;
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public List<BankAccount> getAccountsByIdCustomer(int id) {
        try {
           return accountDAO.getByIdCustomer(id);

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Customer getCustomerById(int id) {
        try {
            return customerDAO.get(id);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Customer> getAllClient() {
        try {
            return customerDAO.get();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public BankAccount getAccount(int id) {
        BankAccount bankAccount = null;
        try {
            bankAccount = accountDAO.get(id);
            if (bankAccount != null){
                return bankAccount;
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return bankAccount;
    }

    @Override
    public List<Operation> getAllOperationsByIdAccount(int id) {
        try {
            return operationDAO.getByIdAccount(id);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean makeOperationDeposit(double montant, int idAccount) {
        Operation operation = new Operation(montant,idAccount);
        BankAccount bankAccount = getAccount(idAccount);
        try {
            return (bankAccount.makeDeposit(operation) && operationDAO.save(operation) && accountDAO.update(bankAccount));
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean makeOperationWithDraw(double montant, int idAccount) {
        Operation operation = new Operation(montant,idAccount);
        BankAccount bankAccount = getAccount(idAccount);
        try {
            return (bankAccount.makeWithDrawl(operation) && operationDAO.save(operation) && accountDAO.update(bankAccount));
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
