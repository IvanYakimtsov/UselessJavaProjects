package com.yakimtsov.pop3client.client.command;

import com.yakimtsov.pop3client.client.ConnectionException;
import com.yakimtsov.pop3client.client.Pop3Client;

/**
 * Created by Ivan on 11.02.2018.
 */
public class QuitCommand implements Command {
    private final String QUIT_COMMAND = "QUIT";
    @Override
    public String execute(Pop3Client client) throws ConnectionException {
        return client.sendCommand(QUIT_COMMAND);
    }
}
