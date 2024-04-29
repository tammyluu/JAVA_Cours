package org.example.dao;

import org.example.exception.CustomerFormatException;
import org.example.models.EventLocation;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LocationDAO extends  BaseDAO <EventLocation> {

    public LocationDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean save(EventLocation element) throws SQLException {
        request = "INSERT INTO eventLocation (location_Name,adrress, capacity ) VALUES(?,?,?)";
        statement = _connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1,element.getName());
        statement.setString(2,element.getAddress());
        statement.setInt(3,element.getCapacity());
        int nbRow = statement.executeUpdate();
        resultSet = statement.getGeneratedKeys();
        if(resultSet.next()){
            element.setId(resultSet.getInt(1));
        }
        return nbRow == 1;
    }

    @Override
    public boolean update(EventLocation element) throws SQLException {
        request = "UPDATE eventLocation SET location_Name = ?, adrress= ?, capacity= ?  WHERE id_location = ?";
        statement = _connection.prepareStatement(request);
        statement.setString(1,element.getName());
        statement.setString(2,element.getAddress());
        statement.setInt(3,element.getCapacity());
        int nbRow = statement.executeUpdate();
        return nbRow == 1;
    }




    @Override
    public boolean delete(EventLocation element) throws SQLException {
        request = "DELETE FROM eventLocation WHERE id_location = ? ";
        statement = _connection.prepareStatement(request);
        statement.setInt(1,element.getId());
        int nbRows = statement.executeUpdate();
        return nbRows == 1;
    }

    @Override
    public EventLocation get(int id) throws SQLException {
        EventLocation location = null;
        request = "SELECT * FROM eventLocation WHERE id_location = ?";
        statement = _connection.prepareStatement(request);
        statement.setInt(1,id);
        resultSet = statement.executeQuery();

        if(resultSet.next()){
            location = new EventLocation(resultSet.getInt("id"),
                    resultSet.getInt("id_location"),
                    resultSet.getString("location_Name"),
                    resultSet.getString("adrress"),
                    resultSet.getInt("capacity")
            );

        }
        return location;

    }

    @Override
    public List<EventLocation> get() throws SQLException, CustomerFormatException {
        List<EventLocation> locations = new ArrayList<>();
        request = "SELECT * FROM eventLocation";
        statement = _connection.prepareStatement(request);
        resultSet = statement.executeQuery();
        while (resultSet.next()){
            EventLocation location = new EventLocation(
                    resultSet.getString(" location_Name"),
                    resultSet.getString("adrress"),
                    resultSet.getInt("capacity"));
            locations.add(location);
        }
        return locations;
    }
}
