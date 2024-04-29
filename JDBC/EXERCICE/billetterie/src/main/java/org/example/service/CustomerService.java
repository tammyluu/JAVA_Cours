package org.example.service;

import org.example.dao.CustomerDAO;
import org.example.models.Customer;
import org.example.utils.DatabaseManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CustomerService implements ITicketService<Customer> {
    private  CustomerDAO customerDAO;

    private Connection connection;
    public CustomerService(){
        try{
            connection = new DatabaseManager().getConnection();

            customerDAO = new CustomerDAO(connection);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public Customer createAndSave(String firstName, String lastName, String email) {
        Customer customer = new Customer(firstName,lastName,email);
        try {
            if (customerDAO.save(customer)) {
                System.out.println("Un client a bien été créé avec id : " + customer.getId() );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return customer;
    }

     @Override
    public boolean modifyById(Customer customer) {
        try {
            customerDAO.update(customer);
            return true ;

        } catch (
                SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean deleteById(int id) {
        try{
            Customer customer = customerDAO.get(id);
            if(customer != null) {
                customerDAO.delete(customer);
            }
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        } return true;
    }

    @Override
    public Customer getById(int id) {
        try {
            return customerDAO.get(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Customer> getAll(int id) {
        return null;
    }
}
