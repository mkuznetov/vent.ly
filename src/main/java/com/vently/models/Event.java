package com.vently.models;

import java.util.Date;

public class Event extends EntityBase {
    private Date date;
    private String description;

    public Date getDate(){
        return date;
    }
    public void setDate(Date d){
        date=d;
    }

    public String getDescription(){
        return description;
    }
    public void setDescription(String s){
        description=s;
    }

    public Event(String Description, Date EventDate){
        date=EventDate;
        description=Description;
    }

}
