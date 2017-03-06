package com.ivan.imageEditor;

import javafx.stage.Screen;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;


/**
 * Created by Ivan on 01.03.2017.
 */
public class DrawingArea extends JPanel {

    BufferedImage image;

    DrawingArea(){

        this.setBackground(Color.white);
        this.setVisible(true);
        setImage();

    }

    private void setImage(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.image = new BufferedImage((int)screenSize.getWidth(),(int)screenSize.getHeight(),BufferedImage.TYPE_INT_RGB);

        Graphics2D gd2 = (Graphics2D) image.createGraphics();
        gd2.setColor(Color.white);
        gd2.fillRect(0, 0,(int)screenSize.getWidth(), (int)screenSize.getHeight());
    }


    @Override
    public void paintComponent (Graphics g){
        super.paintComponent(g);
        g.drawImage(image, 0, 0,this);
    }

    public BufferedImage getImage() {
        return image;
    }


}
