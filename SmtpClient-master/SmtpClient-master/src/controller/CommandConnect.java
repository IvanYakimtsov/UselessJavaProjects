package controller;

public class CommandConnect implements Command{
    private Controller controller;
    private String command;

    public CommandConnect(String command, Controller controller){
        this.command = command;
        this.controller = controller;
    }

    @Override
    public void execute() {
        controller.connect(command);
        controller.receive();
    }
}
