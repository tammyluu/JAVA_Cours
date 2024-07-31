package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@Getter
@Setter
public class BankAccount {
    private int id;

    private Customer customer;

    private List<Operation> operations;

    private double totalAmount;

    private int customerId;

    public BankAccount(Customer customer, double totalAmount) {
        this.customer = customer;
        this.totalAmount = totalAmount;
        this.operations = new ArrayList<>();
    }

    public BankAccount(int id,int customerId, double totalAmount) {
        this.id = id;
        this.customerId = customerId;
        this.totalAmount = totalAmount;
        this.operations = new ArrayList<>();
    }

    public BankAccount(int id, Customer customer, double totalAmount) {
        this(customer,totalAmount);
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
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

    public List<Operation> getOperations() {
        return operations;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public boolean makeDeposit(Operation operation) {
        if (operation.getAmount() > 0){
            operations.add(operation);
            totalAmount += operation.getAmount();
            return true;
        }
        return false;
    }

    public boolean makeWithDrawl(Operation operation) {
        if (operation.getAmount() < 0 && getTotalAmount() >= operation.getAmount()*-1){
            operations.add(operation);
            totalAmount += operation.getAmount();
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "id=" + id +
                ", customer=" + customer +
                ", totalAmount=" + totalAmount +
                '}';
    }
}
