package tf.nick.hypertrash.collections.map;

import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GettingSubmaps {
    public static void main(String[] args) {
        final String matchWhitespace = "\\s+";
        final var sc = new Scanner(System.in);
        String[] limits = sc.nextLine().split(matchWhitespace);
        int from = Integer.parseInt(limits[0]);
        int to = Integer.parseInt(limits[1]) + 1;
        final SortedMap<Integer, String> map = new TreeMap<>(
                IntStream.range(0, Integer.parseInt(sc.nextLine().trim()))
                        .mapToObj(i -> sc.nextLine().split(matchWhitespace))
                        .collect(Collectors.toMap(a -> Integer.parseInt(a[0]), a -> a[1])));

        map.subMap(from, to)
                .forEach((key, value) -> System.out.println(key + " " + value));
    }
}
