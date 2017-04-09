package com.ivan.tableEditor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Ivan on 29.03.2017.
 */
public class WorkingArea {
    private JPanel workingAreaPanel;

    private JLabel pageAmmountLabel;

    private int currentPage;
    private int ammountOfPages;
    private int ammountOfRecords;
    private int examsAmmount;

    private Container tableContainer;
    private TableManager tableManager;

    WorkingArea(TableManager tableManager) {

        currentPage = 1;
        ammountOfPages = 1;
        ammountOfRecords = 5;
        examsAmmount = 5;

        this.tableManager = tableManager;

        workingAreaPanel = new JPanel();
        workingAreaPanel.setBackground(new Color(175, 205, 231));
        workingAreaPanel.setLayout(new BorderLayout());
    }

    private void addToolPanel() {
        JToolBar toolBar = new JToolBar();
        toolBar.setPreferredSize(new Dimension(workingAreaPanel.getWidth(), 32));
        toolBar.setFloatable(false);
        setToolBarComponents(toolBar);
        workingAreaPanel.add(toolBar, BorderLayout.SOUTH);
    }


    private void setToolBarComponents(JToolBar toolBar) {
        Container componentsContainer = new Container();
        toolBar.setLayout(new BorderLayout());
        componentsContainer.setLayout(new GridBagLayout());
        GridBagConstraints cell = new GridBagConstraints();
        cell.gridy = 0;
        cell.anchor = GridBagConstraints.CENTER;
        cell.gridx = GridBagConstraints.RELATIVE;
        cell.insets = new Insets(0, 0, 0, 5);

        JLabel label = new JLabel("Количество записей");
        componentsContainer.add(label, cell);

        JTextField records = new JTextField(5);
        records.setText(String.valueOf(this.ammountOfRecords));
        records.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ammountOfRecords = Integer.parseInt(records.getText());
                if (ammountOfRecords < 0) ammountOfRecords = 1;
                currentPage = 1;
                pageAmmountLabel.setText(String.valueOf(currentPage) + "/" + String.valueOf(ammountOfPages));
                tableManager.validateWorkingArea();
            }
        });
        componentsContainer.add(records, cell);

        label = new JLabel("Страница:");
        componentsContainer.add(label, cell);
        label = new JLabel(String.valueOf(currentPage) + "/" + String.valueOf(ammountOfPages));
        pageAmmountLabel = label;

        componentsContainer.add(label);

        createButtons(componentsContainer);

        toolBar.add(componentsContainer, BorderLayout.WEST);
    }

    private void createButtons(Container componentsContainer) {
        GridBagConstraints cell = new GridBagConstraints();
        cell.gridy = 0;
        cell.anchor = GridBagConstraints.CENTER;
        cell.gridx = GridBagConstraints.RELATIVE;
        cell.insets = new Insets(0, 20, 0, 0);

        addButton("img/back.png", cell, componentsContainer, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentPage > 1) {
                    currentPage--;
                    pageAmmountLabel.setText(String.valueOf(currentPage) + "/" + String.valueOf(ammountOfPages));
                    workingAreaPanel.repaint();
                    tableManager.validateWorkingArea();
                }
            }
        });
        addButton("img/next.png", cell, componentsContainer, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentPage < ammountOfPages) {
                    currentPage++;
                    pageAmmountLabel.setText(String.valueOf(currentPage) + "/" + String.valueOf(ammountOfPages));
                    workingAreaPanel.repaint();
                    tableManager.validateWorkingArea();
                }
            }
        });
        addButton("img/home.png", cell, componentsContainer, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentPage = 1;
                pageAmmountLabel.setText(String.valueOf(currentPage) + "/" + String.valueOf(ammountOfPages));
                workingAreaPanel.repaint();
                tableManager.validateWorkingArea();
            }
        });
        addButton("img/end.png", cell, componentsContainer, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentPage = ammountOfPages;
                pageAmmountLabel.setText(String.valueOf(currentPage) + "/" + String.valueOf(ammountOfPages));
                workingAreaPanel.repaint();
                tableManager.validateWorkingArea();
            }
        });
    }


    private void addButton(String filename, GridBagConstraints cell, Container componentsContainer, ActionListener actionListener) {
        JButton button = new JButton(new ImageIcon(filename));
        button.setBackground(null);
        button.setPreferredSize(new Dimension(28, 28));
        button.addActionListener(actionListener);
        componentsContainer.add(button, cell);
    }


    public void drawPage(java.util.List<Student> page) {
        workingAreaPanel.removeAll();
        GridBagLayout tableLayout = new GridBagLayout();
        tableContainer = new Container();
        tableContainer.setLayout(tableLayout);
        printTableHeader(tableContainer);
        if (page != null) printTableBody(page, tableContainer);
        addToolPanel();
        workingAreaPanel.add(tableContainer, BorderLayout.NORTH);
        workingAreaPanel.validate();
        workingAreaPanel.repaint();
    }

    private void printTableBody(java.util.List<Student> page, Container tableContainer) {
        GridBagConstraints cell = new GridBagConstraints();

        cell.anchor = GridBagConstraints.CENTER;
        cell.fill = GridBagConstraints.BOTH;

        cell.gridy = 2;
        for (Student student : page) {
            cell.gridheight = 1;
            cell.gridwidth = 1;
            cell.weightx = 1;
            cell.gridx = GridBagConstraints.RELATIVE;
            cell.gridy++;
            tableContainer.add(addLabe(student.studentName + " " + student.studentSurname + " "
                    + student.studentPatronymic), cell);
            tableContainer.add(addLabe(String.valueOf(student.group)), cell);
            for (Exam exam : student.exams) {
                tableContainer.add(addLabe(exam.exam), cell);
                tableContainer.add(addLabe(String.valueOf(exam.result)), cell);
            }
        }
    }

    private void printTableHeader(Container tableContainer) {
        GridBagConstraints cell = new GridBagConstraints();

        cell.anchor = GridBagConstraints.CENTER;
        cell.fill = GridBagConstraints.BOTH;
        cell.gridheight = 3;
        cell.gridwidth = 1;
        cell.weightx = 1;
        cell.gridx = 0;
        cell.gridy = 0;
        tableContainer.add(addLabe("фио студента"), cell);

        cell.gridx = GridBagConstraints.RELATIVE;
        tableContainer.add(addLabe("группа"), cell);

        cell.gridwidth = 2 * examsAmmount;
        cell.gridheight = 1;
        tableContainer.add(addLabe("Экзамены"), cell);

        cell.gridx = 1;
        for (int index = 0; index < examsAmmount; index++) {
            cell.gridx = GridBagConstraints.RELATIVE;
            cell.gridy = 1;
            cell.gridwidth = 2;
            tableContainer.add(addLabe(String.valueOf(index + 1)), cell);

            cell.gridwidth = 1;
            cell.gridy = 2;
            tableContainer.add(addLabe("Наименование"), cell);

            cell.gridx = GridBagConstraints.RELATIVE;
            tableContainer.add(addLabe("Результат"), cell);
        }

    }


    private JLabel addLabe(String name) {
        JLabel newLabel = new JLabel(name, SwingConstants.CENTER);
        newLabel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, Color.BLACK));
        return newLabel;
    }


    public JPanel getWorkingAreaPanel() {
        return workingAreaPanel;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public int getAmmountOfRecords() {
        return ammountOfRecords;
    }

    public int getExamsAmmount() {
        return examsAmmount;
    }

    public void setAmmountOfPages(int tableSize) {
        this.ammountOfPages = (int) Math.ceil((double) tableSize / ammountOfRecords);
    }
}
