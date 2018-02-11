package com.yakimtsov.pop3client.client;

import java.util.*;

/**
 * Created by Ivan on 30.01.2018.
 */
public class MessageHolder {
    private String date;
    private String from;
    private String subject;
    private int number;

    private String body;


    public void setHeader(String header, String value) {
        switch (header) {
            case "From":
                from = value;
                break;
            case "Date":
                date = value;
                break;
            case "Subject":
                subject = value;
                break;
        }
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getDate() {
        return date;
    }

    public String getFrom() {
        return from;
    }

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }
}
