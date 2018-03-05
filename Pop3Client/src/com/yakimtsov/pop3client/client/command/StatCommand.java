package com.yakimtsov.pop3client.client.command;

import com.yakimtsov.pop3client.client.ConnectionException;
import com.yakimtsov.pop3client.client.Pop3Client;

/**
 * Created by Ivan on 11.02.2018.
 */
public class StatCommand implements Command {

    private int numberOfMessages = 0;

    @Override
    public String execute(Pop3Client client) throws ConnectionException {
        String response = client.sendCommand("STAT");
        String[] values = response.split(" ");
        numberOfMessages = Integer.parseInt(values[1]);
        return response;
    }


    public int getNumberOfMessages() {
        return numberOfMessages;
    }
}
