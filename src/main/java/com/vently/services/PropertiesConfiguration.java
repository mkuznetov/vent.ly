package com.vently.services;

import com.vently.services.interfaces.Configuration;


import javax.inject.Singleton;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Singleton
public class PropertiesConfiguration implements Configuration {

    private Properties configuration=new Properties();

    public PropertiesConfiguration(){
        InputStream configFileStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties");
        try {
            configuration.load(configFileStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getValue(String name) {
        return configuration.getProperty(name);
    }
}
