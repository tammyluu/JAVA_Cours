package com.example.demo_hexagonal;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

@Path("/hello-world")
public class HelloResource {

    private TodoService todoService;

    public HelloResource() {
        todoService = new TodoService(new TodoRepositoryImpl())
    }
    @GET
    @Produces("text/plain")
    public String hello() {
        return "Hello, World!";
    }
}