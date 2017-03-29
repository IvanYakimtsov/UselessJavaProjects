import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.Raster;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ivan on 21.03.2017.
 */
public class TableController {
    TableView tableView;
    TableModel tableModel;

    TableController(TableModel tableModel, TableView tableView) {
        this.tableView = tableView;
        this.tableModel = tableModel;
        addListeners();
    }

    private void addListeners() {
        tableView.getToolPanelButtons().get(0).addActionListener(new SaveButtonListener());
        tableView.getToolPanelButtons().get(1).addActionListener(new OpenButtonListener());
        tableView.getToolPanelButtons().get(2).addActionListener(new AddButtonListener());
        tableView.getToolPanelButtons().get(3).addActionListener(new DeleteButtonListener());
        tableView.getToolPanelButtons().get(4).addActionListener(new SearchButtonListener());
    }

    class SaveButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    class OpenButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    class AddButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            AddPersonDialog dialog = new AddPersonDialog(tableView.getExamsAmmount());
            tableView.addDialog(dialog.getDialog());
            if (dialog.startDialog() == AddPersonDialog.ID_OK) {
                tableModel.addStudent(dialog.getTableRow());
                tableView.createTable(tableModel.getTableData());
            }
        }
    }


    class DeleteButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            SearchPersonDialog dialog = new SearchPersonDialog("удалить студента");
            tableView.addDialog(dialog.getDialog());
            int dialogExitCode = dialog.startDialog();
            if (dialogExitCode != SearchPersonDialog.ID_CANCEL) {
                int deletedStudentsAmmount = 0;
                switch (dialogExitCode) {
                    case SearchPersonDialog.ID_SEARCH_OPTION_1:
                        deletedStudentsAmmount = tableModel.deleteStudent(dialog.getGroup(), dialog.getStudentSurname());
                        break;
                    case SearchPersonDialog.ID_SEARCH_OPTION_2:
                        deletedStudentsAmmount = tableModel.deleteStudent(dialog.getMinResult(), dialog.getMaxResult(),
                                dialog.getStudentSurname());
                        break;
                    case SearchPersonDialog.ID_SEARCH_OPTION_3:
                        deletedStudentsAmmount = tableModel.deleteStudent(dialog.getExam(), dialog.getMinResult(),
                                dialog.getMaxResult(), dialog.getStudentSurname());
                        break;
                }

                tableView.createTable(tableModel.getTableData());

                JOptionPane.showMessageDialog(dialog.getDialog(), "удалено записей " + deletedStudentsAmmount);
            }
        }
    }

    class SearchButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            SearchPersonDialog dialog = new SearchPersonDialog("Найти");
            tableView.addDialog(dialog.getDialog());
            int dialogExitCode = dialog.startDialog();
            if (dialogExitCode != SearchPersonDialog.ID_CANCEL) {
                List<TableRow> searchResult = null;
                int deletedStudentsAmmount = 0;
                switch (dialogExitCode) {
                    case SearchPersonDialog.ID_SEARCH_OPTION_1:
                        searchResult = tableModel.searchStudent(dialog.getGroup(), dialog.getStudentSurname());
                        break;
                    case SearchPersonDialog.ID_SEARCH_OPTION_2:
                        searchResult = tableModel.searchStudent(dialog.getMinResult(), dialog.getMaxResult(),
                                dialog.getStudentSurname());
                        break;
                    case SearchPersonDialog.ID_SEARCH_OPTION_3:
                        searchResult = tableModel.searchStudent(dialog.getExam(), dialog.getMinResult(),
                                dialog.getMaxResult(), dialog.getStudentSurname());
                        break;
                }
                ResultDialog resultDialog = new ResultDialog(tableView.getExamsAmmount(),searchResult);
                tableView.addDialog(resultDialog.getDialog());
                resultDialog.startDialog();
            }
        }
    }
}