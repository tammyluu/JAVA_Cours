package org.example.dao;

import org.example.models.BankAccount;
import org.example.models.Operation;
import org.example.models.Status;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OperationDAO extends BaseDao<Operation> {

  public OperationDAO(Connection connection) {
    super(connection);
  }

  @Override
  public boolean save(Operation element) throws SQLException {
    request = "INSERT INTO operation(operation_Num,  amount , status) VALUES(?,?,?)";
    statement = _connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
    statement.setString(1,element.getOperationNum());
    statement.setDouble(2,element.getAmount());
    statement.setInt(3,element.getStatus().ordinal());

    int nbRow = statement.executeUpdate();
    resultSet = statement.getGeneratedKeys();
    if (resultSet.next()){
      element.setOperationNum((resultSet.getString(1)));
    }
    return nbRow == 1;
  }

  @Override
  public boolean update(Operation element) throws SQLException {
   return false;
  }

  @Override
  public boolean delete(Operation element) throws SQLException {
    return false;
  }

  @Override
  public Operation get(int id) throws SQLException {
    return null;
  }

  @Override
  public BankAccount get(String numberOperation) throws SQLException {
    return null;
  }

  @Override
  public List<Operation> getByIdAccount(String numberOperation) throws SQLException {
     List<Operation>  operations = new ArrayList<>();
    request = "SELECT *  FROM operation  WHERE operation_Num = ?";
    statement = _connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
    statement.setString(1,numberOperation);
    resultSet = statement.executeQuery();
    if (resultSet.next()){
      Operation o = new Operation(resultSet.getString("operation_Num"),
              resultSet.getDouble("amount"),
              resultSet.getString("id_account"));
      operations.add(o);
    }
    return operations;

  }

  @Override
  public List<Operation> get() throws SQLException {
    List<Operation> operations = new ArrayList<>();
    request = "SELECT * FROM operation";
    statement = _connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
    resultSet = statement.executeQuery();
    while (resultSet.next()) {
        Operation operation = new Operation(
                resultSet.getString("operation_Num"),
                resultSet.getDouble("amount"),
                resultSet.getString("status"));

        operations.add(operation);
      }
    return operations;
    }


}
