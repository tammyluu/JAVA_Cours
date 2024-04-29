package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@AllArgsConstructor
@Getter
@Setter
public class BankAccount {
    private String idAccount;
    private double balance;
    @Getter
    private  Client client;
    private List<Operation> operations;

    public BankAccount(double balance, Client client) {
        this.balance = balance;
        this.client = client;
    }

    public BankAccount(String idAccount, double balance, int idClient) {
        this.idAccount = idAccount;
        this.balance = balance;

    }

    public BankAccount() {

    }

    public void setClient(Client client) {
        this.client = client;
    }
    public boolean makeDeposit(Operation operation){
        if (operation.getAmount()>0){
            operations.add(operation);
            balance += operation.getAmount();
            return  true;
        }
        return false;
    }
    public boolean makeWithdrawal(Operation operation){
        if (operation.getAmount()< 0 && getBalance() >= operation.getAmount() * -1){
            operations.add(operation);
            balance -= operation.getAmount();
            return true;
        }
        return false;
    }
    @Override
    public String toString() {
        return "CompteBancaire|" +
                "idCompte = " + idAccount +
                "| soldCompte = " + balance +
                "| client = " + client +
                "| operations = " + operations +
                '|';
    }
}
