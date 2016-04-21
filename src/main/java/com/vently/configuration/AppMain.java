package com.vently.configuration;

import org.glassfish.jersey.server.ResourceConfig;

//import java.io.IOException;
//import java.io.InputStream;
//import java.util.logging.LogManager;
//import java.util.logging.Logger;

public class AppMain extends ResourceConfig {
    public AppMain() {
        try {
            register(new VentlyBinder());
            packages(true, "com.vently.rest");

//            final InputStream inputStream = AppMain.class.getResourceAsStream("/logging.properties");
//
//            LogManager.getLogManager().readConfiguration(inputStream);
        }
        catch (Exception e)
        {
//            Logger.getAnonymousLogger().severe("Could not load default logging.properties file");
//            Logger.getAnonymousLogger().severe(e.getMessage());
            e.printStackTrace();
        }
//        catch (final Exception e) {
//            e.printStackTrace();
//        }
    }
}
