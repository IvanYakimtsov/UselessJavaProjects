package dataModel;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Ivan on 25.03.2017.
 */
public class Student implements Serializable {
        public String studentSurname;
        public String studentName;
        public String studentPatronymic;
        public int group;
        public List<Exam> exams;

        public Student(String studentSurname, String studentName, String studentPatronymic, int group, List<Exam> exams) {
            this.studentName = studentName;
            this.studentSurname = studentSurname;
            this.studentPatronymic = studentPatronymic;
            this.group = group;
            this.exams = exams;
        }
        Student(){

        }

}
