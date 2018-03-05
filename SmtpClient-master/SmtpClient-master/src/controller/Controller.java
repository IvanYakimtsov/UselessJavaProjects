package controller;

import view.Document;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.*;
import java.net.Socket;
import java.util.Stack;

public class Controller {

    private SSLSocket smtp = null;
    //    private PrintStream ps = null;
//    private DataInputStream dis = null;
    private BufferedReader in;
    private BufferedWriter out;
    private Document document;

    public Controller(Document document) {
        this.document = document;
    }

    public void connect(String str) {
        try {
            SSLSocketFactory ssf = (SSLSocketFactory) SSLSocketFactory
                    .getDefault();
            // smtp = new Socket(str, 25);
            smtp = (SSLSocket) ssf.createSocket(str, 465);
            smtp.startHandshake();
            in = new BufferedReader(new InputStreamReader(smtp.getInputStream(), "ASCII"));
            out = new BufferedWriter(new OutputStreamWriter(smtp.getOutputStream(), "ASCII"));
//            OutputStream os = smtp.getOutputStream();
//            ps = new PrintStream(os);
//            InputStream is = smtp.getInputStream();
//            dis = new DataInputStream(is);
        } catch (IOException e) {
            System.out.println(e);
            end();
        }
    }

    public void send(String str) {
        try {
            System.out.println(str);
            out.write(str);
            out.flush();
            System.out.println("ok");
        } catch (IOException e) {
            e.printStackTrace();
        }

        document.add("Client: " + str);
    }

    public void receive() {
        try {
          //  System.out.println(in);
            String readstr = in.readLine();
            document.add("Server: " + readstr);
        } catch (IOException e) {
            System.out.println(e);
            end();
        }
    }

    public StringBuilder getChat() {
        return document.getChat();
    }

    public void end() {

        try {
            if (smtp != null) {
                smtp.close();
            }

            if (in != null) {
                in.close();
            }

            if (out != null) {
                out.close();
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void sendText(String from, String subject, String text) {

        Stack<String> stack = new Stack<>();
        stack.push("\n");
        stack.push(".");
        stack.push(text);
        stack.push("\n");
        stack.push("subject: " + subject);
        stack.push("from: " + from);

        while (!stack.isEmpty()) {
            send(stack.pop());
        }
    }
}
