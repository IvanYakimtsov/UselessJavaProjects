import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class ImageEdit extends JPanel{

    public ImageEdit() {
    }
    protected void paintComponent(Graphics g) {
        Graphics2D g2D = (Graphics2D)g;
        // paint background
        g2D.setBackground(Color.WHITE);
        g2D.clearRect(0,0,getWidth(), getHeight());

        // paint shape
        g2D.setColor(Color.BLUE);
        drawEllipse(g2D);
    }

    private void drawEllipse(Graphics2D g2D){
        int shapeWidth = 150;
        int shapwHeight = 75;
        Ellipse2D.Double ellipse = new Ellipse2D.Double( (getWidth()-shapeWidth)/2, (getHeight()-shapwHeight)/2, shapeWidth, shapwHeight);
        g2D.draw(ellipse);
    }

    public static void main(String[] args) {
        ImageEdit panel = new ImageEdit();
        JFrame frame = new JFrame("Paint");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel);
        frame.setBounds(100,100,300,300);
        frame.setVisible(true);
    }
}