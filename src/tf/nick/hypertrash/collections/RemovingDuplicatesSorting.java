package tf.nick.hypertrash.collections;

import java.util.Scanner;
import java.util.stream.Stream;

public class RemovingDuplicatesSorting {
    public static void main(String[] args) {
        //bad();
        better();
    }

    private static void better() {
        new Scanner(System.in).tokens().skip(1)
                .distinct().sorted()
                .forEach(System.out::println);
    }

    private static void bad() {
        var sc = new Scanner(System.in);
        Stream.generate(() -> "")
                .limit(Integer.parseInt(sc.nextLine()))
                .map(s -> sc.nextLine())
                .distinct().sorted()
                .forEach(System.out::println);
    }
}
