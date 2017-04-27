package networkData;

import view.ServerControlPanel;

/**
 * Created by Ivan on 24.04.2017.
 */
public class ServerManager {
    private boolean isServerWorking;
    Thread serverThread;
    Server server;
    private ServerControlPanel serverControlPanel;

    public ServerManager() {
        isServerWorking = false;
        this.serverControlPanel = new ServerControlPanel(this);
    }

    public void startServer() {
        if (!isServerWorking) {
            isServerWorking = true;
            serverControlPanel.printLog("server start");
            server = new Server(this);
            serverThread = new Thread(server);
            serverThread.start();
        }
    }

    public void stopServer() {
        if (isServerWorking) {
            serverControlPanel.printLog("server stop");
            server.stopServer();
            serverThread.interrupt();
            isServerWorking = false;
        }
    }

    public ServerControlPanel getServerControlPanel() {
        return serverControlPanel;
    }
}
