package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@Setter
@Getter
public class Customer {
    private int id;
    private String firstName;
    private String lastName;
    private String phone;
    private List<BankAccount> listeAccount;


    public Customer() {
    }

    public Customer(String firstName, String lastName, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.listeAccount = new ArrayList<>();
    }

    public Customer(int id, String firstName, String lastName, String phone) {
        this(firstName,lastName,phone); // apelle du contructeur ligne 13
        this.id = id;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<BankAccount> getListeAccount() {
        return listeAccount;
    }

    public void setListeAccount(List<BankAccount> listeAccount) {
        this.listeAccount = listeAccount;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", listeAccount=" + listeAccount +
                '}';
    }
}
