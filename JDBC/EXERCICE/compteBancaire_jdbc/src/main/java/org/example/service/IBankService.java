package org.example.service;

import org.example.models.BankAccount;

import org.example.models.Customer;
import org.example.models.Operation;

import java.util.List;

public interface IBankService {

    public Customer createAndSaveCustomer(String firstName, String lastName, String phone);

    public BankAccount createAndSaveAccount(int customerId);

    public List<BankAccount> getAccountsByIdCustomer(int id);

    public Customer getCustomerById(int id);

    public List<Customer> getAllClient();

    public BankAccount getAccount(int id);

    public List<Operation> getAllOperationsByIdAccount(int id);

    public boolean makeOperationDeposit(double montant,int idAccount);

    public boolean makeOperationWithDraw(double montant,int idAccount);



}
