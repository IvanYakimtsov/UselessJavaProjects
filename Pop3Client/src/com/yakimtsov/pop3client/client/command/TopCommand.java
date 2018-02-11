package com.yakimtsov.pop3client.client.command;

import com.yakimtsov.pop3client.Exception.ConnectionException;
import com.yakimtsov.pop3client.client.Pop3Client;

/**
 * Created by Ivan on 11.02.2018.
 */
public class TopCommand implements Command{
    int messageNumber;
    int lines;

    public TopCommand(int messageNumber, int lines) {
        this.messageNumber = messageNumber;
        this.lines = lines;
    }

    @Override
    public String execute(Pop3Client client) throws ConnectionException {
        client.sendCommand("TOP " + messageNumber +" " + lines);
        String response;
        StringBuilder result = new StringBuilder();
        while ((response = client.readResponseLine()).length() != 0){
            result.append(response + "\n");
        }

        while (!(response = client.readResponseLine()).equals(".")) {
            result.append(response + "\n");
        }
        return result.toString();
    }
}
