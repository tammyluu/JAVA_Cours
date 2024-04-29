package com.example.demo.service;

import com.example.demo.entity.Person;
import jakarta.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class PersonServiceImpl implements PersonService {

    public Person save(String firstname, String lastname) {
        return new Person(firstname, lastname);
    }
}
