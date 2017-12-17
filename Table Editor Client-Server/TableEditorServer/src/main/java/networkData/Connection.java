package networkData;

import dataModel.Student;
import dataModel.TableModel;
import org.apache.log4j.Logger;

import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ivan on 24.04.2017.
 */
public class Connection implements Runnable {
    private List<Student> searchResultsById;
    private List<Student> searchResultsByGroup;
    private List<Student> searchResultsByMarks;
    private List<Student> searchResultsByExamResult;
    private Socket socket;
    private TableModel tableModel;
    private ObjectOutputStream objectOutputStream;
    private ObjectInputStream objectInputStream;
    private Server server;
    private static final Logger log = Logger.getLogger(Connection.class);

    Connection(Socket socket, Server server) throws Throwable {
        searchResultsById = new ArrayList<>();
        searchResultsByGroup = new ArrayList<>();
        searchResultsByMarks = new ArrayList<>();
        searchResultsByExamResult = new ArrayList<>();
        this.server = server;
        this.socket = socket;
        this.tableModel = new TableModel();
    }

    public void run() {
        try {
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectInputStream = new ObjectInputStream(socket.getInputStream());

            String command = null;
            while (true) {
                command = objectInputStream.readUTF();
                switch (command) {
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
                    case Comands.GET_AMOUNT_OF_RECORDS:
                        getAmountOfRecords();
                        break;
                    case Comands.CHECK_CONNECTION:
                        checkConnection();
                        break;
                    case Comands.GET_SEARCH_RESULT_SIZE:
                        getSearchResultSize();
                        break;
                    case Comands.DELETE_SEARCH_RESULT:
                        deleteSearchResult();
                        break;
                    case Comands.GET_SEARCH_RESULT_PAGE:
                        getSearchResultPageCommand();
                        break;
                }
            }
        } catch (IOException e) {
            log.error(e.getMessage());
            server.getServerManager().getServerControlPanel().printLog("Info " + e.getMessage());
        } catch (Exception e) {
            log.error(e.getMessage());
            server.getServerManager().getServerControlPanel().printLog("Info " + e.getMessage());
        }


    }

    private void getSearchResultPageCommand() {
        try {
            switch (objectInputStream.readUTF()) {
                case Comands.SEARCH_PERSON_BY_ID:
                    getSearchResultPage(searchResultsById);
                    break;
                case Comands.SEARCH_PERSON_BY_GROUP:
                    getSearchResultPage(searchResultsByGroup);
                    break;
                case Comands.SEARCH_PERSON_BY_MARKS:
                    getSearchResultPage(searchResultsByMarks);
                    break;
                case Comands.SEARCH_PERSON_BY_EXAM_RESULT:
                    getSearchResultPage(searchResultsByExamResult);
                    break;
            }
        } catch (IOException e) {


        }
    }

    private void getSearchResultPage(List<Student> searchResult) {
        List<Student> page = new ArrayList<Student>();
        try {
            if (searchResult.size() != 0) {
                int amountOfRecords = objectInputStream.readInt();
                int pageNumber = objectInputStream.readInt();
                int firstRecordIndex = (pageNumber - 1) * amountOfRecords;
                for (int index = firstRecordIndex; index < firstRecordIndex + amountOfRecords; index++) {
                    if (index > searchResult.size() - 1) break;
                    page.add(searchResult.get(index));
                }
                objectOutputStream.writeObject(page);
                objectOutputStream.flush();
            } else {
                objectInputStream.readInt();
                objectInputStream.readInt();
                objectOutputStream.writeObject(page);
                objectOutputStream.flush();
            }

        } catch (IOException e) {
            System.out.println("error");
            e.printStackTrace();
            try {
                objectOutputStream.writeObject(page);
                objectOutputStream.flush();
            } catch (IOException e1) {
                e1.printStackTrace();
            }

        }
    }

    private void deleteSearchResult() {
        searchResultsById.clear();
        searchResultsByGroup.clear();
        searchResultsByMarks.clear();
        searchResultsByExamResult.clear();
    }

    private void getSearchResultSize() {
        try {
            switch (objectInputStream.readUTF()) {
                case Comands.SEARCH_PERSON_BY_ID:
                    objectOutputStream.writeInt(searchResultsById.size());
                    objectOutputStream.flush();
                    break;
                case Comands.SEARCH_PERSON_BY_GROUP:
                    objectOutputStream.writeInt(searchResultsByGroup.size());
                    objectOutputStream.flush();
                    break;
                case Comands.SEARCH_PERSON_BY_MARKS:
                    objectOutputStream.writeInt(searchResultsByMarks.size());
                    objectOutputStream.flush();
                    break;
                case Comands.SEARCH_PERSON_BY_EXAM_RESULT:
                    objectOutputStream.writeInt(searchResultsByExamResult.size());
                    objectOutputStream.flush();
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void checkConnection() {
        try {
            objectOutputStream.writeUTF(Comands.CHECK_CONNECTION);
            objectOutputStream.flush();
        } catch (IOException e) {
            log.error(e.getMessage());
            server.getServerManager().getServerControlPanel().printLog("Error " + e.getMessage());
        }

    }

    private void searchPersonByExamResultCommand() {
        try {
            String exam = objectInputStream.readUTF();
            int min = objectInputStream.readInt();
            int max = objectInputStream.readInt();
            searchResultsByExamResult = tableModel.searchStudent(exam, min, max);

        } catch (Exception e) {
            log.error(e.getMessage());
            server.getServerManager().getServerControlPanel().printLog("Error " + e.getMessage());
        }
    }

    private void searchPersonByMarksCommand() {
        try {
            int min = objectInputStream.readInt();
            int max = objectInputStream.readInt();
            searchResultsByMarks = tableModel.searchStudent(min, max);
        } catch (Exception e) {
            log.error(e.getMessage());
            server.getServerManager().getServerControlPanel().printLog("Error " + e.getMessage());
        }
    }

    private void searchPersonByGroupCommand() throws Exception {
        try {
            searchResultsByGroup = tableModel.searchStudent(objectInputStream.readInt());
        } catch (IOException e) {
            log.error(e.getMessage());
            server.getServerManager().getServerControlPanel().printLog("Error " + e.getMessage());
        }
    }

    private void searchPersonByIdCommand() {
        try {
            searchResultsById = tableModel.searchStudent(objectInputStream.readUTF());
        } catch (Exception e) {
            log.error(e.getMessage());
            server.getServerManager().getServerControlPanel().printLog("Error " + e.getMessage());
        }
    }

    private void deletePersonByExamResultCommand() {
        try {
            String exam = objectInputStream.readUTF();
            int minResult = objectInputStream.readInt();
            int maxResult = objectInputStream.readInt();
            objectOutputStream.writeInt(tableModel.deleteStudent(exam, minResult, maxResult));
            objectOutputStream.flush();
        } catch (Exception e) {
            log.error(e.getMessage());
            server.getServerManager().getServerControlPanel().printLog("Error " + e.getMessage());
        }
    }

    private void deletePersonByMarksCommand() {

        try {
            int minResult = objectInputStream.readInt();
            int maxResult = objectInputStream.readInt();
            objectOutputStream.writeInt(tableModel.deleteStudent(minResult, maxResult));
            objectOutputStream.flush();
        } catch (Exception e) {
            log.error(e.getMessage());
            server.getServerManager().getServerControlPanel().printLog("Error " + e.getMessage());
        }

    }

    private void deletePersonByGroupCommand() {
        try {
            objectOutputStream.writeInt(tableModel.deleteStudent(objectInputStream.readInt()));
            objectOutputStream.flush();
        } catch (Exception e) {
            log.error(e.getMessage());
            server.getServerManager().getServerControlPanel().printLog("Error " + e.getMessage());
        }

    }

    private void deletePersonByIdCommand() {
        try {
            objectOutputStream.writeInt(tableModel.deleteStudent(objectInputStream.readUTF()));
            objectOutputStream.flush();
        } catch (Exception e) {
            log.error(e.getMessage());
            server.getServerManager().getServerControlPanel().printLog("Error " + e.getMessage());
        }
    }

    private void addPersonCommand() {
        try {
            Student student = (Student) objectInputStream.readObject();
            tableModel.addStudent(student);
        } catch (IOException e) {
            log.error(e.getMessage());
            server.getServerManager().getServerControlPanel().printLog("Error " + e.getMessage());
        } catch (ClassNotFoundException e) {
            log.error(e.getMessage());
            server.getServerManager().getServerControlPanel().printLog("Error " + e.getMessage());
        } catch (Exception e) {
            log.error(e.getMessage());
            server.getServerManager().getServerControlPanel().printLog("Error " + e.getMessage());
        }
    }


    private void saveCommand() {
        try {
            String name = objectInputStream.readUTF();
            // tableModel.saveAction(System.getProperty("user.dir")+"\\TablesDataBase\\"+name+".table");
            tableModel.saveAction(name);
        } catch (Exception e) {
            log.error(e.getMessage());
            server.getServerManager().getServerControlPanel().printLog("Error " + e.getMessage());
        }
//        } catch (TransformerException e) {
//            log.error(e.getMessage());
//            server.getServerManager().getServerControlPanel().printLog("Error " +e.getMessage());
//        }
    }

    private void openCommand() {
        try {
            String name = objectInputStream.readUTF();
            //tableModel.openAction(System.getProperty("user.dir")+"\\TablesDataBase\\"+name+".table");
            tableModel.openAction(name);
        } catch (IOException e) {
            log.error(e.getMessage());
            server.getServerManager().getServerControlPanel().printLog("Error " + e.getMessage());
        } catch (TransformerException e) {
            log.error(e.getMessage());
            server.getServerManager().getServerControlPanel().printLog("Error " + e.getMessage());
        } catch (Exception e) {
            log.error(e.getMessage());
            server.getServerManager().getServerControlPanel().printLog("Error " + e.getMessage());
        }
    }


    private void getAmountOfRecords() {
        try {
            objectOutputStream.writeInt(tableModel.getAmountOfRecords());
            objectOutputStream.flush();
        } catch (Exception e) {
            log.error(e.getMessage());
            server.getServerManager().getServerControlPanel().printLog("Error " + e.getMessage());
        }
    }

    private void getPageCommand() {
        try {
            int pageNumber = objectInputStream.readInt();
            int amountOfRecords = objectInputStream.readInt();
            List<Student> page = tableModel.getPage(pageNumber, amountOfRecords);
            objectOutputStream.writeObject(page);
            objectOutputStream.flush();
        } catch (Exception e) {
            log.error(e.getMessage());
            server.getServerManager().getServerControlPanel().printLog("Error " + e.getMessage());
        }

    }

    public void killConnection() {
        try {
            socket.close();
            server.getServerManager().getServerControlPanel().printLog("Info connection killed");
            Thread.currentThread().interrupt();
        } catch (IOException e) {
            log.error(e.getMessage());
            server.getServerManager().getServerControlPanel().printLog("Warning " + e.getMessage());
        }
    }
}
