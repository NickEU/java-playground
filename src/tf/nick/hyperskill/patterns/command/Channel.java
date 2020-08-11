package tf.nick.hyperskill.patterns.command;

class Channel {
    private final int channelNumber;

    Channel(int channelNumber) {
        this.channelNumber = channelNumber;
    }

    void changeChannel() {
        System.out.println("Channel was changed to " + channelNumber);
    }
}
