package com.example.demo_api_rest;

import com.example.demo_api_rest.entity.Person;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/person")

public class PersonResource {

    //Méthode pour ajouter des données
    @POST
    //@Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    public Person postPerson(@FormParam("firstname") String firstname, @FormParam("lastname") String lastname) {
        //Insertion dans une base de données

        return new Person(firstname, lastname);
    }

    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    public Person postPerson(Person person) {
        //Insertion dans une base de données

        return person;
    }

    @DELETE
    @Path("{id}")
    public int delete(@PathParam("id") int id) {
        return id;
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> getPersons() {
        return List.of(new Person(), new Person()) ;
    }
}
