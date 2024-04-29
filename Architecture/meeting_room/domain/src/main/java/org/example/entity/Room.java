package org.example.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class Room {
    private int id;
    private String name;
    private LocalDate date;
    private LocalTime hours;
    private  int capacity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getHours() {
        return hours;
    }

    public void setHours(LocalTime hours) {
        this.hours = hours;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Room(Builder builder) {
        this.setId(builder.id);
        this.setName(builder.name);
        this.setCapacity(builder.capacity);

    }
    public static class Builder {
        private int id;
        private String name;

        private  int capacity;

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }


        public Builder capacity(int capacity) {
            this.capacity = capacity;
            return this;
        }

        public Room build() {
            return new Room(this);
        }
    }

}
