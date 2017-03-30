package com.ivan.tableEditor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Ivan on 29.03.2017.
 */
public class WorkingArea {
    private JPanel workingArea;
    private int examsAmmount;
    private java.util.List<TableRow> table;

    private JLabel pageAmmountLabel;

    private int currentPage;
    private int ammountOfPages;
    private int ammountOfRecords;
    private Container tableContainer;

    WorkingArea(int examsAmmount) {

        currentPage = 1;
        ammountOfPages = 1;
        ammountOfRecords = 5;

        workingArea = new JPanel();
        workingArea.setBackground(new Color(175, 205, 231));
        workingArea.setLayout(new BorderLayout());
        this.examsAmmount = examsAmmount;
    }

    private void addToolPanel() {
        JToolBar toolBar = new JToolBar();
        toolBar.setPreferredSize(new Dimension(workingArea.getWidth(), 32));
        toolBar.setFloatable(false);
        setToolBarComponents(toolBar);
        workingArea.add(toolBar, BorderLayout.SOUTH);
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
                int priviousAmmountOfRecords = ammountOfRecords;
                ammountOfRecords = Integer.parseInt(records.getText());
                if (ammountOfRecords < 0) ammountOfRecords = 1;
                currentPage = 1;
                if (table != null) ammountOfPages = (int) Math.ceil((double) table.size() / ammountOfRecords);
                pageAmmountLabel.setText(String.valueOf(currentPage) + "/" + String.valueOf(ammountOfPages));
                workingArea.repaint();
                createTable(table);
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
                    workingArea.repaint();
                    createTable(table);
                }
            }
        });
        addButton("img/next.png", cell, componentsContainer, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentPage < ammountOfPages) {
                    currentPage++;
                    pageAmmountLabel.setText(String.valueOf(currentPage) + "/" + String.valueOf(ammountOfPages));
                    workingArea.repaint();
                    createTable(table);
                }
            }
        });
        addButton("img/home.png", cell, componentsContainer, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentPage = 1;
                pageAmmountLabel.setText(String.valueOf(currentPage) + "/" + String.valueOf(ammountOfPages));
                workingArea.repaint();
                createTable(table);
            }
        });
        addButton("img/end.png", cell, componentsContainer, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentPage = ammountOfPages;
                pageAmmountLabel.setText(String.valueOf(currentPage) + "/" + String.valueOf(ammountOfPages));
                workingArea.repaint();
                createTable(table);
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


    public void createTable(java.util.List<TableRow> table) {
        this.table = table;
        workingArea.removeAll();
        if (table != null) ammountOfPages = (int) Math.ceil((double) table.size() / ammountOfRecords);
        GridBagLayout tableLayout = new GridBagLayout();
        tableContainer = new Container();
        tableContainer.setLayout(tableLayout);
        printTableHeader(tableContainer);
        if (table != null) printTableBody(table, tableContainer);
        addToolPanel();
        workingArea.add(tableContainer, BorderLayout.NORTH);
        workingArea.validate();
        workingArea.repaint();
    }

    private void printTableBody(java.util.List<TableRow> table, Container tableContainer) {
        GridBagConstraints cell = new GridBagConstraints();

        cell.anchor = GridBagConstraints.CENTER;
        cell.fill = GridBagConstraints.BOTH;

        cell.gridy = 2;
        for (int recordNumber = (currentPage - 1) * ammountOfRecords; recordNumber < currentPage * ammountOfRecords; recordNumber++) {
            if (recordNumber >= table.size()) {
                break;
            }
            TableRow row = table.get(recordNumber);

            cell.gridheight = 1;
            cell.gridwidth = 1;
            cell.weightx = 1;
            cell.gridx = GridBagConstraints.RELATIVE;
            cell.gridy++;
            tableContainer.add(addLabe(row.studentName), cell);
            tableContainer.add(addLabe(String.valueOf(row.group)), cell);
            for (Exam exam : row.exams) {
                tableContainer.add(addLabe(exam.getExam()), cell);
                tableContainer.add(addLabe(String.valueOf(exam.getExamResult())), cell);
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

    public void setExamsAmmount(int examsAmmount) {
        this.examsAmmount = examsAmmount;
    }

    public JPanel getWorkingArea() {
        return workingArea;
    }
}
