package com.yakimtsov.pop3client.client.command;

import com.yakimtsov.pop3client.client.ConnectionException;
import com.yakimtsov.pop3client.client.Pop3Client;

/**
 * Created by Ivan on 11.02.2018.
 */
public class UIDLCommand implements Command {
    int messageNumber;
    private final String UIDL_COMMAND = "UIDL ";

    public UIDLCommand(int messageNumber) {
        this.messageNumber = messageNumber;
    }

    @Override
    public String execute(Pop3Client client) throws ConnectionException {
        return client.sendCommand(UIDL_COMMAND + messageNumber);
    }
}
