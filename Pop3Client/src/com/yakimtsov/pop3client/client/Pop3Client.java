package com.yakimtsov.pop3client.client;

import com.yakimtsov.pop3client.client.command.Command;

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
            in = new BufferedReader(new InputStreamReader(sslClientSocket.getInputStream(), "ASCII"));
            out = new BufferedWriter(new OutputStreamWriter(sslClientSocket.getOutputStream(), "ASCII"));
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