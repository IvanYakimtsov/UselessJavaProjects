package com.ivan.imageEditor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Ivan on 01.03.2017.
 */
public class ParameterPanel {


    DrawingManager drawingManager;
    JPanel parameterPanel;
    JColorChooser colorChooser;




    ParameterPanel(DrawingManager drawingManager) {
        this.drawingManager = drawingManager;
        this. parameterPanel = new JPanel();
        this. parameterPanel.setBackground(Color.LIGHT_GRAY);
        this. parameterPanel.setPreferredSize(new Dimension(400,50));
        //this.colorPanel.setLayout(new GridLayout(1,32,0,32));

        addSizeChooser();
        addColorChooser();
        this. parameterPanel.setVisible(true);
    }

    private void addSizeChooser() {
        this.parameterPanel.add(new JLabel(new ImageIcon("Img/size.png")));
        this.parameterPanel.add(setSizeButton("Img/one.png",1));
        this.parameterPanel.add(setSizeButton("Img/two.png",2));
        this.parameterPanel.add(setSizeButton("Img/three.png",3));

        this.parameterPanel.add(new JLabel("              "));
    }

    private JButton setSizeButton(String fileName,int size){
        JButton sizeButton = new JButton(new ImageIcon(fileName));
        sizeButton.setBackground(null);
        sizeButton.addActionListener(new SizeButtonListener(size));
        return sizeButton;
    }


    private void addColorChooser(){

      JButton colorChooserButton = new JButton(new ImageIcon("Img/swatch.png"));
      colorChooserButton.setBackground(null);

      JPanel colorPanel = new JPanel();
      colorPanel.setBackground(Color.BLACK);

      setColorChooser(colorChooserButton,colorPanel);

      this.parameterPanel.add(colorChooserButton);
      this.parameterPanel.add(colorPanel);
  }

  private void setColorChooser(JButton colorChooserButton, JPanel colorPanel){
      colorChooser = new JColorChooser();

      colorChooserButton.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              JDialog colorChooserDialog = JColorChooser.createDialog(null,"Pick A Color",false,colorChooser,
                    new ColorChooserOkButtonListener(),null);

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
        return  parameterPanel;
    }

   private class SizeButtonListener implements ActionListener{
      private int size;
      SizeButtonListener(int size){
          this.size = size;
      }

       @Override
       public void actionPerformed(ActionEvent e) {
           drawingManager.setSize(this.size);
       }
   }


    //---------------------------------------------------------------------------------------------------





}
