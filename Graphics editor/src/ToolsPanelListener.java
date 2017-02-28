import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Ivan on 28.02.2017.
 */
public class ToolsPanelListener implements ActionListener {
    DrawingManager drawingManager;
    Instrument instrument;
    ToolsPanelListener(DrawingManager drawingManager, Instrument instrument){
        this.drawingManager = drawingManager;
        this.instrument = instrument;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        drawingManager.setCurrentInstrument(this.instrument);
        drawingManager.update();
    }
}
