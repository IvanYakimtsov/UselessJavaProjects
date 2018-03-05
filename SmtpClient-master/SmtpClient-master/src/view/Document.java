package view;

public class Document {
    StringBuilder chat = new StringBuilder();

    public StringBuilder getChat() {
        return chat;
    }

    public void add(String str){
        chat.append(str+"\n");
    }
}
