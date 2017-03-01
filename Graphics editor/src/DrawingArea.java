import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Ivan on 01.03.2017.
 */
public class DrawingArea extends JPanel {

    private Graphics  canvas;


    DrawingArea(){
       // canvas = new JLabel(new ImageIcon(this.canvasViev));
        this.setBackground(Color.white);
        this.setVisible(true);

        canvas = this.getGraphics();

        //this.add(canvas);



    }

    public Graphics getCanvas() {
        return canvas;
    }


}
