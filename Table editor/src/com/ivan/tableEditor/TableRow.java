package com.ivan.tableEditor;

import java.util.List;

/**
 * Created by Ivan on 25.03.2017.
 */
public class TableRow {
        public String studentName;
        public int group;
        public List<Exam> exams;

        TableRow(String studentName, int group, List<Exam> exams) {
            this.studentName = studentName;
            this.group = group;
            this.exams = exams;

        }
        TableRow(){

        }

}
