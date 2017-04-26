import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Ivan on 24.04.2017.
 */
public class ServerControlPanel {
    private ServerManager serverManager;
    private JFrame serverControlPanel;
    private JPanel logPanel;
    ServerControlPanel(ServerManager serverManager){
       this.serverManager = serverManager;
       setServerControlPanel();

    }
    private void setServerControlPanel(){
        serverControlPanel = new JFrame("server control panel");
        serverControlPanel.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        serverControlPanel.setSize(new Dimension(400,500));
        serverControlPanel.setLocationRelativeTo(null);
        serverControlPanel.setVisible(true);
        serverControlPanel.setLayout(new BorderLayout());

        setButtonPanel();

        setLogPanel();

        serverControlPanel.validate();
        serverControlPanel.repaint();
    }


    private void setButtonPanel(){
        JPanel container = new JPanel();
        container.setLayout(new GridBagLayout());

        GridBagConstraints cell = new GridBagConstraints();
        cell.gridy = 0;
        cell.anchor = GridBagConstraints.CENTER;
        cell.gridx = GridBagConstraints.RELATIVE;
        cell.insets = new Insets(0, 0, 0, 20);

        container.setBackground(new Color(94, 115, 232));
        container.setSize(400,100);

        JButton startServerButton = new JButton("Start Server");
        startServerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                serverManager.startServer();
            }
        });
        container.add(startServerButton,cell);
        JButton stopServerButton = new JButton("Stop Server");
        stopServerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                serverManager.stopServer();
            }
        });
        container.add(stopServerButton,cell);

        cell.insets = new Insets(0, 0, 0, 0);
        JButton clearLogButton = new JButton("Clear Log");
        final ServerControlPanel that =this;
        clearLogButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                that.clearLog();
            }
        });
        container.add(clearLogButton,cell);


        serverControlPanel.add(container,BorderLayout.NORTH);
    }

    private void setLogPanel(){
        logPanel = new JPanel();
        logPanel.setBackground(new Color(175, 205, 231));
        logPanel.setLayout(new GridBagLayout());

        JPanel panel = new JPanel();
        panel.setBackground(new Color(175, 205, 231));
        panel.setLayout(new BorderLayout());
        panel.add(logPanel,BorderLayout.NORTH);
        JScrollPane scrollPane = new JScrollPane(panel);
        serverControlPanel.add(scrollPane,BorderLayout.CENTER);

    }

    public void printLog(String text){
        GridBagConstraints cell = new GridBagConstraints();
        cell.gridx = 0;
        cell.weightx = 1;
        cell.anchor = GridBagConstraints.WEST;
        cell.gridy = GridBagConstraints.RELATIVE;
        logPanel.add(new JLabel(text),cell);
        serverControlPanel.validate();
        serverControlPanel.repaint();
    }

    private void clearLog(){
        logPanel.removeAll();
        serverControlPanel.validate();
        serverControlPanel.repaint();
    }
}
