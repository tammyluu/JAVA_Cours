package org.example.service;

import org.example.dao.EvenDAO;
import org.example.dao.LocationDAO;
import org.example.models.Event;
import org.example.models.EventLocation;
import org.example.utils.DatabaseManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

public class EventService implements ITicketService<Event>{
    private EvenDAO evenDAO;
    private LocationDAO locationDAO;
    private Connection connection;
    private EventLocation eventLocation;
    private Event event;

    public EventService() throws SQLException {
        connection = new DatabaseManager().getConnection();
        locationDAO = new LocationDAO(connection);
        evenDAO = new EvenDAO(connection);
    }
    public  Event createAndSaveEvent( String eventName, LocalDateTime date, Double price, int idLocation, int ticketSoldNumber){
        Event event = new Event(eventName,date,price,idLocation,ticketSoldNumber);
        try {
            if (evenDAO.save(event)) {
                System.out.println("Un évènement a bien été créé avec id : " + event.getId() );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return event;
    }
    @Override
    public boolean modifyById(Event element) {
        try {
            evenDAO.update(event);
            return true ;

        } catch (
                SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean deleteById(int id) {
        try{
            event = evenDAO.get(id);
            if(event != null) {
                evenDAO.delete(event);
            }
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        } return true;
    }

    @Override
    public Event getById(int id) {
        try {
            return evenDAO.get(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public  boolean checkEventAvailable (){
        try {
            EventLocation eventLocation = locationDAO.get(event.getEventLocation().getId());
            int numberTicketsAvailable = event.getTicketsSoldNumber();
            if (eventLocation.getCapacity() > numberTicketsAvailable) {
                return true;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
    @Override
    public List<Event> getAll(int id) {
        return null;
    }

    public Event createAndSaveEvent(String iName, String iDate, int iPrice, int iTickeSoldNum, int iIDLocation) {
        return null;
    }
}
