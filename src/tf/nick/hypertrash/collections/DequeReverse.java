package tf.nick.hypertrash.collections;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DequeReverse {
    public static void main(String[] args) {
        var sc = new Scanner("3 \n" +
                "1 \n" +
                "2 \n" +
                "3 \n");
        //bad(sc);
        better(sc);
    }

    private static void better(Scanner sc) {
        sc.tokens().skip(1)
                .collect(Collectors.toCollection(ArrayDeque::new))
                .descendingIterator()
                .forEachRemaining(System.out::println);
    }

    private static void bad(Scanner sc) {
        sc.tokens().skip(1)
                .collect(Collectors.collectingAndThen(Collectors.toList(), l -> {
                    Collections.reverse(l);
                    return l.stream();
                })).forEach(System.out::println);
    }

}
