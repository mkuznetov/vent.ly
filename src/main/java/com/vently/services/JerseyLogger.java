package com.vently.services;

import com.vently.configuration.AppMain;
import com.vently.services.interfaces.Logger;
import javax.inject.Singleton;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.LogManager;

@Singleton
public class JerseyLogger implements Logger {

    private java.util.logging.Logger lgr;

    public JerseyLogger(){
        try {
            final InputStream inputStream = AppMain.class.getResourceAsStream("/logging.properties");
            LogManager.getLogManager().readConfiguration(inputStream);

            lgr = java.util.logging.Logger.getLogger("");
        }catch(Exception ex){
            java.util.logging.Logger.getAnonymousLogger().severe("Failed to log");
            java.util.logging.Logger.getAnonymousLogger().severe(ex.getMessage());
        }
    }

    @Override
    public void Info(String message) {
        try{
            lgr.log(Level.INFO, message);
        }catch (Exception ex){
            java.util.logging.Logger.getAnonymousLogger().severe("Failed to log");
            java.util.logging.Logger.getAnonymousLogger().severe(ex.getMessage());
        }
    }

    @Override
    public void Warning(String message) {
        try{
            lgr.log(Level.WARNING, message);
        }catch (Exception ex){
            java.util.logging.Logger.getAnonymousLogger().severe("Failed to log");
            java.util.logging.Logger.getAnonymousLogger().severe(ex.getMessage());
        }
    }

    @Override
    public void Error(Throwable error){
        try{
            lgr.log(Level.SEVERE, error.getMessage(), error);
        }catch (Exception ex){
            java.util.logging.Logger.getAnonymousLogger().severe("Failed to log");
            java.util.logging.Logger.getAnonymousLogger().severe(ex.getMessage());
        }
    }

    @Override
    public void Error(String message, Throwable error){
        try{
            lgr.log(Level.SEVERE, message, error);
        }catch (Exception ex){
            java.util.logging.Logger.getAnonymousLogger().severe("Failed to log");
            java.util.logging.Logger.getAnonymousLogger().severe(ex.getMessage());
        }
    }

    @Override
    public void Error(String message) {
        try{
            lgr.log(Level.SEVERE, message);
        }catch (Exception ex){
            java.util.logging.Logger.getAnonymousLogger().severe("Failed to log");
            java.util.logging.Logger.getAnonymousLogger().severe(ex.getMessage());
        }
    }
}
