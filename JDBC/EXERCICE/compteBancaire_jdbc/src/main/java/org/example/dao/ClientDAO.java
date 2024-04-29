package org.example.dao;

import jdk.jshell.spi.ExecutionControl;
import org.example.models.BankAccount;
import org.example.models.Client;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO extends BaseDao<Client> {
    public ClientDAO(Connection connection) {
        super(connection);
    }


    @Override
    public boolean save(Client element) throws SQLException {
        request = "INSERT INTO client (first_name, last_name,  phoneNumber) VALUES(?,?,?)";
        statement = _connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, element.getFirstName());
        statement.setString(2, element.getLastName());
        statement.setString(3, element.getPhoneNumber());
        int nbRow = statement.executeUpdate();
        resultSet = statement.getGeneratedKeys();
        if (resultSet.next()) {
            element.setIdClient((resultSet.getInt(1)));
        }
        return nbRow == 1;
    }


    @Override
    public boolean delete(Client element) throws SQLException, ExecutionControl.NotImplementedException {
       throw new ExecutionControl.NotImplementedException("Méthode à implemtée!!!");
    }

    @Override
    public boolean update(Client element) throws SQLException {
        request = "UPDATE client SET  first_name = ?,  last_name = ?, phoneNumber = ? WHERE  id = ?";
        statement = _connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, element.getFirstName());
        statement.setString(2, element.getLastName());
        statement.setString(3, element.getPhoneNumber());
        statement.setInt(3, element.getIdClient());
        int nbRow = statement.executeUpdate();
        return nbRow == 1;
    }


    @Override
    public Client get(int id) throws SQLException {
        Client client = null;
        request = "SELECT *  FROM client  WHERE  id_Client = ?";
        statement = _connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        statement.setInt(1, id);
        resultSet = statement.executeQuery();
        if (resultSet.next()) {
            client = new Client(resultSet.getInt("id_Client"),
                    resultSet.getString("first_name"),
                    resultSet.getString("last_name"),
                    resultSet.getString("phoneNumber"));
        }
        return client;
    }

    @Override
    public BankAccount get(String numberOperation) throws SQLException {
        return null;
    }


    @Override
    public List<Client> get() throws SQLException {
        List<Client> result = new ArrayList<>();
        request = "SELECT *  FROM client ";
        statement = _connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        resultSet = statement.executeQuery();
        while (resultSet.next()){
            Client client = new Client(resultSet.getInt("id_client"),
                    resultSet.getString("first_name"),
                    resultSet.getString("last_name"),
                    resultSet.getString("phoneNumber"));
            result.add(client);
        }
        return result;
    }
    public Client showAccountsOfOneCLient (int idClient) throws SQLException{
        Client client = null;
        request = "SELECT * FROM account a,  client c WHERE a.id_Client = c.id_Client AND c.id_Client = ? ";
        statement = _connection.prepareStatement(request,Statement.RETURN_GENERATED_KEYS);
        statement.setInt(1,idClient);
        resultSet = statement.executeQuery();
        while (resultSet.next()){
            if (client == null) {
                client = new Client();
                client.setIdClient(resultSet.getInt("c.id_Client"));
                client.setFirstName(resultSet.getString("c.first_Name"));
                client.setLastName(resultSet.getString("c.last_Name"));
                client.setPhoneNumber(resultSet.getString("c.phoneNumber"));
                client.setAccounts(new ArrayList<>()); // Initialize the list
            }
            BankAccount account = new BankAccount();
            account.setIdAccount(resultSet.getString("a.id_Account"));
            account.setBalance(resultSet.getDouble("a.Balance"));
            client.getAccounts().add(account);
        }
       return client;
    }

}
