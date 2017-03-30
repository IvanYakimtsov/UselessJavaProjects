package com.ivan.tableEditor;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Ivan on 29.03.2017.
 */
public class ResultDialog {
    public static final int ID_CANCEL = 0;

    private int exitCode = ID_CANCEL;

    private JDialog showPersonDialog;
    private int examsAmmount;

    java.util.List<TableRow> table;

    public ResultDialog(int examsAmmount,java.util.List<TableRow> table) {
        this.examsAmmount = examsAmmount;
        this.showPersonDialog = new JDialog();
        this.table = table;
        createGUI();

    }


    private void createGUI() {
        showPersonDialog.setPreferredSize(new Dimension(800, 400));
        showPersonDialog.setTitle("Результат поиска");
        showPersonDialog.setLayout(new BorderLayout());
        createBody();
        showPersonDialog.pack();
    }

    private void createBody() {
        showPersonDialog.setLayout(new BorderLayout());
        WorkingArea workingArea = new WorkingArea(examsAmmount);
        workingArea.createTable(table);
        showPersonDialog.add(workingArea.getWorkingArea(),BorderLayout.CENTER);
    }


    public int startDialog() {
        showPersonDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        showPersonDialog.setModal(true);
        showPersonDialog.setVisible(true);

        return exitCode;
    }


    public JDialog getDialog() {
        return showPersonDialog;
    }
}
