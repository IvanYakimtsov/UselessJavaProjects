package com.ivan.imageEditor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Ivan on 01.03.2017.
 */
public class ToolsPanel  {

    DrawingManager drawingManager;
    JPanel toolPanel;



    ToolsPanel(DrawingManager drawingManager) {

        this.toolPanel = new JPanel();

        this.drawingManager = drawingManager;
        this.toolPanel.setBackground(Color.LIGHT_GRAY);
        this.toolPanel.setPreferredSize(new Dimension(36,200));
        this.toolPanel.setLayout(new GridLayout(7,1,36,36));
        setTools();
        this.toolPanel.setVisible(true);
    }

    private void setTools(){
        this.addButton(setToolButton("Img/paint-brush.png"),new Paint(this.drawingManager));
        this.addButton(setToolButton("Img/segment.png"),new Line(this.drawingManager));
        this.addButton(setToolButton("Img/eraser.png"),new Eraser(this.drawingManager));
        this.addButton(setToolButton("Img/text.png"),new Paint(this.drawingManager));
        this.addButton(setToolButton("Img/Rectangle.png"),new Rectangle(this.drawingManager));
        this.addButton(setToolButton("Img/save.png"),new Paint(this.drawingManager));
    }

    private JButton setToolButton(String fileName){
        JButton button = new JButton(new ImageIcon(fileName));
        button.setBackground(null);
        return button;
    }

    public void addButton(JButton button, Tool tool){

        button.addActionListener(new ToolsPanelListener(drawingManager, tool));
        this.toolPanel.add(button);
    }

    public JPanel getToolPanel() {
        return toolPanel;
    }




    //------------------------------------------------------------------------------------------------------------
    private class ToolsPanelListener implements ActionListener {
        DrawingManager drawingManager;
        Tool tool;
        ToolsPanelListener(DrawingManager drawingManager, Tool tool){
            this.drawingManager = drawingManager;
            this.tool = tool;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            this.drawingManager.setCurrentTool(this.tool);
        }
    }

}
