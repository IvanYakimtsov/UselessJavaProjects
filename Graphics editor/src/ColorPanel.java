import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Ivan on 01.03.2017.
 */
public class ColorPanel extends JPanel {

    DrawingManager drawingManager;

    ColorPanel(DrawingManager drawingManager) {
        this.drawingManager = drawingManager;
        this.setBackground(Color.LIGHT_GRAY);
        this.setPreferredSize(new Dimension(400,36));
        this.setLayout(new GridLayout(1,32,0,32));
        this.setVisible(true);
    }

    public void addButton(JButton button, Color color){

        button.addActionListener(new ColorPanelListener(drawingManager, color));
        this.add(button);
    }






    //---------------------------------------------------------------------------------------------------
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
        }
    }




}
