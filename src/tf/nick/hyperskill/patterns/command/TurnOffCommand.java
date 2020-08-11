package tf.nick.hyperskill.patterns.command;

class TurnOffCommand implements Command {
    private final TV tv;

    TurnOffCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.turnOff();
    }
}
