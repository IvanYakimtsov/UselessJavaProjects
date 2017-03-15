package com.ivan.imageEditor.tools;

import com.ivan.imageEditor.panels.DrawingManager;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.regex.Pattern;

/**
 * Created by Ivan on 11.03.2017.
 */
public class Text implements Tool {

    private DrawingManager drawingManager;
    private Cursor cursor;

    private int startPositionX;

    private int positionX;
    private int positionY;


    public Text(DrawingManager drawingManager) {
        this.drawingManager = drawingManager;
        setCursor();

    }

    private void setCursor() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image image = toolkit.getImage("Img/textCursor.png");
        Cursor cursor = toolkit.createCustomCursor(image, new Point(11, 21), "text");

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
        mouseTick(event);
    }

    @Override
    public void mousePressed(MouseEvent event) {
        mouseTick(event);
    }

    private void mouseTick(MouseEvent event) {
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
        Graphics2D paint = (Graphics2D) drawingManager.getDrawingArea().getAccessoryImage().createGraphics();
        paint.setColor(Color.BLACK);
        paint.setStroke(new BasicStroke(2.0f));
        drawingManager.getDrawingArea().clearAccessoryImage();
        paint.drawRect(startPositionX - 2, positionY - 3 * drawingManager.getSize(), positionX - startPositionX + 4, 4 * drawingManager.getSize());
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

        boolean isInputValid = (e.getKeyCode() != KeyEvent.VK_BACK_SPACE && e.getKeyCode() != KeyEvent.VK_CONTROL
                && e.getKeyCode() != KeyEvent.VK_DELETE && e.getKeyCode() != KeyEvent.VK_SHIFT &&
                e.getKeyCode() != KeyEvent.VK_ENTER );

        if (isInputValid) {
            Graphics2D paint = (Graphics2D) drawingManager.getDrawingArea().getImage().createGraphics();
            paint.setColor(drawingManager.getColor());
            paint.setStroke(new BasicStroke(2.0f));

            double spaceIndex = 2;
            if (Character.isUpperCase(e.getKeyChar())) spaceIndex *= 1.2;
            if (e.getKeyChar() == 'l' || e.getKeyChar() == 'f') spaceIndex *= 0.7;
            if (e.getKeyChar() == 'w' || e.getKeyChar() == 'W') spaceIndex *= 1.2;
            if (e.getKeyChar() == '@' || e.getKeyChar() == '%') spaceIndex *= 1.5;
            if (e.getKeyChar() == 'i' || e.getKeyChar() == 'I') spaceIndex *= 0.7;

            paint.setFont(new Font("Arial", 0, drawingManager.getSize() * 3));
            paint.drawString(Character.toString(e.getKeyChar()), positionX, positionY);
            positionX += drawingManager.getSize() * spaceIndex;
            paint();
            drawingManager.getDrawingArea().requestFocus();
        }

        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            drawingManager.getDrawingArea().clearAccessoryImage();
            drawingManager.getDrawingArea().repaint();
            drawingManager.getDrawingArea().transferFocus();
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        drawingManager.getDrawingArea().requestFocus();
    }
}

