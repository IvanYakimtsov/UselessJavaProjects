package controller;

import connectionController.ConnectionManager;
import connectionController.ConnectionValidator;
import view.*;
import view.workingArea.WorkingArea;
import view.workingArea.WorkingAreaManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by Ivan on 21.03.2017.
 */
public class TableEditorManager implements ConnectionValidator {
    TableEditorMainFrame tableEditorMainFrame;
    WorkingArea workingArea;
    ConnectionManager connectionManager;

    public TableEditorManager(ConnectionManager connectionManager, TableEditorMainFrame tableEditorMainFrame) {
        this.connectionManager = connectionManager;
        this.connectionManager.addConnectionValidator(this);
        this.tableEditorMainFrame = tableEditorMainFrame;
        this.workingArea = new WorkingArea();
        this.workingArea.addListener(new WorkingAreaManager(connectionManager));
        this.tableEditorMainFrame.addWorkingArea(workingArea);
        setConnection();
        addListeners();
    }

    private void setConnection() {
        if (connectionManager.chooseServerIp()) {
            if (!connectionManager.setConnection()) {
                Object[] options = {"Переподключиться", "Отмена"};
                int n = JOptionPane
                        .showOptionDialog(workingArea.getWorkingAreaPanel(), "Не удается установить соединение с сервером." +
                                        " Желаете выбрать другой сервер?",
                                "Ошибка подключения", JOptionPane.YES_NO_OPTION,
                                JOptionPane.QUESTION_MESSAGE, null, options,
                                options[0]);
                if (n == 0) {
                    setConnection();
                }
            } else JOptionPane.showMessageDialog(workingArea.getWorkingAreaPanel(),"Соединение установлено");
        } else {
            Object[] options = {"Переподключиться", "Отмена"};
            int n = JOptionPane
                    .showOptionDialog(workingArea.getWorkingAreaPanel(), "ip не введен или введен некоректно.",
                            "Ошибка ввода ip", JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE, null, options,
                            options[0]);
            if (n == 0) {
                setConnection();
            }
        }
        if(connectionManager.checkConnection())  tableEditorMainFrame.lostConnectionIcon(false);
    }


    private void addListeners() {
        addButtonsListeners();
        addMenuListeners();
    }

    private void addButtonsListeners() {
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

    private void addMenuListeners() {
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

        tableEditorMainFrame.getMenuButtons().get(TableEditorMainFrame.CHANGE_SERVER_BUTTON_INDEX).addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                connectionManager.shutConnection();
                setConnection();
                workingArea.validate();

            }
        });
    }

    private void serverLostResponseAction(){
        JOptionPane.showMessageDialog(workingArea.getWorkingAreaPanel(),"Потерено соединение с сервером");
        tableEditorMainFrame.lostConnectionIcon(true);
    }

    public boolean checkConnection(){
        if(connectionManager.checkConnection()){
            tableEditorMainFrame.lostConnectionIcon(false);
            return true;
        } else {
            serverLostResponseAction();
            return false;
        }
    }
    class SaveButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if(connectionManager.checkConnection()) {
                String name = JOptionPane.showInputDialog("Введите название таблицы");
                connectionManager.saveAction(name);
            } else serverLostResponseAction();

        }
    }

    class OpenButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if(connectionManager.checkConnection()){
                String name = JOptionPane.showInputDialog("Введите название таблицы");
                connectionManager.openAction(name);
                workingArea.validate();
            }else serverLostResponseAction();
        }
    }

    class AddButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if(connectionManager.checkConnection()){
                AddPersonDialog dialog = new AddPersonDialog(workingArea.getExamsAmmount());
                dialog.getDialog().setLocationRelativeTo(workingArea.getWorkingAreaPanel());
                if (dialog.startDialog() == AddPersonDialog.ID_OK) {
                    connectionManager.addStudent(dialog.getStudent());

                    workingArea.validate();
                }
            } else serverLostResponseAction();
        }
    }


    class DeleteButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if(connectionManager.checkConnection()){
                SearchPersonDialog dialog = new SearchPersonDialog(true, connectionManager);
                dialog.getDialog().setLocationRelativeTo(workingArea.getWorkingAreaPanel());
                dialog.startDialog();
                workingArea.validate();
            } else serverLostResponseAction();
        }
    }

    class SearchButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if(connectionManager.checkConnection()){
                SearchPersonDialog dialog = new SearchPersonDialog(false, connectionManager);
                dialog.getDialog().setLocationRelativeTo(workingArea.getWorkingAreaPanel());
                dialog.startDialog();
                workingArea.validate();
                connectionManager.deleteSearchResults();
            } else serverLostResponseAction();
        }
    }

}
