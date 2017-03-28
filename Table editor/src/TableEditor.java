import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ivan on 21.03.2017.
 */
public class TableEditor {
    public static void main(String args[]){
     TableModel tableModel = new TableModel();

        List<Exam> exams = new ArrayList<>();
        exams.add( new Exam("Моис", 9));
        exams.add( new Exam("Ппвис", 8));
        exams.add( new Exam("Гео", 9));
        exams.add( new Exam("Отс", 9));
        exams.add( new Exam("Мрз", 9));

        tableModel.addStudent("Yakimtsov I.D.", 521701, exams);

        exams = new ArrayList<>();
        exams.add( new Exam("Моис", 4));
        exams.add( new Exam("Ппвис", 4));
        exams.add( new Exam("Гео", 4));
        exams.add( new Exam("Отс", 9));
        exams.add( new Exam("Мрз", 9));

        tableModel.addStudent("Hui S.G.", 521702, exams);

        TableView table = new TableView();
        table.createTable(tableModel.getTableData());

    }
}
