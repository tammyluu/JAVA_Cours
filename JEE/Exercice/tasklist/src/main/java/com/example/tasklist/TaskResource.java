package com.example.tasklist;

import com.example.tasklist.entity.Task;
import com.example.tasklist.service.ITaskService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("tasks")

public class TaskResource {
    private final ITaskService taskService;

    @Inject
    public TaskResource(ITaskService taskService) {
        this.taskService = taskService;
    }

    //Méthode pour ajouter des données
    @POST
    //@Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    public Task postTask(@FormParam("content") String content, @FormParam("isDone") boolean isDone) {
        //Insertion dans une base de données
        return taskService.save(content,isDone);
    }

    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    public Task postTask (Task task) {
        //Insertion dans une base de données
        return task;
    }

    @DELETE
    @Path("{id}")
    public int delete(@PathParam("id") int id) {
        return id;
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Task> getAllTasks() {
        return List.of(new Task(), new Task()) ;
    }
}