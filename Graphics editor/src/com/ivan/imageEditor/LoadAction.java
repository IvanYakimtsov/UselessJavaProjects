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
                // при выборе изображения подстраиваем размеры формы
                // и панели под размеры данного изображения
                fileName = fileChooser.getSelectedFile().getAbsolutePath();
                File file = new File(fileName);
                fileChooser.addChoosableFileFilter(new ImageFileFilter(".png"));
                fileChooser.addChoosableFileFilter(new ImageFileFilter(".jpg"));


                drawingManager.getDrawingArea().setImage(ImageIO.read(file));
                drawingManager.getDrawingArea().repaint();
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(this.mainFrame, "Такого файла не существует");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this.mainFrame, "Исключение ввода-вывода");
            } catch (Exception ex) {
            }
        }
    }
}
