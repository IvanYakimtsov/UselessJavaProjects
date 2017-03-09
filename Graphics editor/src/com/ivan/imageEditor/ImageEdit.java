package com.ivan.imageEditor;

import java.awt.*;
import javax.swing.*;

public class ImageEdit{

    private JFrame mainFrame;
    private ToolsPanel toolsPanel;
    private ParameterPanel parameterPanel;


    private DrawingManager drawingManager;

    ImageEdit(){

        drawingManager = new DrawingManager();

        toolsPanel = new ToolsPanel(drawingManager);
        parameterPanel = new ParameterPanel(drawingManager);
        setFrame();
        setCursor();

    }


    public static void main(String[] args) {

        ImageEdit imageEdit = new ImageEdit();




    }





    private void setCursor(){
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image image = toolkit.getImage("Img/hand.png");
        Cursor cursor = toolkit.createCustomCursor(image,new Point(16,0) , "mainCursor");

        this.mainFrame.setCursor(cursor);

    }



    private void setFrame() {
        this.mainFrame = new JFrame("ImageEditor");
        this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);



        this.mainFrame.setLayout(new BorderLayout());

        this.mainFrame.add(this.toolsPanel.getToolPanel(),BorderLayout.WEST);
        this.mainFrame.add(this.parameterPanel.getParameterPanel(),BorderLayout.NORTH);
        this.mainFrame.add(this.drawingManager.getDrawingArea(),BorderLayout.CENTER);

        setMainMenu();

        this.mainFrame.setVisible(true);
    }

    private void setMainMenu(){
        JMenu mainMenu = new  JMenu("Menu");
        mainMenu.setIcon(new ImageIcon("Img/menu.png"));

        JMenuItem txtFileItem = new JMenuItem("Text file");
        mainMenu.add(txtFileItem);

        JMenuItem imgFileItem = new JMenuItem("Image file");
        mainMenu.add(imgFileItem);

        JMenuItem folderItem = new JMenuItem("Folder");
        mainMenu.add(folderItem);

        JMenu toolsChooser = new  JMenu("tools");
        toolsChooser.setIcon(new ImageIcon("Img/edit.png"));

        JMenuBar mainMenuBar = new JMenuBar();
        mainMenuBar.add(mainMenu);
        mainMenuBar.add(toolsChooser);

        mainFrame.setJMenuBar(mainMenuBar);
    }




    //-------------------------------------------------------------------

   /* public JFrame getMainFrame() {
        return mainFrame;
    }


    public ToolsPanel getToolsPanel() {
        return toolsPanel;
    }

    public ParameterPanel getParameterPanel() {
        return parameterPanel;
    }
    public DrawingManager getDrawingManager() {
        return drawingManager;
    }*/
}