package com.ivan.imageEditor.tools;

import com.ivan.imageEditor.panels.DrawingManager;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 * Created by Ivan on 06.03.2017.
 */
public class Line implements Tool {

    private boolean isPressed;
    private int startXposition;
    private int startYposition;
    private DrawingManager drawingManager;
    private Cursor cursor;


    public Line(DrawingManager drawingManager) {
        this.drawingManager = drawingManager;
        setCursor();
        this.isPressed = false;
    }

    private void setCursor() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image image = toolkit.getImage("Img/segment.png");
        Cursor cursor = toolkit.createCustomCursor(image, new Point(2, 28), "rectangle");

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
            paint.setStroke(new BasicStroke(drawingManager.getSize() * 1.0f));
            paint.setColor(drawingManager.getColor());
            paint.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);

            paintLine(paint, event);

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
        paint.setStroke(new BasicStroke(drawingManager.getSize() * 1.0f));
        paint.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON); //сглаживание
        paintLine(paint, event);
        drawingManager.getDrawingArea().repaint();
    }


    private void paintLine(Graphics2D paint, MouseEvent event) {

        paint.drawLine(event.getX(), event.getY(), startXposition, startYposition);
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
