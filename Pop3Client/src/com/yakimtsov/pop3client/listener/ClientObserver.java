package com.yakimtsov.pop3client.listener;

/**
 * Created by Ivan on 02.02.2018.
 */
public interface ClientObserver {
    void notifyObserver(String response);
}
