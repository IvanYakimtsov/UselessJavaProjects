import javax.swing.*;
import java.awt.*;

/**
 * Created by Ivan on 28.02.2017.
 */
public class DrawingManager  {

    private Tool currentTool;
    private DrawingArea drawingArea;
    private Color color;



    DrawingManager(){


        drawingArea = new DrawingArea();


        this.currentTool = new Paint(this);
        color = Color.black;

        update();
    }


    public void setCurrentTool(Tool currentTool) {
        this.currentTool = currentTool;

    }

    public void setCurrentColor(Color color) {
        this.color = color;
    }

    public void update(){
        this.drawingArea.addMouseListener(currentTool);
        this.drawingArea.addMouseMotionListener(currentTool);
    }

    public Graphics getCanvas(){
        return this.drawingArea.getGraphics();
    }


    public Color getColor() {
        return color;
    }

    public DrawingArea getDrawingArea() {
        return drawingArea;
    }
}
