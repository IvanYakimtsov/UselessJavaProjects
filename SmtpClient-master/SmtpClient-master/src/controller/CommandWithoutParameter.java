package controller;

public class CommandWithoutParameter implements Command{
    private Controller controller;
    private String command;

    public CommandWithoutParameter(String command, Controller controller){
        this.command = command;
        this.controller = controller;
    }

    @Override
    public void execute() {
        controller.send(command);
        controller.receive();
    }
}
