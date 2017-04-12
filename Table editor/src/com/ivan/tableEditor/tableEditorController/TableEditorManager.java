package com.ivan.tableEditor.tableEditorController;

import com.ivan.tableEditor.tableEditorModel.TableFileFilter;
import com.ivan.tableEditor.tableEditorModel.TableModel;
import com.ivan.tableEditor.tableEditorView.*;
import com.ivan.tableEditor.tableEditorView.workingArea.WorkingArea;
import com.ivan.tableEditor.tableEditorView.workingArea.WorkingAreaManager;

import javax.swing.*;
import javax.xml.transform.TransformerException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Created by Ivan on 21.03.2017.
 */
public class TableEditorManager {
    TableEditorMainFrame tableEditorMainFrame;
    WorkingArea workingArea;
    TableModel tableModel;

    public TableEditorManager(TableModel tableModel, TableEditorMainFrame tableEditorMainFrame) {
        this.tableEditorMainFrame = tableEditorMainFrame;
        this.workingArea = new WorkingArea();
        this.workingArea.addListener(new WorkingAreaManager(tableModel));
        this.tableEditorMainFrame.addWorkingArea(workingArea);
        this.tableModel = tableModel;
        addListeners();
    }

    private void addListeners() {
        addButtonsListeners();
        addMenuListeners();
    }

    private void addButtonsListeners(){
        tableEditorMainFrame.getToolPanelButtons().get(TableEditorMainFrame.SAVE_BUTTON_INDEX).
                addActionListener(new SaveButtonListener());
        tableEditorMainFrame.getToolPanelButtons().get(TableEditorMainFrame.OPEN_BUTTON_INDEX).
                addActionListener(new OpenButtonListener());
        tableEditorMainFrame.getToolPanelButtons().get(TableEditorMainFrame.ADD_BUTTON_INDEX).
                addActionListener(new AddButtonListener());
        tableEditorMainFrame.getToolPanelButtons().get(TableEditorMainFrame.DELETE_BUTTON_INDEX).
                addActionListener(new DeleteButtonListener());
        tableEditorMainFrame.getToolPanelButtons().get(TableEditorMainFrame.SEARCH_BUTTON_INDEX).
                addActionListener(new SearchButtonListener());
    }

    private void addMenuListeners(){
        tableEditorMainFrame.getMenuButtons().get(TableEditorMainFrame.SAVE_BUTTON_INDEX).
                addActionListener(new SaveButtonListener());
        tableEditorMainFrame.getMenuButtons().get(TableEditorMainFrame.OPEN_BUTTON_INDEX).
                addActionListener(new OpenButtonListener());
        tableEditorMainFrame.getMenuButtons().get(TableEditorMainFrame.ADD_BUTTON_INDEX).
                addActionListener(new AddButtonListener());
        tableEditorMainFrame.getMenuButtons().get(TableEditorMainFrame.DELETE_BUTTON_INDEX).
                addActionListener(new DeleteButtonListener());
        tableEditorMainFrame.getMenuButtons().get(TableEditorMainFrame.SEARCH_BUTTON_INDEX).
                addActionListener(new SearchButtonListener());
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
        SearchPersonDialog dialog = new SearchPersonDialog(true,tableModel);
        dialog.getDialog().setLocationRelativeTo(workingArea.getWorkingAreaPanel());
        dialog.startDialog();
        workingArea.validate();
        }
    }

    class SearchButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            SearchPersonDialog dialog = new SearchPersonDialog(false,tableModel);
            dialog.getDialog().setLocationRelativeTo(workingArea.getWorkingAreaPanel());
            dialog.startDialog();
            workingArea.validate();
        }
    }
}
