package com.ivan.imageEditor.panels;


import com.ivan.imageEditor.fileActions.LoadAction;
import com.ivan.imageEditor.fileActions.SaveAsAction;
import com.ivan.imageEditor.tools.BrokenLineAllocation;
import com.ivan.imageEditor.tools.Tool;

import javax.swing.*;


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
        setTools(toolsChooser);
        mainMenuBar.add(toolsChooser);

    }

    private void setTools(JMenu toolsChooser){
        addTool(toolsChooser,"Paint",new com.ivan.imageEditor.tools.Paint(this.drawingManager));
        addTool(toolsChooser,"Line",new com.ivan.imageEditor.tools.Line(this.drawingManager));
        addTool(toolsChooser,"Eraser",new com.ivan.imageEditor.tools.Eraser(this.drawingManager));
        addTool(toolsChooser,"Text",new com.ivan.imageEditor.tools.Text(this.drawingManager));
        addTool(toolsChooser,"Allocation",new com.ivan.imageEditor.tools.Allocation(this.drawingManager));
        addTool(toolsChooser,"Broken line allocation",new BrokenLineAllocation(this.drawingManager));
    }


    private void addTool(JMenu toolsChooser, String name, Tool tool){
        JMenuItem paint = new JMenuItem(name);
        paint.addActionListener(new ToolsPanelListener(drawingManager,tool));
        toolsChooser.add(paint);
    }


}
