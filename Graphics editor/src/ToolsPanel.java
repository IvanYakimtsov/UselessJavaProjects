import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Ivan on 01.03.2017.
 */
public class ToolsPanel extends JPanel {

    DrawingManager drawingManager;

    ToolsPanel(DrawingManager drawingManager) {

        this.drawingManager = drawingManager;
        this.setBackground(Color.LIGHT_GRAY);
        this.setPreferredSize(new Dimension(36,200));
        this.setLayout(new GridLayout(7,1,36,36));
        this.setVisible(true);
    }

    public void addButton(JButton button, Tool tool){

        button.addActionListener(new ToolsPanelListener(drawingManager, tool));
        this.add(button);
    }




    //------------------------------------------------------------------------------------------------------------
    public class ToolsPanelListener implements ActionListener {
        DrawingManager drawingManager;
        Tool tool;
        ToolsPanelListener(DrawingManager drawingManager, Tool tool){
            this.drawingManager = drawingManager;
            this.tool = tool;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            this.drawingManager.setCurrentTool(this.tool);
        }
    }

}
