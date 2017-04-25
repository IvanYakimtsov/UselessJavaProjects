

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
    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;
    private Socket socket;


    public boolean setConnection() {
        if (ipAddress == null) {
            return false;
        }
        try {
            socket = new Socket();
            socket.connect(new InetSocketAddress(ipAddress, SERVER_PORT), RESPONSE_TIMEOUT);
            socket.setSoTimeout(RESPONSE_TIMEOUT);

            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            dataInputStream = new DataInputStream(inputStream);
            dataOutputStream = new DataOutputStream(outputStream);

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
            if (dataOutputStream != null) dataOutputStream.writeUTF(Comands.KILL_CONNECTION);
            if (dataOutputStream != null) dataOutputStream.flush();
            if (socket != null) socket.close();
            ipAddress = null;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean addStudent(Student student) {
        try {
            dataOutputStream.writeUTF(Comands.ADD_PERSON);
            dataOutputStream.writeUTF(student.studentSurname);
            dataOutputStream.writeUTF(student.studentName);
            dataOutputStream.writeUTF(student.studentPatronymic);
            dataOutputStream.writeInt(student.group);
            for (Exam exam : student.exams) {
                dataOutputStream.writeUTF(exam.exam);
                dataOutputStream.writeInt(exam.result);
            }
            dataOutputStream.writeUTF(Comands.STOP_WRITING);
            dataOutputStream.flush();
            String response = dataInputStream.readUTF();
            if (response.equals(Comands.OK_RESPONSE)) return true;
            else return false;

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public int getAmountOfRecords() {
        try {
            dataOutputStream.writeUTF(Comands.GET_AMMOUNT_OF_RECORDS);
            dataOutputStream.flush();
            return dataInputStream.readInt();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Student> getPage(int pageNumber, int amountOfRecords) {
        try {
            List<Student> page = new ArrayList<>();
            dataOutputStream.writeUTF(Comands.GET_PAGE);
            dataOutputStream.writeInt(pageNumber);
            dataOutputStream.writeInt(amountOfRecords);
            dataOutputStream.flush();

            while (true) {
                if (dataInputStream.readUTF().equals(Comands.OK_RESPONSE)) {
                    String studentSurname = dataInputStream.readUTF();
                    String studentName = dataInputStream.readUTF();
                    String studentPatronymic = dataInputStream.readUTF();
                    int group = dataInputStream.readInt();
                    List<Exam> exams = new ArrayList<>();
                    while (true) {
                        String exam = dataInputStream.readUTF();
                        if (exam.equals(Comands.END_OF_LINE)) break;
                        int result = dataInputStream.readInt();
                        exams.add(new Exam(exam, result));
                    }
                    page.add(new Student(studentSurname, studentName, studentPatronymic, group, exams));
                } else break;
            }

            return page;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


    public List<Student> searchStudent(int minResult, int maxResult) {
        List<Student> searchResult = new ArrayList<>();
        return searchResult;
    }

    public List<Student> searchStudent(int groupNumber) {
        List<Student> searchResult = new ArrayList<>();
        return searchResult;
    }

    public List<Student> searchStudent(String exam, int minResult, int maxResult) {
        List<Student> searchResult = new ArrayList<>();
        return searchResult;
    }


    public List<Student> searchStudent(String surname) {
        List<Student> searchResult = new ArrayList<>();
        return searchResult;
    }

    public int deleteStudent(String surname) {
        return 0;
    }

    public int deleteStudent(int groupNumber) {
        return 0;
    }


    public int deleteStudent(int minResult, int maxResult) {
        return 0;
    }


    public int deleteStudent(String exam, int minResult, int maxResult) {
        return 0;
    }

    public void saveAction(String path) {

    }


    public void openAction(String path) {


    }


}
