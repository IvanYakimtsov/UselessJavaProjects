package view;

import controller.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogCommon {

    private JDialog dialog = new JDialog();
    private Controller controller;
    private JLabel label;
    private JTextField textField = new JTextField(15);
    private JButton button = new JButton("send");
    private MyFrame frame;

    public DialogCommon(Controller controller, JLabel label, MyFrame frame) {
        this.controller = controller;
        this.label = label;
        this.frame = frame;
    }

    public void createDialog(){

        dialog.setSize(400, 500);
        dialog.setLayout(new GridBagLayout());
        dialog.setLocationRelativeTo(null);

        button.addActionListener(new sendActionListener());

        JPanel panel = new JPanel();

        panel.setLayout(new GridLayout(1, 2));
        panel.add(label);
        panel.add(textField);

        dialog.add(panel, new GridBagConstraints(0, 0, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));

        dialog.add(button, new GridBagConstraints(0, 1, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));

        dialog.pack();
        dialog.setVisible(true);
    }

    public class sendActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            if("SMTP".equals(label.getText())){
                Command connectCommand = new CommandConnect(textField.getText(), controller);
                connectCommand.execute();
            }
            else {
                Command commonCommand = new CommandWithParameter(label.getText(), textField.getText(), controller);
                commonCommand.execute();
            }
            dialog.dispose();

            frame.refreshChat();
        }
    }
}
