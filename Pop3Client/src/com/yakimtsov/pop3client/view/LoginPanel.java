package com.yakimtsov.pop3client.view;

import com.yakimtsov.pop3client.manager.ClientManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Ivan on 04.02.2018.
 */
public class LoginPanel {
    private JTextField username = new JTextField(30);
    private JTextField password = new JTextField(30);
    private ClientManager clientManager;
    private JPanel loginPanel = new JPanel();

 //   public final static String TITLE = "Log IN panel";

    private final int RIGHT_TEXT_PADDING = 10;
    private final int RIGHT_LABEL_PADDING = -80;

    public LoginPanel(ClientManager clientManager){
        loginPanel.setBackground(Color.CYAN);
        loginPanel.setLayout(new BorderLayout());
        this.clientManager = clientManager;
        createBody();
    }

    public JPanel getPanel() {
        return loginPanel;
    }

    private void createBody(){
        Container body = new Container();
        body.setLayout(new GridBagLayout());

        GridBagConstraints cell = new GridBagConstraints();
        cell.anchor = GridBagConstraints.CENTER;
        cell.gridheight = 1;
        cell.insets = new Insets(150, 0, 0, RIGHT_LABEL_PADDING);
        cell.gridx = 1;
        cell.gridy = 1;
        cell.ipadx = 100;
        cell.fill = GridBagConstraints.BOTH;

        JLabel label = new JLabel("username");
        body.add(label,cell);


        cell.gridx = 2;
        cell.insets = new Insets(150, 0, 0, RIGHT_TEXT_PADDING);
        body.add(username, cell);

        cell.gridx = 1;
        cell.gridy = 2;
        cell.insets = new Insets(10, 0, 0, RIGHT_LABEL_PADDING);
        label = new JLabel("password");
        body.add(label,cell);


        cell.gridx = 2;
        cell.insets = new Insets(10, 0, 0, RIGHT_TEXT_PADDING);
        body.add(password, cell);

        JButton disconnectButton = new JButton("Disconnect");
        cell.gridx = 0;
        cell.gridy = 3;
        cell.ipadx = 0;
        cell.insets = new Insets(10, 0, 0, RIGHT_LABEL_PADDING);
        disconnectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clientManager.disconnect();
            }
        });
        body.add(disconnectButton,cell);


        JButton loginButton = new JButton("Log In");
        cell.gridx = 2;
        cell.insets = new Insets(10, 10, 0, RIGHT_TEXT_PADDING);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String login = username.getText();
                String pass = password.getText();
                clientManager.login(login,pass);
            }
        });
        body.add(loginButton,cell);

        loginPanel.add(body,BorderLayout.NORTH);
    }

}
