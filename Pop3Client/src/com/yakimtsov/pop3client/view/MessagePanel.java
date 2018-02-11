package com.yakimtsov.pop3client.view;

import com.yakimtsov.pop3client.client.MessageHolder;
import com.yakimtsov.pop3client.manager.ClientManager;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Ivan on 04.02.2018.
 */
public class MessagePanel {
    private ClientManager clientManager;
    private JPanel messagePanel = new JPanel();
    private List<MessageHolder> messages = new LinkedList<>();
    JPanel holder = new JPanel();


    public MessagePanel(ClientManager clientManager) {

        this.clientManager = clientManager;
        //this.messages = messages;
        createBody();
    }

    public JPanel getPanel() {
        return messagePanel;
    }

    public void setMessages(List<MessageHolder> messages) {
        this.messages = messages;
        createMessageList();
        messagePanel.validate();
        messagePanel.repaint();
    }

    private void createBody() {
        messagePanel.setBackground(Color.CYAN);

        messagePanel.setLayout(new BorderLayout());
        holder.setBackground(Color.CYAN);

        Container container = new Container();
        container.setPreferredSize(new Dimension(500, 50));
        container.setLayout(new FlowLayout());

        JButton disconnect = new JButton("disconnect");
        disconnect.addActionListener(e -> clientManager.logout());

        container.add(disconnect);

        JButton updateMail = new JButton("update emails");

        updateMail.addActionListener(e -> {
            clientManager.update();
            setMessages(clientManager.getMessages());
        });


        container.add(updateMail);

        messagePanel.add(holder, BorderLayout.CENTER);
        messagePanel.add(container, BorderLayout.NORTH);
        createMessageList();

    }

    private void createMessageList() {
        holder.removeAll();
        holder.setLayout(new GridLayout(messages.size(), 1));

      //  int index = 0;

        for (MessageHolder message : messages) {
           // index++;
            Container container = new Container();
            container.setLayout(new BorderLayout());
            JButton button = new JButton(message.getSubject() + " : FROM " + message.getFrom());
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JFrame frame = new JFrame();
                    frame.setSize(400, 400);
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    frame.setBackground(Color.WHITE);
                    frame.setLayout(new BorderLayout());

                    JTextArea header = new JTextArea();
                    header.setEditable(false);
                    Border border = BorderFactory.createLineBorder(Color.BLACK);
                    header.setBorder(BorderFactory.createCompoundBorder(border,
                            BorderFactory.createEmptyBorder(10, 10, 10, 10)));

                    header.append("subject: " + message.getSubject() + "\n");
                    header.append("from: " + message.getFrom() + "\n");
                    header.append("date: " + message.getDate());

                    JTextArea body = new JTextArea();
                    body.setEditable(false);
                    body.append(message.getBody());
                    body.setBorder(BorderFactory.createCompoundBorder(border,
                            BorderFactory.createEmptyBorder(10, 10, 10, 10)));

                    frame.add(header, BorderLayout.NORTH);
                    frame.add(body, BorderLayout.CENTER);
                    frame.setVisible(true);
                }
            });

            container.add(button, BorderLayout.CENTER);

            button = new JButton("delete");
           // int finalIndex = index;
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                  //  System.out.println("DELETE MESSAGE " + message.getNumber());
                    clientManager.deleteMessage(message.getNumber());
                    clientManager.update();
                    setMessages(clientManager.getMessages());
                }
            });

            container.add(button, BorderLayout.EAST);

            holder.add(container);
        }


    }
}
