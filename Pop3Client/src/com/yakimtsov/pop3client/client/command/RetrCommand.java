package com.yakimtsov.pop3client.client.command;

import com.yakimtsov.pop3client.Exception.ConnectionException;
import com.yakimtsov.pop3client.client.MessageHolder;
import com.yakimtsov.pop3client.client.Pop3Client;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Ivan on 11.02.2018.
 */
public class RetrCommand implements Command {
    private int messageNumber;
    private MessageHolder massage;
    private final int EXTRA_SPACE = 2;
    private final String MESSAGE_REGEX = "\\n(\\s*\\w*\\.*\\s*)+\\n";

    private final String RETR_COMMAND = "RETR ";


    public RetrCommand(int messageNumber) {
        this.messageNumber = messageNumber;
    }

    public MessageHolder getMassage() {
        return massage;
    }


    @Override
    public String execute(Pop3Client client) throws ConnectionException {
        String response = client.sendCommand(RETR_COMMAND + messageNumber);

        massage = new MessageHolder();
        massage.setNumber(messageNumber);
        while ((response = client.readResponseLine()).length() != 0) {
            // System.out.println(response);
            int colonPosition = response.indexOf(":");
            if (colonPosition != -1) {
                String headerName = response.substring(0, colonPosition);
                String value = response.substring(colonPosition + EXTRA_SPACE, response.length());
                massage.setHeader(headerName, value);
            }
        }
        String responseBody = "";
        while (!(response = client.readResponseLine()).equals(".")) {
            responseBody += response + "\n";
        }

        Pattern pattern = Pattern.compile(MESSAGE_REGEX);
        Matcher matcher = pattern.matcher(responseBody);
        String messageBody = "";
        if (matcher.find()) {
            messageBody = matcher.group().substring(EXTRA_SPACE);
            messageBody = messageBody.substring(0, messageBody.length());
        }

        massage.setBody(messageBody);
        return response;
    }


}
