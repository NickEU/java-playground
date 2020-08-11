package tf.nick.hyperskill.patterns.command;

class ChangeChannelCommand implements Command {
    private final Channel channel;

    ChangeChannelCommand(Channel channel) {
        this.channel = channel;
    }

    @Override
    public void execute() {
        channel.changeChannel();
    }
}
