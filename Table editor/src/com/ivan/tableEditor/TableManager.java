package com.ivan.tableEditor;

import javax.swing.*;
import javax.xml.transform.TransformerException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

/**
 * Created by Ivan on 21.03.2017.
 */
public class TableManager {
    TableMainFrame tableMainFrame;
    WorkingArea workingArea;
    TableModel tableModel;

    TableManager(TableModel tableModel, TableMainFrame tableMainFrame) {
        this.tableMainFrame = tableMainFrame;
        this.workingArea = new WorkingArea();
        this.workingArea.addListener(new WorkingAreaManager(tableModel));
        this.tableMainFrame.addWorkingArea(workingArea);
        this.tableModel = tableModel;
        addListeners();
    }

    private void addListeners() {
        tableMainFrame.getToolPanelButtons().get(0).addActionListener(new SaveButtonListener());
        tableMainFrame.getToolPanelButtons().get(1).addActionListener(new OpenButtonListener());
        tableMainFrame.getToolPanelButtons().get(2).addActionListener(new AddButtonListener());
        tableMainFrame.getToolPanelButtons().get(3).addActionListener(new DeleteButtonListener());
        tableMainFrame.getToolPanelButtons().get(4).addActionListener(new SearchButtonListener());
    }


    class SaveButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {


            JFileChooser fileChooser = new JFileChooser();
            TableFileFilter xmlFilter = new TableFileFilter(".table");

            fileChooser.addChoosableFileFilter(xmlFilter);

            int result = fileChooser.showSaveDialog(null);

            if (result == JFileChooser.APPROVE_OPTION) {
                try {
                    tableModel.saveAction(fileChooser.getSelectedFile().getAbsolutePath() + ".table");
                } catch (TransformerException exeption) {
                    exeption.printStackTrace();
                    JOptionPane.showMessageDialog(workingArea.getWorkingAreaPanel(), "ошибка записи");
                } catch (IOException exeption) {
                    exeption.printStackTrace();
                    JOptionPane.showMessageDialog(workingArea.getWorkingAreaPanel(), "ошибка записи");
                }
            }
        }
    }

    class OpenButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {


            JFileChooser fileChooser = new JFileChooser();
            TableFileFilter xmlFilter = new TableFileFilter(".table");

            fileChooser.addChoosableFileFilter(xmlFilter);

            int result = fileChooser.showOpenDialog(null);

            if (result == JFileChooser.APPROVE_OPTION) {

                try {
                    tableModel.openAction(fileChooser.getSelectedFile().getAbsolutePath());
                    workingArea.validate();
                } catch (Exception exeption) {
                    exeption.printStackTrace();
                    JOptionPane.showMessageDialog(workingArea.getWorkingAreaPanel(), "ошибка чтения");
                }



            }
        }
    }

    class AddButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            AddPersonDialog dialog = new AddPersonDialog(workingArea.getExamsAmmount());
            dialog.getDialog().setLocationRelativeTo(workingArea.getWorkingAreaPanel());
            if (dialog.startDialog() == AddPersonDialog.ID_OK) {
                tableModel.addStudent(dialog.getStudent());
                workingArea.validate();
            }
        }
    }


    class DeleteButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
//        SearchPersonDialog dialog = new SearchPersonDialog(false,tableModel);
//        dialog.getDialog().setLocationRelativeTo(workingArea.getWorkingAreaPanel());
//        dialog.startDialog();
//        validateWorkingArea();
        }
    }

    class SearchButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
//            SearchPersonDialog dialog = new SearchPersonDialog("Найти");
//            tableMainFrame.addDialog(dialog.getDialog());
//            int dialogExitCode = dialog.startDialog();
//            if (dialogExitCode != SearchPersonDialog.ID_CANCEL) {
//                List<Student> searchResult = null;
//                switch (dialogExitCode) {
//                    case SearchPersonDialog.ID_SEARCH_OPTION_1:
//                        searchResult = tableModel.searchStudent(dialog.getGroup(), dialog.getStudentSurname());
//                        break;
//                    case SearchPersonDialog.ID_SEARCH_OPTION_2:
//                        searchResult = tableModel.searchStudent(dialog.getMinResult(), dialog.getMaxResult(),
//                                dialog.getStudentSurname());
//                        break;
//                    case SearchPersonDialog.ID_SEARCH_OPTION_3:
//                        searchResult = tableModel.searchStudent(dialog.getExam(), dialog.getMinResult(),
//                                dialog.getMaxResult(), dialog.getStudentSurname());
//                        break;
//                }
//                ResultDialog resultDialog = new ResultDialog(tableMainFrame.getExamsAmmount(), searchResult);
//                tableMainFrame.addDialog(resultDialog.getDialog());
//                resultDialog.startDialog();
//            }
        }
    }
}
