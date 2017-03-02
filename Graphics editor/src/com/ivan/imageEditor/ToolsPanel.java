package com.ivan.imageEditor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

/**
 * Created by Ivan on 01.03.2017.
 */
public class ToolsPanel  {

    DrawingManager drawingManager;
    JPanel toolPanel = new JPanel();



    ToolsPanel(DrawingManager drawingManager) {

        this.toolPanel = new JPanel();

        this.drawingManager = drawingManager;
        this.toolPanel.setBackground(Color.LIGHT_GRAY);
        this.toolPanel.setPreferredSize(new Dimension(36,200));
        this.toolPanel.setLayout(new GridLayout(7,1,36,36));
        this.toolPanel.setVisible(true);
    }

    public void addButton(JButton button, Tool tool){

        button.addActionListener(new ToolsPanelListener(drawingManager, tool));
        this.toolPanel.add(button);
    }

    public JPanel getToolPanel() {
        return toolPanel;
    }




    //------------------------------------------------------------------------------------------------------------
    public class ToolsPanelListener implements ActionListener {
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
