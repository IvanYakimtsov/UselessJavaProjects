
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ivan on 24.04.2017.
 */
public class Server implements Runnable {
    ServerManager serverManager;
    ServerSocket serverSocket;
    List<Thread> connectionsList;

    Server(ServerManager serverManager) {
        this.serverManager = serverManager;
        connectionsList = new ArrayList<>();
        adjustServer();
    }

    private void adjustServer() {
        try {
            serverSocket = new ServerSocket(Const.port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                Socket s = serverSocket.accept();
                serverManager.getServerControlPanel().printLog("new conection");
                Thread connection = new Thread(new Connection(s));
                connectionsList.add(connection);
                connection.start();
            }
        } catch (Exception x) {
            x.printStackTrace();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
    public void stopServer(){
        try {
            serverSocket.close();
            for (Thread connection : connectionsList) connection.stop();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public ServerSocket getServerSocket() {
        return serverSocket;
    }
}
