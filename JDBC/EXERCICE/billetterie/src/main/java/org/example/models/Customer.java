package org.example.models;

import lombok.Getter;
import org.example.exception.CustomerFormatException;

import java.util.List;
import java.util.regex.Pattern;

@Getter
public class Customer {

        private int id;
        private static int count = 0;
        private String firstname;

        private String lastname;

        private String email;

        private List<Event> eventsTicket;

        public Customer() {
            id = ++count;
        }


    public Customer(int id, String firstName, String lastName, String email) {
    }

    public Customer(String firstName, String lastName, String email) {
            this.firstname= firstName;
            this.lastname= lastName;
            this.email= email;
    }

    public void setFirstname(String firstname) {
            this.firstname = firstname;
        }

    public void setLastname(String lastname) {
            this.lastname = lastname;
        }

    public void setEmail(String email) throws CustomerFormatException {
            String pattern = "^([a-zA-Z0-9_.-]+)@([a-z0-9-]+\\.?[a-z0-9-]+)\\.([a-z]{2,6})$";
            if(!Pattern.matches(pattern, email)) {
                throw new CustomerFormatException("Not correct email");
            }
            this.email = email;
        }

    public void setEventsTicket(List<Event> eventsTicket) {
            this.eventsTicket = eventsTicket;
        }

    @Override
    public String toString() {
        return "Customer " +
                "id = " + id +
                "| " + firstname + '\'' +
                "| " + lastname + '\'' +
                "| " + email + '\'' +
                "| eventsTicket=" + eventsTicket +
                '|';
    }

    public void setId(int id) {
        this.id = id;
    }
}
