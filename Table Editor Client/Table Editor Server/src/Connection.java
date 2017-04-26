import javax.xml.transform.TransformerException;
import java.io.*;
import java.net.Socket;
import java.util.List;

/**
 * Created by Ivan on 24.04.2017.
 */
public class Connection implements Runnable {
    private  Socket socket;
    private TableModel tableModel;
    private ObjectOutputStream objectOutputStream;
    private ObjectInputStream objectInputStream;
    private Server server;

    Connection(Socket socket,Server server) throws Throwable {
        this.server = server;
        this.socket = socket;
        this.tableModel = new TableModel();
    }

    @Override
    public void run() {
        try {
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectInputStream = new ObjectInputStream(socket.getInputStream());

            String comand = null;
            while (true) {
                comand = objectInputStream.readUTF();
                switch (comand) {
                    case Comands.ADD_PERSON:
                        addPersonCommand();
                        break;
                    case Comands.DELETE_PERSON_BY_ID:
                        deletePersonByIdCommand();
                        break;
                    case Comands.DELETE_PERSON_BY_GROUP:
                        deletePersonByGroupCommand();
                        break;
                    case Comands.DELETE_PERSON_BY_MARKS:
                        deletePersonByMarksCommand();
                        break;
                    case Comands.DELETE_PERSON_BY_EXAM_RESULT:
                        deletePersonByExamResultCommand();
                        break;
                    case Comands.SEARCH_PERSON_BY_ID:
                        searchPersonByIdCommand();
                        break;
                    case Comands.SEARCH_PERSON_BY_GROUP:
                        searchPersonByGroupCommand();
                        break;
                    case Comands.SEARCH_PERSON_BY_MARKS:
                        searchPersonByMarksCommand();
                        break;
                    case Comands.SEARCH_PERSON_BY_EXAM_RESULT:
                        searchPersonByExamResultCommand();
                        break;
                    case Comands.SAVE:
                        saveCommand();
                        break;
                    case Comands.OPEN:
                        openCommand();
                        break;
                    case Comands.KILL_CONNECTION:
                        server.getConnectionsList().remove(this);
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
            e.printStackTrace();
        }


    }

    private void searchPersonByExamResultCommand() {
        try {
            String exam = objectInputStream.readUTF();
            int min = objectInputStream.readInt();
            int max = objectInputStream.readInt();
            objectOutputStream.writeObject(tableModel.searchStudent(exam,min,max));
            objectOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void searchPersonByMarksCommand() {
        try {
            int min = objectInputStream.readInt();
            int max = objectInputStream.readInt();
            objectOutputStream.writeObject(tableModel.searchStudent(min,max));
            objectOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void searchPersonByGroupCommand() {
        try {
            objectOutputStream.writeObject(tableModel.searchStudent(objectInputStream.readInt()));
            objectOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void searchPersonByIdCommand() {
        try {
            objectOutputStream.writeObject(tableModel.searchStudent(objectInputStream.readUTF()));
            objectOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deletePersonByExamResultCommand() {
        try {
            String exam = objectInputStream.readUTF();
            int minResult = objectInputStream.readInt();
            int maxResult = objectInputStream.readInt();
            objectOutputStream.writeInt(tableModel.deleteStudent(exam,minResult,maxResult));
            objectOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deletePersonByMarksCommand() {

        try {
            int minResult = objectInputStream.readInt();
            int maxResult = objectInputStream.readInt();
            objectOutputStream.writeInt(tableModel.deleteStudent(minResult,maxResult));
            objectOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void deletePersonByGroupCommand() {
        try {
            objectOutputStream.writeInt(tableModel.deleteStudent(objectInputStream.readInt()));
            objectOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void deletePersonByIdCommand() {
        try {
          objectOutputStream.writeInt(tableModel.deleteStudent(objectInputStream.readUTF()));
          objectOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addPersonCommand() {
        try {
            Student student = (Student)objectInputStream.readObject();
            tableModel.addStudent(student);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    private void saveCommand() {
        try {
           String name = objectInputStream.readUTF();
           tableModel.saveAction(System.getProperty("user.dir")+"\\Table Editor Server\\TablesDataBase\\"+name+".table");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

    private void openCommand() {
        try {
            String name = objectInputStream.readUTF();
            tableModel.openAction(System.getProperty("user.dir")+"\\Table Editor Server\\TablesDataBase\\"+name+".table");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void getAmountOfRecords(){
        try {
            objectOutputStream.writeInt(tableModel.getTableData().size());
            objectOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void getPageCommand(){
        try {
            int pageNumber = objectInputStream.readInt();
            int amountOfRecords = objectInputStream.readInt();
            List <Student> page  =  tableModel.getPage(pageNumber,amountOfRecords);
            objectOutputStream.writeObject(page);
            objectOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void killConnection(){
        try {
            socket.close();
            server.getServerManager().getServerControlPanel().printLog("connection killed");
            Thread.currentThread().interrupt();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
