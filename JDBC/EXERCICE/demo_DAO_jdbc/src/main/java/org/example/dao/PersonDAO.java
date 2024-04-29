package org.example.dao;

import org.example.models.Person;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PersonDAO extends BaseDao<Person> {

 public PersonDAO(Connection connection) {
        super(connection);
    }


    @Override
    public boolean save(Person element) throws SQLException {
        request = "INSERT INTO person (first_name, last_name) VALUES(?,?)";
        statement = _connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1,element.getFirstName());
        statement.setString(2,element.getLastName());
        int nbRow = statement.executeUpdate();
        resultSet = statement.getGeneratedKeys();
       if (resultSet.next()){
            element.setId((resultSet.getInt(1)));
        }
        return nbRow == 1;
    }

    @Override
    public boolean update(Person element) throws SQLException {
        request = "UPDATE person SET  first_name = ?,  last_name = ? WHERE  id = ?";
        statement = _connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1,element.getFirstName());
        statement.setString(2,element.getLastName());
        statement.setInt(3,element.getId());
        int nbRow = statement.executeUpdate();
        return nbRow == 1;
    }

    @Override
    public boolean delete(Person element) throws SQLException {
        request = "DELETE  FROM person  WHERE  id = ?";
        statement = _connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        statement.setInt(1,element.getId());
        int nbRow = statement.executeUpdate();
        return nbRow == 1;
    }

    @Override
    public Person get(int id) throws SQLException {
       Person person = null;
        request = "SELECT *  FROM person  WHERE  id = ?";
        statement = _connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        statement.setInt(1,id);
        resultSet = statement.executeQuery();
        if (resultSet.next()){
            person = new Person(resultSet.getInt("id"),
                    resultSet.getString("first_name"),
                    resultSet.getString("last_name"));
        }
        return person;
    }

    @Override
    public List<Person> get() throws SQLException {
        List<Person> result = new ArrayList<>();
        request = "SELECT *  FROM person ";
        statement = _connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        resultSet = statement.executeQuery();
       while (resultSet.next()){
            Person person = new Person(resultSet.getInt("id"),
                    resultSet.getString("first_name"),
                    resultSet.getString("last_name"));
            result.add(person);
        }
        return result;
    }
}
