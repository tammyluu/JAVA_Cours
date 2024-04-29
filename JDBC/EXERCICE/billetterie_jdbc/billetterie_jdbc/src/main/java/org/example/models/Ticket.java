package org.example.models;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Ticket {
    private int id;
    private Customer customer;
    private Event event;

    public Ticket() {
    }


    public Ticket(Customer customer, Event event) {
        this.customer = customer;
        this.event = event;
    }

    public Ticket(int idCustomer, int idEvent) {
        
    }

    public Ticket(int id, int idCustomer, int idEvent) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    @Override
    public String toString() {
        return "Ticket " +
                "|id = " + id +
                "| customer = " + customer +
                "| event = " + event +
                '|';
    }
}
