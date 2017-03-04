package com.ivan.imageEditor;

import javax.swing.*;
import java.awt.*;


/**
 * Created by Ivan on 01.03.2017.
 */
public class DrawingArea  {

    JPanel drawingArea;


    DrawingArea(){

        this.drawingArea = new JPanel();
        this.drawingArea.setBackground(Color.white);
        this.drawingArea.setVisible(true);



    }

    public JPanel getDrawingArea() {
        return drawingArea;
    }

}
