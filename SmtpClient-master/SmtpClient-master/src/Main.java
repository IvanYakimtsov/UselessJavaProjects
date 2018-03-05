import controller.Controller;
import view.Document;
import view.MyFrame;

import java.awt.*;

/**
 * Created by Asus on 06.02.2018.
 */
public class Main {

    public static void main(String args[])
    {
        Document document = new Document();
        Controller controller = new Controller(document);

        MyFrame frame = new MyFrame("SmtpClient",new Dimension(700,700), controller);
        frame.init();
    }
}
