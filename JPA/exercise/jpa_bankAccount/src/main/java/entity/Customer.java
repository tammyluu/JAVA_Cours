package entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String lastName;
    private String firstName;
    private Date dateOfBirth;
    @ManyToMany
    @JoinTable(name = "customer_account",
            joinColumns = @JoinColumn(name = "account_id"),
            inverseJoinColumns = @JoinColumn(name = "customer_id"))
    private List<Account> accounts = new ArrayList<>();

   /* public BranchBank getBranchBank() {
        return branchBank;
    }*/

   /* public void setBranchBank(BranchBank branchBank) {
        this.branchBank = branchBank;
    }*/

    public Customer() {
    }

    public Customer(String lastName, String firstName, Date date) {
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }


    @Override
    public String toString() {
        return "Customer " +
                " | id=" + id +
                "| lastName = '" + lastName + '\'' +
                "| firstName = '" + firstName + '\'' +
                "| dateOfBirth = '" + dateOfBirth + '\'' +
                '|';
    }



}
