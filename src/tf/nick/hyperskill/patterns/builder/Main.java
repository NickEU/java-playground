package tf.nick.hyperskill.patterns.builder;

import tf.nick.hyperskill.patterns.builder.components.Geek;
import tf.nick.hyperskill.patterns.builder.components.GeekBuilder;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final String geekName = scanner.nextLine();
        final String geekType = scanner.nextLine();
        scanner.close();
        GeekDirector director = new GeekDirector();
        Builder builder = new GeekBuilder();

        switch (geekType) {
            case "Rockstar":
                director.buildRockstar(builder);
                break;
            case "Backend":
                director.buildBackend(builder);
                break;
            case "Admin":
                director.buildAdmin(builder);
                break;
            default:
                System.out.println("Error");
                return;
        }
        Geek geek = builder.getResult();

        System.out.println("Geek " + geekName + " created.");
        System.out.println(geek);
    }
}
