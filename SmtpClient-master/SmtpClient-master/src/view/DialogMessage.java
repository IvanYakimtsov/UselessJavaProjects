package view;

import controller.*;
import view.MyFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class DialogMessage {

    private JDialog dialog = new JDialog();
    private Controller controller;
    private JLabel labelSubject = new JLabel("Subject: ");
    private JTextField textSubject = new JTextField(15);
    private JLabel labelFrom = new JLabel("From: ");
    private JTextField textFrom = new JTextField(15);
    private JLabel labelData = new JLabel("DATA");
    private JTextArea textAreaToServer = new JTextArea(10, 20);
    private JScrollPane scrollTextTo;
    private JButton button = new JButton("send");
    private MyFrame frame;

    public DialogMessage(Controller controller, MyFrame frame) {
        this.controller = controller;
        this.frame = frame;
    }

    public void readMessage(){

        dialog.setSize(400, 500);
        dialog.setLayout(new GridBagLayout());
        dialog.setLocationRelativeTo(null);

        button.addActionListener(new sendActionListener());

        scrollTextTo = new JScrollPane(textAreaToServer,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        JPanel panel = new JPanel();

        panel.setLayout(new GridLayout(3, 2));
        panel.add(labelFrom);
        panel.add(textFrom);
        panel.add(labelSubject);
        panel.add(textSubject);
        panel.add(labelData);

        dialog.add(panel, new GridBagConstraints(0, 0, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));

        dialog.add(textAreaToServer, new GridBagConstraints(0, 1, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));

        dialog.add(button, new GridBagConstraints(0, 2, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));

        dialog.pack();
        dialog.setVisible(true);
    }

    public class sendActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            Command dataCommand = new CommandWithoutParameter("DATA", controller);
            dataCommand.execute();

            Command sendLetterCommand = new SendLetterCommand(textFrom.getText(),
                    textSubject.getText(), textAreaToServer.getText(), controller);
            sendLetterCommand.execute();

            dialog.dispose();

            frame.refreshChat();
        }
    }
}
