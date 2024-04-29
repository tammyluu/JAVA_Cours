package org.example.service;

import org.example.dao.LocationDAO;
import org.example.exception.CustomerFormatException;
import org.example.models.EventLocation;
import org.example.utils.DatabaseManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class LocationService implements ITicketService<EventLocation> {
    private LocationDAO locationDAO;
    private Connection connection;
    public LocationService() throws SQLException {

            connection = new DatabaseManager().getConnection();
            locationDAO = new LocationDAO(connection);

        }
    public EventLocation createAndSaveLocation(String locationName, String address, int capacity) throws CustomerFormatException {
        EventLocation location = new EventLocation(locationName, address, capacity);
        try {

            if (locationDAO.save(location)) {
                System.out.println("Un lieu a bien été créé avec l'id : " + location.getId());
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return location;
    }
    @Override
    public boolean modifyById(EventLocation location) {
        try {
           locationDAO.update(location);
            return true;

        } catch (
                SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean deleteById(int id) {
        try {
            EventLocation location = locationDAO.get(id);
            if (location != null) {
                locationDAO.delete(location);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    @Override
    public EventLocation getById(int id) {

        try {
           return locationDAO.get(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<EventLocation> getAll(int id) {
        return null;
    }
}
