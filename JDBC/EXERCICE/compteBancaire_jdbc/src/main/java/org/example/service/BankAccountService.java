package org.example.service;

import jdk.jshell.spi.ExecutionControl;
import org.example.dao.BankAccountDAO;
import org.example.dao.ClientDAO;
import org.example.dao.OperationDAO;
import org.example.models.BankAccount;
import org.example.models.Client;
import org.example.models.Operation;
import org.example.utils.DataBaseManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BankAccountService  implements IBankService{
    private BankAccountDAO accountDAO;
    private Connection connection;
    private  ClientDAO clientDAO;
    private OperationDAO operationDAO;
    public BankAccountService(){
        try {
            connection = new DataBaseManager().getConnection();
            accountDAO = new BankAccountDAO(connection);
            clientDAO = new ClientDAO(connection);
            operationDAO = new OperationDAO(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public  boolean createAnAccount(Double balance,Client client ){
        BankAccount account = new BankAccount();
        account.setBalance(balance);
        account.setClient(client);
        try {
            return accountDAO.save(account);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean updateAnAccoount(BankAccount account){
        try {
            return  accountDAO.update(account);
        }catch ( SQLException e){
            throw new RuntimeException(e);
        }
    }
    public BankAccount getAccount(int id){
        try {
            return accountDAO.get(id);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }


    @Override
    public Client createAndSaveClient(String firstName, String lastName, String phoneNumber) {
        return null;
    }

    @Override
    public BankAccount createAndSaveAccount(int clientId) {
        return null;
    }

    @Override
    public List<BankAccount> getAccountsByIdClient(int id) {
        return null;
    }

    @Override
    public Client getClientById(int id) {
        return null;
    }

    @Override
    public List<Client> getAllClients() {
        return null;
    }

    @Override
    public BankAccount getAccount(String id) {
        return null;
    }

    @Override
    public List<Operation> getAllOperationsById(String operationNum) {
        return null;
    }

    @Override
    public boolean makeperationDepopsit(double amount, String idAccount) {
        return false;
    }

    @Override
    public boolean makeperationWithdrawal(double amount, String idAccount) {
        return false;
    }
}

