import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by Ivan on 21.03.2017.
 */
public class TableEditorManager {
    TableEditorMainFrame tableEditorMainFrame;
    WorkingArea workingArea;
    ConnectionManager connectionManager;

    public TableEditorManager(ConnectionManager connectionManager, TableEditorMainFrame tableEditorMainFrame) {
        this.connectionManager = connectionManager;
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
                Object[] options = {"Переподключиться", "Выйти"};
                int n = JOptionPane
                        .showOptionDialog(workingArea.getWorkingAreaPanel(), "Не удается установить соединение с сервером." +
                                        " Желаете выбрать другой сервер?",
                                "Ошибка подключения", JOptionPane.YES_NO_OPTION,
                                JOptionPane.QUESTION_MESSAGE, null, options,
                                options[0]);
                if (n == 1) {
                    tableEditorMainFrame.disposeFrame();
                } else setConnection();
            } else JOptionPane.showMessageDialog(workingArea.getWorkingAreaPanel(),"Соединение установлено");
        } else {
            Object[] options = {"Переподключиться", "Выйти"};
            int n = JOptionPane
                    .showOptionDialog(workingArea.getWorkingAreaPanel(), "ip не введен или введен некоректно.",
                            "Ошибка ввода ip", JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE, null, options,
                            options[0]);
            if (n == 1) {
                tableEditorMainFrame.disposeFrame();
            } else setConnection();
        }

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
    }


    class SaveButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

//
//            JFileChooser fileChooser = new JFileChooser();
//            TableFileFilter xmlFilter = new TableFileFilter(".table");
//
//            fileChooser.addChoosableFileFilter(xmlFilter);
//
//            int result = fileChooser.showSaveDialog(null);
//
//            if (result == JFileChooser.APPROVE_OPTION) {
//                try {
//                    connectionManager.saveAction(fileChooser.getSelectedFile().getAbsolutePath() + ".table");
//                } catch (TransformerException exeption) {
//                    exeption.printStackTrace();
//                    JOptionPane.showMessageDialog(workingArea.getWorkingAreaPanel(), "ошибка записи");
//                } catch (IOException exeption) {
//                    exeption.printStackTrace();
//                    JOptionPane.showMessageDialog(workingArea.getWorkingAreaPanel(), "ошибка записи");
//                }
//            }
        }
    }

    class OpenButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

//
//            JFileChooser fileChooser = new JFileChooser();
//
//            TableFileFilter xmlFilter = new TableFileFilter(".table");
//
//            fileChooser.addChoosableFileFilter(xmlFilter);
//
//            int result = fileChooser.showOpenDialog(null);
//
//            if (result == JFileChooser.APPROVE_OPTION) {
//
//                try {
//                    connectionManager.openAction(fileChooser.getSelectedFile().getAbsolutePath());
//                    workingArea.validate();
//                } catch (Exception exeption) {
//                    exeption.printStackTrace();
//                    JOptionPane.showMessageDialog(workingArea.getWorkingAreaPanel(), "ошибка чтения");
//                }
//
//
//
//            }
        }
    }

    class AddButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            AddPersonDialog dialog = new AddPersonDialog(workingArea.getExamsAmmount());
            dialog.getDialog().setLocationRelativeTo(workingArea.getWorkingAreaPanel());
            if (dialog.startDialog() == AddPersonDialog.ID_OK) {
                connectionManager.addStudent(dialog.getStudent());

                workingArea.validate();
            }
        }
    }


    class DeleteButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
        SearchPersonDialog dialog = new SearchPersonDialog(true, connectionManager);
        dialog.getDialog().setLocationRelativeTo(workingArea.getWorkingAreaPanel());
        dialog.startDialog();
        workingArea.validate();
        }
    }

    class SearchButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            SearchPersonDialog dialog = new SearchPersonDialog(false, connectionManager);
            dialog.getDialog().setLocationRelativeTo(workingArea.getWorkingAreaPanel());
            dialog.startDialog();
            workingArea.validate();
        }
    }

}