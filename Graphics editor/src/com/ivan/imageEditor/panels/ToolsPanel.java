package com.ivan.imageEditor.panels;

import com.ivan.imageEditor.fileActions.SaveAsAction;
import com.ivan.imageEditor.tools.*;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Ivan on 01.03.2017.
 */
public class ToolsPanel {

    private DrawingManager drawingManager;
    private JPanel toolPanel;


    public ToolsPanel(DrawingManager drawingManager) {

        this.toolPanel = new JPanel();

        this.drawingManager = drawingManager;
        this.toolPanel.setBackground(Color.LIGHT_GRAY);
        this.toolPanel.setPreferredSize(new Dimension(36, 200));
        this.toolPanel.setLayout(new GridLayout(9, 1, 36, 36));
        setTools();
        this.toolPanel.setVisible(true);
    }

    private void setTools() {
        setButtons();
        JButton saveButton = setToolButton("Img/save.png");
        saveButton.addActionListener(new SaveAsAction(drawingManager, "Save file"));
        this.toolPanel.add(saveButton);

    }

    private void setButtons() {
        this.addButton(setToolButton("Img/paint-brush.png"), new com.ivan.imageEditor.tools.Paint(this.drawingManager));
        this.addButton(setToolButton("Img/segment.png"), new com.ivan.imageEditor.tools.Line(this.drawingManager));
        this.addButton(setToolButton("Img/eraser.png"), new com.ivan.imageEditor.tools.Eraser(this.drawingManager));
        this.addButton(setToolButton("Img/text.png"), new com.ivan.imageEditor.tools.Text(this.drawingManager));
        this.addButton(setToolButton("Img/Rectangle.png"), new com.ivan.imageEditor.tools.Rectangle(this.drawingManager));
        this.addButton(setToolButton("Img/zoom.png"), new com.ivan.imageEditor.tools.Zoom(this.drawingManager));
        this.addButton(setToolButton("Img/allocation.png"), new com.ivan.imageEditor.tools.Allocation(this.drawingManager));
        this.addButton(setToolButton("Img/allocation-broken-line.png"), new BrokenLineAllocation(this.drawingManager));
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


}
