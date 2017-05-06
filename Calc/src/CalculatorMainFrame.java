import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by Ivan on 06.05.2017.
 */
public class CalculatorMainFrame {
    JFrame mainFrame;
    JPanel resultPanel;
    JPanel treePanel;
    JTextField expressionPanel;
    JButton submitButton;

    public CalculatorMainFrame() {
        setMainFrame();
    }

    private void setMainFrame() {
        mainFrame = new JFrame();
        mainFrame.setSize(new Dimension(600, 400));
        mainFrame.setResizable(false);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setLayout(new GridBagLayout());
        GridBagConstraints cell = new GridBagConstraints();
        cell.gridx = GridBagConstraints.RELATIVE;
        cell.gridy = 0;
        cell.weightx = 7;
        cell.weighty = 1;
        cell.fill = GridBagConstraints.BOTH;
        Container resultContainer = new Container();
        setResultContainer(resultContainer);
        mainFrame.add(resultContainer, cell);

        cell.weightx = 5;
        Container commandsContainer = new Container();
        setCommandContainer(commandsContainer);
        mainFrame.add(commandsContainer, cell);


        mainFrame.setVisible(true);
    }

    private void setResultContainer(Container container) {
        container.setLayout(new BorderLayout());
        resultPanel = new JPanel();
        resultPanel.setBackground(Color.WHITE);
        resultPanel.setPreferredSize(new Dimension(70,50));
        resultPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        container.add(resultPanel,BorderLayout.NORTH);
        treePanel = new JPanel();
        treePanel.setBackground(Color.WHITE);
        treePanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        container.add(treePanel,BorderLayout.CENTER);
    }

    private void setCommandContainer(Container container) {
        container.setLayout(new BorderLayout());
        expressionPanel = new JTextField();
        expressionPanel.setBackground(Color.WHITE);
        expressionPanel.setPreferredSize(new Dimension(70,50));
        expressionPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        expressionPanel.setEditable(false);
        JScrollPane jScrollPane = new JScrollPane(expressionPanel);
        container.add(jScrollPane,BorderLayout.NORTH);
        JPanel commandPanel = new JPanel();
        setCommandPanel(commandPanel);
        container.add(commandPanel,BorderLayout.CENTER);
    }

    private void setCommandPanel(JPanel commandPanel){
        int row = 0;
        commandPanel.setBackground(Color.WHITE);
        commandPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
        commandPanel.setLayout(new BorderLayout());

        JPanel basicCommandsPanel = new JPanel();
        basicCommandsPanel.setBackground(Color.WHITE);
        basicCommandsPanel.setLayout(new GridBagLayout());
        GridBagConstraints cell = new GridBagConstraints();
        cell.gridx = GridBagConstraints.RELATIVE;
        cell.fill = GridBagConstraints.BOTH;
        cell.gridy = row;
        cell.weightx = 1;
        cell.weighty = 1;
        basicCommandsPanel.add(createCommandButton("<"),cell);
        basicCommandsPanel.add(createCommandButton(">"),cell);
        basicCommandsPanel.add(createCommandButton("C"),cell);
        basicCommandsPanel.add(createCommandButton("("),cell);
        basicCommandsPanel.add(createCommandButton(")"),cell);


        row++;
        cell.gridy = row;
        basicCommandsPanel.add(createNumberButton("7"),cell);
        basicCommandsPanel.add(createNumberButton("8"),cell);
        basicCommandsPanel.add(createNumberButton("9"),cell);
        basicCommandsPanel.add(createCommandButton("+"),cell);
        basicCommandsPanel.add(createCommandButton("-"),cell);

        row++;
        cell.gridy = row;
        basicCommandsPanel.add(createNumberButton("4"),cell);
        basicCommandsPanel.add(createNumberButton("5"),cell);
        basicCommandsPanel.add(createNumberButton("6"),cell);
        basicCommandsPanel.add(createCommandButton("*"),cell);
        basicCommandsPanel.add(createCommandButton("-"), cell);

        row++;
        cell.gridy = row;
        basicCommandsPanel.add(createNumberButton("1"),cell);
        basicCommandsPanel.add(createNumberButton("2"),cell);
        basicCommandsPanel.add(createNumberButton("3"),cell);
        basicCommandsPanel.add(createCommandButton("%"),cell);
        basicCommandsPanel.add(createCommandButton("1/x"), cell);

        row++;
        cell.gridy = row;
        basicCommandsPanel.add(new JLabel(),cell);
        basicCommandsPanel.add(createNumberButton("0"),cell);
        basicCommandsPanel.add(createCommandButton("."), cell);
        cell.gridwidth = 2;
        submitButton = new JButton("=");
        basicCommandsPanel.add(submitButton, cell);

        commandPanel.add(basicCommandsPanel,BorderLayout.CENTER);

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setPreferredSize(new Dimension(70,300));
        commandPanel.add(panel,BorderLayout.EAST);
    }

    private JButton createCommandButton(String title){
        JButton button = new JButton();
        button.setText(title);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        return button;
    }

    private JButton createNumberButton(String title){
        JButton button = new JButton();
        button.setText(title);
        return button;
    }
}
