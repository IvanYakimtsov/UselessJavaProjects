import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ivan on 21.03.2017.
 */
public class TableModel {
    private List<TableRow> tableData;


    TableModel() {
        tableData = new ArrayList<>();

    }

    public void addStudent(String studentName, int group, List<Exam> exams) {
        tableData.add(new TableRow(studentName, group, exams));
    }

    public List<TableRow> getTableData() {
        return tableData;
    }

    public List<TableRow> searchByAverageExamsResult(int minResult, int maxResult, String surname) {
        List<TableRow> searchResult;
        searchResult = findStudentBySurname(surname);
        if (!searchResult.isEmpty()) {
            searchResult = findStudentsByAverageExamsResult(minResult, maxResult, searchResult);
        }
        return searchResult;
    }

    public List<TableRow> searchByGroupNumber(int groupNumber, String surname) {
        List<TableRow> searchResult;
        searchResult = findStudentBySurname(surname);
        if (!searchResult.isEmpty()) {
            searchResult = findStudentsByGroupNumber(groupNumber, searchResult);
        }
        return searchResult;
    }

    public List<TableRow> searchByExamResult(String exam, int minResult, int maxResult, String surname) {
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
        List<TableRow> searchResult = new ArrayList<>();

        for (TableRow tableRow : tableData) {
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


    public void deleteByGroupNumber(int groupNumber, String surname) {
        List<TableRow> searchResult = this.searchByGroupNumber(groupNumber, surname);

        clearData(searchResult);
    }


    public void deleteByAverageExamsResult(int minResult, int maxResult, String surname) { //TODO: change to int to
                                                                                          //TODO: show how many results were deleted
        List<TableRow> searchResult = this.searchByAverageExamsResult(minResult, maxResult, surname);

        clearData(searchResult);
    }


    public void deleteByExamResult(String exam, int minResult, int maxResult, String surname) {
        List<TableRow> searchResult = this.searchByExamResult(exam, minResult, maxResult, surname);

        clearData(searchResult);
    }

    private void clearData(List<TableRow> dataForCleaning) {
        for (TableRow tableRow : tableData) {
            for (TableRow resultRow : dataForCleaning) {
                if (tableRow == resultRow) tableData.remove(tableRow);
            }
        }
    }


}
