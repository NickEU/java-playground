package tf.nick.hyperskill.sorting;

import java.util.Arrays;
import java.util.Scanner;

public class Bubble {
    public static void main(String[] args) {
        System.out.print("Enter your numbers in a line: ");
        int[] nums = Arrays.stream(new Scanner(System.in)
                .nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        System.out.println("Total swaps done: " + ascSortBubble(nums));
    }

    private static int ascSortBubble(int[] nums) {
        int swaps = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                    swaps++;
                }
            }
        }
        return swaps;
    }

    private static void swap(int[] nums, int j, int i) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}

