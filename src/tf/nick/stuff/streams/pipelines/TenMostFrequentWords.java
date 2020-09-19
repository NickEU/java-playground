package tf.nick.stuff.streams.pipelines;

import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TenMostFrequentWords {
    public static void main(String[] args) {
        new Scanner(System.in).tokens()
            .map(String::toLowerCase)
            .map(word -> word.replaceAll("[^\\d\\w]", ""))
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
            .entrySet().stream()
            .sorted(Map.Entry.<String, Long>comparingByValue().reversed()
                .thenComparing(Map.Entry::getKey))
            .limit(10)
            .map(Map.Entry::getKey)
            .forEach(System.out::println);
    }
}
