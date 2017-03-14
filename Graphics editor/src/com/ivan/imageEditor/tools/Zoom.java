package com.ivan.imageEditor.tools;

import com.ivan.imageEditor.panels.DrawingManager;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

/**
 * Created by Ivan on 11.03.2017.
 */
public class Zoom implements Tool {
    private DrawingManager drawingManager;
    private Cursor cursor;
    private int zoomSize;

    public Zoom(DrawingManager drawingManager) {
        this.drawingManager = drawingManager;
        zoomSize = 1;
        setCursor();
    }

    private void setCursor() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image image = toolkit.getImage("Img/zoom.png");
        Cursor cursor = toolkit.createCustomCursor(image, new Point(0, 5), "zoom");

        this.cursor = cursor;
    }

    @Override
    public Cursor getCursor() {
        return cursor;
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

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        zoomPicture(e);

    }



    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }


    private void zoomPicture(MouseEvent event) {
        zoomSize++;

        int imageWidthBeforeChange = drawingManager.getDrawingArea().getImage().getWidth();
        int imageHeightBeforeChange = drawingManager.getDrawingArea().getImage().getHeight();

        chooseZoomSize(zoomSize);

        setScreenVisiblePart(event,imageWidthBeforeChange,imageHeightBeforeChange);
    }

    private void chooseZoomSize(int zoomSize){
        switch (zoomSize) {
            case 1:
                drawingManager.getDrawingArea().setImage(scale(drawingManager.getDrawingArea().getImage(), 0.25));
                break;
            case 2:
                drawingManager.getDrawingArea().setImage(scale(drawingManager.getDrawingArea().getImage(), 2));
                break;
            case 3:
                drawingManager.getDrawingArea().setImage(scale(drawingManager.getDrawingArea().getImage(), 2));
                this.zoomSize = 0;
                break;
        }
    }

    private void setScreenVisiblePart(MouseEvent event,int imageWidthBeforeChange,int imageHeightBeforeChange){
        int positionX = event.getX() * drawingManager.getDrawingArea().getImage().getWidth() / imageWidthBeforeChange ;
        int positionY = event.getY() * drawingManager.getDrawingArea().getImage().getHeight() / imageHeightBeforeChange ;
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        drawingManager.getDrawingArea().getDrawingAreaContentPane().getViewport().setViewPosition(
                new Point((int)(positionX - toolkit.getScreenSize().getWidth()/2),(int) (positionY - toolkit.getScreenSize().getHeight()/2)));
    }

    public BufferedImage scale(BufferedImage input, double coefficient) {
        int inW = input.getWidth();
        int inH = input.getHeight();
        int outW = (int) (inW * coefficient);
        int outH = (int) (inH * coefficient);


        BufferedImage res = new BufferedImage(outW, outH, BufferedImage.TYPE_INT_RGB);

        for (int x = 0; x < outW; x++) {
            for (int y = 0; y < outH; y++) {
                int cl = input.getRGB(x * inW / outW, y * inH / outH);
                res.setRGB(x, y, cl);
            }
        }


        return res;
    }
}
