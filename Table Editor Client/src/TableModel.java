import javax.swing.*;
import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by Ivan on 25.04.2017.
 */
public class TableModel {
    public static final int SERVER_PORT = 1488;
    public static final int RESPONSE_TIMEOUT = 5000;
    private InetAddress ipAddress;
    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;
    private boolean isConnectionSet;
    private Socket socket;


    public boolean setConnection() {
        if (ipAddress == null) {
            return false;
        }
        try {
            socket = new Socket();
            socket.connect(new InetSocketAddress(ipAddress, SERVER_PORT), RESPONSE_TIMEOUT);

            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            dataInputStream = new DataInputStream(inputStream);
            dataOutputStream = new DataOutputStream(outputStream);
            isConnectionSet = true;
            return isConnectionSet;
        } catch (IOException e) {
            e.printStackTrace();
            isConnectionSet = false;
            return isConnectionSet;
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
            //TODO: send comand to server
            if(socket != null) socket.close();
            ipAddress = null;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
