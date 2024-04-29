package entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (nullable = false)
    private String label;
    @Column(length = 27, nullable = false)
    private Long codeIban;
    @Column(precision = 10, scale = 2)
    private double balance;
    @ManyToOne
    @JoinColumn(name = "branch_id")
    private BranchBank branch ;
    @ManyToMany (mappedBy = "accounts")
    private List<Customer> customers = new ArrayList<>();


    public Account() {
    }

    public Account(String label, String iban, BranchBank bank) {
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Long getCodeIban() {
        return codeIban;
    }

    public void setCodeIban(Long codeIban) {
        this.codeIban = codeIban;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public BranchBank getBranch() {
        return branch;
    }

    public void setBranch(BranchBank branch) {
        this.branch = branch;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Account " +
                "|id = " + id +
                "| label = '" + label + '\'' +
                "| codeIban = " + codeIban +
                "| balance = " + balance +
                "| branch = " + branch +
                "| customers = " + customers +
                '|';
    }
}
