package entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Branch_of_Bank")
public class BranchBank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String address;
    @OneToMany(mappedBy = "branch")
    private List<Account> accounts = new ArrayList<>();
    @OneToMany(mappedBy = "branchBank")
    private List<Customer> customers = new ArrayList<>();
    public void setId(Long id) {
        this.id = id;
    }

    public BranchBank() {
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }


    @Override
    public String toString() {
        return "BranchBank" +
                "|id = " + id +
                "| address = '" + address + '\'' +
                "| accounts = " + accounts +
                '|';
    }


}
