package com.vently.rest;

import com.vently.models.Event;
import com.vently.services.MongoClient;
import com.vently.services.interfaces.Configuration;
import com.vently.services.interfaces.DatabaseClient;

import javax.inject.Inject;
import javax.ws.rs.GET;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Date;


@Path("events")
public class EventsController{

    @Inject
    DatabaseClient mongo;

    @Inject
    Configuration config;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String ping() {

        Event evt=new Event("description", new Date());
        Event test = new Event("desc2", new Date());

        mongo.SaveItem(evt);
        return "";
    }
}
