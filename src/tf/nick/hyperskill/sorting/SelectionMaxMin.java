package tf.nick.hyperskill.sorting;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SelectionMaxMin {
    // Let's say that an array is max-min sorted if the first element of the array
    // is the maximum element, the second is the minimum,
    // the third is the second maximum and so on.
    // Modify Selection sort such that it can be used for max-min sorting.
    //
    // Input: the first line contains a number n
    // n — the length of an input array.
    // The next line contains n numbers — the elements of the array.
    //
    // Output: a max-min sorted input array.
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] nums = sc.tokens().limit(size)
            .mapToInt(Integer::parseInt).toArray();
        String result = weirdSelectSort(nums);
        System.out.println(result);
    }

    private static String weirdSelectSort(int[] nums) {
        for (int idx = 0; idx < nums.length; idx++) {
            boolean lookingForMax = idx % 2 == 0;
            int currTarget = nums[idx];
            int currTargetIdx = idx;
            for (int i = idx + 1; i < nums.length; i++) {
                if (lookingForMax && nums[i] > currTarget
                    || !lookingForMax && nums[i] < currTarget) {
                    currTarget = nums[i];
                    currTargetIdx = i;
                }
            }
            if (currTargetIdx != idx) {
                swap(nums, currTargetIdx, idx);
            }
        }

        return Arrays.stream(nums)
            .mapToObj(String::valueOf)
            .collect(Collectors.joining(" "));
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
