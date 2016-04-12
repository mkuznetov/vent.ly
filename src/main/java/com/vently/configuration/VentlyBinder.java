package com.vently.configuration;

import com.vently.services.MongoClient;
import com.vently.services.interfaces.DatabaseClient;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class VentlyBinder extends AbstractBinder {

    @Override
    protected void configure() {
        Properties props = new Properties();
        InputStream configFileStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties");
        try {
            props.load(configFileStream);
            bind(props).to(Properties.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        MongoClient client = new MongoClient(props.getProperty("mongoip"), Integer.parseInt(props.getProperty("mongoport")));
        bind(client).to(DatabaseClient.class);
    }

}
