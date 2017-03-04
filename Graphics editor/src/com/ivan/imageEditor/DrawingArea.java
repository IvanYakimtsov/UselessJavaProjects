package com.ivan.imageEditor;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;


/**
 * Created by Ivan on 01.03.2017.
 */
public class DrawingArea  {

    JPanel drawingArea;
    BufferedImage image;


    DrawingArea(){

        this.drawingArea = new JPanel();
        this.drawingArea.setBackground(Color.white);
        this.drawingArea.setVisible(true);


       // this.image = new BufferedImage(drawingArea.getWidth(),drawingArea.getHeight(),BufferedImage.TYPE_INT_RGB);

    }

    public JPanel getDrawingArea() {
        return drawingArea;
    }

}
