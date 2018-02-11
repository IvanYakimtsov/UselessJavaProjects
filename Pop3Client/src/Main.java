import com.yakimtsov.pop3client.Exception.ConnectionException;
import com.yakimtsov.pop3client.client.MessageHolder;
import com.yakimtsov.pop3client.client.Pop3Client;
import com.yakimtsov.pop3client.client.command.*;
import com.yakimtsov.pop3client.manager.ClientManager;

import java.util.LinkedList;

/**
 * Created by Ivan on 30.01.2018.
 */
class Main {
    public static void main(String[] args) throws ConnectionException {
//        Pop3Client client = new Pop3Client();
//        client.connect("pop.mail.ru", 995);
//      //  client.login("uslessmailtest@mail.ru", "qwerty12");
//        client.executeCommand(new LoginCommand("uslessmailtest@mail.ru", "qwerty12"));
//        System.out.println(client.executeCommand(new NoopCommand()));
//        //client.noop();
//        StatCommand stat = new StatCommand();
//        client.executeCommand(stat);
//        System.out.println("UIDL " + client.sendCommand("UIDL 2"));
//
//
//        System.out.println("Number of new emails: " + stat.getNumberOfMessages());
//        GetMassagesCommand massagesCommand = new GetMassagesCommand();
//        client.executeCommand(massagesCommand);
//        LinkedList<MessageHolder> messages = massagesCommand.getMessageHolderList();
//        for (int index = 0; index < messages.size(); index++) {
//            System.out.println("--- com.yakimtsov.pop3client.client.MessageHolder num. " + index + " ---");
//            System.out.println("From " +messages.get(index).getFrom());
//            System.out.println("Date " +messages.get(index).getDate());
//            System.out.println("Subject " +messages.get(index).getSubject());
//            System.out.println(messages.get(index).getBody());
//        }
//
//
//        TopCommand topCommand = new TopCommand(5,4);
//        System.out.println(client.executeCommand(topCommand));
//
//
//       // System.out.println("LIST " + client.sendCommand("LIST"));
//        System.out.println("UIDL " + client.sendCommand("UIDL 2"));
//        System.out.println(client.executeCommand(new ListCommand()));
//        System.out.println("UIDL " + client.sendCommand("UIDL 2"));
//
//        client.executeCommand(new QuitCommand());
//
//        client.disconnect();

        new ClientManager().startClient();
    }
}