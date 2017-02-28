import java.awt.*;
import javax.swing.*;

public class ImageEdit{

    private JFrame mainFrame;
    private JPanel drawingArea;
    private JPanel toolsPanel;
    private JPanel colorPanel;

    private DrawingManager drawingManager;

    ImageEdit(){
        drawingManager = new DrawingManager(this);

        setDrawingArea();
        setToolsPanel();
        setColorPanel();
        setFrame();
        prepareGameManager();

    }


    public static void main(String[] args) {

     ImageEdit imageEdit = new ImageEdit();

    }


    private void setColorPanel() {
        this.colorPanel = new JPanel();
        this.colorPanel.setBackground(Color.blue);
        this.colorPanel.setSize(this.mainFrame.MAXIMIZED_HORIZ,34);
        this.colorPanel.setVisible(true);
    }

    private void setToolsPanel() {
        this.toolsPanel = new JPanel();
        this.toolsPanel.setBackground(Color.RED);
        this.toolsPanel.setVisible(true);
    }

    private void setDrawingArea() {
        this.drawingArea = new JPanel();
        this.drawingArea.setBackground(Color.white);
        this.drawingArea.setSize(this.mainFrame.MAXIMIZED_HORIZ-128,this.mainFrame.MAXIMIZED_VERT-128);
        this.drawingArea.setVisible(true);
    }

    private void setFrame() {
        this.mainFrame = new JFrame("Paint");
        this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        this.mainFrame.setLayout(new BorderLayout());


        this.mainFrame.add(this.toolsPanel,BorderLayout.WEST);
        this.mainFrame.add(this.colorPanel,BorderLayout.NORTH);
        this.mainFrame.add(this.drawingArea,BorderLayout.CENTER);


        this.mainFrame.setVisible(true);
    }


    private void prepareGameManager() {

    }

    public JFrame getMainFrame() {
        return mainFrame;
    }

    public JPanel getDrawingArea() {
        return drawingArea;
    }

    public JPanel getToolsPanel() {
        return toolsPanel;
    }

    public JPanel getColorPanel() {
        return colorPanel;
    }
}