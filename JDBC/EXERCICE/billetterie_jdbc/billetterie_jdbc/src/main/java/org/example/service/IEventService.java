package org.example.service;

import org.example.models.Customer;
import org.example.models.Event;
import org.example.models.EventLocation;
import org.example.models.Ticket;

import java.util.Date;
import java.util.List;

public interface IEventService  {

    public EventLocation createEventLocation(String name, String address, int capacity);
    public EventLocation modifyEventLocationById(int id);
    public EventLocation deleteEventLocationById(int id);
    public Event createAnEvent(String name, Date date, Double price, int idLocation);
    public Event modifyAnEventById(int id);
    public Event deleteAnEventById(int id);
    public Customer createCustomer(String firstName, String lastName, String email);
    public  Customer modifyACustomerById(int id);
    public  Customer deleteACustomertById(int id);
    public Ticket soldATicket(int idCustomer, int idEvent);
    public Ticket CancelOneticket(int id);
    public List<Event> getAllEventsAvailable(int id);
    public List<Ticket> ticketListOfOneCustomer(int id);

}
