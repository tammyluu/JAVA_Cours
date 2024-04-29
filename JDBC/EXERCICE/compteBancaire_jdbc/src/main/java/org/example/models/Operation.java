package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Operation extends BankAccount {
    private String operationNum;
    private double amount;
    private Status status;
    private int accountId;

    public Operation(String operationNum, double amount, String idAccount) {
    }


    @Override
    public String toString() {
        return "Operation | " +
                "operationNum = '" + operationNum + '\'' +
                "| amount = " + amount +
                "| status = " + status +
                '|';
    }
}
