package com.yakimtsov.pop3client.client.command;

import com.yakimtsov.pop3client.Exception.ConnectionException;
import com.yakimtsov.pop3client.client.MessageHolder;
import com.yakimtsov.pop3client.client.Pop3Client;

import java.util.LinkedList;

/**
 * Created by Ivan on 11.02.2018.
 */
public class GetMassagesCommand implements Command {
    LinkedList<MessageHolder> messageHolderList;

    public LinkedList<MessageHolder> getMessageHolderList() {
        return messageHolderList;
    }

    @Override
    public String execute(Pop3Client client) throws ConnectionException {
        StatCommand stat = new StatCommand();
        client.executeCommand(stat);
        RetrCommand retr;
        int numOfMessages = stat.getNumberOfMessages();
        messageHolderList = new LinkedList<>();
        for (int i = 1; i <= numOfMessages; i++) {
            retr = new RetrCommand(i);
            client.executeCommand(retr);
            messageHolderList.add(retr.getMassage());
        }
        return "";
    }
}
