package com.ivan.tableEditor.tableEditorView.workingArea;

import com.ivan.tableEditor.tableEditorModel.Exam;
import com.ivan.tableEditor.tableEditorModel.Student;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by Ivan on 11.04.2017.
 */

public class WorkingAreaPanel extends JPanel {

    final public static int BACK_BUTTON_INDEX = 0;
    final public static int NEXT_BUTTON_INDEX = 1;
    final public static int HOME_BUTTON_INDEX = 2;
    final public static int END_BUTTON_INDEX = 3;

    private List<JButton> buttons;
    private JTextField records;
    private WorkingAreaData workingAreaData;
    private JLabel pageAmmountLabel;

    WorkingAreaPanel(WorkingAreaData workingAreaData) {
        this.buttons = new ArrayList<>();
        this.workingAreaData = workingAreaData;
        this.setBackground(new Color(175, 205, 231));
        this.setLayout(new BorderLayout());
    }


    private void addToolPanel() {
        buttons.clear();
        JToolBar toolBar = new JToolBar();
        toolBar.setPreferredSize(new Dimension(this.getWidth(), 32));
        toolBar.setFloatable(false);
        setToolBarComponents(toolBar);
        this.add(toolBar, BorderLayout.SOUTH);
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

        records = new JTextField(5);
        records.setText(String.valueOf(workingAreaData.getAmmountOfRecords()));


        componentsContainer.add(records, cell);

        label = new JLabel("Страница:");
        componentsContainer.add(label, cell);
        label = new JLabel(String.valueOf(workingAreaData.getCurrentPage()) + "/" +
                String.valueOf(workingAreaData.getAmmountOfPages()));
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

        addButton("img/back.png", cell, componentsContainer);
        addButton("img/next.png", cell, componentsContainer);
        addButton("img/home.png", cell, componentsContainer);
        addButton("img/end.png", cell, componentsContainer);
    }


    private void addButton(String filename, GridBagConstraints cell, Container componentsContainer) {
        JButton button = new JButton(new ImageIcon(filename));
        button.setBackground(null);
        button.setPreferredSize(new Dimension(28, 28));
        componentsContainer.add(button, cell);
        buttons.add(button);
    }


    public void drawPage(List<Student> page) {
        this.removeAll();
        GridBagLayout tableLayout = new GridBagLayout();
        Container tableContainer = new Container();
        tableContainer.setLayout(tableLayout);
        printTableHeader(tableContainer);
        if (page != null) printTableBody(tableContainer, page);
        addToolPanel();
        this.add(tableContainer, BorderLayout.NORTH);
        this.validate();
        this.repaint();
    }

    private void printTableBody(Container tableContainer, List<Student> page) {
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
            tableContainer.add(addLabe(student.studentSurname + " " + student.studentName + " "
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

        cell.gridwidth = 2 * workingAreaData.getExamsAmmount();
        cell.gridheight = 1;
        tableContainer.add(addLabe("Экзамены"), cell);

        cell.gridx = 1;
        for (int index = 0; index < workingAreaData.getExamsAmmount(); index++) {
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

    public java.util.List<JButton> getButtons() {
        return buttons;
    }

    public JTextField getRecords() {
        return records;
    }

    public JLabel getPageAmmountLabel() {
        return pageAmmountLabel;
    }
}
