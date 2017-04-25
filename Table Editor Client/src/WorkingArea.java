import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ivan on 29.03.2017.
 */
public class WorkingArea {

    private List<WorkingAreaListener> listeners = new ArrayList<WorkingAreaListener>();

    private WorkingAreaData workingAreaData;
    private WorkingAreaPanel workingAreaPanel;

    public WorkingArea() {
        this.workingAreaData = new WorkingAreaData();
        this.workingAreaPanel = new WorkingAreaPanel(workingAreaData);
        workingAreaPanel.drawPage(null);
        setViewListeners();
    }

    private void setViewListeners(){
        workingAreaPanel.getRecords().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                workingAreaData.setAmmountOfRecords(Integer.parseInt( workingAreaPanel.getRecords().getText()));
                workingAreaData.setCurrentPage(1);
                workingAreaPanel.getPageAmmountLabel().setText(String.valueOf(workingAreaData.getCurrentPage())
                        + "/" + String.valueOf(workingAreaData.getAmmountOfPages()));
                validate();
            }
        });
        workingAreaPanel.getButtons().get(WorkingAreaPanel.BACK_BUTTON_INDEX).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (workingAreaData.getCurrentPage() > 1) {
                    workingAreaData.setCurrentPage(workingAreaData.getCurrentPage()-1);
                    workingAreaPanel.getPageAmmountLabel().setText(String.valueOf(workingAreaData.getCurrentPage()) +
                            "/" + String.valueOf(workingAreaData.getAmmountOfPages()));
                    validate();
                }
            }
        });

        workingAreaPanel.getButtons().get(WorkingAreaPanel.NEXT_BUTTON_INDEX).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (workingAreaData.getCurrentPage() < workingAreaData.getAmmountOfPages()) {
                    workingAreaData.setCurrentPage(workingAreaData.getCurrentPage()+1);
                    workingAreaPanel.getPageAmmountLabel().setText(String.valueOf(workingAreaData.getCurrentPage()) +
                            "/" + String.valueOf(workingAreaData.getAmmountOfPages()));
                    validate();
                }
            }
        });

        workingAreaPanel.getButtons().get(WorkingAreaPanel.HOME_BUTTON_INDEX).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                workingAreaData.setCurrentPage(1);
                workingAreaPanel.getPageAmmountLabel().setText(String.valueOf(workingAreaData.getCurrentPage()) +
                        "/" + String.valueOf(workingAreaData.getAmmountOfPages()));
                validate();
            }
        });

        workingAreaPanel.getButtons().get(WorkingAreaPanel.END_BUTTON_INDEX).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                workingAreaData.setCurrentPage(workingAreaData.getAmmountOfPages());
                workingAreaPanel.getPageAmmountLabel().setText(String.valueOf(workingAreaData.getCurrentPage()) +
                        "/" + String.valueOf(workingAreaData.getAmmountOfPages()));
                validate();
            }
        });
    }

    public void addListener(WorkingAreaListener listener) {
        listeners.add(listener);
    }

    public void removeListener(WorkingAreaListener listener) {
        listeners.remove(listener);
    }

    public void validate() {
        for(WorkingAreaListener listener : listeners) {
            listener.validateWorkingArea(this);
        }
        setViewListeners();
    }



    public WorkingAreaPanel getWorkingAreaPanel() {
        return workingAreaPanel;
    }


    public int getCurrentPage() {
        return workingAreaData.getCurrentPage();
    }

    public int getAmmountOfRecords() {
        return workingAreaData.getAmmountOfRecords();
    }

    public int getExamsAmmount() {
        return workingAreaData.getExamsAmmount();
    }

    public void setAmmountOfPages(int pageSize) {
       if(pageSize!=0) workingAreaData.setAmmountOfPages((int) Math.ceil((double) pageSize / workingAreaData.getAmmountOfRecords()));
            else workingAreaData.setAmmountOfPages(1);
    }

    public WorkingAreaData getWorkingAreaData() {
        return workingAreaData;
    }

    public void setColor(Color color){
        workingAreaPanel.setBackground(color);
    }
}
