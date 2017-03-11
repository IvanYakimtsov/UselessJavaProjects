package com.ivan.imageEditor;


import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;


/**
 * Created by Ivan on 01.03.2017.
 */
public class DrawingArea extends JPanel {

    private BufferedImage image;
    private BufferedImage accessoryImage;
    private JScrollPane drawingAreaContentPane;




    public JScrollPane getDrawingAreaContentPane() {
        return drawingAreaContentPane;
    }

    DrawingArea() {

        this.setBackground(Color.white);
        this.setVisible(true);

        setImage();

        this.setPreferredSize(new Dimension(image.getWidth(),image.getHeight()));


        drawingAreaContentPane = new JScrollPane(this,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);



    }

    private void setImage() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.image = new BufferedImage((int) screenSize.getWidth() - 40, (int) screenSize.getHeight() - 148, BufferedImage.TYPE_INT_RGB);

        setAccessoryImage(image.getWidth(),image.getHeight());
    }

    private void setAccessoryImage(int width,int height){
        this.accessoryImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        Graphics2D gd2 = (Graphics2D) image.createGraphics();
        gd2.setColor(Color.white);
        gd2.fillRect(0, 0, width, height);


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
        g2d.clearRect(0, 0, accessoryImage.getWidth(), accessoryImage.getHeight());


    }

    public void clear() {
        setImage();
        this.setSize(new Dimension(image.getWidth(),image.getHeight()));
        this.setPreferredSize(new Dimension(image.getWidth(),image.getHeight()));

        setAccessoryImage(image.getWidth(),image.getHeight());
        repaint();
    }


    public BufferedImage getImage() {
        return image;
    }

    public BufferedImage getAccessoryImage() {
        return accessoryImage;
    }

    public void setImage(BufferedImage image) {
        this.setSize(new Dimension(image.getWidth(),image.getHeight()));
        this.setPreferredSize(new Dimension(image.getWidth(),image.getHeight()));

        setAccessoryImage(image.getWidth(),image.getHeight());

        this.image = image;

        repaint();
    }


}
