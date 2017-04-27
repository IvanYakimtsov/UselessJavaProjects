package networkData;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ivan on 24.04.2017.
 */
public class Server implements Runnable {
    private ServerManager serverManager;
    private ServerSocket serverSocket;
    private List<Connection> connectionsList;
    private static final Logger log = Logger.getLogger(Server.class);

    public static int PORT = 1488;

    Server(ServerManager serverManager) {
        this.serverManager = serverManager;
        connectionsList = new ArrayList<Connection>();
        adjustServer();
    }

    private void adjustServer() {
        try {
            serverSocket = new ServerSocket(PORT);
        } catch (IOException e) {
            log.error(e.getMessage());
            serverManager.getServerControlPanel().printLog("Error " +e.getMessage());
        }
    }

    public void run() {
        try {
            while (true) {
                Socket s = serverSocket.accept();
                serverManager.getServerControlPanel().printLog("Info " +"new connection");
                Connection connection = new Connection(s,this);
                connectionsList.add(connection);
                 new Thread(connection).start();

            }
        } catch (Exception e) {
            log.warn(e.getMessage());
            serverManager.getServerControlPanel().printLog("Warning " + e.getMessage());

        } catch (Throwable throwable) {
            log.error(throwable.getMessage());
            serverManager.getServerControlPanel().printLog("Error " +throwable.getMessage());
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
            log.error(e.getMessage());
            serverManager.getServerControlPanel().printLog("Error " +e.getMessage());
        }
    }



    public ServerManager getServerManager() {
        return serverManager;
    }

    public List<Connection> getConnectionsList() {
        return connectionsList;
    }

}
