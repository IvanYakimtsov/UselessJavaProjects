import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Ivan on 21.03.2017.
 */
public class TableController {
    TableView tableView;
    TableModel tableModel;

    TableController(TableModel tableModel, TableView tableView){
        this.tableView = tableView;
        this.tableModel = tableModel;
        addListeners();
    }

    private void addListeners(){
        tableView.getToolPanelButtons().get(0).addActionListener(new SaveButtonListener());
        tableView.getToolPanelButtons().get(1).addActionListener(new OpenButtonListener());
        tableView.getToolPanelButtons().get(2).addActionListener(new AddButtonListener());
        tableView.getToolPanelButtons().get(3).addActionListener(new DeleteButtonListener());
        tableView.getToolPanelButtons().get(4).addActionListener(new SearchButtonListener());
    }

    class SaveButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    class OpenButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    class AddButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            AddPersonDialog dialog = new AddPersonDialog();
            tableView.addDialog(dialog);
            if(dialog.doModal() == AddPersonDialog.ID_OK) {
                tableModel.addStudent(dialog.getTableRow());
                tableView.createTable(tableModel.getTableData());
            }
        }
    }


    class DeleteButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    class SearchButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
}
