package com.ivan.imageEditor.tools;

import com.ivan.imageEditor.panels.DrawingManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Created by Ivan on 14.03.2017.
 */
public class brokenLineAllocation implements Tool {
    private boolean isPressed;
    private int lastXposition;
    private int lastYposition;
    private DrawingManager drawingManager;

    private Point startPosition;
    private final int RADIUS = 25;
    private Polygon bufferedAreaPoligon;
    private BufferedImage bufferedArea;

    private ArrayList<Integer> xPoints;
    private ArrayList<Integer> yPoints;
    private Point copyPoint;

    private boolean isAreaChoosen;
    private boolean isLeavedInitialArea;
    private boolean isInitialPointExist;


    public brokenLineAllocation(DrawingManager drawingManager) {
        this.drawingManager = drawingManager;

        xPoints = new ArrayList<>(0);
        yPoints = new ArrayList<>(0);
        isAreaChoosen = false;
        isLeavedInitialArea = false;
        isInitialPointExist = false;

    }


    @Override
    public void mouseDragged(MouseEvent event) {
        if (!SwingUtilities.isRightMouseButton(event)) {
            if (!isPressed) {
                lastXposition = event.getX();
                lastYposition = event.getY();
                isPressed = true;
            }
            if (startPosition != null && !(Math.abs(event.getX() - startPosition.getX()) < RADIUS && Math.abs(event.getY() - startPosition.getY()) < RADIUS)) {
                isLeavedInitialArea = true;
            } else if (startPosition != null &&
                    (Math.abs(event.getX() - startPosition.getX()) < RADIUS && Math.abs(event.getY() - startPosition.getY()) < RADIUS) &&
                    (isLeavedInitialArea)) allocateArea(event);

            if (!isAreaChoosen) {
                paint(event);
                lastXposition = event.getX();
                lastYposition = event.getY();
            }
        }
    }

    private void allocateArea(MouseEvent event) {
        if (!isAreaChoosen) {
            Graphics2D paint = (Graphics2D) drawingManager.getDrawingArea().getAccessoryImage().createGraphics();
            paint.setStroke(new BasicStroke(1.0f));
            paint.setColor(Color.BLACK);
            paint.drawLine(event.getX(), event.getY(), (int) startPosition.getX(), (int) startPosition.getY());
            paint.drawLine(lastXposition, lastYposition, event.getX(), event.getY());
            drawingManager.getDrawingArea().repaint();
        }
        isAreaChoosen = true;
        drawingManager.getDrawingArea().requestFocus();
        bufferedAreaPoligon = new Polygon(getPointsArray(xPoints), getPointsArray(yPoints), xPoints.size());
    }

    private int[] getPointsArray(ArrayList<Integer> integers) {
        int[] ret = new int[integers.size()];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = integers.get(i).intValue();
        }
        return ret;
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }


    @Override
    public void mouseClicked(MouseEvent event) {
        mousePressed(event);
    }

    @Override
    public void mousePressed(MouseEvent event) {
        if (!isInitialPointExist && (event.getButton() != MouseEvent.BUTTON3)) {
            startPosition = new Point(event.getX(), event.getY());
            xPoints.add(event.getX());
            yPoints.add(event.getY());
            Graphics2D paint = (Graphics2D) drawingManager.getDrawingArea().getAccessoryImage().createGraphics();
            paint.setStroke(new BasicStroke(5.0f));
            paint.setColor(Color.BLACK);
            paint.draw(new Ellipse2D.Double(event.getX() - RADIUS / 2, event.getY() - RADIUS / 2, RADIUS, RADIUS));
            drawingManager.getDrawingArea().repaint();
            isInitialPointExist = true;
            lastXposition = event.getX();
            lastYposition = event.getY();
            isPressed = true;
        }

        if (event.getButton() == MouseEvent.BUTTON3) {
            copyPoint = new Point(event.getX(), event.getY());
        }
    }


    public void mouseReleased(MouseEvent event) {
        if (isAreaChoosen) {
            isPressed = false;
            startPosition = null;
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }


    private void paint(MouseEvent event) {
        xPoints.add(event.getX());
        yPoints.add(event.getY());
        Graphics2D paint = (Graphics2D) drawingManager.getDrawingArea().getAccessoryImage().createGraphics();
        paint.setStroke(new BasicStroke(1.0f));
        paint.setColor(Color.BLACK);

        paint.drawLine(event.getX(), event.getY(), event.getX(), event.getY());

        if (isPressed) {
            paint.drawLine(lastXposition, lastYposition, event.getX(), event.getY());
        }
        drawingManager.getDrawingArea().repaint();

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
        if (isAreaChoosen) {
            if ((e.getKeyCode() == KeyEvent.VK_C) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
                drawingManager.getDrawingArea().clearAccessoryImage();
                drawingManager.getDrawingArea().repaint();
                isAreaChoosen = false;
                isLeavedInitialArea = false;
                isInitialPointExist = false;
                copyPartOfImage();
                xPoints.clear();
                yPoints.clear();


            }

        }


        if ((e.getKeyCode() == KeyEvent.VK_V) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
            if (bufferedArea != null) {
                pastPartOfImage();
                drawingManager.getDrawingArea().repaint();
            }
        }
    }


    private void copyPartOfImage() {
        Rectangle2D poligonBounds = bufferedAreaPoligon.getBounds2D();
        Color unvisibleColor = new Color(0, 0, 0, 0);

        bufferedArea = new BufferedImage((int) poligonBounds.getWidth(), (int) poligonBounds.getHeight(), BufferedImage.TYPE_INT_ARGB);


        for (int x = (int) poligonBounds.getX(); x <(int) poligonBounds.getX()+ poligonBounds.getWidth(); x++)
            for (int y = (int) poligonBounds.getY(); y <(int) poligonBounds.getY() + poligonBounds.getHeight(); y++) {
                if (bufferedAreaPoligon.contains(x, y)) {
                    int cl = drawingManager.getDrawingArea().getImage().getRGB(x, y);
                    bufferedArea.setRGB((int) (x - poligonBounds.getX()), (int) (y - poligonBounds.getY()), cl);
                 } else
                     bufferedArea.setRGB((int) (x - poligonBounds.getX()), (int) (y - poligonBounds.getY()),unvisibleColor.getRGB());


            }



    }

    private void pastPartOfImage() {
        drawingManager.getDrawingArea().getImage().createGraphics().drawImage(bufferedArea, null,
                (int) copyPoint.getX() - bufferedArea.getWidth() / 2,
                (int) copyPoint.getY() - bufferedArea.getHeight() / 2);
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}