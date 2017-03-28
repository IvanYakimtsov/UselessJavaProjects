/**
 * Created by Ivan on 25.03.2017.
 */
public class Exam {
    private final String exam;
    private final int result;

    public Exam(String exam, int result) {
        this.exam = exam;
        this.result = result;
    }
    public String getExam() { return exam; }
    public int getExamResult() { return result; }
}
