package tf.nick.hypertrash.collections;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FilterOddIndexes {
    public static void main(String[] args) {
        var nums = Arrays.stream(new Scanner(System.in).nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        IntStream.iterate(nums.size() - 1, n -> n - 1).limit(nums.size())
                .filter(i -> i % 2 != 0).map(nums::get)
                .forEach(n -> System.out.print(n + " "));
    }
}
