package view;

import controller.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MyFrame {

    private Dimension d;
    private String title;
    private JFrame frame = new JFrame();
    private Controller controller;
    public JScrollPane scrollTextFrom;

    private JPanel panelButton = new JPanel();
    private JPanel panelText = new JPanel();

    private JButton connectButton = new JButton("Connect");
    private JButton domenButton = new JButton("HELO");
    private JButton fromButton = new JButton("MAIL FROM:");
    private JButton toButton = new JButton("RCPT TO:");
    private JButton sendMessageButton = new JButton("SendMessage");
    private JButton clearButton = new JButton("QUIT ");
    private JButton rsetButton = new JButton("RSET");
    private JButton noopButton = new JButton("NOOP");
    private JButton sendFromButton = new JButton("SEND FROM:");
    private JButton somlButton = new JButton("SOML FROM:");
    private JButton samlButton = new JButton("SAML FROM:");
    private JButton vrfyButton = new JButton("VRFY");
    private JButton helpButton = new JButton("HELP");
    private JTextArea textAreaFromServer = new JTextArea(13, 30);

    public MyFrame(String title, Dimension d, Controller controller) {
        this.title = title;
        this.d = d;
        this.controller = controller;
    }

    public void init(){
        frame.setTitle(title);
        frame.setSize(d);
        frame.setLayout(new GridBagLayout());
        frame.setLocationRelativeTo(null);

        connectButton.addActionListener(new connectActionListener());
        domenButton.addActionListener(new domenActionListener());
        fromButton.addActionListener(new fromActionListener());
        toButton.addActionListener(new toButtonActionListener());
        sendMessageButton.addActionListener(new sendMessageActionListener());
        clearButton.addActionListener(new clearActionListener());
        rsetButton.addActionListener(new rsetActionListener());
        noopButton.addActionListener(new noopActionListener());
        sendFromButton.addActionListener(new sendFromActionListener());
        somlButton.addActionListener(new somlActionListener());
        samlButton.addActionListener(new samlActionListener());
        vrfyButton.addActionListener(new vrfyActionListener());
        helpButton.addActionListener(new helpActionListener());

        panelButton.setLayout(new GridLayout(7, 2));
        panelButton.add(connectButton);
        panelButton.add(domenButton);
        panelButton.add(fromButton);
        panelButton.add(toButton);
        panelButton.add(sendMessageButton);
        panelButton.add(clearButton);
        panelButton.add(rsetButton);
        panelButton.add(noopButton);
        panelButton.add(sendFromButton);
        panelButton.add(somlButton);
        panelButton.add(samlButton);
        panelButton.add(vrfyButton);
        panelButton.add(helpButton);

        scrollTextFrom = new JScrollPane(textAreaFromServer, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        panelText.add(scrollTextFrom);

        frame.add(panelText, new GridBagConstraints(2, 0, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));

        frame.add(panelButton, new GridBagConstraints(3, 0, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));

        frame.setVisible(true);
        frame.pack();
    }

    public class connectActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            DialogCommon dialogConnect = new DialogCommon(controller, new JLabel("SMTP"),MyFrame.this);
            dialogConnect.createDialog();
        }
    }

    public class domenActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            DialogCommon dialogDomen = new DialogCommon(controller, new JLabel("HELO"),MyFrame.this);
            dialogDomen.createDialog();
        }
    }

    public class fromActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            DialogCommon dialogFrom = new DialogCommon(controller, new JLabel("MAIL FROM:"),MyFrame.this);
            dialogFrom.createDialog();
        }
    }

    public class toButtonActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            DialogCommon dialogTo = new DialogCommon(controller, new JLabel("RCPT TO:"),MyFrame.this);
            dialogTo.createDialog();
        }
    }

    public class sendMessageActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
           DialogMessage dialogMessage = new DialogMessage(controller, MyFrame.this);
           dialogMessage.readMessage();
        }
    }

    public class clearActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            Command quitCommand = new CommandWithoutParameter("QUIT",controller);
            quitCommand.execute();
            refreshChat();
        }
    }

    public class noopActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            Command noopCommand = new CommandWithoutParameter("NOOP",controller);
            noopCommand.execute();
            refreshChat();
        }
    }

    public class rsetActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            Command rsetCommand = new CommandWithoutParameter("RSET",controller);
            rsetCommand.execute();
            refreshChat();
        }
    }

    public class vrfyActionListener implements ActionListener {//////////////

        public void actionPerformed(ActionEvent e) {

            DialogCommon dialogVrfy = new DialogCommon(controller, new JLabel("VRFY"),MyFrame.this);
            dialogVrfy.createDialog();
        }
    }

    public class helpActionListener implements ActionListener {/////////////

        public void actionPerformed(ActionEvent e) {

            DialogCommon dialogHelp = new DialogCommon(controller, new JLabel("HELP"),MyFrame.this);
            dialogHelp.createDialog();
        }
    }

    public class sendFromActionListener implements ActionListener {/////////////

        public void actionPerformed(ActionEvent e) {

            DialogCommon dialogSendFrom = new DialogCommon(controller, new JLabel("SEND FROM:"),MyFrame.this);
            dialogSendFrom.createDialog();
        }
    }

    public class somlActionListener implements ActionListener {/////////////

        public void actionPerformed(ActionEvent e) {

            DialogCommon dialogHelp = new DialogCommon(controller, new JLabel("SOML FROM:"),MyFrame.this);
            dialogHelp.createDialog();
        }
    }

    public class samlActionListener implements ActionListener {/////////////

        public void actionPerformed(ActionEvent e) {

            DialogCommon dialogHelp = new DialogCommon(controller, new JLabel("SAML FROM:"),MyFrame.this);
            dialogHelp.createDialog();
        }
    }

    public void refreshChat() {
        textAreaFromServer.setText("");
        textAreaFromServer.setText(controller.getChat().toString());
    }
}
