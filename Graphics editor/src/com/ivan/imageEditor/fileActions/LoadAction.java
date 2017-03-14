package com.ivan.imageEditor.fileActions;

import com.ivan.imageEditor.panels.DrawingManager;

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

    public LoadAction(DrawingManager drawingManager, String name) {
        super(name);
        this.drawingManager = drawingManager;

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
                JOptionPane.showMessageDialog(this.drawingManager.getDrawingArea(), "No File Exists");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this.drawingManager.getDrawingArea(), "Input/Output Exeption");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this.drawingManager.getDrawingArea(), "Undefined Exeption");
            }
        }
    }
}
