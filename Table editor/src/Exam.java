/**
 * Created by Ivan on 25.03.2017.
 */
public class Exam {
    private String exam;
    private int result;

    public Exam(String exam, int result) {
        this.exam = exam;
        this.result = result;
    }

    public Exam(){

    }

    public void setExam(String exam) {
        this.exam = exam;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getExam() { return exam; }
    public int getExamResult() { return result; }
}
