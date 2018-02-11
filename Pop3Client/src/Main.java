import com.yakimtsov.pop3client.Exception.ConnectionException;
import com.yakimtsov.pop3client.client.MessageHolder;
import com.yakimtsov.pop3client.client.Pop3Client;
import com.yakimtsov.pop3client.manager.ClientManager;

import java.util.LinkedList;

/**
 * Created by Ivan on 30.01.2018.
 */
class Main {
    public static void main(String[] args) throws ConnectionException {
        Pop3Client client = new Pop3Client();
        client.connect("pop.mail.ru", 995);
        client.login("uslessmailtest@mail.ru", "qwerty12");
        client.noop();

//        System.out.println("Number of new emails: " + client.getNumberOfNewMessages());
//        LinkedList<MessageHolder> messages = client.getMessages();
//        for (int index = 0; index < messages.size(); index++) {
//            System.out.println("--- com.yakimtsov.pop3client.client.MessageHolder num. " + index + " ---");
//            System.out.println("From " +messages.get(index).getFrom());
//            System.out.println("Date " +messages.get(index).getDate());
//            System.out.println("Subject " +messages.get(index).getSubject());
//            System.out.println(messages.get(index).getBody());
//        }
        client.logout();

        client.disconnect();

 //       new ClientManager().startClient();
    }
}