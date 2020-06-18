package tf.nick.interviewCamp.ic03ArrayTraversal;

import java.util.Arrays;

public class SortedSquares {
  //  Given a sorted array in non-decreasing order, return an array of squares of each number, also
  //  in non-decreasing order. For example:
  //          [-4,-2,-1,0,3,5] -> [0,1,4,9,16,25]
  //  How can you do it in O(n) time?

  public static void main(String[] args) {
    int[] input = {-4, -2, -1, 0, 3, 5};

    int[] actual = getArray(input);
    int[] expected = {0,1,4,9,16,25};

    System.out.println(Arrays.equals(actual, expected));
  }

  private static int[] getArray(int[] arr) {
    int[] sortedSquares = new int[arr.length];

    int resultIdx = arr.length - 1;
    int i = 0;
    int j = arr.length - 1;

    // basic steps:
    // 1) two pointers start at opposite ends
    // 2) compare arr els that are being pointed to
    // 3) push the bigger one to the end of the result array
    // 3) with an offset to the left being the number of iterations
    // 4) decrement the said offset by one
    // 5) move up related pointer closer to the opposite end
    // 6) if pointers do not point to the same el go to 2)
    // 7) if they do point to the same el push the square of the smaller one
    // 7) to the first el of the result array and return
    while (true) {
      int leftMostNum = Math.abs(arr[i]);
      int rightMostNum = Math.abs(arr[j]);
      if (leftMostNum > rightMostNum) {
        sortedSquares[resultIdx--] = leftMostNum * leftMostNum;
        i++;
        if (i == j) {
          sortedSquares[resultIdx] = rightMostNum * rightMostNum;
          break;
        }
      } else {
        sortedSquares[resultIdx--] = rightMostNum * rightMostNum;
        j--;
        if (i == j) {
          sortedSquares[resultIdx] = leftMostNum * leftMostNum;
          break;
        }
      }

    }

    return sortedSquares;
  }
}
