package com.ivan.imageEditor;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 * Created by Ivan on 06.03.2017.
 */
public class Line implements Tool{

    boolean isPressed;
    int startXposition;
    int startYposition;
    DrawingManager drawingManager;
    Cursor cursor;


    Line(DrawingManager drawingManager) {
        this.drawingManager = drawingManager;
        setCursor();

    }

    private void setCursor(){
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image image = toolkit.getImage("Img/segment.png");
        Cursor cursor = toolkit.createCustomCursor(image,new Point(2,28) , "rectangle");

        this.cursor = cursor;
        this.isPressed = false;

    }

    @Override
    public void mouseDragged(MouseEvent event) {

        if(!isPressed){
            startXposition = event.getX();
            startYposition = event.getY();
        }

        isPressed = true;
        paint(event);

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }


    @Override
    public void mouseClicked(MouseEvent event) {

    }

    @Override
    public void mousePressed(MouseEvent event) {

    }


    public void mouseReleased(MouseEvent event) {

        if(isPressed){
            isPressed = false;
            Graphics2D paint = (Graphics2D)drawingManager.getDrawingArea().getImage().createGraphics();
            paint.setStroke(new  BasicStroke(drawingManager.getSize()*4.0f));
            paint.setColor(drawingManager.getColor());

            paintLine(paint,event);

            drawingManager.getDrawingArea().clearAccessoryImage();
            drawingManager.getDrawingArea().repaint();
        }

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }


    private void paint(MouseEvent event){

        Graphics2D paint = (Graphics2D)drawingManager.getDrawingArea().getAccessoryImage().createGraphics();
        paint.setColor(drawingManager.getColor());
        drawingManager.getDrawingArea().clearAccessoryImage();
        paint.setStroke(new  BasicStroke(drawingManager.getSize()*4.0f));
        paintLine(paint,event);
        drawingManager.getDrawingArea().repaint();
    }


    private void paintLine(Graphics2D paint, MouseEvent event) {

        paint.drawLine(event.getX(),event.getY(),startXposition,startYposition);
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
