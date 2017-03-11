package com.ivan.imageEditor;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 * Created by Ivan on 11.03.2017.
 */
public class Text implements Tool {

    DrawingManager drawingManager;
    Cursor cursor;
    int startPositionX;

    int positionX;
    int positionY;


    Text(DrawingManager drawingManager) {
        this.drawingManager = drawingManager;
        setCursor();

    }

    private void setCursor() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image image = toolkit.getImage("Img/text.png");
        Cursor cursor = toolkit.createCustomCursor(image, new Point(0, 8), "text");

        this.cursor = cursor;


    }

    @Override
    public void mouseDragged(MouseEvent event) {


    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }


    @Override
    public void mouseClicked(MouseEvent event) {
        drawingManager.getDrawingArea().requestFocus();
        positionX = event.getX();
        positionY = event.getY();
        startPositionX = event.getX();
        paint();
    }

    @Override
    public void mousePressed(MouseEvent event) {
        drawingManager.getDrawingArea().requestFocus();
        positionX = event.getX();
        positionY = event.getY();
        startPositionX = event.getX();
        paint();
    }

    @Override
    public void mouseReleased(MouseEvent event) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        drawingManager.getDrawingArea().requestFocus();
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }


    private void paint() {
        Graphics2D paint = (Graphics2D)drawingManager.getDrawingArea().getAccessoryImage().createGraphics();
        paint.setColor(Color.BLACK);
        paint.setStroke(new  BasicStroke(2.0f));
        drawingManager.getDrawingArea().clearAccessoryImage();
        paint.drawRect(startPositionX-2,positionY-15*drawingManager.getSize(),positionX-startPositionX+4,20*drawingManager.getSize());
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
        Graphics2D paint = (Graphics2D)drawingManager.getDrawingArea().getImage().createGraphics();
        paint.setColor(drawingManager.getColor());
        paint.setStroke(new  BasicStroke(2.0f));

        String str = "";
        str+=e.getKeyChar();
        paint.setFont(new  Font("Arial", 0,drawingManager.getSize()* 15));
        paint.drawString(str,positionX,positionY);
        positionX+=drawingManager.getSize()*10;
        paint();
        drawingManager.getDrawingArea().requestFocus();


    }

    @Override
    public void keyReleased(KeyEvent e) {
        drawingManager.getDrawingArea().requestFocus();
    }
}

