package com.yakimtsov.pop3client.client.command;

import com.yakimtsov.pop3client.client.ConnectionException;
import com.yakimtsov.pop3client.client.Pop3Client;

/**
 * Created by Ivan on 11.02.2018.
 */
public class DeleCommand implements Command{
    private int messageIndex;
    private final String DELE_COMMAND = "DELE ";

    public DeleCommand(int messageIndex) {
        this.messageIndex = messageIndex;
    }

    @Override
    public String execute(Pop3Client client) throws ConnectionException {
        return client.sendCommand(DELE_COMMAND + messageIndex);
    }
}
