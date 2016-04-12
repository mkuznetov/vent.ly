package com.vently.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.vently.models.interfaces.Entity;
import com.vently.services.interfaces.DatabaseClient;
import org.bson.Document;

import java.util.HashMap;


public class MongoClient implements DatabaseClient {

    private MongoDatabase db=null;
    private ObjectMapper mapper=null;

    public MongoClient(String host, int port){
        try {
            com.mongodb.MongoClient mongo = new com.mongodb.MongoClient(host, port);
            db = mongo.getDatabase("vently");

            mapper = new ObjectMapper();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void SaveItem(Entity item){
        try {
            if(db!=null && mapper.canSerialize(item.getClass())){
                Document doc = Document.parse(mapper.writeValueAsString(item));
                MongoCollection<Document> coll =  db.getCollection(item.getCollectionName());

                if(coll!=null){
                    coll.insertOne(doc);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Entity GetItem(String key, String value, String collectionName){
        HashMap<String, Object> map=new HashMap<>();

        map.put(key, value);

        return GetItem(map, collectionName);
    }

    public Entity GetItem(HashMap<String, Object> query, String collectionName){
        try{
            if(db!=null){
                MongoCollection<Entity> coll = db.getCollection(collectionName, Entity.class);

                if(coll!=null && coll.count()>0){
                    coll.find(new Document(query));
                }
            }
        }catch(Exception ex){

        }

        return null;
    }
}