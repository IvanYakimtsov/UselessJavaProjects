package com.yakimtsov.pop3client.client;

import com.yakimtsov.pop3client.Exception.ConnectionException;
import com.yakimtsov.pop3client.client.command.Command;
import com.yakimtsov.pop3client.observer.ClientObserver;
import com.yakimtsov.pop3client.observer.ObservableClient;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Ivan on 30.01.2018.
 */
public class Pop3Client implements ObservableClient {
    private SSLSocket sslClientSocket;

    private BufferedReader in;
    private BufferedWriter out;
    private static final int PORT = 995;


    private Set<ClientObserver> clientObservers = new HashSet<>();


    public String connect(String host, int port) throws ConnectionException {
        SSLSocketFactory ssf = (SSLSocketFactory) SSLSocketFactory
                .getDefault();
        sslClientSocket = null;
        try {
            sslClientSocket = (SSLSocket) ssf.createSocket(host, port);
            sslClientSocket.startHandshake();
            in = new BufferedReader(new InputStreamReader(sslClientSocket.getInputStream(), "UTF-8"));
            // out = new BufferedWriter(new OutputStreamWriter(sslClientSocket.getOutputStream(), "UTF-8"));
            out = new BufferedWriter(new OutputStreamWriter(sslClientSocket.getOutputStream(), "UTF-8"));
            //  System.out.println("Connected to the host");
            notifyObservers("Connected to the host");
            return readResponseLine();
        } catch (IOException e) {
            throw new ConnectionException("connection error: ", e);
        }

    }

    public String connect(String host) throws ConnectionException {
        return connect(host, PORT);
    }

    public boolean isConnected() {
        return sslClientSocket != null && sslClientSocket.isConnected();
    }

    public void disconnect() throws ConnectionException {
        if (!isConnected())
            throw new ConnectionException("Not connected to a host");
        try {
            sslClientSocket.close();
        } catch (IOException e) {
            throw new ConnectionException("Error while closing socket: ", e);
        }
        in = null;
        out = null;
        //  System.out.println("Disconnected from the host");
        notifyObservers("Disconnected from the host");
    }

    public String readResponseLine() throws ConnectionException {
        String response = null;
        try {
            response = in.readLine();
        } catch (IOException e) {
            throw new ConnectionException("Read response error", e);
        }

        if (response.startsWith("-ERR")) {
            throw new ConnectionException("Server has returned an error: " + response.replaceFirst("-ERR ", ""));
        }

        notifyObservers("[FROM SERVER: ] " + response);
        return response;
    }

    public String sendCommand(String command) throws ConnectionException {

        try {
            notifyObservers("[TO SERVER: ] " + command);
            out.write(command + "\n");
            out.flush();
            return readResponseLine();
        } catch (IOException e) {
            throw new ConnectionException("Error while sending command: ", e);
        }

    }

    public String executeCommand(Command command) throws ConnectionException {
        return command.execute(this);
    }

//    public void login(String username, String password) throws ConnectionException {
//        sendCommand("USER " + username);
//        sendCommand("PASS " + password);
//    }

//    public void noop() throws ConnectionException {
//        sendCommand("NOOP");
//    }

//    public void logout() throws ConnectionException {
//        sendCommand("QUIT");
//    }

//    public void delete(int index) throws ConnectionException {
//        sendCommand("DELE " + index);
//    }

//    public int getNumberOfNewMessages() throws ConnectionException {
//        String response = sendCommand("STAT");
//      //  System.out.println(response);
//        String[] values = response.split(" ");
//        return Integer.parseInt(values[1]);
//    }

//    public MessageHolder getMessage(int messageNumber) throws ConnectionException {
//        //  System.out.println(messageNumber);
//        String response = sendCommand("RETR " + messageNumber);
//        MessageHolder massage = new MessageHolder();
//        massage.setNumber(messageNumber);
//        while ((response = readResponseLine()).length() != 0) {
//            // System.out.println(response);
//            int colonPosition = response.indexOf(":");
//            if (colonPosition != -1) {
//                String headerName = response.substring(0, colonPosition);
//                String value = response.substring(colonPosition + EXTRA_SPACE, response.length());
//                massage.setHeader(headerName, value);
//            }
//        }
//        String responseBody = "";
//        while (!(response = readResponseLine()).equals(".")) {
//            responseBody += response + "\n";
//        }
//
//        Pattern pattern = Pattern.compile(MESSAGE_REGEX);
//        Matcher matcher = pattern.matcher(responseBody);
//        String messageBody = "";
//        if (matcher.find()) {
//            messageBody = matcher.group().substring(EXTRA_SPACE);
//            messageBody = messageBody.substring(0, messageBody.length());
//        }
//
//        massage.setBody(messageBody);
//
//        return massage;
//    }

//
//    public LinkedList<MessageHolder> getMessages() throws ConnectionException {
//        int numOfMessages = getNumberOfNewMessages();
//        LinkedList<MessageHolder> messageHolderList = new LinkedList<>();
//        for (int i = 1; i <= numOfMessages; i++) {
//            messageHolderList.add(getMessage(i));
//        }
//        return messageHolderList;
//    }


    @Override
    public void addListener(ClientObserver clientObserver) {
        clientObservers.add(clientObserver);
    }

    @Override
    public void deleteListener(ClientObserver clientObserver) {
        clientObservers.remove(clientObserver);
    }

    @Override
    public void notifyObservers(String message) {
        for (ClientObserver clientObserver : clientObservers) {
            clientObserver.notifyObserver(message);
        }
    }
}