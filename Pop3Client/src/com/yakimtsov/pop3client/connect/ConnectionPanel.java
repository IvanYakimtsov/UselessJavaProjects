package com.yakimtsov.pop3client.connect;

import com.yakimtsov.pop3client.client.ClientManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Ivan on 03.02.2018.
 */
public class ConnectionPanel implements ActionListener {
    private JTextField address = new JTextField(30);
    private JTextField port = new JTextField(30);
    private ClientManager clientManager;
    private JPanel connectionPanel = new JPanel();

 //   public final static String TITLE = "Connection panel";

    private final int RIGHT_TEXT_PADDING = 10;
    private final int RIGHT_LABEL_PADDING = -80;

    public ConnectionPanel(ClientManager clientManager){
        connectionPanel.setBackground(Color.CYAN);
        connectionPanel.setLayout(new BorderLayout());
        this.clientManager = clientManager;
        createBody();
    }

    public JPanel getPanel() {
        return connectionPanel;
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

        JLabel label = new JLabel("address");
        body.add(label,cell);


        cell.gridx = 2;
        cell.insets = new Insets(150, 0, 0, RIGHT_TEXT_PADDING);
        body.add(address, cell);

        cell.gridx = 1;
        cell.gridy = 2;
        cell.insets = new Insets(10, 0, 0, RIGHT_LABEL_PADDING);
        label = new JLabel("port");
        body.add(label,cell);


        cell.gridx = 2;
        cell.insets = new Insets(10, 0, 0, RIGHT_TEXT_PADDING);
        body.add(port, cell);


        JButton submit = new JButton("Connect");
        cell.gridy = 3;
        cell.insets = new Insets(10, 0, 0, RIGHT_TEXT_PADDING);
        submit.addActionListener(this);
        body.add(submit,cell);

        connectionPanel.add(body,BorderLayout.NORTH);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String address = this.address.getText();
        int port = Integer.valueOf(this.port.getText());
        clientManager.connect(address,port);
    }
}
