package tf.nick.hyperskill.patterns.command;

class TurnOnCommand implements Command {
    private final TV tv;

    TurnOnCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
       tv.turnOn();
    }
}
