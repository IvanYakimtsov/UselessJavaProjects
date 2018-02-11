package com.yakimtsov.pop3client.client.command;

import com.yakimtsov.pop3client.Exception.ConnectionException;
import com.yakimtsov.pop3client.client.Pop3Client;

/**
 * Created by Ivan on 11.02.2018.
 */
public class LoginCommand implements Command{
    private String username;
    private String password;
    private final String USER_COMMAND = "USER ";
    private final String PASS_COMMAND = "PASS ";

    public LoginCommand(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String execute(Pop3Client client) throws ConnectionException {
        client.sendCommand(USER_COMMAND + username);
        return client.sendCommand(PASS_COMMAND + password);
    }
}
