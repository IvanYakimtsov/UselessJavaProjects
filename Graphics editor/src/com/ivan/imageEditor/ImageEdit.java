package com.ivan.imageEditor;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.*;

public class ImageEdit {

    private JFrame mainFrame;
    private ToolsPanel toolsPanel;
    private ParameterPanel parameterPanel;


    private DrawingManager drawingManager;

    ImageEdit() {

        drawingManager = new DrawingManager();

        toolsPanel = new ToolsPanel(drawingManager, this.mainFrame);
        parameterPanel = new ParameterPanel(drawingManager);
        setFrame();
        setCursor();

    }


    public static void main(String[] args) {

        ImageEdit imageEdit = new ImageEdit();


    }


    private void setCursor() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image image = toolkit.getImage("Img/hand.png");
        Cursor cursor = toolkit.createCustomCursor(image, new Point(16, 0), "mainCursor");

        this.mainFrame.setCursor(cursor);

    }


    private void setFrame() {
        this.mainFrame = new JFrame("ImageEditor");
        this.mainFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        addFrameListener();

        this.mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mainFrameSetPanels();


        new MenuBar(this.mainFrame, this.drawingManager);

        this.mainFrame.setVisible(true);
    }

    private void addFrameListener() {
        this.mainFrame.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                Object[] options = {"Да", "Нет!"};
                int n = JOptionPane
                        .showOptionDialog(e.getWindow(), "Закрыть окно?",
                                "Подтверждение", JOptionPane.YES_NO_OPTION,
                                JOptionPane.QUESTION_MESSAGE, null, options,
                                options[0]);
                if (n == 0) {
                    e.getWindow().setVisible(false);
                    System.exit(0);
                }
            }

            @Override
            public void windowClosed(WindowEvent e) {

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

            }
        });
    }

    private void mainFrameSetPanels() {
        this.mainFrame.setLayout(new BorderLayout());

        this.mainFrame.add(this.toolsPanel.getToolPanel(), BorderLayout.WEST);
        this.mainFrame.add(this.parameterPanel.getParameterPanel(), BorderLayout.NORTH);
        this.mainFrame.add(this.drawingManager.getDrawingArea(), BorderLayout.CENTER);
    }


}