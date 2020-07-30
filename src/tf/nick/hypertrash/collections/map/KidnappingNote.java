package tf.nick.hypertrash.collections.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class KidnappingNote {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String newspaper = sc.nextLine();
        String note = sc.nextLine();
        boolean isPossible = canWriteNote(newspaper, note); // case-sensitive
        System.out.println(isPossible ? "You get money" : "You are busted");
    }

    private static boolean canWriteNote(String newspaper, String note) {
        Map<Character, Integer> src = mapFromString(newspaper);
        Map<Character, Integer> target = mapFromString(note);
        return oneMapDominatesAnother(src, target);
    }

    private static boolean oneMapDominatesAnother(
        Map<Character, Integer> dominant, Map<Character, Integer> compareTo) {
        return compareTo.entrySet().stream()
            .noneMatch(e -> dominant.getOrDefault(e.getKey(), 0) < e.getValue());
    }

    private static Map<Character, Integer> mapFromString(String line) {
        return line.replaceAll(" ", "")
            .chars().mapToObj(i -> (char) i)
            .collect(Collectors.toMap(i -> i, i -> 1, Integer::sum, HashMap::new));
    }
}
