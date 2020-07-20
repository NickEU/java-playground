package tf.nick.hyperskill.stuff;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ArraySearch {
    final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        final var o = new ArraySearch();
        o.testKOccurrence();
        o.testLastOccurrence();
    }

    // https://hyperskill.org/learn/step/3102
    public int searchIndexOfKOccurrence(int[] numbers, int value, int k) {
        return IntStream.range(0, numbers.length)
                .mapToObj(i -> new IdxNumPair(i, numbers[i]))
                .filter(o -> o.num == value)
                .mapToInt(o -> o.idx)
                .skip(k - 1).limit(1)
                .reduce(-1, (acc, cur) -> cur);
    }
    // https://hyperskill.org/learn/step/3099
    public int searchIndexOfLastOccurrence(int[] numbers, int value) {
        return IntStream.range(0, numbers.length)
                .mapToObj(i -> new IdxNumPair(i, numbers[i]))
                .filter(o -> o.num == value)
                .mapToInt(o -> o.idx)
                .reduce(-1, (lastIdx, idx) -> idx);
    }

    static class IdxNumPair {
        final int idx;
        final int num;

        public IdxNumPair(int idx, int num) {
            this.idx = idx;
            this.num = num;
        }
    }

    private void testKOccurrence() {
        System.out.println("Testing 'The index of the K occurrence':");
        System.out.println("Line 1 : nums, Line 2: k, Line 3: searching for?");
        final int[] numbers;
        final int k;
        final int value;
        if (sc.hasNextInt()) {
            numbers = Arrays.stream(sc.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            value = Integer.parseInt(sc.nextLine());
            k = Integer.parseInt(sc.nextLine());
        } else {
            numbers = new int[0];
            value = 0;
            k = 1;
        }
        System.out.println(searchIndexOfKOccurrence(numbers, value, k));
    }

    public void testLastOccurrence() {
        System.out.println("Testing 'The index of the last occurrence':");
        System.out.println("Line 1 : nums, Line 2 : searching for?");
        final int[] numbers;
        final int k;
        if (sc.hasNextInt()) {
            numbers = Arrays.stream(sc.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            k = Integer.parseInt(sc.nextLine());
        } else {
            numbers = new int[0];
            k = 10;
        }
        System.out.println(searchIndexOfLastOccurrence(numbers, k));
    }
}
