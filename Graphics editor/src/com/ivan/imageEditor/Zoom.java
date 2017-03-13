package com.ivan.imageEditor;

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
    private BufferedImage originalImage;
    private BufferedImage changbleImage;

    Zoom(DrawingManager drawingManager) {
        this.drawingManager = drawingManager;
        originalImage = drawingManager.getDrawingArea().getImage();
        changbleImage = drawingManager.getDrawingArea().getImage();
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

    public void setOriginalImage() {
        drawingManager.getDrawingArea().setImage(originalImage);
        zoomSize = 1;
        changbleImage = originalImage;
    }

    private void zoomPicture(MouseEvent event) {
        zoomSize++;

        int imageWidthBeforeChange = changbleImage.getTileWidth();
        int imageHeightBeforeChange = changbleImage.getHeight();

        chooseZoomSize(zoomSize);

        setScreenVisibleSize(event,imageWidthBeforeChange,imageHeightBeforeChange);
    }

    private void chooseZoomSize(int zoomSize){
        switch (zoomSize) {
            case 1:
                setOriginalImage();
                break;
            case 2:
                changbleImage = scale(changbleImage, 2);
                drawingManager.getDrawingArea().setImage(changbleImage);
                break;
            case 3:
                changbleImage = scale(changbleImage, 2);
                drawingManager.getDrawingArea().setImage(changbleImage);
                this.zoomSize = 0;
                break;
            default:
                setOriginalImage();
                this.zoomSize = 0;
                break;
        }
    }

    private void setScreenVisibleSize(MouseEvent event,int imageWidthBeforeChange,int imageHeightBeforeChange){
        int positionX = event.getX() * changbleImage.getWidth() / imageWidthBeforeChange ;
        int positionY = event.getY() * changbleImage.getHeight() / imageHeightBeforeChange ;
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
