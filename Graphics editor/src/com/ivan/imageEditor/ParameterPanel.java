package com.ivan.imageEditor;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
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
        this.parameterPanel.setLayout(new FlowLayout());


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


        JSlider sizeChooser = new JSlider(JSlider.HORIZONTAL, 1, 20, 5);
        sizeChooser.setMajorTickSpacing(1);
        sizeChooser.setBackground(null);

        sizeChooser.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                drawingManager.setSize(sizeChooser.getValue());
            }
        });


        this.parameterPanel.add(sizeChooser);

        this.parameterPanel.add(new JLabel("              "));
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


    //---------------------------------------------------------------------------------------------------


}
