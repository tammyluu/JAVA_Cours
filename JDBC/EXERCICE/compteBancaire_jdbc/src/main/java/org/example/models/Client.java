package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@Setter
@Getter
public class Client {
    private  int idClient;
    private String firstName;
    private String lastName;
    private List<BankAccount> accounts;
    private  String phoneNumber;
    public Client(String firstName, String lastName, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.accounts = new ArrayList<>();
    }

    public Client(int idClient, String firstName, String lastName, String phoneNumber) {
        this(firstName,lastName,phoneNumber); //appele du constructor aussus
        this.idClient = idClient;

    }


    public Client() {

    }

    @Override
    public String toString() {
        return "Client " +
                "| " + idClient +
                "| firstName = '" + firstName + '\'' +
                "| lastName = '" + lastName + '\'' +
                "| accounts = " + accounts +
                "| phoneNumber = '" + phoneNumber + '\'' +
                '|';
    }
}
