package dataModel;

import java.io.Serializable;

/**
 * Created by Ivan on 25.03.2017.
 */
public class Exam implements Serializable{
    public String exam;
    public int result;

    public Exam(String exam, int result) {
        this.exam = exam;
        this.result = result;
    }
    public Exam(){

    }

}
