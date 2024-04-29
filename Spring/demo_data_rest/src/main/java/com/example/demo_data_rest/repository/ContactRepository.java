package com.example.demo_data_rest.repository;

import com.example.demo_data_rest.entity.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//@RepositoryRestResource(path = "contact", collectionResourceRel = "contacts")
public interface ContactRepository extends CrudRepository<Contact, Long> {


}
