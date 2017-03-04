package com.ivan.imageEditor;

import javax.swing.*;
import java.awt.*;


/**
 * Created by Ivan on 28.02.2017.
 */
public class DrawingManager  {

    private Tool currentTool;
    private DrawingArea drawingArea;
    private Color color;



    DrawingManager(){


        drawingArea = new DrawingArea();


        this.currentTool = new Paint(this);
        color = Color.black;

        update();
    }


    public void setCurrentTool(Tool currentTool) {

       // this.drawingArea.removeMouseListener(this.currentTool);
        this.drawingArea.getDrawingArea().removeMouseMotionListener(this.currentTool);

        this.currentTool = currentTool;

        update();

    }

    public void setCurrentColor(Color color) {
        this.color = color;
    }

    public void update(){
        this.drawingArea.getDrawingArea().addMouseListener(currentTool);
        this.drawingArea.getDrawingArea().addMouseMotionListener(currentTool);
        this.getDrawingArea().setCursor(this.currentTool.getCursor());
    }

    public Graphics getCanvas(){
        return this.drawingArea.getDrawingArea().getGraphics();
    }


    public Color getColor() {
        return color;
    }

    public JPanel getDrawingArea() {
        return drawingArea.getDrawingArea();
    }
}
