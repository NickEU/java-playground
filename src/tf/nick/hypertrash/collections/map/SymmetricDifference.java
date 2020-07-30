package tf.nick.hypertrash.collections.map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SymmetricDifference {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        var one = mapFromString(sc.nextLine());
        var two = mapFromString(sc.nextLine());
        Map<String, Integer> diff = getSymmetricDiff(one, two);
        System.out.println(diff.values().stream().mapToInt(x -> x).sum());
    }

    private static Map<String, Integer> mapFromString(String line) {
        return Arrays.stream(line.trim().toLowerCase().split(""))
                .collect(Collectors.toMap(c -> c, c -> 1, Integer::sum, HashMap::new));
    }

    private static Map<String, Integer> getSymmetricDiff(Map<String, Integer> one, Map<String, Integer> two) {
        Map<String, Integer> result = new HashMap<>();
        addAllExtraChars(result, one, two);
        addAllExtraChars(result, two, one);
        return result;
    }

    private static void addAllExtraChars(Map<String, Integer> addTo, Map<String, Integer> addFrom,
                                         Map<String, Integer> comparedTo) {
        addFrom.forEach((k, v) -> {
            var otherVal = comparedTo.get(k);
            if (otherVal == null) {
                addTo.put(k, v);
            } else if (otherVal < v) {
                addTo.put(k, v - otherVal);
            }
        });
    }
}
