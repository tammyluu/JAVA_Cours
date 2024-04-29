package org.example.models;

import lombok.AllArgsConstructor;


public class Ticket {
    private int id;
    private int idCustomer;
    private int idEvent;
    private int purchasedTicketCount;

    public Ticket() {
    }

    public Ticket(int idCustomer, int idEvent, int purchasedTicketCount) {
        this.idCustomer = idCustomer;
        this.idEvent = idEvent;
        this.purchasedTicketCount = purchasedTicketCount;
    }

    public Ticket(int id, int idCustomer, int idEvent, int purchasedTicketCount) {
        this.id = id;
        this.idCustomer = idCustomer;
        this.idEvent = idEvent;
        this.purchasedTicketCount = purchasedTicketCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public int getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }

    public int getPurchasedTicketCount() {
        return purchasedTicketCount;
    }

    public void setPurchasedTicketCount(int purchasedTicketCount) {
        this.purchasedTicketCount = purchasedTicketCount;
    }

    @Override
    public String toString() {
        return "Ticket" +
                " |id = " + id +
                "| idCustomer = " + idCustomer +
                "| idEvent = " + idEvent +
                "| purchasedTicketCount = " + purchasedTicketCount +
                '|';
    }
}
