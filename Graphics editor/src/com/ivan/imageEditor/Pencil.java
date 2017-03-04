package com.ivan.imageEditor;

import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * Created by Ivan on 01.03.2017.
 */
public class Pencil implements Tool{

    boolean isPressed;
    int lastXposition;
    int lastYposition;
    DrawingManager drawingManager;
    Cursor cursor;


    Pencil(DrawingManager drawingManager) {
        this.drawingManager = drawingManager;
        setCursor();
    }

    public void setCursor(){
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image image = toolkit.getImage("Img/pencil.png");
        Cursor cursor = toolkit.createCustomCursor(image,new Point(0,28) , "pencil");

        this.cursor = cursor;
    }

    @Override
    public void mouseDragged(MouseEvent event) {


            if (!isPressed) {
                lastXposition = event.getX();
                lastYposition = event.getY();
            }
            isPressed = true;
            paint(event);
            lastXposition = event.getX();
            lastYposition = event.getY();


    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }


    @Override
    public void mouseClicked(MouseEvent event) {
        paint(event);

    }

    @Override
    public void mousePressed(MouseEvent event) {
        paint(event);

    }

    @Override
    public void mouseReleased(MouseEvent event) {
        isPressed = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }


    private void paint(MouseEvent event){
        Graphics2D paint = (Graphics2D)drawingManager.getCanvas();
        paint.setColor(drawingManager.getColor());
        paint.setStroke(new  BasicStroke(1.0f));
        paint.drawLine(event.getX(),event.getY(),event.getX(),event.getY());

        if(isPressed){
            paint.drawLine(lastXposition,lastYposition,event.getX(),event.getY());
        }
    }

    @Override
    public Cursor getCursor() {
        return this.cursor;
    }


}
