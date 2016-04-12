package com.vently.models.interfaces;

import org.bson.types.ObjectId;

public interface Entity{
    ObjectId getId();
    String getCollectionName();
}
