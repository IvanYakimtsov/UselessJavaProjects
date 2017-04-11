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
public class TableEditorMainFrame {
    private JFrame mainFrame;
    private List<JButton> toolPanelButtons;



    TableEditorMainFrame() {
        toolPanelButtons = new ArrayList<>();
        setFrame();
        mainFrame.validate();
        mainFrame.repaint();
    }


    private void setFrame() {
        this.mainFrame = new JFrame("TableEditor");
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

    public void addWorkingArea(WorkingArea workingArea) {
       mainFrame.add(workingArea.getWorkingAreaPanel());
       mainFrame.validate();
       mainFrame.repaint();
    }


    private void addFrameListener() {
        this.mainFrame.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                Object[] options = {"Выйти", "Отменить"};
                int n = JOptionPane
                        .showOptionDialog(e.getWindow(), "Вы действительно хотите выйти?",
                                "Подтверждение", JOptionPane.YES_NO_OPTION,
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

}
