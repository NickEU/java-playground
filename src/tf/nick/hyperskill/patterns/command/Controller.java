package tf.nick.hyperskill.patterns.command;

class Controller {
    private Command command;
    void setCommand(Command command) {
        this.command = command;
    }
    void executeCommand() {
        command.execute();
    }
}
