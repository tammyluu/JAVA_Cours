package org.example.dao;

import jdk.jshell.spi.ExecutionControl;
import org.example.models.BankAccount;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BankAccountDAO extends BaseDao<BankAccount>{
    public BankAccountDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean save(BankAccount element) throws SQLException {
        request = "INSERT INTO account (id_Account,  balance,  id_Client) VALUES(?,?,?)";
        statement = _connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1,element.getIdAccount());
        statement.setDouble(2,element.getBalance());
        statement.setInt(3,element.getClient().getIdClient());
        int nbRow = statement.executeUpdate();
        resultSet = statement.getGeneratedKeys();
        if (resultSet.next()){
            element.setIdAccount((resultSet.getString(1)));
        }
        return nbRow == 1;
    }

    @Override
    public boolean update(BankAccount element) throws SQLException {
        request = "UPDATE account SET  balance = ?,  WHERE  id = ?";
        statement = _connection.prepareStatement(request);
        statement.setDouble(1,element.getBalance());
        statement.setInt(2,element.getClient().getIdClient());
        int nbRow = statement.executeUpdate();
        return nbRow == 1;
    }
 // exception surveillé car  on n'a pas besoins de cette méthode pour cet application
    @Override
    public boolean delete(BankAccount element) throws SQLException, ExecutionControl.NotImplementedException {
        throw  new ExecutionControl.NotImplementedException("Méthode à implementé!!!");
    }



    @Override
    public BankAccount get(int id) throws SQLException {
        BankAccount account = null;
        request = "SELECT *  FROM account  WHERE  id = ?";
        statement = _connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        statement.setInt(1,id);
        resultSet = statement.executeQuery();
        if (resultSet.next()){
            account = new BankAccount(
                    resultSet.getString("id_Account"),
                    resultSet.getDouble("balance"),
                    resultSet.getInt("id_Client"));
        }
        return account;
    }

    @Override
    public BankAccount get(String numberOperation) throws SQLException {
        BankAccount account = null;
        request = "SELECT *  FROM account  WHERE  numberOperation = ?";
        statement = _connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1,numberOperation);
        resultSet = statement.executeQuery();
        if (resultSet.next()){
            account = new BankAccount(
                    resultSet.getString("id_Account"),
                    resultSet.getDouble("balance"),
                    resultSet.getInt("id_Client"));
        }
        return account;

    }

    @Override
    public List<BankAccount> get() throws SQLException, ExecutionControl.NotImplementedException {
        throw  new ExecutionControl.NotImplementedException("Méthode à implementé!!!");
    }
    public List<BankAccount> get(String numberOperation) throws SQLException {
        BankAccount account = null;
        request = "SELECT *  FROM account  WHERE  id_Client = ?";
        statement = _connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1,numberOperation);
        resultSet = statement.executeQuery();
        if (resultSet.next()){
            account = new BankAccount(
                    resultSet.getInt("id_Client")),
                    resultSet.getDouble("balance");
        }
        return account;
    }

    public void deposit(int accountId, double amount) throws SQLException {
      request = "UPDATE account SET balance = (balance + ?) WHERE id_Account = ?";
        statement = _connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        statement.setInt(1,accountId);
        resultSet = statement.executeQuery();
        if (resultSet.next()){
            statement.setDouble(1, amount);
            statement.setInt(2, accountId);

            int affectedRows = statement.executeUpdate();

        if (affectedRows > 0) {
                System.out.println("Deposit successful.");
            } else {
                System.out.println("Deposit failed. No rows were updated.");
            }
        }
    }
    public void withdrawal(int accountId, double amount) throws SQLException {
        request = "UPDATE account SET balance = (balance - ?) WHERE id_Account = ?";
        statement = _connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        statement.setInt(1,accountId);
        resultSet = statement.executeQuery();
        if (resultSet.next()){
            statement.setDouble(1, amount);
            statement.setInt(2, accountId);

            int affectedRows = statement.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("Retrait successful.");
            } else {
                System.out.println("Retrait  failed. No rows were updated.");
            }
        }
    }


}
