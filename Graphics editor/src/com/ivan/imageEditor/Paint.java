package com.ivan.imageEditor;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;


/**
 * Created by Ivan on 28.02.2017.
 */
public class Paint implements Tool{

    boolean isPressed;
    int lastXposition;
    int lastYposition;
    DrawingManager drawingManager;
    Cursor cursor;


    Paint(DrawingManager drawingManager) {
        this.drawingManager = drawingManager;
        setCursor();
    }

    private void setCursor(){
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image image = toolkit.getImage("Img/artistic-brush.png");
        Cursor cursor = toolkit.createCustomCursor(image,new Point(0,28) , "paint");

        this.cursor = cursor;
    }

    @Override
    public void mouseDragged(MouseEvent event) {

        if(!isPressed){
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

    }


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
        Graphics2D paint = (Graphics2D)drawingManager.getDrawingArea().getImage().createGraphics();
        paint.setStroke(new  BasicStroke(drawingManager.getSize()*4.0f));
        paint.setColor(drawingManager.getColor());

        paint.drawLine(event.getX(),event.getY(),event.getX(),event.getY());

        if(isPressed){
            paint.drawLine(lastXposition,lastYposition,event.getX(),event.getY());
        }
        drawingManager.getDrawingArea().repaint();

    }

    @Override
    public Cursor getCursor() {
        return this.cursor;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
