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
import java.util.List;

/**
 * Created by Ivan on 21.03.2017.
 */
public class TableModel {
    private List<Student> tableData;

    public TableModel() {
        tableData = new ArrayList<>();

    }

    public void addStudent(Student student) {
        tableData.add(student);
    }


    public List<Student> getTableData() {
        return tableData;
    }

    public List<Student> getPage(int pageNumber, int amountOfRecords){
        List<Student> page = new ArrayList<>();
        int firstRecordIndex = (pageNumber-1)*amountOfRecords;
        for (int index = firstRecordIndex; index < firstRecordIndex + amountOfRecords; index++){
            if(index>tableData.size() - 1) break;
            page.add(tableData.get(index));
        }

        return page;
    }

    public List<Student> searchStudent(int minResult, int maxResult) {
        List<Student> searchResult = new ArrayList<>();
        for (Student student : tableData) {
            double result = 0;
            for (Exam examResult : student.exams) {
                result += examResult.result;
            }
            result = result / student.exams.size();
            if (result >= minResult && result <= maxResult) {
                searchResult.add(student);
            }
        }
        return searchResult;
    }

    public List<Student> searchStudent(int groupNumber) {
        List<Student> searchResult = new ArrayList<>();

        for (Student student : tableData) {
            if (student.group == groupNumber) searchResult.add(student);
        }

        return searchResult;
    }

    public List<Student> searchStudent(String exam, int minResult, int maxResult) {
        List<Student> searchResult = new ArrayList<>();

        for (Student student : tableData) {
            for (Exam examResult : student.exams) {
                if (examResult.exam.equals(exam)) {
                    if (examResult.result >= minResult && examResult.result <= maxResult)
                        searchResult.add(student);
                }
            }

        }

        return searchResult;
    }



    public List<Student> searchStudent(String surname) {
        List<Student> searchResult = new ArrayList<>();

        for (Student student : tableData) {
            boolean isSurnameMatches = student.studentSurname.equals(surname);

            if (isSurnameMatches) searchResult.add(student);
        }
        return searchResult;
    }

    public int deleteStudent(String surname){
        List<Student> searchResult = this.searchStudent(surname);
        tableData.removeAll(searchResult);
        return searchResult.size();
    }

    public int deleteStudent(int groupNumber) {
        List<Student> searchResult = this.searchStudent(groupNumber);
        tableData.removeAll(searchResult);
        return searchResult.size();
    }


    public int deleteStudent(int minResult, int maxResult) {
        List<Student> searchResult = this.searchStudent(minResult, maxResult);
        tableData.removeAll(searchResult);
        return searchResult.size();
    }


    public int deleteStudent(String exam, int minResult, int maxResult) {
        List<Student> searchResult = this.searchStudent(exam, minResult, maxResult);
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
        Element RootElement = document.createElement("studentsList");

        for (Student student : tableData) {
            Element tableRow = document.createElement("student");

            Element studentSurname = document.createElement("studentSurname");
            studentSurname.appendChild(document.createTextNode(student.studentSurname));
            tableRow.appendChild(studentSurname);

            Element studentName = document.createElement("studentName");
            studentName.appendChild(document.createTextNode(student.studentName));
            tableRow.appendChild(studentName);


            Element studentPatronymic = document.createElement("studentPatronymic");
            studentPatronymic.appendChild(document.createTextNode(student.studentPatronymic));
            tableRow.appendChild(studentPatronymic);

            Element group = document.createElement("group");
            group.appendChild(document.createTextNode(String.valueOf(student.group)));
            tableRow.appendChild(group);

            Element exams = document.createElement("exams");

            for (Exam exam : student.exams) {
                Element examElement = document.createElement("exam");


                Element examTitle = document.createElement("examTitle");
                examTitle.appendChild(document.createTextNode(exam.exam));
                examElement.appendChild(examTitle);

                Element examResult = document.createElement("examResult");
                examResult.appendChild(document.createTextNode(String.valueOf(exam.result)));
                examElement.appendChild(examResult);

                exams.appendChild(examElement);
            }

            tableRow.appendChild(exams);

            RootElement.appendChild(tableRow);
        }

        document.appendChild(RootElement);

        Transformer t = TransformerFactory.newInstance().newTransformer();
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        t.transform(new DOMSource(document), new StreamResult(fileOutputStream));
        fileOutputStream.close();

    }


    public void openAction(String path) throws Exception {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            tableData = new TableParser().parse(path,saxParser);


    }


}

