import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Ivan on 28.02.2017.
 */
public class ColorPanelListener implements ActionListener {
    DrawingManager drawingManager;
    Color color;
    ColorPanelListener(DrawingManager drawingManager, Color color){
        this.drawingManager = drawingManager;
        this.color = color;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        this.drawingManager.setCurrentColor(color);
        drawingManager.update();
    }
}
