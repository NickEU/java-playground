package tf.nick.hyperskill.sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class InsertionNumberOfShifts {
    public static void main(String[] args) {
        var numbers = new Scanner(System.in)
            .tokens().skip(1)
            .mapToInt(Integer::parseInt)
            .toArray();
        System.out.println(countShifts(numbers));
    }

    private static int countShifts(int[] numbers) {
        int result = 0;
        int sortedPartIdx = 0;
        for (int i = 1; i < numbers.length && sortedPartIdx < numbers.length; i++) {
            boolean earlyExit = false;
            for (int j = sortedPartIdx; j >= 0; j--) {
                if (numbers[i] <= numbers[j]) {
                    sortedPartIdx++;
                    if (j != i - 1) {
                        result++;
                    }
                    sortPartOfArray(numbers, j + 1, i);
                    earlyExit = true;
                    break;
                }
            }
            if (!earlyExit) {
                sortedPartIdx++;
                result++;
                sortPartOfArray(numbers, 0, i);
            }
        }
        return result;
    }

    private static void sortPartOfArray(int[] arr, int from, int toIncl) {
        AtomicInteger idx = new AtomicInteger(from);
        Arrays.stream(arr)
            .skip(from)
            .limit(toIncl - from + 1)
            .boxed()
            .sorted(Comparator.reverseOrder())
            .forEach(n -> arr[idx.getAndIncrement()] = n);
    }
}
