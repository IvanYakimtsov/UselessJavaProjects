import javax.swing.*;
import java.awt.*;
import java.awt.List;
import java.util.*;

/**
 * Created by Ivan on 29.03.2017.
 */
public class WorkingArea {
    JPanel workingArea;
    int examsAmmount;
    WorkingArea(int examsAmmount){
        workingArea = new JPanel();
        workingArea.setBackground(new Color(175, 205, 231));
        workingArea.setLayout(new BorderLayout());
        this.examsAmmount = examsAmmount;
    }

    public void createTable(java.util.List<TableRow> table) {
        //TODO: add ammount of rows depanding from page
        workingArea.removeAll();
        GridBagLayout tableLayout = new GridBagLayout();
        Container tableContainer = new Container();
        tableContainer.setLayout(tableLayout);
        printTableHeader(tableContainer);
        if (table != null) printTableBody(table, tableContainer);
        workingArea.add(tableContainer, BorderLayout.NORTH);
    }

    private void printTableBody(java.util.List<TableRow> table, Container tableContainer) {
        GridBagConstraints cell = new GridBagConstraints();

        cell.anchor = GridBagConstraints.CENTER;
        cell.fill = GridBagConstraints.BOTH;

        cell.gridy = 2;
        for (TableRow row : table) {
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

        cell.gridwidth = 2*examsAmmount;
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
