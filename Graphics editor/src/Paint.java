import javafx.scene.shape.Line;

import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * Created by Ivan on 28.02.2017.
 */
public class Paint extends Tool {

    boolean isPressed;
    int lastXposition;
    int lastYposition;


    Paint(DrawingManager drawingManager) {
        super(drawingManager);
        setCursor();
    }


    private void setCursor(){
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image image = toolkit.getImage("Img/artistic-brush.png");
        Cursor cursor = toolkit.createCustomCursor(image,new Point(0,28) , "paint");

        drawingManager.getDrawingArea().setCursor(cursor);
    }

    @Override
    public void mouseDragged(MouseEvent event) {

        if(!isPressed){
            lastXposition = event.getX();
            lastYposition = event.getY();
        }
        isPressed = true;
        paint(event);
        lastXposition = event.getX();
        lastYposition = event.getY();


    }

    @Override
    public void mouseMoved(MouseEvent event) {

    }

    @Override
    public void mouseClicked(MouseEvent event) {
        paint(event);

    }

    @Override
    public void mousePressed(MouseEvent event) {
        paint(event);


    }

    @Override
    public void mouseReleased(MouseEvent event) {
        isPressed = false;
    }

    @Override
    public void mouseEntered(MouseEvent event) {

    }

    @Override
    public void mouseExited(MouseEvent event) {

    }

    private void paint(MouseEvent event){
        Graphics2D paint = (Graphics2D)drawingManager.getCanvas();
        paint.setStroke(new  BasicStroke(4.0f));
        paint.setColor(drawingManager.getColor());

        paint.drawLine(event.getX(),event.getY(),event.getX(),event.getY());

        if(isPressed){
            paint.drawLine(lastXposition,lastYposition,event.getX(),event.getY());
        }
    }
}
