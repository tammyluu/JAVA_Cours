package org.example.dao;

import jdk.jshell.spi.ExecutionControl;
import org.example.models.Operation;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class OperationDAO extends BaseDAO<Operation> {
  public OperationDAO(Connection connection) {
    super(connection);
  }

  @Override
  public boolean save(Operation element) throws SQLException {
    request = "INSERT INTO operation (amount,account_id,status) VALUES (?,?,?)";
    statement = _connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
    statement.setDouble(1,element.getAmount());
    statement.setInt(2,element.getAccountId());
    statement.setInt(3,element.getStatus().ordinal());
    int nbRow = statement.executeUpdate();
    resultSet = statement.getGeneratedKeys();
    if(resultSet.next()){
      element.setId(resultSet.getInt(1));
    }
    return nbRow == 1;
  }

  @Override
  public boolean update(Operation element) throws SQLException, ExecutionControl.NotImplementedException {
    throw new ExecutionControl.NotImplementedException("Méthode à implementé !!!!");
  }

  @Override
  public boolean delete(Operation element) throws SQLException, ExecutionControl.NotImplementedException {
    throw new ExecutionControl.NotImplementedException("Méthode à implementé !!!!");
  }

  @Override
  public Operation get(int id) throws SQLException, ExecutionControl.NotImplementedException {
    throw new ExecutionControl.NotImplementedException("Méthode à implementé !!!!");
  }

  @Override
  public List<Operation> get() throws SQLException, ExecutionControl.NotImplementedException {
    throw new ExecutionControl.NotImplementedException("Méthode à implementé !!!!");
  }

  public List<Operation> getByIdAccount(int id) throws SQLException {
    List<Operation> operations = new ArrayList<>();
    request = "SELECT * FROM operation WHERE account_id = ?";
    statement = _connection.prepareStatement(request);
    statement.setInt(1,id);
    resultSet = statement.executeQuery();
    while (resultSet.next()){
      Operation operation = new Operation(resultSet.getInt("id"),
              resultSet.getDouble("amount"),
              resultSet.getInt("account_id"));
      operations.add(operation);
    }
    return operations;

  }
}
