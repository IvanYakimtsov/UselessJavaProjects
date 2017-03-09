package com.ivan.imageEditor;

import java.awt.*;
import javax.swing.*;

public class ImageEdit{

    private JFrame mainFrame;
    private ToolsPanel toolsPanel;
    private ColorPanel colorPanel;


    private DrawingManager drawingManager;

    ImageEdit(){

        drawingManager = new DrawingManager();

        toolsPanel = new ToolsPanel(drawingManager);
        colorPanel = new ColorPanel(drawingManager);
        setFrame();
        setTools();
        setCursor();

    }


    public static void main(String[] args) {

        ImageEdit imageEdit = new ImageEdit();




    }


    private void setTools(){

        setToolsForToolPanel();
        setToolsForColorPanel();

        this.toolsPanel.getToolPanel().setVisible(false); //TODO fix it. But not sure.
        this.toolsPanel.getToolPanel().setVisible(true);

    }

    private void setToolsForToolPanel(){
        this.toolsPanel.addButton(setToolButton("Img/paint-brush.png"),new Paint(this.drawingManager));
        this.toolsPanel.addButton(setToolButton("Img/segment.png"),new Line(this.drawingManager));
        this.toolsPanel.addButton(setToolButton("Img/eraser.png"),new Eraser(this.drawingManager));
        this.toolsPanel.addButton(setToolButton("Img/text.png"),new Paint(this.drawingManager));
        this.toolsPanel.addButton(setToolButton("Img/Rectangle.png"),new Rectangle(this.drawingManager));
        this.toolsPanel.addButton(setToolButton("Img/save.png"),new Paint(this.drawingManager));
    }

    private JButton setToolButton(String fileName){
        JButton button = new JButton(new ImageIcon(fileName));
        button.setBackground(null);
        return button;
    }

    private void setCursor(){
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image image = toolkit.getImage("Img/hand.png");
        Cursor cursor = toolkit.createCustomCursor(image,new Point(16,0) , "mainCursor");

        this.mainFrame.setCursor(cursor);

    }

    private  void setToolsForColorPanel(){

        this.colorPanel.getColorPanel().add(new JLabel(new ImageIcon("Img/paint-palette.png")));

        setColorButton(Color.blue);
        setColorButton(Color.red);
        setColorButton(Color.black);
        setColorButton(Color.GREEN);
        setColorButton(Color.CYAN);
        setColorButton(Color.MAGENTA);
        setColorButton(Color.GRAY);
        setColorButton(Color.LIGHT_GRAY);
        setColorButton(Color.ORANGE);
        setColorButton(Color.PINK);
        setColorButton(Color.WHITE);
        setColorButton(Color.YELLOW);


    }

    private void setColorButton(Color color){
        JButton button = new JButton();
        button.setBackground(color);
        this.colorPanel.addButton(button,color);
    }


    private void setFrame() {
        this.mainFrame = new JFrame("com.ivan.imageEditor.Paint");
        this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);



        this.mainFrame.setLayout(new BorderLayout());

        this.mainFrame.add(this.toolsPanel.getToolPanel(),BorderLayout.WEST);
        this.mainFrame.add(this.colorPanel.getColorPanel(),BorderLayout.NORTH);
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

    public JFrame getMainFrame() {
        return mainFrame;
    }


    public ToolsPanel getToolsPanel() {
        return toolsPanel;
    }

    public ColorPanel getColorPanel() {
        return colorPanel;
    }
    public DrawingManager getDrawingManager() {
        return drawingManager;
    }
}