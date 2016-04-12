package com.vently.models;

import com.vently.models.interfaces.Entity;
import org.bson.types.ObjectId;

import java.beans.Transient;

abstract class EntityBase implements Entity {

    private ObjectId id;

    @Override
    public ObjectId getId() {
        return id;
    }

    @Override
    @Transient
    public String getCollectionName() {
        return String.format("%ss", this.getClass().getSimpleName().toLowerCase());
    }

    public EntityBase(){
        id=ObjectId.get();
    }
}
