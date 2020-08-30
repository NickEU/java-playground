package tf.nick.hyperskill.sorting;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SelectionPartial {
    // Input: the first line contains a number n — the length of an input array.
    // The next line contains n numbers — the elements of the array.
    // The 3rd line contains an integer k
    //
    // Output: k largest elements of the input array in descending order.
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] nums = sc.tokens().limit(size)
            .mapToInt(Integer::parseInt)
            .toArray();
        int elsToSort = sc.nextInt();
        String result = partialSorting(nums, elsToSort);
        System.out.println(result);
    }

    private static String partialSorting(int[] nums, int elsToSort) {
        for (int idx = 0; idx < elsToSort; idx++) {
            int max = nums[idx];
            int idxOfMax = idx;
            for (int i = idx + 1; i < nums.length; i++) {
                int curEL = nums[i];
                if (max < curEL) {
                    max = curEL;
                    idxOfMax = i;
                }
            }
            if (idx != idxOfMax) {
                swap(nums, idx, idxOfMax);
            }
        }
        return Arrays.stream(nums)
            .mapToObj(String::valueOf)
            .limit(elsToSort)
            .collect(Collectors.joining(" "));
    }

    private static void swap(int[] nums, int fromIdx, int toIdx) {
        int temp = nums[fromIdx];
        nums[fromIdx] = nums[toIdx];
        nums[toIdx] = temp;
    }
}
