import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class test extends JFrame {
    JDialog dialog;

    public void showP() {
        dialog.setVisible(true);
        for (int i = 0; i < 200; i++) {
            dialog.setSize(i, 200);
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
            }
        }
    }

    test() {
        setSize(300, 200);
        dialog = new JDialog();
        dialog.setSize(0, 200);
        dialog.setLocation(400, 100);
        JButton b = new JButton("Show");
        setLayout(new BorderLayout());
        add(b, BorderLayout.CENTER);
        setVisible(true);
        b.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent ae) {
                        showP();
                    }
                });
    }

    public static void main(String[] args) {
        new test();
    }
}

