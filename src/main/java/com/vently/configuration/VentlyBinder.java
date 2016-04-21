package com.vently.configuration;

import com.vently.services.JerseyLogger;
import com.vently.services.MongoClient;
import com.vently.services.PropertiesConfiguration;
import com.vently.services.interfaces.DatabaseClient;
import com.vently.services.interfaces.Configuration;
import com.vently.services.interfaces.Logger;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

import javax.inject.Singleton;

public class VentlyBinder extends AbstractBinder {
    @Override
    protected void configure() {
        bind(new PropertiesConfiguration()).to(Configuration.class);
        bind(JerseyLogger.class).to(Logger.class).in(Singleton.class);
        bind(MongoClient.class).to(DatabaseClient.class).in(Singleton.class);
    }
}
