package com.example.demo_api_rest;

import com.example.demo_api_rest.entity.Person;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jdk.jfr.DataAmount;
import lombok.Data;

import java.util.List;

@Path("/person")

public class PersonSource {
    // method for add data
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)

    public Person postPerson(Person person){
        //insertion data
        return person;
    }
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public  List<Person> getPerson(){
        return List.of(new Person(), new Person());
    }
    @DELETE
    @Path("{id}")
    public  Person delect(@PathParam()){
        return  null;
    }


}
