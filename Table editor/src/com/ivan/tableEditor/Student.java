package com.ivan.tableEditor;

import java.util.List;

/**
 * Created by Ivan on 25.03.2017.
 */
public class Student {
        public String studentName;
        public String studentSurname;
        public String studentPatronymic;
        public int group;
        public List<Exam> exams;

        Student(String studentName,String studentSurname,String studentPatronymic, int group, List<Exam> exams) {
            this.studentName = studentName;
            this.studentSurname = studentSurname;
            this.studentPatronymic = studentPatronymic;
            this.group = group;
            this.exams = exams;
        }
        Student(){

        }

}
