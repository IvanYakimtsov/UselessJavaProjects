package com.ivan.imageEditor;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

/**
 * Created by Ivan on 11.03.2017.
 */
public class SaveAsAction extends AbstractAction {
    private DrawingManager drawingManager;
    private JFrame mainFrame;

    SaveAsAction(DrawingManager drawingManager, String name, JFrame mainFrame) {
        super(name);
        this.drawingManager = drawingManager;
        this.mainFrame = mainFrame;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String fileName;
        try {
            JFileChooser fileChooser = new JFileChooser();
            // Создаем фильтры для файлов
            ImageFileFilter pngFilter = new ImageFileFilter(".png");
            ImageFileFilter jpgFilter = new ImageFileFilter(".jpg");
            // Добавляем фильтры
            fileChooser.addChoosableFileFilter(pngFilter);
            fileChooser.addChoosableFileFilter(jpgFilter);

            int result = fileChooser.showSaveDialog(null);

            if (result == JFileChooser.APPROVE_OPTION) {
                fileName = fileChooser.getSelectedFile().getAbsolutePath();

                // Смотрим какой фильтр выбран
                if (fileChooser.getFileFilter() == pngFilter) {
                    ImageIO.write(drawingManager.getDrawingArea().getImage(), "png", new File(fileName + ".png"));
                } else {
                    ImageIO.write(drawingManager.getDrawingArea().getImage(), "jpeg", new File(fileName + ".jpg"));
                }
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(mainFrame, "Ошибка ввода-вывода");
        }
    }


}
