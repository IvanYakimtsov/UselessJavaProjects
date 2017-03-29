import jdk.internal.org.xml.sax.Attributes;
import jdk.internal.org.xml.sax.helpers.DefaultHandler;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileOutputStream;
import java.io.IOException;
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

    public void saveAction(String path) throws TransformerException, IOException {
        writeParamXML(paramLangXML(), path);
    }


    private DocumentBuilder paramLangXML() {
        DocumentBuilder builder = null;
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        return builder;
    }

    private void writeParamXML(DocumentBuilder builder, String path) throws TransformerException, IOException {

        Document document = builder.newDocument();
        Element RootElement = document.createElement("table");

        for (TableRow row : tableData) {
            Element tableRow = document.createElement("tableRow");

            Element studentName = document.createElement("studentName");
            studentName.appendChild(document.createTextNode(row.studentName));
            tableRow.appendChild(studentName);

            Element group = document.createElement("group");
            group.appendChild(document.createTextNode(String.valueOf(row.group)));
            tableRow.appendChild(group);

            Element exams = document.createElement("exams");

            for (Exam exam : row.exams) {
                Element examElement = document.createElement("exam");


                Element examTitle = document.createElement("examTitle");
                examTitle.appendChild(document.createTextNode(exam.getExam()));
                examElement.appendChild(examTitle);

                Element examResult = document.createElement("examResult");
                examResult.appendChild(document.createTextNode(String.valueOf(exam.getExamResult())));
                examElement.appendChild(examResult);

                exams.appendChild(examElement);
            }

            tableRow.appendChild(exams);

            RootElement.appendChild(tableRow);
        }

        document.appendChild(RootElement);

        Transformer t = TransformerFactory.newInstance().newTransformer();
        t.transform(new DOMSource(document), new StreamResult(new FileOutputStream(path)));

    }


    public void openAction(String path) throws Exception {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            tableData = new TableParser().parse(path,saxParser);

    }


}

