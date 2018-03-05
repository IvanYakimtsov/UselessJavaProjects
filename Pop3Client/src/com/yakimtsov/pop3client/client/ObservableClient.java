package com.yakimtsov.pop3client.client;

import com.yakimtsov.pop3client.client.ClientObserver;

/**
 * Created by Ivan on 03.02.2018.
 */
public interface ObservableClient {
    void addListener(ClientObserver clientObserver);
    void deleteListener(ClientObserver clientObserver);
    void notifyObservers(String message);
}
