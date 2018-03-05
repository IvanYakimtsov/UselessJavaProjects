package com.yakimtsov.pop3client.view;

import com.yakimtsov.pop3client.client.MessageHolder;
import com.yakimtsov.pop3client.client.ClientManager;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.Color;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Ivan on 04.02.2018.
 */
public class MessagePanel {
    private ClientManager clientManager;
    private JPanel messagePanel = new JPanel();
    private List<MessageHolder> messages = new LinkedList<>();
    private JPanel messageHolder = new JPanel();
    private List<JButton> deleteButtons = new LinkedList<>();
    private Color buttonColor = new JButton().getBackground();


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
        messageHolder.setBackground(Color.CYAN);

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

        JButton checkConnection = new JButton("Check connection");
        checkConnection.addActionListener(e -> {
            clientManager.checkConnection();
        });

        container.add(checkConnection);

        JButton resetButton = new JButton("Reset");
        resetButton.addActionListener(e -> {
            clientManager.rset();
            deleteButtons.forEach(b -> {b.setBackground(buttonColor);});
        });

        container.add(resetButton);

        JButton listButton = new JButton("list");
        listButton.addActionListener(e -> clientManager.list());
        container.add(listButton);

        messagePanel.add(messageHolder, BorderLayout.CENTER);
        messagePanel.add(container, BorderLayout.NORTH);
        createMessageList();

    }

    private void createMessageList() {
        messageHolder.removeAll();
        messageHolder.setLayout(new GridLayout(messages.size(), 1));

        //  int index = 0;

        for (MessageHolder message : messages) {
            // index++;
            JPanel container = new JPanel();
            container.setLayout(new BorderLayout());
            JButton button = new JButton(message.getSubject() + " : FROM " + message.getFrom());
            button.addActionListener(e -> {
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

                JScrollPane bodyHolder = new JScrollPane(body);
                bodyHolder.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                bodyHolder.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

                frame.add(header, BorderLayout.NORTH);
                frame.add(bodyHolder, BorderLayout.CENTER);
                frame.setVisible(true);
            });

            container.add(button, BorderLayout.CENTER);

            button = new JButton("delete");
            deleteButtons.add(button);
            JButton finalButton = button;
            button.addActionListener(e -> {
                clientManager.deleteMessage(message.getNumber());
                finalButton.setBackground(Color.RED);
            });

            container.add(button, BorderLayout.EAST);

            button = new JButton("id");
            button.addActionListener(e -> {
                String id = clientManager.findMessageId(message.getNumber());
                JOptionPane.showMessageDialog(messageHolder,
                        id,
                        "message ID",
                        JOptionPane.INFORMATION_MESSAGE);
            });

            container.add(button, BorderLayout.WEST);


            button = new JButton("Top command");
            button.addActionListener(e -> {
                String linesAmount = JOptionPane.showInputDialog(messageHolder, "lines amount");
                if(linesAmount != null){
                    String result = clientManager.top(message.getNumber(),Integer.parseInt(linesAmount));
                    JFrame frame = new JFrame();
                    frame.setSize(400, 400);
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    frame.setBackground(Color.WHITE);

                    JTextArea body = new JTextArea();
                    body.setEditable(false);
                    body.append(result);

                    JScrollPane bodyHolder = new JScrollPane(body);
                    bodyHolder.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                    bodyHolder.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

                    frame.add(bodyHolder, BorderLayout.CENTER);
                    frame.setVisible(true);
                }

            });

            container.add(button, BorderLayout.NORTH);

            Border border = BorderFactory.createLineBorder(Color.BLACK);
            container.setBorder(BorderFactory.createCompoundBorder(border,
                    BorderFactory.createEmptyBorder(10, 10, 10, 10)));

            messageHolder.add(container);
        }


    }
}
