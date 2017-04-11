package com.ivan.tableEditor;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

/**
 * Created by Ivan on 29.03.2017.
 */
public class SearchPersonDialog{

//
//    public static final int ID_CANCEL = 0;
//
//    private int exitCode = ID_CANCEL;
//    private boolean isDeletedMod;
//    private String dialogTitle;
//    private TableModel tableModel;
//    private TableModel searchResult;
//
//    private JDialog searchPersonDialog;
//    private WorkingArea workingArea;
//
//
//    final JTabbedPane tabbedPane = new JTabbedPane();
//
//
//    public SearchPersonDialog(boolean isDeletedMod, TableModel tableModel) {
//        this.tableModel = tableModel;
//        this.isDeletedMod = isDeletedMod;
//        if (!isDeletedMod) {
//            searchResult = new TableModel();
//        }
//        this.searchPersonDialog = new JDialog();
//        createGUI();
//
//    }
//
//
//    private void createGUI() {
//        searchPersonDialog.setPreferredSize(new Dimension(900, 400));
//        if (isDeletedMod) dialogTitle = "удалить студента";
//        else dialogTitle = "найти студента";
//        searchPersonDialog.setTitle(dialogTitle);
//        setTabs();
//        searchPersonDialog.pack();
//    }
//
//
//    private void setTabs() {
//        setSearchSurnameTab();
//        setSearchGroupNumberTab();
//        setSearchResultTab();
//        searchPersonDialog.add(tabbedPane);
//    }
//
//    private void setSearchSurnameTab() {
//        JButton submitButton = new JButton(dialogTitle);
//        java.util.List<JTextField> textFieldList = new ArrayList<>();
//        submitButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if (!isDeletedMod) {
//                    JOptionPane.showMessageDialog(searchPersonDialog, "записей удалено " +
//                            tableModel.deleteStudent(textFieldList.get(0).getText()));
//                    searchPersonDialog.dispose();
//                } else {
//                    searchResult.setTableData(tableModel.searchStudent(textFieldList.get(0).getText()));
//                    validateWorkingArea();
//                }
//            }
//        });
//        setOptionTab("Фамилия", submitButton, textFieldList);
//    }
//
//    private void setSearchGroupNumberTab() {
//        JButton submitButton = new JButton(dialogTitle);
//        java.util.List<JTextField> textFieldList = new ArrayList<>();
//        submitButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if (!isDeletedMod) {
//                    JOptionPane.showMessageDialog(searchPersonDialog, "записей удалено " +
//                            tableModel.deleteStudent(Integer.parseInt(textFieldList.get(0).getText())));
//                    searchPersonDialog.dispose();
//                } else {
//                    searchResult.setTableData(tableModel.searchStudent(Integer.parseInt(textFieldList.get(0).getText())));
//                    validateWorkingArea();
//                }
//            }
//        });
//        setOptionTab( "Номер группы", submitButton, textFieldList);
//    }
//
//    private void setOptionTab(String title, JButton submitButton, java.util.List<JTextField> textFieldList) {
//        WorkingArea workingArea = new WorkingArea(this);
//        GridBagConstraints cell = new GridBagConstraints();
//        Container dialogBody = new Container();
//        dialogBody.setLayout(new GridBagLayout());
//        cell.anchor = GridBagConstraints.CENTER;
//        cell.gridheight = 1;
//        cell.insets = new Insets(20, 20, 0, 0);
//
//        addLabel(title, cell, dialogBody, 1, 0, 0);
//        addTextField(textFieldList, cell, dialogBody, 1, 1, 0);
//        addButton(submitButton, dialogBody);
//        JPanel panel = new JPanel();
//        panel.setBackground(Color.WHITE);
//        panel.setLayout(new BorderLayout());
//        panel.add(dialogBody, BorderLayout.NORTH);
//        if (!isDeletedMod) {
//            panel.add(workingArea.getWorkingAreaPanel(),BorderLayout.CENTER);
//            workingArea.drawPage(null);
//        }
//
//        tabbedPane.addTab(title, panel);
//    }
//
//
//    private void setSearchResultTab() {
//        WorkingArea workingArea = new WorkingArea(this);
//        JPanel panel = new JPanel();
//        panel.setBackground(Color.WHITE);
//        panel.setLayout(new BorderLayout());
//
//        if (!isDeletedMod) {
//            panel.add(workingArea.getWorkingAreaPanel(), BorderLayout.CENTER);
//            workingArea.drawPage(null);
//        }
//
//        java.util.List<JTextField> textFieldList = new ArrayList<>();
//        GridBagConstraints cell = new GridBagConstraints();
//        Container dialogBody = new Container();
//        dialogBody.setLayout(new GridBagLayout());
//        cell.anchor = GridBagConstraints.CENTER;
//        cell.gridheight = 1;
//        cell.insets = new Insets(20, 20, 0, 0);
//
//        addLabel("минимальный порог", cell, dialogBody, 1, 0, 0);
//        addTextField(textFieldList, cell, dialogBody, 1, 1, 0);
//
//        addLabel("максимальный порог", cell, dialogBody, 1, 0, 1);
//        addTextField(textFieldList, cell, dialogBody, 1, 1, 1);
//
//        JButton submitButton = new JButton(dialogTitle);
//        submitButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if (!isDeletedMod) {
//                    JOptionPane.showMessageDialog(searchPersonDialog, "записей удалено " +
//                            tableModel.deleteStudent(Integer.parseInt(textFieldList.get(0).getText()),
//                                    Integer.parseInt(textFieldList.get(1).getText())));
//                    searchPersonDialog.dispose();
//                } else {
//                    searchResult.setTableData( tableModel.searchStudent(Integer.parseInt(textFieldList.get(0).getText(),
//                            Integer.parseInt(textFieldList.get(1).getText()))));
//                    validateWorkingArea();
//                }
//            }
//        });
//        addButton(submitButton, dialogBody);
//        panel.add(dialogBody, BorderLayout.NORTH);
//        tabbedPane.addTab("средний балл", panel);
//    }
////
////
////    private void addSecondButton(Container dialogBody, java.util.List<JTextField> textFieldList){
////        JButton button = new JButton(dialogTitle);
////        button.addActionListener(new ActionListener() {
////            @Override
////            public void actionPerformed(ActionEvent e) {
////                studentSurname = textFieldList.get(0).getText();
////                minResult = Integer.valueOf(textFieldList.get(1).getText());
////                maxResult = Integer.valueOf(textFieldList.get(2).getText());
////                exitCode = SearchPersonDialog.ID_SEARCH_OPTION_2;
////                searchPersonDialog.dispose();
////            }
////        });
////        addButton(button,dialogBody);
////    }
////
////    private void setThirdSearchOptionTab(){
////        JPanel panel = new JPanel();
////        panel.setLayout(new BorderLayout());
////        java.util.List<JTextField> textFieldList = new ArrayList<>();
////        GridBagConstraints cell =  new GridBagConstraints();
////        Container dialogBody = new Container();
////        dialogBody.setLayout(new GridBagLayout());
////        cell.anchor = GridBagConstraints.CENTER;
////        cell.gridheight = 1;
////        cell.insets = new Insets(20, 20, 0, 0);
////
////        addLabel("фaмилия студента",cell,dialogBody,1,0,0);
////        addTextField(textFieldList,cell,dialogBody,1,1,0);
////
////        addLabel("название экзамена",cell,dialogBody,1,0,1);
////        addTextField(textFieldList,cell,dialogBody,1,1,1);
////
////        addLabel("минимальный порог",cell,dialogBody,1,0,2);
////        addTextField(textFieldList,cell,dialogBody,1,1,2);
////
////        addLabel("максимальный порог",cell,dialogBody,1,0,3);
////        addTextField(textFieldList,cell,dialogBody,1,1,3);
////
////        addThirdButton(dialogBody,textFieldList);
////
////        panel.add(dialogBody,BorderLayout.NORTH);
////        tabbedPane.addTab("результат экзамена" , panel);
////    }
////
////    private void addThirdButton(Container dialogBody, java.util.List<JTextField> textFieldList){
////        JButton button = new JButton(dialogTitle);
////        button.addActionListener(new ActionListener() {
////            @Override
////            public void actionPerformed(ActionEvent e) {
////                studentSurname = textFieldList.get(0).getText();
////                exam = textFieldList.get(1).getText();
////                minResult = Integer.valueOf(textFieldList.get(2).getText());
////                maxResult = Integer.valueOf(textFieldList.get(3).getText());
////                exitCode = SearchPersonDialog.ID_SEARCH_OPTION_3;
////                searchPersonDialog.dispose();
////            }
////        });
////        addButton(button,dialogBody);
////    }
//
//    private void addButton(JButton button, Container tableBody) {
//        GridBagConstraints cell = new GridBagConstraints();
//        cell.gridx = 0;
//        cell.gridy = GridBagConstraints.RELATIVE;
//        cell.insets = new Insets(20, 20, 0, 0);
//        tableBody.add(button, cell);
//    }
//
//
//    private void addLabel(String name, GridBagConstraints cell, Container dialogBody, int width, int x, int y) {
//        cell.gridx = x;
//        cell.gridy = y;
//        cell.ipadx = 20;
//        cell.gridwidth = width;
//        cell.fill = GridBagConstraints.BOTH;
//        JLabel label = new JLabel(name, SwingConstants.CENTER);
//        dialogBody.add(label, cell);
//    }
//
//    private void addTextField(java.util.List<JTextField> textFieldList, GridBagConstraints cell, Container dialogBody, int width, int x, int y) {
//        cell.gridx = x;
//        cell.gridy = y;
//        cell.ipadx = 100;
//        cell.gridwidth = width;
//        cell.fill = GridBagConstraints.BOTH;
//        JTextField textField = new JTextField(20);
//        dialogBody.add(textField, cell);
//        textFieldList.add(textField);
//    }
//
//    public int startDialog() {
//        searchPersonDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//        searchPersonDialog.setModal(true);
//        searchPersonDialog.setVisible(true);
//
//        return exitCode;
//    }
//
//
//
//    public JDialog getDialog() {
//        return searchPersonDialog;
//    }
//
//    @Override
//    public void validateWorkingArea() {
//
//    }



}
