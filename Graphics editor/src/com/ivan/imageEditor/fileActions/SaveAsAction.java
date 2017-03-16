package com.ivan.imageEditor.fileActions;

import com.ivan.imageEditor.panels.DrawingManager;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

/**
 * Created by Ivan on 11.03.2017.
 */
public class SaveAsAction extends AbstractAction {
    private DrawingManager drawingManager;

    public SaveAsAction(DrawingManager drawingManager, String name) {
        super(name);
        this.drawingManager = drawingManager;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String fileName;
        try {
            JFileChooser fileChooser = new JFileChooser();
            ImageFileFilter pngFilter = new ImageFileFilter(".png");
            ImageFileFilter jpgFilter = new ImageFileFilter(".jpg");

            fileChooser.addChoosableFileFilter(pngFilter);
            fileChooser.addChoosableFileFilter(jpgFilter);

            int result = fileChooser.showSaveDialog(null);

            if (result == JFileChooser.APPROVE_OPTION) {
                fileName = fileChooser.getSelectedFile().getAbsolutePath();

                if (fileChooser.getFileFilter() == pngFilter) {
                    ImageIO.write(drawingManager.getDrawingArea().getImage(), "png", new File(fileName + ".png"));
                } else {
                    ImageIO.write(drawingManager.getDrawingArea().getImage(), "jpeg", new File(fileName + ".jpg"));
                }
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(drawingManager.getDrawingArea(), "Input/Output Exeption");
        }
    }


}
