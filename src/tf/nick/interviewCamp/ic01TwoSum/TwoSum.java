package tf.nick.interviewCamp.ic01TwoSum;

// Given an array of integers, find a pair of integers that sums to a number Target.
// For e.g, if A = [6,3,5,2,1,7]. Target = 4, Result= [3,1]

import java.util.Arrays;
import java.util.HashSet;

public class TwoSum {
  public static void main(String[] args) {
    testTwoSum();
  }
  // O(n) Time O(n) Space
  private static int[] twoSum(int[] nums, int targetSum) {
    HashSet<Integer> numbersSeen = new HashSet<>();
    if (nums == null) {
      return null;
    }
    for (int num : nums) {
      int remainder = targetSum - num;
      if (numbersSeen.contains(remainder)) {
        return new int[]{remainder, num};
      } else {
        numbersSeen.add(num);
      }
    }
    return null;
  }

  private static void testTwoSum() {
    {
      int[] actual = twoSum(new int[] {6, 3, 5, 2, 1, 7}, 4);
      int[] expected = new int[] {3, 1};
      System.out.println(Arrays.equals(actual, expected));
    }
    {
      int[] actual = twoSum(new int[] {6, 3, 5, 2, 1, 7}, 15);
      int[] expected = null;
      System.out.println(actual == expected);
    }
    {
      int[] actual = twoSum(new int[] {6}, 6);
      int[] expected = null;
      System.out.println(actual == expected);
    }
    {
      int[] actual = twoSum(new int[] {}, 15);
      int[] expected = null;
      System.out.println(actual == expected);
    }
    {
      int[] actual = twoSum(null, 15);
      int[] expected = null;
      System.out.println(actual == expected);
    }
  }
}
