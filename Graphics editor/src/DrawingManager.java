import javax.swing.*;
import java.awt.*;

/**
 * Created by Ivan on 28.02.2017.
 */
public class DrawingManager  {

    private Tool currentTool;
    DrawingArea drawingArea;
    Color color;


    public DrawingArea getDrawingArea() {
        return drawingArea;
    }

    DrawingManager(){


        drawingArea = new DrawingArea();


        this.currentTool = new Paint(this);

        update();
    }


    public void setCurrentTool(Tool currentTool) {
        this.currentTool = currentTool;

    }

    public void setCurrentColor(Color color) {
        this.color = color;
    }

    public void update(){
        this.drawingArea.addMouseMotionListener(currentTool);
    }

    public Graphics getCanvas(){
        return this.drawingArea.getGraphics();
    }
}
