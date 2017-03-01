import java.awt.*;
import javax.swing.*;

public class ImageEdit{

    private JFrame mainFrame;
  //  private JPanel drawingArea;
    private ToolsPanel toolsPanel;
    private ColorPanel colorPanel;


    private DrawingManager drawingManager;

    ImageEdit(){

        drawingManager = new DrawingManager();

        toolsPanel = new ToolsPanel(drawingManager);
        colorPanel = new ColorPanel(drawingManager);
        setFrame();
        setTools();

    }


    public static void main(String[] args) {

        ImageEdit imageEdit = new ImageEdit();




    }


    private void setTools(){

        setToolsForToolPanel();
        setToolsForColorPanel();

        this.toolsPanel.setVisible(false); //TODO fix it. But not sure.
        this.toolsPanel.setVisible(true);

    }

    private void setToolsForToolPanel(){
        JButton button = new JButton(new ImageIcon("Img/paint-brush.png"));
        button.setBackground(null);
        this.toolsPanel.addButton(button,new Paint(this.drawingManager));

        button = new JButton( new ImageIcon("Img/pencil.png"));
        button.setBackground(null);
        this.toolsPanel.addButton(button,new Paint(this.drawingManager));

        button = new JButton( new ImageIcon("Img/eraser.png"));
        button.setBackground(null);
        this.toolsPanel.addButton(button,new Paint(this.drawingManager));

        button = new JButton( new ImageIcon("Img/vector.png"));
        button.setBackground(null);
        this.toolsPanel.addButton(button,new Paint(this.drawingManager));

        button = new JButton( new ImageIcon("Img/rectangle.png"));
        button.setBackground(null);
        this.toolsPanel.addButton(button,new Paint(this.drawingManager));

        button = new JButton( new ImageIcon("Img/save.png"));
        button.setBackground(null);
        this.toolsPanel.addButton(button,new Paint(this.drawingManager));

    }

    private  void setToolsForColorPanel(){
        JButton button;

        this.colorPanel.add(new JLabel(new ImageIcon("Img/paint-palette.png")));

        button = new JButton();
        button.setBackground(Color.blue);
        this.colorPanel.addButton(button,Color.blue);


        button = new JButton();
        button.setBackground(Color.red);
        this.colorPanel.addButton(button,Color.red);


        button = new JButton();
        button.setBackground(Color.black);
        this.colorPanel.addButton(button,Color.black);


        button = new JButton();
        button.setBackground(Color.GREEN);
        this.colorPanel.addButton(button,Color.GREEN);

        button = new JButton();
        button.setBackground(Color.CYAN);
        this.colorPanel.addButton(button,Color.CYAN);

        button = new JButton();
        button.setBackground(Color.MAGENTA);
        this.colorPanel.addButton(button,Color.MAGENTA);

        button = new JButton();
        button.setBackground(Color.GRAY);
        this.colorPanel.addButton(button,Color.GRAY);

        button = new JButton();
        button.setBackground(Color.LIGHT_GRAY);
        this.colorPanel.addButton(button,Color.LIGHT_GRAY);

        button = new JButton();
        button.setBackground(Color.ORANGE);
        this.colorPanel.addButton(button,Color.ORANGE);

        button = new JButton();
        button.setBackground(Color.PINK);
        this.colorPanel.addButton(button,Color.PINK);

        button = new JButton();
        button.setBackground(Color.WHITE);
        this.colorPanel.addButton(button,Color.WHITE);


        button = new JButton();
        button.setBackground(Color.YELLOW);
        this.colorPanel.addButton(button,Color.YELLOW);



    }


    private void setFrame() {
        this.mainFrame = new JFrame("Paint");
        this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);



        this.mainFrame.setLayout(new BorderLayout());

        this.mainFrame.add(this.toolsPanel,BorderLayout.WEST);
        this.mainFrame.add(this.colorPanel,BorderLayout.NORTH);
        this.mainFrame.add(this.drawingManager.getDrawingArea(),BorderLayout.CENTER);


        this.mainFrame.setVisible(true);
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