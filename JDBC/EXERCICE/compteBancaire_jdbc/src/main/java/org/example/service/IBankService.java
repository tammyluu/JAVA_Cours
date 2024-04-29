package org.example.service;

import org.example.models.BankAccount;
import org.example.models.Client;
import org.example.models.Operation;

import java.util.List;

public interface IBankService {
public Client createAndSaveClient(String firstName, String lastName, String phoneNumber);
public BankAccount createAndSaveAccount(int clientId);
public List<BankAccount> getAccountsByIdClient(int id);
public Client getClientById(int id);
public  List<Client> getAllClients ();
public BankAccount getAccount (String id);
public List<Operation> getAllOperationsById(String operationNum);
public boolean makeperationDepopsit(double amount, String idAccount);
public boolean makeperationWithdrawal(double amount, String idAccount);

}
