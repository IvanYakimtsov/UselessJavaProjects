import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Ivan on 21.03.2017.
 */
public class TableModel {
    private List<TableRow> tableData;

    TableModel() {
        tableData = new ArrayList<>();

    }

    public void addStudent(TableRow row) {
        tableData.add(row);
    }


    public List<TableRow> getTableData() {
        return tableData;
    }

    public List<TableRow> searchStudent(int minResult, int maxResult, String surname) {
        List<TableRow> searchResult;
        searchResult = findStudentBySurname(surname);
        if (!searchResult.isEmpty()) {
            searchResult = findStudentsByAverageExamsResult(minResult, maxResult, searchResult);
        }
        return searchResult;
    }

    public List<TableRow> searchStudent(int groupNumber, String surname) {
        List<TableRow> searchResult;
        searchResult = findStudentBySurname(surname);
        if (!searchResult.isEmpty()) {
            searchResult = findStudentsByGroupNumber(groupNumber, searchResult);
        }
        return searchResult;
    }

    public List<TableRow> searchStudent(String exam, int minResult, int maxResult, String surname) {
        List<TableRow> searchResult;
        searchResult = findStudentBySurname(surname);
        if (!searchResult.isEmpty()) {
            searchResult = findStudentByExamResult(minResult, maxResult, exam, searchResult);
        }
        return searchResult;
    }

    private List<TableRow> findStudentByExamResult(int minResult, int maxResult, String exam, List<TableRow> inputData) {
        List<TableRow> searchResult = new ArrayList<>();


        for (TableRow tableRow : inputData) {
            for (Exam examResult : tableRow.exams) {
                if (examResult.getExam().equals(exam)) {
                    if (examResult.getExamResult() >= minResult && examResult.getExamResult() <= maxResult)
                        searchResult.add(tableRow);
                }
            }

        }

        return searchResult;
    }

    public List<TableRow> findStudentsByGroupNumber(int groupNumber, List<TableRow> inputData) {
        List<TableRow> searchResult = new ArrayList<>(); //TODO: check this

        for (TableRow tableRow : inputData) {
            if (tableRow.group == groupNumber) searchResult.add(tableRow);
        }

        return searchResult;
    }

    public List<TableRow> findStudentBySurname(String surname) {
        List<TableRow> searchResult = new ArrayList<>();

        for (TableRow tableRow : tableData) {
            boolean isSurnameMatches = tableRow.studentName.split(" ")[0].equals(surname);

            if (isSurnameMatches) searchResult.add(tableRow);
        }
        return searchResult;
    }

    public List<TableRow> findStudentsByAverageExamsResult(int minResult, int maxResult, List<TableRow> inputData) {
        List<TableRow> searchResult = new ArrayList<>();


        for (TableRow tableRow : inputData) {

            double result = 0;

            for (Exam examResult : tableRow.exams) {
                result += examResult.getExamResult();
            }

            result = result / tableRow.exams.size();

            if (result >= minResult && result <= maxResult) {
                searchResult.add(tableRow);
            }

        }

        return searchResult;
    }


    public int deleteStudent(int groupNumber, String surname) {
        List<TableRow> searchResult = this.searchStudent(groupNumber, surname);
        tableData.removeAll(searchResult);
        return searchResult.size();
    }


    public int deleteStudent(int minResult, int maxResult, String surname) {
        List<TableRow> searchResult = this.searchStudent(minResult, maxResult, surname);
        tableData.removeAll(searchResult);
        return searchResult.size();
    }


    public int deleteStudent(String exam, int minResult, int maxResult, String surname) {
        List<TableRow> searchResult = this.searchStudent(exam, minResult, maxResult, surname);
        tableData.removeAll(searchResult);
        return searchResult.size();
    }

    private void clearData(List<TableRow> dataForCleaning) {
     tableData.removeAll(dataForCleaning);
    }


}
