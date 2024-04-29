package org.example.models;

import lombok.Getter;
import org.example.exception.CustomerFormatException;
import org.example.exception.TicketSoldException;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Event {
    private static int count = 0;
    @Getter
    private int id;

    @Getter
    private String name;

    private LocalDateTime dateTime;

    @Getter
    private EventLocation eventLocation;

    @Getter
    private double price;

    @Getter
    private int ticketsSoldNumber;

    public Event() {
        id = ++count;
    }

    public Event(String name, LocalDateTime dateTime, EventLocation eventLocation, double price) throws CustomerFormatException {
        this();
        setName(name);
        setDateTime(dateTime);
        setEventLocation(eventLocation);
        setPrice(price);
        ticketsSoldNumber = 0;
    }



    public Event(int idEvent, String eventName, LocalDateTime date, double price, int idLocation, int ticketSoldNumber) {
    }

    public Event(String eventName, LocalDateTime date, Double price, int idLocation, int ticketSoldNumber) {
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) throws CustomerFormatException {
        if(name.length() > 2) {
            this.name = name;
        }else {
            throw new CustomerFormatException("name should be gt 2 char");
        }
    }

    public LocalDateTime getDateTime(Timestamp timestamp) {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) throws CustomerFormatException{
        if(this.dateTime.isAfter(LocalDateTime.now())) {
            this.dateTime = dateTime;
        }else {
            throw new CustomerFormatException("Datetime should be after then current datetime");
        }

    }

    public void setEventLocation(EventLocation eventLocation) {
        this.eventLocation = eventLocation;
    }

    public void setPrice(double price) throws CustomerFormatException {
        if(price >= 0) {
            this.price = price;
        }
        else {
            throw new CustomerFormatException("price should be positive");
        }
    }

    public boolean checkTicketSoldPossibility() {
        return ticketsSoldNumber < eventLocation.getCapacity();
    }

    public void cancelTicket() throws TicketSoldException {
        if(ticketsSoldNumber == 0) {
            throw new TicketSoldException("No Ticket available to cancel");
        }else{

        }
        ticketsSoldNumber--;
    }

    public void soldTicket() throws TicketSoldException {
        if(!checkTicketSoldPossibility()){
            ticketsSoldNumber++;
            throw new TicketSoldException(" one Ticket sold out" +(this.eventLocation.getCapacity() - this.ticketsSoldNumber) + "place disponibility");
        }
        ticketsSoldNumber++;
    }

    @Override
    public String toString() {
        return "Event" +
                "|id = " + id +
                "| eventName = '" + name + '\'' +
                "| dateTime = " + dateTime +
                "| eventLocation = " + eventLocation +
                "| price = " + price +
                "| ticketsSoldNumber = " + ticketsSoldNumber +
                '|';
    }
}
