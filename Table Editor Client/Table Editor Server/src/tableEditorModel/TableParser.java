package tableEditorModel; /**
 * Created by Ivan on 29.03.2017.
 */

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import java.util.ArrayList;
import java.util.List;

public class TableParser {
    final String TAG_STUDENT = "student";
    final String TAG_NAME = "studentName";
    final String TAG_SURNAME = "studentSurname";
    final String TAG_PATRONYMIC = "studentPatronymic";
    final String TAG_GROUP = "group";
    final String TAG_EXAMS = "exams";
    final String TAG_EXAM = "exam";
    final String TAG_EXAM_TITLE = "examTitle";
    final String TAG_EXAM_RESULT = "examResult";

    private List<Student> table;
    private Student currentStudent;
    private List<Exam> currentExams;
    private Exam currentExam;
    private  String tagName;

    TableParser() {
        table = new ArrayList<>();
        currentStudent = new Student();
        currentExams = new ArrayList<>();
        currentExam = new Exam();
    }



    public List<Student> parse(String path, SAXParser parser) throws Exception {
        parser.parse(path, new DefaultHandler() {

            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                tagName = qName;
                switch (tagName) {
                    case TAG_STUDENT:
                        currentStudent = new Student();
                        table.add(currentStudent);
                        break;
                    case TAG_EXAMS:
                        currentExams = new ArrayList<>();
                        currentStudent.exams = currentExams;
                        break;

                    case TAG_EXAM:
                        currentExam = new Exam();
                        currentExams.add(currentExam);
                        break;
                }

            }

            @Override
            public void characters(char ch[], int start, int length) throws SAXException {
                switch (tagName) {
                    case TAG_NAME:
                        currentStudent.studentName = new String(ch, start, length);
                        break;
                    case TAG_SURNAME:
                        currentStudent.studentSurname = new String(ch, start, length);
                        break;
                    case TAG_PATRONYMIC:
                        currentStudent.studentPatronymic = new String(ch, start, length);
                        break;
                    case TAG_GROUP:
                        currentStudent.group = Integer.valueOf(new String(ch, start, length));
                        break;
                    case TAG_EXAM_TITLE:
                        currentExam.exam = new String(ch, start, length);
                        break;
                    case TAG_EXAM_RESULT:
                        currentExam.result = Integer.valueOf(new String(ch, start, length));
                        break;
                }
            }

            @Override
            public void endElement(String uri, String localName, String qName) throws SAXException {
                super.endElement(uri, localName, qName);
            }

            @Override
            public void startDocument() throws SAXException {
            }

            @Override
            public void endDocument() throws SAXException {
            }
        });
        return table;
    }
}