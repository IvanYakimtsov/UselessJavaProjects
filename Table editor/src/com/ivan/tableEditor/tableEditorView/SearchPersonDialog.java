package com.ivan.tableEditor.tableEditorView;

import com.ivan.tableEditor.tableEditorModel.TableModel;
import com.ivan.tableEditor.tableEditorView.workingArea.WorkingArea;
import com.ivan.tableEditor.tableEditorView.workingArea.WorkingAreaManager;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;


/**
 * Created by Ivan on 29.03.2017.
 */
public class SearchPersonDialog {


    public static final int ID_CANCEL = 0;

    private int exitCode = ID_CANCEL;
    private boolean isDeletedMod;
    private String dialogTitle;
    private TableModel tableModel;

    private JDialog searchPersonDialog;


    final JTabbedPane tabbedPane = new JTabbedPane();


    public SearchPersonDialog(boolean isDeletedMod, TableModel tableModel) {
        this.tableModel = tableModel;
        this.isDeletedMod = isDeletedMod;
        this.searchPersonDialog = new JDialog();
        createGUI();

    }


    private void createGUI() {
        if (!isDeletedMod) searchPersonDialog.setPreferredSize(new Dimension(900, 600));
        else searchPersonDialog.setPreferredSize(new Dimension(500, 300));
        if (isDeletedMod) dialogTitle = "Удалить студента";
        else dialogTitle = "Найти студента";
        searchPersonDialog.setTitle(dialogTitle);
        setTabs();
        searchPersonDialog.pack();
    }


    private void setTabs() {
        setSearchSurnameTab();
        setSearchGroupNumberTab();
        setSearchResultTab();
        setSearchExamResultTab();
        searchPersonDialog.add(tabbedPane);
    }


    private void setSearchSurnameTab() {
        JButton submitButton = new JButton(dialogTitle);
        List<JTextField> textFieldList = new ArrayList<>();
        TableModel searchResult = new TableModel();
        WorkingArea workingArea = new WorkingArea();
        workingArea.addListener(new WorkingAreaManager(searchResult));

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isInputValid()) {
                    if (isDeletedMod) {
                        JOptionPane.showMessageDialog(searchPersonDialog, "записей удалено " +
                                tableModel.deleteStudent(textFieldList.get(0).getText()));
                        searchPersonDialog.dispose();
                    } else {
                        searchResult.setTableData(tableModel.searchStudent(textFieldList.get(0).getText()));
                        workingArea.validate();
                    }
                } else {
                    JOptionPane.showMessageDialog(searchPersonDialog, "проверьте правильность ввода");
                }

            }

            private boolean isInputValid() {
                boolean isInputCorrect = true;
                Pattern nameField = Pattern.compile("([А-Я])[а-я]+");
                if (!nameField.matcher(textFieldList.get(0).getText()).matches()) isInputCorrect = false;
                return isInputCorrect;
            }
        });
        setOptionTab("Фамилия", submitButton, textFieldList, workingArea);
    }

    private void setSearchGroupNumberTab() {
        JButton submitButton = new JButton(dialogTitle);
        List<JTextField> textFieldList = new ArrayList<>();
        TableModel searchResult = new TableModel();
        WorkingArea workingArea = new WorkingArea();
        workingArea.addListener(new WorkingAreaManager(searchResult));

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isInputValid()) {
                    if (isDeletedMod) {
                        JOptionPane.showMessageDialog(searchPersonDialog, "записей удалено " +
                                tableModel.deleteStudent(Integer.parseInt(textFieldList.get(0).getText())));
                        searchPersonDialog.dispose();
                    } else {
                        searchResult.setTableData(tableModel.searchStudent(Integer.parseInt(textFieldList.get(0).getText())));
                        workingArea.validate();
                    }
                } else {
                    JOptionPane.showMessageDialog(searchPersonDialog, "проверьте правильность ввода");
                }
            }

            private boolean isInputValid() {
                boolean isInputCorrect = true;
                Pattern nameField = Pattern.compile("\\d+");
                if (!nameField.matcher(textFieldList.get(0).getText()).matches()) isInputCorrect = false;
                return isInputCorrect;
            }
        });
        setOptionTab("Номер группы", submitButton, textFieldList, workingArea);
    }

    private void setOptionTab(String title, JButton submitButton, List<JTextField> textFieldList, WorkingArea workingArea) {
        GridBagConstraints cell = new GridBagConstraints();
        Container dialogBody = new Container();
        dialogBody.setLayout(new GridBagLayout());
        cell.anchor = GridBagConstraints.CENTER;
        cell.gridheight = 1;
        cell.insets = new Insets(20, 20, 0, 0);

        addLabel(title, cell, dialogBody, 1, 0, 0);
        addTextField(textFieldList, cell, dialogBody, 1, 1, 0);
        addButton(submitButton, dialogBody);
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(new BorderLayout());
        panel.add(dialogBody, BorderLayout.NORTH);

        if (!isDeletedMod) {
            panel.add(workingArea.getWorkingAreaPanel(), BorderLayout.CENTER);
            workingArea.validate();
        }

        tabbedPane.addTab(title, panel);
    }


    private void setSearchResultTab() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(new BorderLayout());

        TableModel searchResult = new TableModel();
        WorkingArea workingArea = new WorkingArea();
        workingArea.addListener(new WorkingAreaManager(searchResult));

        if (!isDeletedMod) {
            panel.add(workingArea.getWorkingAreaPanel(), BorderLayout.CENTER);
            workingArea.validate();
        }

        java.util.List<JTextField> textFieldList = new ArrayList<>();
        GridBagConstraints cell = new GridBagConstraints();
        Container dialogBody = new Container();
        dialogBody.setLayout(new GridBagLayout());
        cell.anchor = GridBagConstraints.CENTER;
        cell.gridheight = 1;
        cell.insets = new Insets(20, 20, 0, 0);

        addLabel("минимальный порог", cell, dialogBody, 1, 0, 0);
        addTextField(textFieldList, cell, dialogBody, 1, 1, 0);

        addLabel("максимальный порог", cell, dialogBody, 1, 0, 1);
        addTextField(textFieldList, cell, dialogBody, 1, 1, 1);

        JButton submitButton = new JButton(dialogTitle);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isInputValid()) {
                    if (isDeletedMod) {
                        JOptionPane.showMessageDialog(searchPersonDialog, "записей удалено " +
                                tableModel.deleteStudent(Integer.parseInt(textFieldList.get(0).getText()),
                                        Integer.parseInt(textFieldList.get(1).getText())));
                        searchPersonDialog.dispose();
                    } else {
                        searchResult.setTableData(tableModel.searchStudent(Integer.parseInt(textFieldList.get(0).getText()),
                                Integer.parseInt(textFieldList.get(1).getText())));
                        workingArea.validate();
                    }
                } else {
                    JOptionPane.showMessageDialog(searchPersonDialog, "проверьте правильность ввода");
                }
            }

            private boolean isInputValid() {
                boolean isInputCorrect = true;
                Pattern examResultField = Pattern.compile("\\d|10");
                if (!examResultField.matcher(textFieldList.get(0).getText()).matches() ||
                        !examResultField.matcher(textFieldList.get(1).getText()).matches()) isInputCorrect = false;
                return isInputCorrect;
            }
        });
        addButton(submitButton, dialogBody);
        panel.add(dialogBody, BorderLayout.NORTH);
        tabbedPane.addTab("средний балл", panel);
    }


    private void setSearchExamResultTab() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(new BorderLayout());
        List<JTextField> textFieldList = new ArrayList<>();
        GridBagConstraints cell = new GridBagConstraints();
        Container dialogBody = new Container();
        dialogBody.setLayout(new GridBagLayout());
        cell.anchor = GridBagConstraints.CENTER;
        cell.gridheight = 1;
        cell.insets = new Insets(20, 20, 0, 0);

        TableModel searchResult = new TableModel();
        WorkingArea workingArea = new WorkingArea();
        workingArea.addListener(new WorkingAreaManager(searchResult));

        if (!isDeletedMod) {
            panel.add(workingArea.getWorkingAreaPanel(), BorderLayout.CENTER);
            workingArea.validate();
        }

        addLabel("название экзамена", cell, dialogBody, 1, 0, 1);
        addTextField(textFieldList, cell, dialogBody, 1, 1, 1);

        addLabel("минимальный порог", cell, dialogBody, 1, 0, 2);
        addTextField(textFieldList, cell, dialogBody, 1, 1, 2);

        addLabel("максимальный порог", cell, dialogBody, 1, 0, 3);
        addTextField(textFieldList, cell, dialogBody, 1, 1, 3);

        JButton submitButton = new JButton(dialogTitle);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!isDeletedMod && textFieldList.get(0).getText().equals("Слава Украине!!!")){
                  workingArea.setColor(Color.YELLOW);
                  panel.setBackground(Color.blue);
                  JOptionPane.showMessageDialog(searchPersonDialog, "Героям Слава!!!");
                } else if (isInputValid()) {
                    if (isDeletedMod) {
                        JOptionPane.showMessageDialog(searchPersonDialog, "записей удалено " +
                                tableModel.deleteStudent(textFieldList.get(0).getText(), Integer.parseInt(textFieldList.get(1).getText()),
                                        Integer.parseInt(textFieldList.get(2).getText())));
                        searchPersonDialog.dispose();
                    } else {
                        searchResult.setTableData(tableModel.searchStudent(textFieldList.get(0).getText(),
                                Integer.parseInt(textFieldList.get(1).getText()), Integer.parseInt(textFieldList.get(2).getText())));

                        workingArea.validate();

                    }
                } else {
                    JOptionPane.showMessageDialog(searchPersonDialog, "проверьте правильность ввода");
                }
            }

            private boolean isInputValid() {
                boolean isInputCorrect = true;
                Pattern examTitle = Pattern.compile("([А-Я]|[а-я])+");
                Pattern examResultField = Pattern.compile("\\d|10");
                if (!examTitle.matcher(textFieldList.get(0).getText()).matches() ||
                        !examResultField.matcher(textFieldList.get(1).getText()).matches() ||
                        !examResultField.matcher(textFieldList.get(2).getText()).matches()) isInputCorrect = false;
                return isInputCorrect;
            }
        });
        addButton(submitButton, dialogBody);
        panel.add(dialogBody, BorderLayout.NORTH);
        tabbedPane.addTab("Средний балл за экзамен", panel);
    }


    private void addButton(JButton button, Container tableBody) {
        GridBagConstraints cell = new GridBagConstraints();
        cell.gridx = 0;
        cell.gridy = GridBagConstraints.RELATIVE;
        cell.insets = new Insets(20, 20, 0, 0);
        tableBody.add(button, cell);
    }


    private void addLabel(String name, GridBagConstraints cell, Container dialogBody, int width, int x, int y) {
        cell.gridx = x;
        cell.gridy = y;
        cell.ipadx = 20;
        cell.gridwidth = width;
        cell.fill = GridBagConstraints.BOTH;
        JLabel label = new JLabel(name, SwingConstants.CENTER);
        dialogBody.add(label, cell);
    }

    private void addTextField(List<JTextField> textFieldList, GridBagConstraints cell, Container dialogBody, int width, int x, int y) {
        cell.gridx = x;
        cell.gridy = y;
        cell.ipadx = 100;
        cell.gridwidth = width;
        cell.fill = GridBagConstraints.BOTH;
        JTextField textField = new JTextField(20);
        dialogBody.add(textField, cell);
        textFieldList.add(textField);
    }

    public int startDialog() {
        searchPersonDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        searchPersonDialog.setModal(true);
        searchPersonDialog.setVisible(true);

        return exitCode;
    }


    public JDialog getDialog() {
        return searchPersonDialog;
    }


}
