package tf.nick.hypertrash.collections.map;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class CountingWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] words = sc.nextLine().split("\\s+");
        printMap(wordCount(words));
    }

    private static SortedMap<String, Integer> wordCount(String[] tokens) {
        return Arrays.stream(tokens).collect(Collectors.toMap(
                token -> token, token -> 1, Integer::sum, TreeMap::new));
    }

    private static void printMap(Map<String, Integer> map) {
        map.forEach((k, v) -> System.out.println(k + " : " + v));
    }
}
