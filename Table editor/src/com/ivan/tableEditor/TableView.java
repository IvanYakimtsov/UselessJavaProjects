package com.ivan.tableEditor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.*;
import java.util.List;

/**
 * Created by Ivan on 21.03.2017.
 */
public class TableView {
    private JFrame mainFrame;
    private WorkingArea workingArea;
    private List<JButton> toolPanelButtons;
    private int examsAmmount;


    TableView(int examsAmmount) {
        toolPanelButtons = new ArrayList<>();
        this.examsAmmount = examsAmmount;
        setFrame();
        addWorkingArea();
        createTable(null);
        mainFrame.validate();
        mainFrame.repaint();
    }


    private void setFrame() {
        this.mainFrame = new JFrame("com.ivan.tableEditor.TableEditor");
        this.mainFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        addFrameListener();
        addToolPanel();

        this.mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        this.mainFrame.setVisible(true);
    }

    private void addToolPanel() {
        JToolBar toolBar = new JToolBar();
        toolBar.setPreferredSize(new Dimension(mainFrame.getWidth(), 48));
        toolBar.setFloatable(false);
        Box buttonsBox = Box.createHorizontalBox();
        toolBar.setBackground(new Color(94, 115, 232));
        setButtons(buttonsBox);
        toolBar.add(buttonsBox);
        mainFrame.add(toolBar, BorderLayout.NORTH);

    }

    private void setButtons(Box buttonsBox) {
        addButton("img/save.png", buttonsBox);
        addButton("img/open.png", buttonsBox);
        addButton("img/add-user.png", buttonsBox);
        addButton("img/remove-user.png", buttonsBox);
        addButton("img/search-user.png", buttonsBox);
    }

    private void addButton(String filename, Box buttonsBox) {
        JButton button = new JButton(new ImageIcon(filename));
        button.setBackground(null);
        button.setPreferredSize(new Dimension(40, 40));
        buttonsBox.add(button);
        buttonsBox.add(Box.createHorizontalStrut(32));
        toolPanelButtons.add(button);
    }

    private void addWorkingArea() {
       workingArea = new WorkingArea(examsAmmount);
       mainFrame.add(workingArea.getWorkingArea());
    }


    public void createTable(List<TableRow> table) {
        //TODO: add ammount of rows depanding from page
        workingArea.createTable(table);
        mainFrame.validate();
        mainFrame.repaint();
    }


    public void addDialog(JDialog dialog) {

        dialog.setLocationRelativeTo(workingArea.getWorkingArea());
    }

    private void addFrameListener() {
        this.mainFrame.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                Object[] options = {"Exit", "Cancel"};
                int n = JOptionPane
                        .showOptionDialog(e.getWindow(), "Are you sure you want to exit?",
                                "Submit", JOptionPane.YES_NO_OPTION,
                                JOptionPane.QUESTION_MESSAGE, null, options,
                                options[0]);
                if (n == 0) {
                    e.getWindow().setVisible(false);
                    System.exit(0);
                }
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
    }


    public List<JButton> getToolPanelButtons() {
        return toolPanelButtons;
    }


    public int getExamsAmmount() {
        return examsAmmount;
    }


    public void setExamsAmmount(int examsAmmount) {
        this.examsAmmount = examsAmmount;
        workingArea.setExamsAmmount(examsAmmount);
    }

    public JPanel getWorkingArea() {
        return workingArea.getWorkingArea();
    }

}
