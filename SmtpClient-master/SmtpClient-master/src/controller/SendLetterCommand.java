package controller;

public class SendLetterCommand implements Command{

    private String from;
    private String subject;
    private String text;
    private Controller controller;

    public SendLetterCommand(String from, String subject, String text, Controller controller){
        this.from = from;
        this.subject = subject;
        this.text = text;
        this.controller = controller;
    }

    @Override
    public void execute() {
        controller.sendText(from, subject, text);
        controller.receive();
    }
}
