package org.example.models;

import lombok.Getter;
import org.example.exception.CustomerFormatException;

@Getter
public class EventLocation {
    private int id;
    private static int count = 0;
    private String name;
    private String address;
    private int capacity;

    public EventLocation(String name, String address, int capacity) throws CustomerFormatException {
        this();
        setName(name);
        setAddress(address);
        setCapacity(capacity);
    }

    private EventLocation() {
        id = ++count;
    }




    public EventLocation(int id, int idLocation, String locationName, String adrress, int capacity) {
    }

    public EventLocation(int id, int idEvent, String eventName, String date, double price, int idLocation) {
    }

    public EventLocation(int id, String iName, String iAddress, int iCapacity) {
    }


    public void setName(String name) throws CustomerFormatException {
        if(name.length() > 2) {
            this.name = name;
        }else {
            throw new CustomerFormatException("name should be gt 2 char");
        }
    }

    public void setAddress(String address) throws CustomerFormatException {
        if(address.length() > 2) {
            this.address = address;
        }
        else {
            throw new CustomerFormatException("address should be gt 2 char");
        }
    }

    public void setCapacity(int capacity) throws CustomerFormatException {
        if(capacity > 0) {
            this.capacity = capacity;
        }
        else {
            throw new CustomerFormatException("capacity should be positive");
        }
    }

    @Override
    public String toString() {
        return "EventLocation " +
                "|id =" + id +
                "| Location's name = '" + name + '\'' +
                "| address = '" + address + '\'' +
                "| capacity = " + capacity +
                '|';
    }

    public void setId(int id) {
        this.id = id;
    }
}
