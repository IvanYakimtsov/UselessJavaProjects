package com.ivan.imageEditor.panels;

import com.ivan.imageEditor.panels.DrawingArea;
import com.ivan.imageEditor.tools.Tool;

import java.awt.*;


/**
 * Created by Ivan on 28.02.2017.
 */
public class DrawingManager {

    private Tool currentTool;
    private DrawingArea drawingArea;
    private Color color;
    private int size;


    public DrawingManager() {


        drawingArea = new DrawingArea();


        this.currentTool = new com.ivan.imageEditor.tools.Paint(this);
        color = Color.black;
        size = 5;

        update();
    }


    public void setCurrentTool(Tool currentTool) {

        this.drawingArea.removeMouseListener(this.currentTool);
        this.drawingArea.removeMouseMotionListener(this.currentTool);
        this.drawingArea.removeKeyListener(this.currentTool);

        this.drawingArea.clearAccessoryImage();
        this.drawingArea.repaint();


        this.currentTool = currentTool;

        update();

    }

    public void setCurrentColor(Color color) {
        this.color = color;
    }

    public void update() {
        this.drawingArea.addMouseListener(currentTool);
        this.drawingArea.addMouseMotionListener(currentTool);
        this.drawingArea.addKeyListener(this.currentTool);
        this.getDrawingArea().setCursor(this.currentTool.getCursor());



        this.drawingArea.repaint();
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Color getColor() {
        return color;
    }

    public DrawingArea getDrawingArea() {
        return this.drawingArea;
    }

    public int getSize() {
        return size;
    }
}
