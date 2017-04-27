package connectionController;

import dataModel.Student;
import org.apache.log4j.Logger;
import view.PageSwapper;

import javax.swing.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by Ivan on 25.04.2017.
 */
public class ConnectionManager implements PageSwapper {
    public static final int SERVER_PORT = 1488;
    public static final int RESPONSE_TIMEOUT = 5000;
    private InetAddress ipAddress;
    private ObjectInputStream objectInputStream;
    private ObjectOutputStream objectOutputStream;
    private Socket socket;
    private static final Logger log = Logger.getLogger(ConnectionManager.class);
    private ConnectionValidator connectionValidator;
    private static final String IP_ADDRESS_PATTERN
            = "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
            + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
            + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
            + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";

    public void addConnectionValidator(ConnectionValidator connectionValidator){
        this.connectionValidator = connectionValidator;
    }

    public boolean setConnection() {
        if (ipAddress == null) {
            return false;
        }
        try {
            socket = new Socket();
            socket.connect(new InetSocketAddress(ipAddress, SERVER_PORT), RESPONSE_TIMEOUT);
            socket.setSoTimeout(RESPONSE_TIMEOUT);

        //    System.out.println("status " + socket.isConnected()+" " + ipAddress.isReachable(RESPONSE_TIMEOUT));

            objectInputStream = new ObjectInputStream(socket.getInputStream());
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());


            return true;
        } catch (IOException e) {
            log.error(e.getMessage());
            return false;
        }

    }

    public boolean chooseServerIp() {
        String address = JOptionPane.showInputDialog("Введите ip сервера");
        Pattern correctIp = Pattern.compile(IP_ADDRESS_PATTERN);

        if (address != null && correctIp.matcher(address).matches()) {
            try {
                ipAddress = InetAddress.getByName(address);
            } catch (UnknownHostException e) {
                log.error(e.getMessage());
            }
            return true;
        } else {
            return false;
        }

    }


    public void shutConnection() {
        try {
            if (objectOutputStream != null && checkConnection()){
                objectOutputStream.writeUTF(Comands.KILL_CONNECTION);
                objectOutputStream.flush();
            }
            if (socket != null) socket.close();
            ipAddress = null;
        } catch (IOException e) {
            log.error(e.getMessage());
            connectionValidator.checkConnection();
        }
    }

    public boolean addStudent(Student student) {
        try {
            objectOutputStream.writeUTF(Comands.ADD_PERSON);
            objectOutputStream.writeObject(student);
            objectOutputStream.flush();
            return true;
        } catch (IOException e) {
            log.error(e.getMessage());
            connectionValidator.checkConnection();
            return false;
        }

    }


    public int getAmountOfRecords() {
        try {
            objectOutputStream.writeUTF(Comands.GET_AMOUNT_OF_RECORDS);
            objectOutputStream.flush();
            return objectInputStream.readInt();
        } catch (IOException e) {
            log.error(e.getMessage());
            connectionValidator.checkConnection();
            return 0;
        }
    }


    public List<Student> getPage(int pageNumber, int amountOfRecords) {

        try {
            List<Student> page = null;
            objectOutputStream.writeUTF(Comands.GET_PAGE);
            objectOutputStream.writeInt(pageNumber);
            objectOutputStream.writeInt(amountOfRecords);
            objectOutputStream.flush();
            page = (ArrayList)objectInputStream.readObject();
            return page;
        } catch (IOException e) {
            log.error(e.getMessage());
            connectionValidator.checkConnection();
            return  null;
        } catch (ClassNotFoundException e) {
            log.error(e.getMessage());
            connectionValidator.checkConnection();
            return  null;
        }

    }


    public void searchStudent(int minResult, int maxResult) {
        try {
            objectOutputStream.writeUTF(Comands.SEARCH_PERSON_BY_MARKS);
            objectOutputStream.writeInt(minResult);
            objectOutputStream.writeInt(maxResult);
            objectOutputStream.flush();
        } catch (IOException e) {
            log.error(e.getMessage());
            connectionValidator.checkConnection();
        }
    }

    public void searchStudent(int groupNumber) {
        try {
            objectOutputStream.writeUTF(Comands.SEARCH_PERSON_BY_GROUP);
            objectOutputStream.writeInt(groupNumber);
            objectOutputStream.flush();
        } catch (IOException e) {
            log.error(e.getMessage());
            connectionValidator.checkConnection();
        }
    }

    public void searchStudent(String exam, int minResult, int maxResult) {
        try {
            objectOutputStream.writeUTF(Comands.SEARCH_PERSON_BY_EXAM_RESULT);
            objectOutputStream.writeUTF(exam);
            objectOutputStream.writeInt(minResult);
            objectOutputStream.writeInt(maxResult);
            objectOutputStream.flush();
        } catch (IOException e) {
            log.error(e.getMessage());
            connectionValidator.checkConnection();
        }

    }


    public void searchStudent(String surname) {
        try {
            objectOutputStream.writeUTF(Comands.SEARCH_PERSON_BY_ID);
            objectOutputStream.writeUTF(surname);
            objectOutputStream.flush();
        } catch (IOException e) {
            log.error(e.getMessage());
            connectionValidator.checkConnection();
        }
    }

    public int deleteStudent(String surname) {
        try {
            objectOutputStream.writeUTF(Comands.DELETE_PERSON_BY_ID);
            objectOutputStream.writeUTF(surname);
            objectOutputStream.flush();
            return objectInputStream.readInt();
        } catch (IOException e) {
            log.error(e.getMessage());
            connectionValidator.checkConnection();
            return  0;
        }
    }

    public int deleteStudent(int groupNumber) {
        try {
            objectOutputStream.writeUTF(Comands.DELETE_PERSON_BY_GROUP);
            objectOutputStream.writeInt(groupNumber);
            objectOutputStream.flush();
            return objectInputStream.readInt();
        } catch (IOException e) {
            log.error(e.getMessage());
            connectionValidator.checkConnection();
            return  0;
        }
    }


    public int deleteStudent(int minResult, int maxResult) {
        try {
            objectOutputStream.writeUTF(Comands.DELETE_PERSON_BY_MARKS);
            objectOutputStream.writeInt(minResult);
            objectOutputStream.writeInt(maxResult);
            objectOutputStream.flush();
            return objectInputStream.readInt();
        } catch (IOException e) {
            log.error(e.getMessage());
            connectionValidator.checkConnection();
            return  0;
        }

    }


    public int deleteStudent(String exam, int minResult, int maxResult)
    {
        try {
            objectOutputStream.writeUTF(Comands.DELETE_PERSON_BY_EXAM_RESULT);
            objectOutputStream.writeUTF(exam);
            objectOutputStream.writeInt(minResult);
            objectOutputStream.writeInt(maxResult);
            objectOutputStream.flush();
            return objectInputStream.readInt();
        } catch (IOException e) {
            log.error(e.getMessage());
            connectionValidator.checkConnection();
            return  0;
        }
    }

    public void saveAction(String name) {
        try {
            objectOutputStream.writeUTF(Comands.SAVE);
            objectOutputStream.writeUTF(name);
            objectOutputStream.flush();
        } catch (IOException e) {
            log.error(e.getMessage());
            connectionValidator.checkConnection();
        }
    }


    public void openAction(String name) {
        try {
            objectOutputStream.writeUTF(Comands.OPEN);
            objectOutputStream.writeUTF(name);
            objectOutputStream.flush();
        } catch (IOException e) {
            log.error(e.getMessage());
            connectionValidator.checkConnection();
        }

    }

   public boolean checkConnection(){
       try {
           if(ipAddress !=null && socket!=null && objectOutputStream !=null && objectInputStream != null){
               if(socket.isConnected() &&  ipAddress.isReachable(RESPONSE_TIMEOUT)){
               objectOutputStream.writeUTF(Comands.CHECK_CONNECTION);
               objectOutputStream.flush();
               objectInputStream.readUTF();
               return true;
               }
           }
           return false;
       } catch (IOException e) {
           log.error(e.getMessage());
           return false;
       }
   }

    public void deleteSearchResults() {
        try {
            objectOutputStream.writeUTF(Comands.DELETE_SEARCH_RESULT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getSearchSize(String typeOfSearch) {
        try {
            objectOutputStream.writeUTF(Comands.GET_SEARCH_RESULT_SIZE);
            objectOutputStream.writeUTF(typeOfSearch);
            objectOutputStream.flush();
            return objectInputStream.readInt();
        } catch (IOException e) {
            log.error(e.getMessage());
        }

       return 0;
    }

    public List<Student> getSearchResultPage(int pageNumber, int amountOfRecords, String typeOfSearch) {
        try {
            objectOutputStream.writeUTF(Comands.GET_SEARCH_RESULT_PAGE);
            objectOutputStream.writeUTF(typeOfSearch);
            objectOutputStream.writeInt(amountOfRecords);
            objectOutputStream.writeInt(pageNumber);
            objectOutputStream.flush();
            return (List<Student>) objectInputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        }catch (ClassNotFoundException e) {

        }
        return null;
    }
}
