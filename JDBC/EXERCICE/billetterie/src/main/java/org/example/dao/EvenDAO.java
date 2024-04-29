package org.example.dao;

import org.example.exception.CustomerFormatException;
import org.example.models.Event;
import org.example.models.Ticket;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class EvenDAO extends BaseDAO<Event> {
    public EvenDAO(Connection connection) {
        super(connection);
    }

    public LocalDateTime dateTime;
    public Timestamp timestamp;

    @Override
    public boolean save(Event element) throws SQLException {
        request = "INSERT INTO event( event_Name, date,  price ) VALUES(?,?,?)";
        statement = _connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, element.getName());
        dateTime = element.getDateTime(Timestamp.valueOf(dateTime));
        timestamp = Timestamp.valueOf(dateTime);
        statement.setTimestamp(2, timestamp);
        statement.setDouble(3, element.getPrice());
        int nbRow = statement.executeUpdate();
        resultSet = statement.getGeneratedKeys();
        if (resultSet.next()) {
            element.setId(resultSet.getInt(1));
        }
        return nbRow == 1;
    }

    @Override
    public boolean update(Event element) throws SQLException {
        request = "UPDATE event SET event_Name = ?, date= ?, price= ?  WHERE id_event = ?";
        statement = _connection.prepareStatement(request);
        statement.setString(1, element.getName());
        statement.setString(2, String.valueOf(element.getDateTime(Timestamp.valueOf(dateTime))));
        statement.setDouble(3, element.getPrice());
        int nbRow = statement.executeUpdate();
        return nbRow == 1;
    }

    @Override
    public boolean delete(Event element) throws SQLException {
        statement = _connection.prepareStatement(request);
        statement.setInt(1, element.getId());
        int nbRows = statement.executeUpdate();
        return nbRows == 1;
    }

    @Override
    public Event get(int id) throws SQLException {
        Event event = null;
        request = "SELECT * FROM event WHERE id_event = ?";
        statement = _connection.prepareStatement(request);
        statement.setInt(1, id);
        resultSet = statement.executeQuery();
        if (resultSet.next()) {
            event = new Event(
                    resultSet.getInt("id_event"),
                    resultSet.getString("event_Name"),
                    resultSet.getTimestamp("date").toLocalDateTime(),
                    resultSet.getDouble("price"),
                    resultSet.getInt("id_location"),
                    resultSet.getInt("id_location")
            );

        }
        return event;
    }

    @Override
    public List<Event> get() throws SQLException, CustomerFormatException {
        List<Event> events = new ArrayList<>();
        request = "SELECT * FROM event";
        statement = _connection.prepareStatement(request);
        resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Event event = new Event(
                    resultSet.getInt("id_event"),
                    resultSet.getString("event_Name"),
                    resultSet.getTimestamp("date").toLocalDateTime(),
                    resultSet.getDouble("price"),
                    resultSet.getInt("id_location"),
                    resultSet.getInt("ticket_Sold_Number"));
            events.add(event);
        }
        return events;
    }
    public List<Event> getAllEventAvailable() throws SQLException{
        List<Event> eventListAvailable = new ArrayList<>();
        request = "SELECT event_Name, capacity, ticket_Sold_Number FROM event " +
                "INNER JOIN location N id_location = id_event" +
                " WHERE (capacity - ticket_Sold_Number )>0";
        statement = _connection.prepareStatement(request);
        resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Event event = new Event(
                    resultSet.getInt("id_event"),
                    resultSet.getString("event_Name"),
                    resultSet.getTimestamp("date").toLocalDateTime(),
                    resultSet.getDouble("price"),
                    resultSet.getInt("id_location"),
                    resultSet.getInt("ticket_Sold_Number"));
            eventListAvailable.add(event);
        }
        return eventListAvailable;

    }
    public boolean updateTicketSoldNumber(Ticket element) throws SQLException {
        request = "UPDATE  events SET  ticket_Sold_Number = ?  WHERE id_event = ? ";
        statement = _connection.prepareStatement(request);
        statement.setInt(1, element.getPurchasedTicketCount());
        statement.setInt(2, element.getId());
        int nbRows = statement.executeUpdate();
        return nbRows>0;
    }


}