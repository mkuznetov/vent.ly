package com.vently.services.interfaces;

public interface Logger {
    void Info(String message);
    void Warning(String message);
    void Error(String message);
    void Error(Throwable error);
    void Error(String message, Throwable error);
}
