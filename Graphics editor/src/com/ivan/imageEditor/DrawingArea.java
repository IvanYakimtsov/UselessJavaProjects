package com.ivan.imageEditor;

import javafx.stage.Screen;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;


/**
 * Created by Ivan on 01.03.2017.
 */
public class DrawingArea extends JPanel {

    private BufferedImage image;
    private BufferedImage accessoryImage;


    DrawingArea() {

        this.setBackground(Color.white);
        this.setVisible(true);
        setImage();

    }

    private void setImage() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.image = new BufferedImage((int) screenSize.getWidth() - 35, (int) screenSize.getHeight() - 145, BufferedImage.TYPE_INT_RGB);
        this.accessoryImage = new BufferedImage((int) screenSize.getWidth() - 35, (int) screenSize.getHeight() - 145, BufferedImage.TYPE_INT_ARGB);

        Graphics2D gd2 = (Graphics2D) image.createGraphics();
        gd2.setColor(Color.white);
        gd2.fillRect(0, 0, (int) screenSize.getWidth(), (int) screenSize.getHeight());


        gd2 = (Graphics2D) accessoryImage.createGraphics();
        gd2.setBackground(new Color(0, 0, 0, 0));

    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
        g.drawImage(accessoryImage, 0, 0, this);
    }

    public void clearAccessoryImage() {
        Graphics2D g2d = (Graphics2D) accessoryImage.createGraphics();
        g2d.setBackground(new Color(0, 0, 0, 0));
        g2d.clearRect(0, 0, image.getWidth(), image.getHeight());


    }

    public void clear() {
        clearAccessoryImage();
        Graphics2D g2d = (Graphics2D) image.createGraphics();
        g2d.setBackground(Color.WHITE);
        g2d.clearRect(0, 0, image.getWidth(), image.getHeight());
    }


    public BufferedImage getImage() {
        return image;
    }

    public BufferedImage getAccessoryImage() {
        return accessoryImage;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }


}
