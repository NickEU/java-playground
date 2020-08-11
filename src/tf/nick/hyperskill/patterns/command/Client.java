package tf.nick.hyperskill.patterns.command;

import java.util.Scanner;

class Client {

    public static void main(String[] args) {

        Controller controller = new Controller();
        TV tv = new TV();

        Command changeChannel;
        int[] channelList = new int[3];

        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            channelList[i] = scanner.nextInt();
        }

        Command turnOnTV = new TurnOnCommand(tv);
        controller.setCommand(turnOnTV);
        controller.executeCommand();

        for (int i = 0; i < 3; i++) {
            changeChannel = new ChangeChannelCommand(new Channel(channelList[i]));
            controller.setCommand(changeChannel);
            controller.executeCommand();
        }

        Command turnOffTV = new TurnOffCommand(tv);
        controller.setCommand(turnOffTV);
        controller.executeCommand();
    }
}


