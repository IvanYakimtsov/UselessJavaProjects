
import java.io.IOException;
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
    List<Connection> connectionsList;

    public static int PORT = 1488;

    Server(ServerManager serverManager) {
        this.serverManager = serverManager;
        connectionsList = new ArrayList<>();
        adjustServer();
    }

    private void adjustServer() {
        try {
            serverSocket = new ServerSocket(PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                Socket s = serverSocket.accept();
                serverManager.getServerControlPanel().printLog("new connection");
                Connection connection = new Connection(s,this);
                connectionsList.add(connection);
                 new Thread(connection).start();

            }
        } catch (Exception x) {
            x.printStackTrace();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
    public void stopServer(){
        try {
            for(Connection connection:connectionsList){
                 connection.killConnection();
            }
            connectionsList.clear();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public ServerManager getServerManager() {
        return serverManager;
    }

    public List<Connection> getConnectionsList() {
        return connectionsList;
    }

}
