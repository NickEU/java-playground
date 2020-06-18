package tf.nick.interviewCamp.ic03ArrayTraversal;

import tf.nick.interviewCamp.ic03ArrayTraversal.twoSum.Pair;

import java.util.Arrays;

public class ShortestUnsortedSubarray {
  public static void main(String[] args) {
    int[] input = {1, 2, 4, 5, 3, 5, 6, 7};

    Pair pair = findPairOfIndices(input);

    System.out.println(pair.equals(new Pair(2, 4)));

    findPairOfIndices(new int[] {1, 3, 5, 2, 6, 4, 7, 8, 9});
    findPairOfIndices(new int[] {2, 6, 4, 8, 10, 9, 15});
    findPairOfIndices(new int[] {1, 3, 2, 2, 2});
  }

  private static Pair findPairOfIndices(int[] arr) {
    System.out.println(Arrays.toString(arr));
    int left = -1;
    int right = -1;

    Integer min = null;
    Integer max = null;
    for (int i = arr.length - 1; ; i--) {
      if (i == 0 && min == null || i < 0) {
        break;
      }
      if (min == null && arr[i] < arr[i - 1]) {
        right = i;
        min = arr[i];
        max = arr[i - 1];
      } else if (min != null && arr[i] < min) {
        min = arr[i];
      } else if (min != null && arr[i] > min) {
        left = i;
        max = Math.max(arr[i], max);
      }
    }

    if (max != null) {
      for (int i = arr.length - 1; i >= 0; i--) {
        if (arr[i] < max) {
          right = i;
          break;
        }
      }
    }

    System.out.println(left + " " + right);
    System.out.println("------------");
    return new Pair(left, right);
  }
}
