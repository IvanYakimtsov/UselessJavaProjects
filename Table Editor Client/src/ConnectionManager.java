import javax.swing.*;
import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

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


    public boolean setConnection() {
        if (ipAddress == null) {
            return false;
        }
        try {
            socket = new Socket();
            socket.connect(new InetSocketAddress(ipAddress, SERVER_PORT), RESPONSE_TIMEOUT);
            socket.setSoTimeout(RESPONSE_TIMEOUT);

            objectInputStream = new ObjectInputStream(socket.getInputStream());
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());


            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }

    public boolean chooseServerIp() {
        String address = JOptionPane.showInputDialog("Введите ip сервера");
        //TODO: validate input here
        if (address != null) {
            try {
                ipAddress = InetAddress.getByName(address);
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
            return true;
        } else return false;

    }


    public void shutConnection() {
        try {
            if (objectOutputStream != null){
                objectOutputStream.writeUTF(Comands.KILL_CONNECTION);
                objectOutputStream.flush();
            }
            if (socket != null) socket.close();
            ipAddress = null;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean addStudent(Student student) {
        try {
            objectOutputStream.writeUTF(Comands.ADD_PERSON);
            objectOutputStream.writeObject(student);
            objectOutputStream.flush();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public int getAmountOfRecords() {
        try {
            objectOutputStream.writeUTF(Comands.GET_AMMOUNT_OF_RECORDS);
            objectOutputStream.flush();
            return objectInputStream.readInt();
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
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
            e.printStackTrace();
            return  null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return  null;
        }

    }


    public List<Student> searchStudent(int minResult, int maxResult) {
        try {
            objectOutputStream.writeUTF(Comands.SEARCH_PERSON_BY_MARKS);
            objectOutputStream.writeInt(minResult);
            objectOutputStream.writeInt(maxResult);
            objectOutputStream.flush();
            return (List<Student>)objectInputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
            return  null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Student> searchStudent(int groupNumber) {
        try {
            objectOutputStream.writeUTF(Comands.SEARCH_PERSON_BY_GROUP);
            objectOutputStream.writeInt(groupNumber);
            objectOutputStream.flush();
            return (List<Student>)objectInputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
            return  null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Student> searchStudent(String exam, int minResult, int maxResult) {
        try {
            objectOutputStream.writeUTF(Comands.SEARCH_PERSON_BY_EXAM_RESULT);
            objectOutputStream.writeUTF(exam);
            objectOutputStream.writeInt(minResult);
            objectOutputStream.writeInt(maxResult);
            objectOutputStream.flush();
            return (List<Student>)objectInputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
            return  null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }


    public List<Student> searchStudent(String surname) {
        try {
            objectOutputStream.writeUTF(Comands.SEARCH_PERSON_BY_ID);
            objectOutputStream.writeUTF(surname);
            objectOutputStream.flush();
            return (List<Student>)objectInputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
            return  null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int deleteStudent(String surname) {
        try {
            objectOutputStream.writeUTF(Comands.DELETE_PERSON_BY_ID);
            objectOutputStream.writeUTF(surname);
            objectOutputStream.flush();
            return objectInputStream.readInt();
        } catch (IOException e) {
            e.printStackTrace();
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
            e.printStackTrace();
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
            e.printStackTrace();
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
            e.printStackTrace();
            return  0;
        }
    }

    public void saveAction(String name) {
        try {
            objectOutputStream.writeUTF(Comands.SAVE);
            objectOutputStream.writeUTF(name);
            objectOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void openAction(String name) {
        try {
            objectOutputStream.writeUTF(Comands.OPEN);
            objectOutputStream.writeUTF(name);
            objectOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
