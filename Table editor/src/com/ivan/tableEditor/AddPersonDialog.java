package com.ivan.tableEditor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.regex.Pattern;

/**
 * Created by Ivan on 28.03.2017.
 */
public class AddPersonDialog {
    public static final int ID_OK = 1;
    public static final int ID_CANCEL = 0;

    private int exitCode = ID_CANCEL;

    private JDialog addPersonDialog;

    private Student student;
    private java.util.List<JTextField> textFieldList;
    private int examsAmmount;


    public AddPersonDialog(int examsAmmount) {
        textFieldList = new ArrayList<>();
        this.examsAmmount = examsAmmount;
        this.addPersonDialog = new JDialog();
        createGUI();

    }


    private void createGUI() {
        addPersonDialog.setPreferredSize(new Dimension(600, 400));
        addPersonDialog.setTitle("Добавить студента");
        addPersonDialog.setLayout(new BorderLayout());
        createBody();
        addPersonDialog.pack();
    }

    private void createBody() {
        GridBagConstraints cell = new GridBagConstraints();
        Container dialogBody = new Container();
        dialogBody.setLayout(new GridBagLayout());
        cell.anchor = GridBagConstraints.CENTER;
        cell.gridheight = 1;
        cell.insets = new Insets(20, 20, 0, 0);

        addLabel("фио студента", cell, dialogBody, 1, 0, 0);
        addTextField(cell, dialogBody, 1, 1, 0);
        addTextField(cell, dialogBody, 1, 2, 0);
        addTextField(cell, dialogBody, 1, 3, 0);

        addLabel("группа", cell, dialogBody, 1, 0, 1);
        addTextField(cell, dialogBody, 3, 1, 1);

        for (int rowIndex = 2; rowIndex < examsAmmount + 2; rowIndex++) {
            addLabel("Экзамен", cell, dialogBody, 1, 0, rowIndex);
            addTextField(cell, dialogBody, 1, 1, rowIndex);

            addLabel("Результат", cell, dialogBody, 1, 2, rowIndex);
            addTextField(cell, dialogBody, 1, 3, rowIndex);
        }

        addSubmitButton(dialogBody);
        addPersonDialog.add(dialogBody, BorderLayout.NORTH);
    }


    private void addSubmitButton(Container dialogBody) {
        GridBagConstraints cell = new GridBagConstraints();
        cell.gridx = 0;
        cell.gridy = examsAmmount + 2;
        cell.insets = new Insets(20, 40, 0, 0);
        cell.anchor = GridBagConstraints.CENTER;

        JButton submitButton = new JButton("Добавить студента");


        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(isInputValid()){
                    addStudent();
                    exitCode = ID_OK;
                    addPersonDialog.dispose();
                } else {
                    JOptionPane.showMessageDialog(addPersonDialog, "проверьте правильность ввода");
                }
            }

            private void addStudent(){
                java.util.List<Exam> exams = new ArrayList<>();
                String studentSurname = textFieldList.get(0).getText();
                String studentName = textFieldList.get(1).getText();
                String studentPatronymic = textFieldList.get(2).getText();

                int group = Integer.parseInt(textFieldList.get(3).getText());
                for (int index = 4; index < textFieldList.size(); index += 2) {
                    String title = textFieldList.get(index).getText();
                    int result = Integer.parseInt(textFieldList.get(index + 1).getText());
                    exams.add(new Exam(title, result));
                }

                student = new Student(studentSurname, studentName, studentPatronymic,group, exams);
            }

            private boolean isInputValid(){
                boolean isInputCorrect = true;
                Pattern nameField = Pattern.compile("([А-Я])[а-я]+");
                Pattern examTitle = Pattern.compile("([А-Я]|[а-я])+");
                Pattern groupNumberField = Pattern.compile("\\d+");
                Pattern examResultField = Pattern.compile("\\d|10");

               for(int index = 0; index<3;index++){
                   if(!nameField.matcher(textFieldList.get(index).getText()).matches()) isInputCorrect = false;
               }

                if(!groupNumberField.matcher(textFieldList.get(3).getText()).matches()) isInputCorrect = false;

                for (int index = 4; index < textFieldList.size(); index += 2) {
                    if(!examTitle.matcher(textFieldList.get(index).getText()).matches()) isInputCorrect = false;
                    if(!examResultField.matcher(textFieldList.get(index+1).getText()).matches()) isInputCorrect = false;
                }

                return isInputCorrect;
            }
        });

        dialogBody.add(submitButton, cell);
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

    private void addTextField(GridBagConstraints cell, Container dialogBody, int width, int x, int y) {
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
        addPersonDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        addPersonDialog.setModal(true);
        addPersonDialog.setVisible(true);

        return exitCode;
    }

    public Student getStudent() {
        return student;
    }

    public JDialog getDialog() {
        return addPersonDialog;
    }
}
