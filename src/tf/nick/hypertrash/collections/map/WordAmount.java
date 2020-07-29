package tf.nick.hypertrash.collections.map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordAmount {
    public static void main(String[] args) {
        Arrays.stream(new Scanner(System.in).nextLine().split("\\s+"))
                .map(s -> Map.of(s.toLowerCase(), 1))
                .reduce(new HashMap<>(), (acc, cur) -> {
                    acc.merge(cur.keySet().iterator().next(),
                            cur.values().iterator().next(), Integer::sum);
                    return acc;
                })
                .forEach((k, v) -> System.out.println(k + " " + v));
    }
}
