package com.ivan.imageEditor;

import java.awt.*;


/**
 * Created by Ivan on 28.02.2017.
 */
public class DrawingManager  {

    private Tool currentTool;
    private DrawingArea drawingArea;
    private Color color;
    private int size;



    DrawingManager(){


        drawingArea = new DrawingArea();


        this.currentTool = new Paint(this);
        color = Color.black;
        size = 1;

        update();
    }


    public void setCurrentTool(Tool currentTool) {

        this.drawingArea.removeMouseListener(this.currentTool);
        this.drawingArea.removeMouseMotionListener(this.currentTool);
        this.drawingArea.removeKeyListener(this.currentTool);

        this.currentTool = currentTool;

        update();

    }

    public void setCurrentColor(Color color) {
        this.color = color;
    }

    public void update(){
        this.drawingArea.addMouseListener(currentTool);
        this.drawingArea.addMouseMotionListener(currentTool);
        this.drawingArea.addKeyListener(this.currentTool);
        this.getDrawingArea().setCursor(this.currentTool.getCursor());
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
