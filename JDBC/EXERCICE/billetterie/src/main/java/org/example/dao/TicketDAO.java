package org.example.dao;

import jdk.jshell.spi.ExecutionControl;
import org.example.models.Customer;
import org.example.models.Ticket;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TicketDAO  extends BaseDAO<Ticket> {
    public TicketDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean save(Ticket element) throws SQLException {
        request = "INSERT INTO ticket (id_customer, id_event,purchased_Ticket_Count) VALUES (?, ?, ?)";
        statement = _connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        statement.setInt(1, element.getIdCustomer());
        statement.setInt(2, element.getIdEvent());
        statement.setInt(3, element.getPurchasedTicketCount());
        int nbRows = statement.executeUpdate();
        resultSet = statement.getGeneratedKeys();
        if(resultSet.next()){
            element.setId(resultSet.getInt(1));
        }
        return nbRows == 1;
    }

    @Override
    public boolean update(Ticket element) throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("Méthode à implementé !!!!");
    }

    @Override
    public boolean delete(Ticket element) throws SQLException {
        request = "DELETE FROM ticket WHERE id_ticket = ?";
        statement = _connection.prepareStatement(request);
        statement.setInt(1,element.getId());
        int nbRows = statement.executeUpdate();
        return nbRows == 1;
    }

    @Override
    public Ticket get(int id) throws SQLException {
        Ticket ticket = null;
        request = "SELECT * FROM ticket WHERE id_ticket = ?";
        statement = _connection.prepareStatement(request);
        statement.setInt(1,id);
        resultSet = statement.executeQuery();
        if(resultSet.next()){
            ticket = new Ticket(
                    resultSet.getInt("id_customer"),
                    resultSet.getInt("id_event"),
                    resultSet.getInt("purchased_Ticket_Count"));

        }
        return ticket;
    }

    @Override
    public List<Ticket> get() throws SQLException {
       List<Ticket> tickets = new ArrayList<>();
       request = "SELECT * FROM ticket";
        statement = _connection.prepareStatement(request);
        resultSet = statement.executeQuery();
        while (resultSet.next()){
            Ticket ticket = new Ticket(
                    resultSet.getInt("id_ticket"),
                    resultSet.getInt("id_customer"),
                    resultSet.getInt("id_event"),
                    resultSet.getInt("purchased_Ticket_Count"));
            tickets.add(ticket);
        }
        return tickets;
    }
}
