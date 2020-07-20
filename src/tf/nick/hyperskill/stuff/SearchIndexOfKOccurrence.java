package tf.nick.hyperskill.stuff;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class SearchIndexOfKOccurrence {
        public int searchIndexOfKOccurrence(int[] numbers, int value, int k) {
            return IntStream.range(0, numbers.length)
                    .mapToObj(i -> new IdxNumPair(i, numbers[i]))
                    .filter(o -> o.num == value)
                    .mapToInt(o -> o.idx)
                    .skip(k - 1).limit(1)
                    .reduce(-1, (acc, cur) -> cur);
        }

        static class IdxNumPair {
            final int idx;
            final int num;

            public IdxNumPair(int idx, int num) {
                this.idx = idx;
                this.num = num;
            }
        }

        public static void main(String[] args) {
            final Scanner sc = new Scanner(System.in);
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
            var o = new SearchIndexOfKOccurrence();
            System.out.println(o.searchIndexOfKOccurrence(numbers, value, k));
        }
}
