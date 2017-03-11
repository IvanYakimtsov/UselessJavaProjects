package com.ivan.imageEditor;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

/**
 * Created by Ivan on 06.03.2017.
 */
public class Rectangle implements Tool {

    boolean isPressed;
    int startXposition;
    int startYposition;
    DrawingManager drawingManager;
    Cursor cursor;


    Rectangle(DrawingManager drawingManager) {
        this.drawingManager = drawingManager;
        setCursor();
        this.isPressed = false;

    }

    private void setCursor() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image image = toolkit.getImage("Img/rectangle.png");
        Cursor cursor = toolkit.createCustomCursor(image, new Point(0, 8), "rectangle");

        this.cursor = cursor;


    }

    @Override
    public void mouseDragged(MouseEvent event) {

        if (!isPressed) {
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

    @Override
    public void mouseReleased(MouseEvent event) {
        if (isPressed) {
            isPressed = false;
            Graphics2D paint = (Graphics2D) drawingManager.getDrawingArea().getImage().createGraphics();
            paint.setStroke(new BasicStroke(drawingManager.getSize() * 4.0f));
            paint.setColor(drawingManager.getColor());

            paintRect(paint, event);

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


    private void paint(MouseEvent event) {

        Graphics2D paint = (Graphics2D) drawingManager.getDrawingArea().getAccessoryImage().createGraphics();
        paint.setColor(drawingManager.getColor());
        drawingManager.getDrawingArea().clearAccessoryImage();
        paint.setStroke(new BasicStroke(drawingManager.getSize() * 4.0f));
        paintRect(paint, event);
        drawingManager.getDrawingArea().repaint();
    }


    private void paintRect(Graphics2D paint, MouseEvent event) {

        if (event.getX() > startXposition && event.getY() > startYposition) {
            paint.drawRect(startXposition, startYposition, event.getX() - startXposition, event.getY() - startYposition);
        } else if (event.getX() < startXposition && event.getY() < startYposition) {
            paint.drawRect(event.getX(), event.getY(), startXposition - event.getX(), startYposition - event.getY());
        } else if (event.getX() > startXposition && event.getY() < startYposition) {
            paint.drawRect(startXposition, event.getY(), event.getX() - startXposition, startYposition - event.getY());
        } else if (event.getX() < startXposition && event.getY() > startYposition) {
            paint.drawRect(event.getX(), startYposition, startXposition - event.getX(), event.getY() - startYposition);
        }
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
