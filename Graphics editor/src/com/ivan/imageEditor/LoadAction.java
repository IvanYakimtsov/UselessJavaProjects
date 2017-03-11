package com.ivan.imageEditor;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Ivan on 11.03.2017.
 */
public class LoadAction extends AbstractAction {
    private DrawingManager drawingManager;
    private JFrame mainFrame;

    LoadAction(DrawingManager drawingManager, String name, JFrame mainFrame) {
        super(name);
        this.drawingManager = drawingManager;
        this.mainFrame = mainFrame;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String fileName;
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            try {

                fileName = fileChooser.getSelectedFile().getAbsolutePath();
                File file = new File(fileName);
                fileChooser.addChoosableFileFilter(new ImageFileFilter(".png"));
                fileChooser.addChoosableFileFilter(new ImageFileFilter(".jpg"));


                drawingManager.getDrawingArea().setImage(ImageIO.read(file));

            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(this.mainFrame, "No File Exists");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this.mainFrame, "Input/Output Exeption");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this.mainFrame, "Undefined Exeption");
            }
        }
    }
}
