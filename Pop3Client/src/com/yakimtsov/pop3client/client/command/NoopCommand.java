package com.yakimtsov.pop3client.client.command;

import com.yakimtsov.pop3client.Exception.ConnectionException;
import com.yakimtsov.pop3client.client.Pop3Client;

/**
 * Created by Ivan on 11.02.2018.
 */
public class NoopCommand implements Command {
    private final String NOOP_COMMAND = "NOOP";
    @Override
    public String execute(Pop3Client client) throws ConnectionException {
        return client.sendCommand(NOOP_COMMAND);
    }
}
