package com.yakimtsov.pop3client.client;

/**
 * Created by Ivan on 01.02.2018.
 */
public class ConnectionException extends Exception {

    public ConnectionException(String message) {
        super(message);
    }

    public ConnectionException() {
    }

    public ConnectionException(Throwable th) {
        super(th);
    }

    public ConnectionException(String m, Throwable th) {
        super(m, th);
    }

}
