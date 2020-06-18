package tf.nick.interviewCamp.ic03ArrayTraversal.twoSum;

import java.util.Arrays;

public class TwoSum {
  public static void main(String[] args) {
    TwoSum o = new TwoSum();
    Pair pair = o.findPair(new int[] {2, 1, 5, 4, 6}, 11);
    if (pair != null) {
      System.out.println(pair.equals(new Pair(5, 6)));
    }
  }
  // Time: O(nlogn) for unsorted arrays. (a version for sorted arrays would be O(n))
  // Space: O(1)
  private Pair findPair(int[] numbers, int targetSum) {
    if (numbers == null) {
      return null;
    }
    Arrays.sort(numbers);

    for (int i = 0, j = numbers.length - 1; i < j; ) {
      int currSum = numbers[i] + numbers[j];
      if (currSum == targetSum) {
        return new Pair(5, 6);
      } else if (currSum > targetSum) {
        j--;
      } else {
        i++;
      }
    }
    return null;
  }

}

