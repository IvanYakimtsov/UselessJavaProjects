package com.ivan.imageEditor;

import com.sun.deploy.security.ValidationState;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

/**
 * Created by Ivan on 12.03.2017.
 */
public class Allocation implements Tool {
    private boolean isPressed;
    private int startXposition;
    private int startYposition;
    private DrawingManager drawingManager;
    private Point[] areaCoordinates = new Point[2];
    private Point copyPoint;
    private BufferedImage bufferedArea;


    Allocation(DrawingManager drawingManager) {
        this.drawingManager = drawingManager;
        this.isPressed = false;
        this.copyPoint = new Point(0, 0);

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
        if (event.getButton() == MouseEvent.BUTTON3) {
            copyPoint.setLocation(event.getX(), event.getY());
        }

    }

    @Override
    public void mousePressed(MouseEvent event) {
        if (event.getButton() == MouseEvent.BUTTON3) {
            copyPoint.setLocation(event.getX(), event.getY());
        }
    }


    @Override
    public void mouseReleased(MouseEvent event) {
        if (isPressed) {
            isPressed = false;
            Graphics2D paint = (Graphics2D) drawingManager.getDrawingArea().getAccessoryImage().createGraphics();
            paint.setStroke(new BasicStroke(1.0f));
            paint.setColor(Color.BLACK);

            paintRect(paint, event);


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
        paint.setColor(Color.BLACK);
        drawingManager.getDrawingArea().clearAccessoryImage();
        paint.setStroke(new BasicStroke(1.0f));
        paintRect(paint, event);
        drawingManager.getDrawingArea().repaint();
    }


    private void paintRect(Graphics2D paint, MouseEvent event) {

        if (event.getX() > startXposition && event.getY() > startYposition) {
            paint.drawRect(startXposition, startYposition, event.getX() - startXposition, event.getY() - startYposition);
            areaCoordinates[0] = new Point(startXposition, startYposition);
            areaCoordinates[1] = new Point(event.getX(), event.getY());
        } else if (event.getX() < startXposition && event.getY() < startYposition) {
            paint.drawRect(event.getX(), event.getY(), startXposition - event.getX(), startYposition - event.getY());
            areaCoordinates[0] = new Point(event.getX(), event.getY());
            areaCoordinates[1] = new Point(startXposition, startYposition);
        } else if (event.getX() > startXposition && event.getY() < startYposition) {
            paint.drawRect(startXposition, event.getY(), event.getX() - startXposition, startYposition - event.getY());
            areaCoordinates[0] = new Point(startXposition, event.getY());
            areaCoordinates[1] = new Point(event.getX(), startYposition);
        } else if (event.getX() < startXposition && event.getY() > startYposition) {
            paint.drawRect(event.getX(), startYposition, startXposition - event.getX(), event.getY() - startYposition);
            areaCoordinates[0] = new Point(event.getX(), startYposition);
            areaCoordinates[1] = new Point(startXposition, event.getY());
        }

        drawingManager.getDrawingArea().requestFocus();
    }


    @Override
    public Cursor getCursor() {
        return null;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if ((e.getKeyCode() == KeyEvent.VK_C) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
            if (areaCoordinates[1] != null) {


                drawingManager.getDrawingArea().clearAccessoryImage();
                drawingManager.getDrawingArea().repaint();
                copyPartOfImage();

            }
        }
        if ((e.getKeyCode() == KeyEvent.VK_V) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
            passBufferedArea();
        }
    }

    private void copyPartOfImage() {
        bufferedArea = new BufferedImage((int) Math.abs(areaCoordinates[0].getX() - areaCoordinates[1].getX()),
                (int) Math.abs(areaCoordinates[0].getY() - areaCoordinates[1].getY()), BufferedImage.TYPE_INT_RGB);

        int startCoordX = 0;
        int stopCoordX = 0;
        int startCoordY = 0;
        int stopCoordY = 0;

        if ((int) areaCoordinates[0].getX() < (int) areaCoordinates[1].getX()) {
            startCoordX = (int) areaCoordinates[0].getX();
            stopCoordX = (int) areaCoordinates[1].getX();
        } else {
            startCoordX = (int) areaCoordinates[1].getX();
            stopCoordX = (int) areaCoordinates[0].getX();
        }

        if ((int) areaCoordinates[0].getY() < (int) areaCoordinates[1].getY()) {
            startCoordY = (int) areaCoordinates[0].getY();
            stopCoordY = (int) areaCoordinates[1].getY();
        } else {
            startCoordY = (int) areaCoordinates[1].getY();
            stopCoordY = (int) areaCoordinates[0].getY();
        }


        int bufferedAreaXCoord = -1;
        int bufferedAreaYCoord = -1;


        for (int x = startCoordX; x < stopCoordX; x++) {
            bufferedAreaXCoord++;
            for (int y = startCoordY; y < stopCoordY; y++) {
                bufferedAreaYCoord++;

                int cl = drawingManager.getDrawingArea().getImage().getRGB(x, y);
                bufferedArea.setRGB(bufferedAreaXCoord, bufferedAreaYCoord, cl);

            }
            bufferedAreaYCoord = -1;
        }
    }

    private void passBufferedArea() {
        if (bufferedArea != null) {

            int bufferedAreaXCoord = -1;
            int bufferedAreaYCoord = -1;

            int stopCoordX = 0;
            int stopCoordY = 0;

            if ((int) copyPoint.getX() + bufferedArea.getWidth() > drawingManager.getDrawingArea().getImage().getWidth())
                stopCoordX = drawingManager.getDrawingArea().getImage().getWidth();
            else stopCoordX = (int) copyPoint.getX() + bufferedArea.getWidth();

            if ((int) copyPoint.getY() + bufferedArea.getHeight() > drawingManager.getDrawingArea().getImage().getHeight())
                stopCoordY = drawingManager.getDrawingArea().getImage().getHeight();
            else stopCoordY = (int) (int) copyPoint.getY() + bufferedArea.getHeight();

            for (int x = (int) copyPoint.getX(); x < stopCoordX; x++) {
                bufferedAreaXCoord++;
                for (int y = (int) copyPoint.getY(); y < stopCoordY; y++) {
                    bufferedAreaYCoord++;
                    int cl = bufferedArea.getRGB(bufferedAreaXCoord, bufferedAreaYCoord);
                    drawingManager.getDrawingArea().getImage().setRGB(x, y, cl);

                }
                bufferedAreaYCoord = -1;
            }
            drawingManager.getDrawingArea().repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
