package com.ivan.imageEditor.tools;

import com.ivan.imageEditor.panels.DrawingManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ivan on 14.03.2017.
 */
public class BrokenLineAllocation implements Tool {
    private boolean isPressed;
    private int lastXposition;
    private int lastYposition;
    private DrawingManager drawingManager;
    private Point startPosition;
    private Polygon bufferedAreaPoligon;
    private BufferedImage bufferedArea;
    private List<Integer> xPoints;
    private List<Integer> yPoints;
    private Point copyPoint;
    private boolean isAreaChoosen;
    private JPopupMenu popMenu;


    public BrokenLineAllocation(DrawingManager drawingManager) {
        this.drawingManager = drawingManager;

        xPoints = new ArrayList<>(0);
        yPoints = new ArrayList<>(0);
        isAreaChoosen = false;
        setPopMenu();
    }

    private void setPopMenu() {
        popMenu = new JPopupMenu();

        JMenuItem copyItem = new JMenuItem("Copy");
        BrokenLineAllocation that = this;
        copyItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                that.copyAction();
            }
        });

        JMenuItem pasteItem = new JMenuItem("Paste");

        pasteItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                that.pasteAction();
            }
        });

        popMenu.add(copyItem);
        popMenu.add(pasteItem);
    }


    @Override
    public void mouseDragged(MouseEvent event) {
        if (!SwingUtilities.isRightMouseButton(event)) {
            if (!isPressed) {
                lastXposition = event.getX();
                lastYposition = event.getY();
                isPressed = true;
            }
            if (!isAreaChoosen) paint(event);
            lastXposition = event.getX();
            lastYposition = event.getY();
        }
    }

    private void allocateArea(MouseEvent event) {
        if (!isAreaChoosen) {
            Graphics2D paint = (Graphics2D) drawingManager.getDrawingArea().getAccessoryImage().createGraphics();
            paint.setStroke(new BasicStroke(1.0f));
            paint.setColor(Color.BLACK);
            paint.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
            paint.drawLine(event.getX(), event.getY(), (int) startPosition.getX(), (int) startPosition.getY());
            paint.drawLine(lastXposition, lastYposition, event.getX(), event.getY());
            drawingManager.getDrawingArea().repaint();
        }
        isAreaChoosen = true;
        validateAreaCoordinates();

        bufferedAreaPoligon = new Polygon(getPointsArray(xPoints), getPointsArray(yPoints), xPoints.size());

    }

    private int[] getPointsArray(List<Integer> integers) {
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
        drawingManager.getDrawingArea().requestFocus();
        if (event.getButton() != MouseEvent.BUTTON3) {
            updateInitialParametrs(event);
        }

        if (event.getButton() == MouseEvent.BUTTON3) {
            copyPoint = new Point(event.getX(), event.getY());
            popMenu.show(drawingManager.getDrawingArea(), event.getX(), event.getY());
        }
    }


    private void updateInitialParametrs(MouseEvent event) {
        resetAreaAllocation();
        startPosition = new Point(event.getX(), event.getY());
        xPoints.add(event.getX());
        yPoints.add(event.getY());
    }


    public void mouseReleased(MouseEvent event) {
        if (event.getButton() != MouseEvent.BUTTON3) allocateArea(event);
        isPressed = false;

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
        paint.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
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
        if ((e.getKeyCode() == KeyEvent.VK_C) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
            copyAction();
        }


        if ((e.getKeyCode() == KeyEvent.VK_Z) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
            resetAreaAllocation();
        }


        if ((e.getKeyCode() == KeyEvent.VK_V) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
            pasteAction();
        }
    }

    private void resetAreaAllocation() {
        drawingManager.getDrawingArea().clearAccessoryImage();
        drawingManager.getDrawingArea().repaint();
        isAreaChoosen = false;
        xPoints.clear();
        yPoints.clear();
    }

    private void copyAction() {
        if (isAreaChoosen) {
            drawingManager.getDrawingArea().clearAccessoryImage();
            drawingManager.getDrawingArea().repaint();
            isAreaChoosen = false;
            copyPartOfImage();
            xPoints.clear();
            yPoints.clear();
        }
    }

    private void pasteAction() {
        if (bufferedArea != null) {
            pastPartOfImage();
            drawingManager.getDrawingArea().repaint();
        }
    }


    private void copyPartOfImage() {
        Rectangle2D poligonBounds = bufferedAreaPoligon.getBounds2D();
        Color unvisibleColor = new Color(0, 0, 0, 0);

        bufferedArea = new BufferedImage((int) poligonBounds.getWidth(), (int) poligonBounds.getHeight(), BufferedImage.TYPE_INT_ARGB);


        for (int x = (int) poligonBounds.getX(); x < (int) poligonBounds.getX() + poligonBounds.getWidth(); x++)
            for (int y = (int) poligonBounds.getY(); y < (int) poligonBounds.getY() + poligonBounds.getHeight(); y++) {
                if (bufferedAreaPoligon.contains(x, y)) {
                    int cl = drawingManager.getDrawingArea().getImage().getRGB(x, y);
                    bufferedArea.setRGB((int) (x - poligonBounds.getX()), (int) (y - poligonBounds.getY()), cl);
                } else
                    bufferedArea.setRGB((int) (x - poligonBounds.getX()), (int) (y - poligonBounds.getY()), unvisibleColor.getRGB());


            }


    }

    private void validateAreaCoordinates() {
        for (int index = 0; index < xPoints.size(); index++) {
            if (xPoints.get(index) < 0) xPoints.set(index, 0);
            if (xPoints.get(index) > drawingManager.getDrawingArea().getImage().getWidth())
                xPoints.set(index, drawingManager.getDrawingArea().getImage().getWidth());

            if (yPoints.get(index) < 0) yPoints.set(index, 0);
            if (yPoints.get(index) > drawingManager.getDrawingArea().getImage().getHeight())
                yPoints.set(index, drawingManager.getDrawingArea().getImage().getHeight());
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