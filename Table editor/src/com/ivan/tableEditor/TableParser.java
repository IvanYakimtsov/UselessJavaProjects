package com.ivan.tableEditor; /**
 * Created by Ivan on 29.03.2017.
 */

import javax.xml.parsers.SAXParser;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class TableParser {
    final String TAG_TABLE_ROW = "tableRow";
    final String TAG_NAME = "studentName";
    final String TAG_GROUP = "group";
    final String TAG_EXAMS = "exams";
    final String TAG_EXAM = "exam";
    final String TAG_EXAM_TITLE = "examTitle";
    final String TAG_EXAM_RESULT = "examResult";

    private List<TableRow> table;
    private TableRow currentRow;
    private List<Exam> currentExams;
    private Exam currentExam;
    private  String tagName;

    TableParser() {
        table = new ArrayList<>();
        currentRow = new TableRow();
        currentExams = new ArrayList<>();
        currentExam = new Exam();
    }



    public List<TableRow> parse(String path, SAXParser parser) throws Exception {
        parser.parse(path, new DefaultHandler() {

            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                tagName = qName;
                switch (tagName) {
                    case TAG_TABLE_ROW:
                        currentRow = new TableRow();
                        table.add(currentRow);
                        break;
                    case TAG_EXAMS:
                        currentExams = new ArrayList<>();
                        currentRow.exams = currentExams;
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
                        currentRow.studentName = new String(ch, start, length);
                        break;
                    case TAG_GROUP:
                        currentRow.group = Integer.valueOf(new String(ch, start, length));
                        break;
                    case TAG_EXAM_TITLE:
                        currentExam.setExam(new String(ch, start, length));
                        break;
                    case TAG_EXAM_RESULT:
                        currentExam.setResult(Integer.valueOf(new String(ch, start, length)));
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