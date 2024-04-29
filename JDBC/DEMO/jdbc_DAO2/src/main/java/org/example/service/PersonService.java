package org.example.service;

import org.example.dao.PersonDAO;
import org.example.models.Person;
import org.example.utils.DataBaseManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class PersonService {
    private PersonDAO personDAO;
    private Connection connection;


    //gestion global pour Person, inject tous la même connection

    public PersonService() {
            connection = DataBaseManager.getConnection();
            personDAO = new PersonDAO(connection);

    }


    public  boolean createPerson(String firstName, String lastName){
        Person person = new Person();
        person.setFirstName(firstName);
        person.setLastName(lastName);
        try {
             return personDAO.save(person);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    public boolean updatePerson(Person person){
        try {
            return personDAO.update(person);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    public  Person getPerson(int id){
        try {
            return personDAO.get(id);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    public boolean deletePerson(int id){
        Person person = null;
        try {
           person =  personDAO.get(id);
           if ( person != null){
               return  personDAO.delete(person);
           }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return  false;
    }
    public List<Person> getALLperson(){
        try {
            return personDAO.get();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    public  void close(){
        DataBaseManager.closeConnection();
    }
}

