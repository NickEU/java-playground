package tf.nick.interviewCamp.ic03ArrayTraversal;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ReverseOrderOfElsInArray {
  public static void main(String[] args) {
    int[] input = {3, 5, 2, 5, 2, 3, 9};
    reverseDeclarative(input);
    reverseImperative(input);
    boolean resultAsExpected = Arrays.equals(input, new int[] {9, 3, 2, 5, 2, 5, 3});
    System.out.println(resultAsExpected);
  }

  private static void reverseImperative(int[] arr) {
    for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
      int temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
    }
  }

  private static void reverseDeclarative(int[] arr) {
    List<Integer> numbers = Arrays.stream(arr).boxed().collect(Collectors.toList());
    Collections.reverse(numbers);
    arr = numbers.stream().mapToInt(x -> x).toArray();
    System.out.println(Arrays.equals(arr, new int[] {9, 3, 2, 5, 2, 5, 3}));
  }
}
