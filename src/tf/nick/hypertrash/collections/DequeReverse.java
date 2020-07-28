package tf.nick.hypertrash.collections;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DequeReverse {
    public static void main(String[] args) {
        //bad();
        better();
    }

    private static void better() {
        new Scanner(System.in).tokens().skip(1)
                .collect(Collectors.toCollection(ArrayDeque::new))
                .descendingIterator()
                .forEachRemaining(System.out::println);
    }

    private static void bad() {
        new Scanner(System.in).tokens().skip(1)
                .collect(Collectors.collectingAndThen(Collectors.toList(), l -> {
                    Collections.reverse(l);
                    return l.stream();
                })).forEach(System.out::println);
    }

}
