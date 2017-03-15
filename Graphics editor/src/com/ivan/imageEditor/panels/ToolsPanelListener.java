package com.ivan.imageEditor.panels;

import com.ivan.imageEditor.tools.Tool;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Ivan on 14.03.2017.
 */
public class ToolsPanelListener implements ActionListener {
    DrawingManager drawingManager;
    Tool tool;

    ToolsPanelListener(DrawingManager drawingManager, Tool tool) {
        this.drawingManager = drawingManager;
        this.tool = tool;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        this.drawingManager.setCurrentTool(tool);
    }
}