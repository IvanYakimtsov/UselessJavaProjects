package com.ivan.imageEditor.panels;


import com.ivan.imageEditor.fileActions.LoadAction;
import com.ivan.imageEditor.fileActions.SaveAsAction;

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

        this.mainFrame.setJMenuBar(mainMenuBar);
    }

    private void setMainMenu(JMenuBar mainMenuBar) {
        JMenu mainMenu = new JMenu("Menu");
        mainMenu.setIcon(new ImageIcon("Img/menu.png"));


        mainMenu.add(new JMenuItem(new SaveAsAction(drawingManager, "Save file")));
        mainMenu.add(new JMenuItem(new LoadAction(drawingManager, "Open file")));


        mainMenuBar.add(mainMenu);
    }




    private void setToolsMenu(JMenuBar mainMenuBar) {
        JMenu toolsChooser = new JMenu("tools");
        toolsChooser.setIcon(new ImageIcon("Img/edit.png"));
        mainMenuBar.add(toolsChooser);

    }


}
