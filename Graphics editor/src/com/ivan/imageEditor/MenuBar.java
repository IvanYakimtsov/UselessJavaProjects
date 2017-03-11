package com.ivan.imageEditor;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by Ivan on 11.03.2017.
 */
public class MenuBar {

    private DrawingManager drawingManager;
    private JFrame mainFrame;

    public MenuBar(JFrame mainFrame, DrawingManager drawingManager) {

        this.drawingManager = drawingManager;
        this.mainFrame = mainFrame;

        JMenuBar mainMenuBar = new JMenuBar();
        setMainMenu(mainMenuBar);
        setToolsMenu(mainMenuBar);

        mainFrame.setJMenuBar(mainMenuBar);
    }

    private void setMainMenu(JMenuBar mainMenuBar) {
        JMenu mainMenu = new JMenu("Menu");
        mainMenu.setIcon(new ImageIcon("Img/menu.png"));


        mainMenu.add(new JMenuItem(new SaveAsAction(drawingManager, "Save file", this.mainFrame)));
        mainMenu.add(new JMenuItem(new LoadAction(drawingManager, "Open file", this.mainFrame)));


        mainMenu.addSeparator();
        mainMenu.add(mainMenuClearAllItem());

        mainMenuBar.add(mainMenu);
    }

    private JMenuItem mainMenuSaveItem() {

        JMenuItem saveasMenu = new JMenuItem(new SaveAsAction(drawingManager, "Save file", this.mainFrame));

        return saveasMenu;
    }

    private JMenuItem mainMenuClearAllItem() {

        JMenuItem clearAllItem = new JMenuItem("Clear all");
        clearAllItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawingManager.getDrawingArea().clear();
                drawingManager.getDrawingArea().repaint();
            }
        });
        return clearAllItem;
    }

    private void setToolsMenu(JMenuBar mainMenuBar) {
        JMenu toolsChooser = new JMenu("tools");
        toolsChooser.setIcon(new ImageIcon("Img/edit.png"));
        mainMenuBar.add(toolsChooser);

    }


}
