package com.ivan.imageEditor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by Ivan on 01.03.2017.
 */
public class ParameterPanel {


    private DrawingManager drawingManager;
    private JPanel parameterPanel;
    private JColorChooser colorChooser;
    private JDialog colorChooserDialog;


    ParameterPanel(DrawingManager drawingManager) {
        this.drawingManager = drawingManager;
        this.parameterPanel = new JPanel();
        this.parameterPanel.setBackground(Color.LIGHT_GRAY);
        this.parameterPanel.setPreferredSize(new Dimension(400, 50));


        addSizeChooser();
        addColorChooser();
        this.parameterPanel.setVisible(true);
    }

    private void addColorDialogListener() {

        colorChooserDialog.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {

            }

            @Override
            public void windowClosed(WindowEvent e) {
                colorChooserDialog.dispose();
            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                colorChooserDialog.dispose();


            }
        });
    }

    private void addSizeChooser() {
        this.parameterPanel.add(new JLabel(new ImageIcon("Img/size.png")));
        this.parameterPanel.add(setSizeButton("Img/one.png", 1));
        this.parameterPanel.add(setSizeButton("Img/two.png", 2));
        this.parameterPanel.add(setSizeButton("Img/three.png", 3));

        this.parameterPanel.add(new JLabel("              "));
    }

    private JButton setSizeButton(String fileName, int size) {
        JButton sizeButton = new JButton(new ImageIcon(fileName));
        sizeButton.setBackground(null);
        sizeButton.addActionListener(new SizeButtonListener(size));
        return sizeButton;
    }


    private void addColorChooser() {

        JButton colorChooserButton = new JButton(new ImageIcon("Img/swatch.png"));
        colorChooserButton.setBackground(null);

        JPanel colorPanel = new JPanel();
        colorPanel.setBackground(Color.BLACK);

        setColorChooser(colorChooserButton, colorPanel);

        this.parameterPanel.add(colorChooserButton);
        this.parameterPanel.add(colorPanel);
    }

    private void setColorChooser(JButton colorChooserButton, JPanel colorPanel) {
        colorChooser = new JColorChooser();


        colorChooserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                colorChooserDialog = JColorChooser.createDialog(null, "Pick A Color",
                        false, colorChooser, new ColorChooserOkButtonListener(), null);
                addColorDialogListener();
                colorChooserDialog.setVisible(true);


            }

            class ColorChooserOkButtonListener implements ActionListener {

                @Override
                public void actionPerformed(ActionEvent e) {
                    Color color = colorChooser.getColor();
                    colorChooser.setColor(color);
                    colorPanel.setBackground(color);
                    drawingManager.setCurrentColor(color);

                }
            }
        });

    }

    public JPanel getParameterPanel() {
        return parameterPanel;
    }

    private class SizeButtonListener implements ActionListener {
        private int size;

        SizeButtonListener(int size) {
            this.size = size;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            drawingManager.setSize(this.size);
        }
    }


    //---------------------------------------------------------------------------------------------------


}
