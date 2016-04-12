package com.vently.rest;

import com.vently.models.Event;
import com.vently.services.interfaces.*;

import javax.inject.Inject;
import javax.ws.rs.GET;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Date;



@Path("events")
public class EventsController {

    @Inject
    DatabaseClient mongo;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String ping() {

        Event evt=new Event("description", new Date());

        mongo.SaveItem(evt);
        return "";
    }
}
