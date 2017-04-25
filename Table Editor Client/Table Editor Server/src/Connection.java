import tableEditorModel.Exam;
import tableEditorModel.Student;
import tableEditorModel.TableModel;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ivan on 24.04.2017.
 */
public class Connection implements Runnable {
    private  Socket socket;
    private TableModel tableModel;
    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;
    private Server server;

    Connection(Socket socket,Server server) throws Throwable {
        this.server = server;
        this.socket = socket;
        this.tableModel = new TableModel();
    }

    @Override
    public void run() {
        try {
            InputStream sin = socket.getInputStream();
            OutputStream sout = socket.getOutputStream();

            dataInputStream = new DataInputStream(sin);
            dataOutputStream = new DataOutputStream(sout);


            String comand = null;
            while (true) {
                comand = dataInputStream.readUTF();
                switch (comand) {
                    case Comands.ADD_PERSON:
                        addPersonComand();
                        break;
                    case Comands.DELETE_PERSON:
                        deletePersonCommand();
                        break;
                    case Comands.SEARCH_PERSON:
                        searchPersonCommand();
                        break;

                    case Comands.SAVE:
                        saveCommand();
                        break;
                    case Comands.OPEN:
                        openCommand();
                        break;
                    case Comands.KILL_CONNECTION:
                        killConnection();
                        break;
                    case Comands.GET_PAGE:
                        getPageCommand();
                        break;
                    case Comands.GET_AMMOUNT_OF_RECORDS:
                        getAmountOfRecords();
                        break;
                }
            }
        } catch (IOException e) {
            killConnection();
            e.printStackTrace();
        }


    }

    private void addPersonComand() {
        try {
            String studentSurname = dataInputStream.readUTF();
            String studentName = dataInputStream.readUTF();
            String studentPatronymic = dataInputStream.readUTF();
            int group = dataInputStream.readInt();
            List<Exam> exams = new ArrayList<>();
            while (true){
                String exam = dataInputStream.readUTF();
                if(exam.equals(Comands.STOP_WRITING)) break;
                int result = dataInputStream.readInt();
                exams.add(new Exam(exam,result));
            }
            tableModel.addStudent(new Student(studentSurname,studentName,studentPatronymic,group,exams));
            dataOutputStream.writeUTF(Comands.OK_RESPONSE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deletePersonCommand() {

    }

    private void searchPersonCommand() {

    }

    private void saveCommand() {

    }

    private void openCommand() {

    }


    private void getAmountOfRecords(){
        try {
            dataOutputStream.writeInt(tableModel.getTableData().size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void getPageCommand(){
        try {
            int pageNumber = dataInputStream.readInt();
            int amountOfRecords = dataInputStream.readInt();
            List<Student> page = tableModel.getPage(pageNumber,amountOfRecords);
            if (page == null) dataOutputStream.writeUTF(Comands.ERROR_RESPONSE);
                    else {
                             for (Student student : page){
                                 dataOutputStream.writeUTF(Comands.OK_RESPONSE);
                                 dataOutputStream.writeUTF(student.studentSurname);
                                 dataOutputStream.writeUTF(student.studentName);
                                 dataOutputStream.writeUTF(student.studentPatronymic);
                                 dataOutputStream.writeInt(student.group);
                                 for (Exam exam : student.exams) {
                                     dataOutputStream.writeUTF(exam.exam);
                                     dataOutputStream.writeInt(exam.result);
                                 }
                                 dataOutputStream.writeUTF(Comands.END_OF_LINE);
                             }
                                 dataOutputStream.writeUTF(Comands.STOP_WRITING);
                                 dataOutputStream.flush();
                         }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void killConnection(){
        try {
            socket.close();
            server.killConnection(Thread.currentThread());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
