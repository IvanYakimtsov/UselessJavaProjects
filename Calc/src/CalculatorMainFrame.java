import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.regex.Pattern;

/**
 * Created by Ivan on 06.05.2017.
 */
public class CalculatorMainFrame {
    private JFrame mainFrame;
    private JTextField resultPanel;
    private JPanel treePanel;
    private JTextField expressionPanel;

    private JButton submitButton;
    private JButton clearButton;
    private JButton forwardButton;
    private JButton backwardButton;


    private final int MAIN_FRAME_WIDTH = 600;
    private final int MAIN_FRAME_HEIGHT = 400;

    private boolean isAdvencedCalc;

    public CalculatorMainFrame() {
        isAdvencedCalc = false;
        setMainFrame();
    }

    private void setMainFrame() {
        mainFrame = new JFrame();
        mainFrame.setSize(new Dimension(MAIN_FRAME_WIDTH, MAIN_FRAME_HEIGHT));
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
        resultPanel = new JTextField();
        resultPanel.setEditable(false);
        resultPanel.setBackground(Color.WHITE);
        resultPanel.setPreferredSize(new Dimension(MAIN_FRAME_WIDTH / 10, MAIN_FRAME_WIDTH / 10));
        resultPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        container.add(resultPanel, BorderLayout.NORTH);
        treePanel = new JPanel();
        treePanel.setBackground(Color.WHITE);
        treePanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        container.add(treePanel, BorderLayout.CENTER);
    }

    private void setCommandContainer(Container container) {
        container.setLayout(new BorderLayout());
        expressionPanel = new JTextField();
        expressionPanel.setBackground(Color.WHITE);
        expressionPanel.setPreferredSize(new Dimension(MAIN_FRAME_WIDTH / 10, MAIN_FRAME_WIDTH / 10));
        expressionPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        expressionPanel.setEditable(false);
        // JScrollPane jScrollPane = new JScrollPane(expressionPanel);
        // jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        container.add(expressionPanel, BorderLayout.NORTH);
        JPanel commandPanel = new JPanel();
        setCommandPanel(commandPanel);
        container.add(commandPanel, BorderLayout.CENTER);
    }

    private void setCommandPanel(JPanel commandPanel) {
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
        backwardButton = new JButton("<");
        basicCommandsPanel.add(backwardButton, cell);
        forwardButton = new JButton(">");
        basicCommandsPanel.add(forwardButton, cell);
        clearButton = new JButton("C");
        basicCommandsPanel.add(clearButton, cell);
        basicCommandsPanel.add(createSpecialCommandButton("(", "("), cell);
        basicCommandsPanel.add(createCommandButton(")"), cell);


        row++;
        cell.gridy = row;
        basicCommandsPanel.add(createNumberButton("7"), cell);
        basicCommandsPanel.add(createNumberButton("8"), cell);
        basicCommandsPanel.add(createNumberButton("9"), cell);
        basicCommandsPanel.add(createCommandButton("+"), cell);
        JButton button = new JButton();
        button.setText("-");
        Pattern digit = Pattern.compile("(\\d|\\)|!)");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean isLastDigit;
                if (expressionPanel.getText().length() != 0) {
                    isLastDigit = digit.matcher(expressionPanel.getText().substring(expressionPanel.getText().length() - 1
                            , expressionPanel.getText().length())).matches();
                    if (isLastDigit) {
                        expressionPanel.setText(expressionPanel.getText() + "-");
                    } else {
                        if (!expressionPanel.getText().substring(expressionPanel.getText().length() - 1
                                , expressionPanel.getText().length()).equals("(") )
                            expressionPanel.setText(expressionPanel.getText().substring(0, expressionPanel.getText().length() - 1)
                                    + "-");
                        else expressionPanel.setText(expressionPanel.getText() + "-");
                    }
                } else expressionPanel.setText("-");
            }
        });
        basicCommandsPanel.add(button, cell);

        row++;
        cell.gridy = row;
        basicCommandsPanel.add(createNumberButton("4"), cell);
        basicCommandsPanel.add(createNumberButton("5"), cell);
        basicCommandsPanel.add(createNumberButton("6"), cell);
        basicCommandsPanel.add(createCommandButton("*"), cell);
        basicCommandsPanel.add(createCommandButton("/"), cell);

        row++;
        cell.gridy = row;
        basicCommandsPanel.add(createNumberButton("1"), cell);
        basicCommandsPanel.add(createNumberButton("2"), cell);
        basicCommandsPanel.add(createNumberButton("3"), cell);
        basicCommandsPanel.add(createCommandButton("%"), cell);
        basicCommandsPanel.add(createSpecialCommandButton("1/x", "1/"), cell);

        row++;
        cell.gridy = row;
        basicCommandsPanel.add(new JLabel(), cell);
        basicCommandsPanel.add(createNumberButton("0"), cell);
        JButton pointButton = new JButton(".");
        pointButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pattern validator = Pattern.compile("\\d");
                boolean isValid;
                if (expressionPanel.getText().length() != 0) {
                    isValid = validator.matcher(expressionPanel.getText().substring(expressionPanel.getText().length() - 1
                            , expressionPanel.getText().length())).matches();
                    if (isValid) {
                        expressionPanel.setText(expressionPanel.getText() + ".");
                    }
                }
            }
        });
        basicCommandsPanel.add(pointButton, cell);
        cell.gridwidth = 2;
        submitButton = new JButton("=");
        basicCommandsPanel.add(submitButton, cell);

        commandPanel.add(basicCommandsPanel, BorderLayout.CENTER);

        JPanel advancedCommandsPanel = new JPanel(new BorderLayout());
        JButton advancedCommandsButton = new JButton(">");
        JButton factButton = new JButton("!");
        factButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pattern validator = Pattern.compile("\\d|\\)");
                boolean isValid;
                if (expressionPanel.getText().length() != 0) {
                    isValid = validator.matcher(expressionPanel.getText().substring(expressionPanel.getText().length() - 1
                            , expressionPanel.getText().length())).matches();
                    if (isValid) {
                        expressionPanel.setText(expressionPanel.getText() + "!");
                    }
                }
            }
        });
        JButton logButton = createSpecialCommandButton("log", "log(");
        JButton lnButton = createSpecialCommandButton("ln", "ln(");
        JButton sqrtButton = createSpecialCommandButton("sqrt", "sqrt(");
        Container advancedCommandsContainer = new Container();
        advancedCommandsContainer.setLayout(new GridLayout(4, 1));
        advancedCommandsContainer.setBackground(Color.WHITE);
        advancedCommandsContainer.add(factButton);
        advancedCommandsContainer.add(logButton);
        advancedCommandsContainer.add(lnButton);
        advancedCommandsContainer.add(sqrtButton);

        advancedCommandsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isAdvencedCalc) {
                    advancedCommandsButton.setText("<");
                    isAdvencedCalc = true;
                    for (int i = 0; i < 70; i++) {
                        mainFrame.setSize(MAIN_FRAME_WIDTH + i, MAIN_FRAME_HEIGHT);
                    }
                    advancedCommandsPanel.add(advancedCommandsContainer, BorderLayout.CENTER);
                } else {
                    advancedCommandsButton.setText(">");
                    isAdvencedCalc = false;
                    int currentFrameSize = mainFrame.getWidth();
                    for (int i = 0; i < 70; i++) {
                        mainFrame.setSize(currentFrameSize - i, MAIN_FRAME_HEIGHT);
                    }
                    advancedCommandsPanel.remove(advancedCommandsContainer);
                }
            }
        });

        advancedCommandsPanel.add(advancedCommandsButton, BorderLayout.EAST);

        commandPanel.add(advancedCommandsPanel, BorderLayout.EAST);
    }

    private JButton createCommandButton(String title) {
        JButton button = new JButton();
        button.setText(title);
        Pattern digit = Pattern.compile("(\\d|\\)|!)");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean isLastDigit;
                if (expressionPanel.getText().length() != 0) {
                    isLastDigit = digit.matcher(expressionPanel.getText().substring(expressionPanel.getText().length() - 1
                            , expressionPanel.getText().length())).matches();
                    if (isLastDigit) {
                        expressionPanel.setText(expressionPanel.getText() + title);
                    } else {
                        if (!expressionPanel.getText().substring(expressionPanel.getText().length() - 1
                                , expressionPanel.getText().length()).equals("(") && !expressionPanel.getText().substring(0).equals("-"))
                            expressionPanel.setText(expressionPanel.getText().substring(0, expressionPanel.getText().length() - 1)
                                    + title);
                    }
                }
            }
        });
        return button;
    }

    private JButton createNumberButton(String title) {
        JButton button = new JButton();
        button.setText(title);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pattern validator = Pattern.compile("(!|%|\\))");
                boolean isInvalid;
                if (expressionPanel.getText().length() != 0) {
                    isInvalid = validator.matcher(expressionPanel.getText().substring(expressionPanel.getText().length() - 1
                            , expressionPanel.getText().length())).matches();
                    if (!isInvalid) {
                        expressionPanel.setText(expressionPanel.getText() + title);
                    } else {
                        expressionPanel.setText(expressionPanel.getText() + "*" + title);
                    }
                } else expressionPanel.setText(expressionPanel.getText() + title);
            }
        });
        return button;
    }

    private JButton createSpecialCommandButton(String title, String command) {
        JButton button = new JButton();
        button.setText(title);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pattern validator = Pattern.compile("(\\d|!|%|\\))");
                boolean isInvalid;
                if (expressionPanel.getText().length() != 0) {
                    isInvalid = validator.matcher(expressionPanel.getText().substring(expressionPanel.getText().length() - 1
                            , expressionPanel.getText().length())).matches();
                    if (!isInvalid) {
                        if (!expressionPanel.getText().substring(expressionPanel.getText().length() - 1
                                , expressionPanel.getText().length()).equals("."))
                            expressionPanel.setText(expressionPanel.getText() + command);
                    } else {
                        expressionPanel.setText(expressionPanel.getText() + "*" + command);
                    }
                } else expressionPanel.setText(expressionPanel.getText() + command);
            }
        });
        return button;
    }

    public JButton getSubmitButton() {
        return submitButton;
    }

    public JButton getClearButton() {
        return clearButton;
    }

    public JButton getForwardButton() {
        return forwardButton;
    }

    public JButton getBackwardButton() {
        return backwardButton;
    }

    public JTextField getExpressionPanel() {
        return expressionPanel;
    }
}
