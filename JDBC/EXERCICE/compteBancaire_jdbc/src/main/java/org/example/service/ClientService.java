package org.example.service;

import org.example.dao.ClientDAO;
import org.example.models.BankAccount;
import org.example.models.Client;
import org.example.utils.DataBaseManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientService {
    private ClientDAO clientDAO;
    private Connection connection;
    public  ClientService(){
        try {
            connection = new DataBaseManager().getConnection();
            clientDAO = new ClientDAO(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public  boolean createAClient( String firstName,String lastName,String phoneNumber ){
        Client client = new Client();
        // List<BankAccount> accounts = new ArrayList<>();
        client.setFirstName(firstName);
        client.setLastName(lastName);
        client.setPhoneNumber(phoneNumber);
       // client.setAccounts(accounts);
        try {
            return clientDAO.save(client);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean updateAClient(Client client){
        try {
            return  clientDAO.update(client);
        }catch ( SQLException e){
            throw new RuntimeException(e);
        }
    }
    public Client getPerson(int id){
        try {
            return clientDAO.get(id);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    public boolean deleteOneClient(int id){
        Client client = null;
        try {
            client = clientDAO.get(id);
            if ( client != null){
                return  clientDAO.delete(client);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return  false;
    }
    public  List<Client> getAllClients(){
        try {
            return clientDAO.get();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
