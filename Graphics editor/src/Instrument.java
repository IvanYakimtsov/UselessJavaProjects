import java.awt.*;
import java.awt.event.MouseMotionListener;

/**
 * Created by Ivan on 28.02.2017.
 */
public abstract class Instrument implements MouseMotionListener {
    Color color;
    ImageEdit imageEdit;

    public abstract void draw();
    public void setColor(Color color){
        this.color = color;
    }
}
