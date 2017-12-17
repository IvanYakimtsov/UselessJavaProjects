package dataModel;

import com.mysql.fabric.jdbc.FabricMySQLDriver;
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
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Ivan on 21.03.2017.
 */
public class TableModel {
   // private List<Student> tableData;

    private final String URL = "jdbc:mysql://localhost:3306/studentDB";
    private final String USERNAME = "root";
    private final String PASSWORD = "root";

    private String studentTableName = "defaultStudentTable";
    private String examTableName = "defaultExamTable";
    private java.sql.Connection dbConnection;

    public TableModel() throws Exception {

        Driver driver = new FabricMySQLDriver();

        DriverManager.registerDriver(driver);

        dbConnection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

    }

    public void addStudent(Student student) throws Exception {
        String query = "INSERT INTO " + studentTableName +" VALUES (NULL,?,?,?,?)";
        PreparedStatement prepareStatement = dbConnection.prepareStatement(query);
        prepareStatement.setString(1,student.studentSurname);
        prepareStatement.setString(2,student.studentName);
        prepareStatement.setString(3,student.studentPatronymic);
        prepareStatement.setInt(4,student.group);
        prepareStatement.execute();

        String id_query = "SELECT id FROM " + studentTableName +" WHERE surname = ? && name = ? && patronymic = ?" +
                " && groupNumber = ?";
        prepareStatement = dbConnection.prepareStatement(id_query);
        prepareStatement.setString(1,student.studentSurname);
        prepareStatement.setString(2,student.studentName);
        prepareStatement.setString(3,student.studentPatronymic);
        prepareStatement.setInt(4,student.group);
        ResultSet res = prepareStatement.executeQuery();
        res.next();
        int id = res.getInt(1);
        String exam_query = "INSERT INTO " + examTableName +" VALUES (?,?,?)";
        for (Exam exam : student.exams){
            prepareStatement = dbConnection.prepareStatement(exam_query);
            prepareStatement.setInt(1,id);
            prepareStatement.setString(2,exam.exam);
            prepareStatement.setInt(3, exam.result);
            prepareStatement.execute();
        }
        prepareStatement.close();
    }


    public int getAmountOfRecords() throws Exception{
        String query = "select COUNT(*) FROM " + studentTableName;
        PreparedStatement prepareStatement = dbConnection.prepareStatement(query);
        ResultSet res = prepareStatement.executeQuery();
        res.next();
        return res.getInt(1);
    }

    public List<Student> getPage(int pageNumber, int amountOfRecords) throws Exception{
        List<Student> page = new ArrayList<>();
        int firstRecordIndex = (pageNumber - 1) * amountOfRecords;
//        for (int index = firstRecordIndex; index < firstRecordIndex + amountOfRecords; index++) {
//            if (index > tableData.size() - 1) break;
//            page.add(tableData.get(index));
//        }
        String query = "SELECT * FROM "+ studentTableName +" ORDER BY surname LIMIT ? OFFSET ?";
        PreparedStatement prepareStatement = dbConnection.prepareStatement(query);
        prepareStatement.setInt(1, amountOfRecords);
        prepareStatement.setInt(2, firstRecordIndex);
        ResultSet res = prepareStatement.executeQuery();
        //prepareStatement.close();
        page = createResult(res);
        return page;
    }

    public List<Student> searchStudent(int minResult, int maxResult) throws Exception{
        List<Student> searchResult = new ArrayList<>();
        String query = "SELECT DISTINCT a.student_id FROM " +
                examTableName +" a WHERE ?<(SELECT AVG(exam_result) FROM " + examTableName +" b WHERE b.student_id = a.student_id) " +
                "&& ?>(SELECT AVG(exam_result) FROM "+ examTableName +" b WHERE b.student_id = a.student_id)";
        PreparedStatement prepareStatement = dbConnection.prepareStatement(query);
        prepareStatement.setInt(1, minResult);
        prepareStatement.setInt(2, maxResult);
        ResultSet res = prepareStatement.executeQuery();

        String id_query = "SELECT * FROM "+ studentTableName +" WHERE id = ?";

        while (res.next()){
            int id = res.getInt("student_id");
            prepareStatement = dbConnection.prepareStatement(id_query);
            prepareStatement.setInt(1, id);
            ResultSet studentData = prepareStatement.executeQuery();
            List<Student> tmp = createResult(studentData);
            searchResult.add(tmp.get(0));
        }
        return searchResult;
    }

    public List<Student> searchStudent(int groupNumber) throws Exception {
        List<Student> page;
        String query = "SELECT * FROM "+ studentTableName +" WHERE groupNumber = ? ORDER BY surname";
        PreparedStatement prepareStatement = dbConnection.prepareStatement(query);
        prepareStatement.setInt(1, groupNumber);
        ResultSet res = prepareStatement.executeQuery();
        page = createResult(res);
        return page;
    }

    public List<Student> createResult(ResultSet res) throws Exception{
        List<Student> searchResult = new ArrayList<Student>();
        String id_query = "SELECT id FROM " + studentTableName +" WHERE surname = ? && name = ? && patronymic = ?" +
                " && groupNumber = ?";
        String exam_query = "SELECT exam,exam_result FROM " + examTableName + " WHERE student_id = ?";

        PreparedStatement prepareStatement;

        while (res.next()){
         //   System.out.println("check student");
            Student student = new Student();

            student.studentSurname = res.getString("surname");
            student.studentName = res.getString("name");
            student.studentPatronymic = res.getString("patronymic");
            student.group = res.getInt("groupNumber");
            student.exams = new ArrayList<Exam>();


            prepareStatement = dbConnection.prepareStatement(id_query);
            prepareStatement.setString(1,student.studentSurname);
            prepareStatement.setString(2,student.studentName);
            prepareStatement.setString(3,student.studentPatronymic);
            prepareStatement.setInt(4,student.group);
            ResultSet id_res = prepareStatement.executeQuery();
            id_res.next();
            int id = res.getInt(1);
           // System.out.println("check id " + id);
            prepareStatement = dbConnection.prepareStatement(exam_query);
            prepareStatement.setInt(1,id);
            ResultSet examSet = prepareStatement.executeQuery();
            while (examSet.next()){
             //   System.out.println("check exam");
               String exam = examSet.getString("exam");
               int exam_result = examSet.getInt("exam_result");
               student.exams.add(new Exam(exam,exam_result));
            }
       //     System.out.println("check");
            searchResult.add(student);
        }
     //   System.out.println("return page");
        return searchResult;
    }

    public List<Student> searchStudent(String exam, int minResult, int maxResult) throws Exception{
        List<Student> searchResult = new ArrayList<>();
        String query = "SELECT DISTINCT student_id FROM "+ examTableName +" WHERE exam = ? && exam_result > ? && exam_result <?";
        PreparedStatement prepareStatement = dbConnection.prepareStatement(query);
        prepareStatement.setString(1, exam);
        prepareStatement.setInt(2, minResult);
        prepareStatement.setInt(3, maxResult);
        ResultSet res = prepareStatement.executeQuery();

        String id_query = "SELECT * FROM "+ studentTableName +" WHERE id = ?";

        while (res.next()){
            int id = res.getInt("student_id");
           // System.out.println(id);
            prepareStatement = dbConnection.prepareStatement(id_query);
            prepareStatement.setInt(1, id);
            ResultSet studentData = prepareStatement.executeQuery();
            List<Student> tmp = createResult(studentData);
            searchResult.add(tmp.get(0));
        }
        return searchResult;
    }


    public List<Student> searchStudent(String surname) throws Exception{
        List<Student> page;
        String query = "SELECT * FROM "+ studentTableName +" WHERE surname = ?";
        PreparedStatement prepareStatement = dbConnection.prepareStatement(query);
        prepareStatement.setString(1, surname);
        ResultSet res = prepareStatement.executeQuery();
        page = createResult(res);
        return page;
    }

    public int deleteStudent(String surname) throws Exception{
        String query = "SELECT id FROM "+ studentTableName +" WHERE surname = ?";
        String deleteQuery = "DELETE FROM "+ studentTableName +" WHERE surname = ?";
        String deleteExamQuery = "DELETE FROM "+ examTableName +" WHERE student_id = ?";

        PreparedStatement prepareStatement = dbConnection.prepareStatement(query);
        prepareStatement.setString(1, surname);
        ResultSet res = prepareStatement.executeQuery();
        while (res.next()){
            prepareStatement = dbConnection.prepareStatement(deleteExamQuery);
            prepareStatement.setInt(1, res.getInt("id"));
            prepareStatement.execute();
        }

        prepareStatement = dbConnection.prepareStatement(deleteQuery);
        prepareStatement.setString(1, surname);
        int amount = prepareStatement.executeUpdate();
        return amount;
    }

    public int deleteStudent(int groupNumber) throws Exception{
        String query = "SELECT id FROM "+ studentTableName +" WHERE groupNumber = ?";
        String deleteQuery = "DELETE FROM "+ studentTableName +" WHERE groupNumber = ?";
        String deleteExamQuery = "DELETE FROM "+ examTableName +" WHERE student_id = ?";

        PreparedStatement prepareStatement = dbConnection.prepareStatement(query);
        prepareStatement.setInt(1, groupNumber);
        ResultSet res = prepareStatement.executeQuery();
        while (res.next()){
            prepareStatement = dbConnection.prepareStatement(deleteExamQuery);
            prepareStatement.setInt(1, res.getInt("id"));
            prepareStatement.execute();
        }

        prepareStatement = dbConnection.prepareStatement(deleteQuery);
        prepareStatement.setInt(1, groupNumber);
        int amount = prepareStatement.executeUpdate();
        return amount;
    }


    public int deleteStudent(int minResult, int maxResult)  throws Exception{
        String query = "SELECT DISTINCT a.student_id FROM " +
                examTableName +" a WHERE ?<(SELECT AVG(exam_result) FROM " + examTableName +" b WHERE b.student_id = a.student_id) " +
                "&& ?>(SELECT AVG(exam_result) FROM "+ examTableName +" b WHERE b.student_id = a.student_id)";
        PreparedStatement prepareStatement = dbConnection.prepareStatement(query);
        prepareStatement.setInt(1, minResult);
        prepareStatement.setInt(2, maxResult);
        ResultSet res = prepareStatement.executeQuery();
        return deleteIDSet(res);
    }


    public int deleteStudent(String exam, int minResult, int maxResult) throws Exception{
        String query = "SELECT DISTINCT student_id FROM "+ examTableName +" WHERE exam = ? && exam_result > ? && exam_result <?";
        PreparedStatement prepareStatement = dbConnection.prepareStatement(query);
        prepareStatement.setString(1, exam);
        prepareStatement.setInt(2, minResult);
        prepareStatement.setInt(3, maxResult);
        ResultSet res = prepareStatement.executeQuery();
        return deleteIDSet(res);
    }

    private int deleteIDSet(ResultSet res) throws Exception{
        int count = 0;
        String deleteQuery = "DELETE FROM "+ studentTableName +" WHERE id = ?";
        String deleteExamQuery = "DELETE FROM "+ examTableName +" WHERE student_id = ?";
        PreparedStatement prepareStatement;
        while (res.next()){
            prepareStatement = dbConnection.prepareStatement(deleteExamQuery);
            prepareStatement.setInt(1, res.getInt("student_id"));
            prepareStatement.execute();

            prepareStatement = dbConnection.prepareStatement(deleteQuery);
            prepareStatement.setInt(1, res.getInt("student_id"));
            prepareStatement.execute();
            count++;
        }
        return count;
    }

    public void saveAction(String name) throws Exception{
        studentTableName = name + "StudentTable";
        examTableName = name + "ExamTable";
     //   System.out.println("saveAction");
        //TODO: fix foreign key
        String createStudentTable = "CREATE TABLE " + studentTableName +" (" +
                "                id INTEGER NOT NULL AUTO_INCREMENT," +
                "                surname VARCHAR(30) NOT NULL," +
                "                name VARCHAR(30) NOT NULL," +
                "                patronymic VARCHAR(30)," +
                "                groupNumber INTEGER NOT NULL," +
                "                PRIMARY KEY (id)" +
                "        )";

        PreparedStatement prepareStatement = dbConnection.prepareStatement(createStudentTable);
        prepareStatement.execute();
//        String createExamTable = "CREATE TABLE "+ examTableName+" (\n" +
//                " student_id INTEGER NOT NULL," +
//                " exam VARCHAR(10) NOT NULL," +
//                " exam_result SMALLINT(10) NOT NULL," +
//                " FOREIGN KEY(student_id) REFERENCES "+examTableName+"(id))";
        String createExamTable = "CREATE TABLE "+ examTableName+" (\n" +
                " student_id INTEGER NOT NULL," +
                " exam VARCHAR(10) NOT NULL," +
                " exam_result SMALLINT(10) NOT NULL)";
        prepareStatement = dbConnection.prepareStatement(createExamTable);
        prepareStatement.execute();
        prepareStatement.close();
    }



    public void openAction(String name) throws Exception {
      //  System.out.println("openAction");
          studentTableName = name + "StudentTable";
          examTableName = name + "ExamTable";

    }


}

