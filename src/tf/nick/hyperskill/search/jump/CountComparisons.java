package tf.nick.hyperskill.search.jump;

import java.util.Scanner;
import java.util.stream.IntStream;

// Count how many comparisons you need to do to determine the index of the element,
// or to determine that this element is not in the array.
// You need to use the jump search algorithm.
//
// The first line contains the length of an input array,
// the second one consists of array elements, the last one has the target value.
public class CountComparisons {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        int size = sc.nextInt();

        int[] nums = IntStream.generate(() -> 0).limit(size)
            .map(i -> sc.nextInt()).toArray();

        int target = sc.nextInt();

        int comparisonsDone = countComparisonsJumpSearch(nums, target);
        System.out.println(comparisonsDone);
    }

    private static int countComparisonsJumpSearch(int[] nums, int target) {
        int count = 1;
        if (nums[0] == target) {
            return count;
        }
        int arrSize = nums.length;
        int blockSize = (int) Math.sqrt(arrSize);
        int i = blockSize;

        while (true) {
            count++;

            if (nums[i] == target) {
                return count;
            }

            if (nums[i] > target) {
                int lowerBound = i - blockSize + 1;
                while (--i >= lowerBound) {
                    count++;
                    if (nums[i] <= target) {
                        return count;
                    }
                }
                return count;
            }

            if (i == arrSize - 1) {
                return count;
            }

            i = Math.min(i + blockSize, arrSize - 1);
        }
    }
}
