import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

/**
 * Created by Ivan on 28.02.2017.
 */
public class DrawingManager  {

    private Instrument currentInstrument;


    private ImageEdit imageEdit;

    DrawingManager(ImageEdit imageEdit){
        this.imageEdit = imageEdit;

    }


    public void setCurrentInstrument(Instrument currentInstrument) {
        this.currentInstrument = currentInstrument;
    }

    public void setCurrentColor(Color color) {
        this.currentInstrument.setColor(color);
    }

    public Instrument getCurrentInstrument() {
        return currentInstrument;
    }

    public void update(){
        this.imageEdit.getDrawingArea().addMouseMotionListener(currentInstrument);
    }


}
