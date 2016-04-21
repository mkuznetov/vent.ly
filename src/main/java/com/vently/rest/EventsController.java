package com.vently.rest;

import com.vently.models.Event;
import com.vently.services.interfaces.DatabaseClient;
import com.vently.services.interfaces.Logger;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("events")
public class EventsController{

    @Inject
    DatabaseClient mongo;

    @Inject
    Logger logger;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Event Get(@PathParam("id") String id){
        try{

        }
        catch (Exception e){
            logger.Error(e);
        }

        return null;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String Event(Event ev) {
        try {

        }
        catch (Exception e){
            logger.Error(e);
            return "ERROR";
        }

        return "OK";
    }
}
