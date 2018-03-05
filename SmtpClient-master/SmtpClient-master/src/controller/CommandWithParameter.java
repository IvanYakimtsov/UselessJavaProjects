package controller;

public class CommandWithParameter implements Command{

    private Controller controller;
    private String command;
    private String parameter;

    public CommandWithParameter(String command, String parameter, Controller controller){
        this.command = command;
        this.parameter = parameter;
        this.controller = controller;
    }

    @Override
    public void execute() {
        controller.send(command +" "+ parameter);
        controller.receive();
    }
}
