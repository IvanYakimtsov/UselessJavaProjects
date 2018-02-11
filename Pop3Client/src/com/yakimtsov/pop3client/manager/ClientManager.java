package com.yakimtsov.pop3client.manager;

import com.yakimtsov.pop3client.Exception.ConnectionException;
import com.yakimtsov.pop3client.client.MessageHolder;
import com.yakimtsov.pop3client.client.Pop3Client;
import com.yakimtsov.pop3client.client.command.*;
import com.yakimtsov.pop3client.observer.ClientObserver;
import com.yakimtsov.pop3client.view.ConnectionPanel;
import com.yakimtsov.pop3client.view.LoginPanel;
import com.yakimtsov.pop3client.view.MessagePanel;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 * Created by Ivan on 03.02.2018.
 */
public class ClientManager implements ClientObserver {
    private Pop3Client client = new Pop3Client();
    private JFrame mainFrame = new JFrame("Pop3Client");
    private ConnectionPanel connectionPanel = new ConnectionPanel(this);
    private LoginPanel loginPanel = new LoginPanel(this);
    private JTextArea logPanel = new JTextArea();
    private JPanel workingArea = new JPanel();
    private MessagePanel messagePanel = new MessagePanel(this);

    private final String LOGIN_PANEL_TITLE = "login panel";
    private final String CONNECT_PANEL_TITLE = "connect panel";
    private final String MESSAGE_PANEL_TITLE = "message panel";

    private String host;
    private int port;
    private String username;
    private String password;

    public void startClient(){
        client.addListener(this);
        setUpGUI();
    }

    private void setUpGUI(){
        mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setLayout(new BorderLayout());

       // logPanel.setPreferredSize();
        logPanel.setBorder(new TitledBorder("Log panel"));
        logPanel.setEditable(false);
        JScrollPane scroll = new JScrollPane(logPanel);
        scroll.setPreferredSize(new Dimension(450,mainFrame.getHeight()));
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);



        workingArea.setLayout(new CardLayout());
        workingArea.add(connectionPanel.getPanel(), CONNECT_PANEL_TITLE);
        workingArea.add(loginPanel.getPanel(), LOGIN_PANEL_TITLE);
        workingArea.add(messagePanel.getPanel(), MESSAGE_PANEL_TITLE);
        mainFrame.add(workingArea, BorderLayout.CENTER);

        CardLayout cards = (CardLayout)(workingArea.getLayout());
        cards.show(workingArea, CONNECT_PANEL_TITLE);

        mainFrame.add(scroll, BorderLayout.EAST);

        mainFrame.setVisible(true);
    }

    @Override
    public void notifyObserver(String message) {
        logPanel.append(message + "\n");
    }

    public void connect(String address, int port){
        try {
            client.connect(address,port);
            CardLayout cards = (CardLayout)(workingArea.getLayout());
            this.host = address;
            this.port = port;
            cards.show(workingArea, LOGIN_PANEL_TITLE);
        } catch (ConnectionException e) {
            logPanel.append(e.getMessage() + "\n");
            e.printStackTrace();
        }
    }

    public void login(String username, String password){
        try {
            //client.login(username,password);
            client.executeCommand(new LoginCommand(username, password));
            GetMassagesCommand massagesCommand = new GetMassagesCommand();
            client.executeCommand(massagesCommand);
            LinkedList<MessageHolder> messages = massagesCommand.getMessageHolderList();
            messagePanel.setMessages(messages);
            CardLayout cards = (CardLayout)(workingArea.getLayout());
            this.username = username;
            this.password = password;
            cards.show(workingArea, MESSAGE_PANEL_TITLE);
        } catch (ConnectionException e) {
            logPanel.append(e.getMessage() + "\n");
            e.printStackTrace();
        }
    }

    public List<MessageHolder> getMessages(){
        try {
            GetMassagesCommand massagesCommand = new GetMassagesCommand();
            client.executeCommand(massagesCommand);
            return massagesCommand.getMessageHolderList();
        } catch (ConnectionException e) {
            logPanel.append(e.getMessage() + "\n");
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public void logout(){
        try {
            client.executeCommand(new QuitCommand());
            client.disconnect();
            CardLayout cards = (CardLayout)(workingArea.getLayout());
            cards.show(workingArea, CONNECT_PANEL_TITLE);
        } catch (ConnectionException e) {
            logPanel.append(e.getMessage() + "\n");
            e.printStackTrace();
        }
    }

    public void deleteMessage(int index){
        try {
            DeleCommand deleCommand = new DeleCommand(index);
            client.executeCommand(deleCommand);
           // client.delete(index);
        } catch (ConnectionException e) {
            logPanel.append(e.getMessage() + "\n");
            e.printStackTrace();
        }
    }

    public void update(){
        try {
//            client.logout();
            client.executeCommand(new QuitCommand());
            client.disconnect();
            client.connect(host,port);
           // client.login(username,password);
            client.executeCommand(new LoginCommand(username, password));
        } catch (ConnectionException e) {
            logPanel.append(e.getMessage() + "\n");
            e.printStackTrace();
        }
    }

    public void disconnect(){
        try {
            client.disconnect();
            CardLayout cards = (CardLayout)(workingArea.getLayout());
            cards.show(workingArea, CONNECT_PANEL_TITLE);
        } catch (ConnectionException e) {
            logPanel.append(e.getMessage() + "\n");
            e.printStackTrace();
        }
    }

    public void checkConnection(){
        try {
            client.executeCommand(new NoopCommand());
        } catch (ConnectionException e) {
            logPanel.append(e.getMessage() + "\n");
            e.printStackTrace();
        }
    }

    public String findMessageId(int index){
        try {
            UIDLCommand command = new UIDLCommand(index);
          //  client.executeCommand(command);
            return client.executeCommand(command);
        } catch (ConnectionException e) {
            logPanel.append(e.getMessage() + "\n");
            e.printStackTrace();
            return "error";
        }
    }

    public void rset(){
        try {
            client.executeCommand(new RsetCommand());
        } catch (ConnectionException e) {
            e.printStackTrace();
            logPanel.append(e.getMessage() + "\n");
        }
    }

    public String top(int index,int linesAmount){
        try {
            return client.executeCommand(new TopCommand(index, linesAmount));
        } catch (ConnectionException e) {
            e.printStackTrace();
            logPanel.append(e.getMessage() + "\n");
            return "error";
        }
    }

    public void list(){
        try {
            client.executeCommand(new ListCommand());
        } catch (ConnectionException e) {
            e.printStackTrace();
            logPanel.append(e.getMessage() + "\n");
        }
    }
}
