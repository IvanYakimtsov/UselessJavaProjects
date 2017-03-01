import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

/**
 * Created by Ivan on 28.02.2017.
 */
public abstract class Tool implements MouseMotionListener {

    DrawingManager drawingManager;

    Tool(DrawingManager drawingManager){
        this.drawingManager = drawingManager;

    }


}
