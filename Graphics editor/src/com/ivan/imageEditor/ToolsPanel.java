package com.ivan.imageEditor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Ivan on 01.03.2017.
 */
public class ToolsPanel {

    private DrawingManager drawingManager;
    private JPanel toolPanel;
    private JFrame mainFrame;


    ToolsPanel(DrawingManager drawingManager, JFrame mainFrame) {

        this.toolPanel = new JPanel();
        this.mainFrame = mainFrame;

        this.drawingManager = drawingManager;
        this.toolPanel.setBackground(Color.LIGHT_GRAY);
        this.toolPanel.setPreferredSize(new Dimension(36, 200));
        this.toolPanel.setLayout(new GridLayout(9, 1, 36, 36));
        setTools();
        this.toolPanel.setVisible(true);
    }

    private void setTools() {
        this.addButton(setToolButton("Img/paint-brush.png"), new Paint(this.drawingManager));
        this.addButton(setToolButton("Img/segment.png"), new Line(this.drawingManager));
        this.addButton(setToolButton("Img/eraser.png"), new Eraser(this.drawingManager));
        this.addButton(setToolButton("Img/text.png"), new Text(this.drawingManager));
        this.addButton(setToolButton("Img/Rectangle.png"), new Rectangle(this.drawingManager));
        this.addButton(setToolButton("Img/zoom.png"), new Zoom(this.drawingManager));
        this.addButton(setToolButton("Img/allocation.png"), new Allocation(this.drawingManager));
        this.addButton(setToolButton("Img/allocation-broken-line.png"), new Allocation(this.drawingManager));

        JButton saveButton = setToolButton("Img/save.png");
        saveButton.addActionListener(new SaveAsAction(drawingManager, "Save file", this.mainFrame));
        this.toolPanel.add(saveButton);

    }

    private JButton setToolButton(String fileName) {
        JButton button = new JButton(new ImageIcon(fileName));
        button.setBackground(null);
        return button;
    }

    public void addButton(JButton button, Tool tool) {

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

        ToolsPanelListener(DrawingManager drawingManager, Tool tool) {
            this.drawingManager = drawingManager;
            this.tool = tool;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            this.drawingManager.setCurrentTool(this.tool);
        }
    }

}
