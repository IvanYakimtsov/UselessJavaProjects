package com.yakimtsov.pop3client.client.command;

import com.yakimtsov.pop3client.client.ConnectionException;
import com.yakimtsov.pop3client.client.Pop3Client;

/**
 * Created by Ivan on 11.02.2018.
 */
public class ListCommand implements Command {
    private final String LIST_COMMAND = "LIST ";
    @Override
    public String execute(Pop3Client client) throws ConnectionException {
        String response = client.sendCommand(LIST_COMMAND);
        StringBuilder result = new StringBuilder();
        result.append(response +" ");
        while (!(response = client.readResponseLine()).equals(".")){
            result.append(response);
        }
        return result.toString();
    }
}
