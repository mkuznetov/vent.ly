package com.vently.configuration;

import org.glassfish.jersey.server.ResourceConfig;

public class AppMain extends ResourceConfig {
    public AppMain() {
        register(new VentlyBinder());
        packages(true, "com.vently.rest");
    }
}
