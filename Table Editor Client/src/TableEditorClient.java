import javax.swing.*;

/**
 * Created by Ivan on 13.04.2017.
 */


public class TableEditorClient {
    public static void main(String[] ar) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

    ConnectionManager connectionManager = new ConnectionManager();
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            public void run() {
                connectionManager.shutConnection();
            }
        }, "Shutdown-thread"));
        new TableEditorManager(connectionManager,new TableEditorMainFrame());
    }


}