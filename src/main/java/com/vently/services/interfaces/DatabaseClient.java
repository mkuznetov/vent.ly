package com.vently.services.interfaces;

import com.vently.models.interfaces.Entity;

import java.util.HashMap;

public interface DatabaseClient {
    void SaveItem(Entity item);
    Entity GetItem(String key, String value, String collectionName);
    Entity GetItem(HashMap<String, Object> query, String collectionName);
}
