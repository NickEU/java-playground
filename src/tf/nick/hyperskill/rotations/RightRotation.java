package tf.nick.hyperskill.rotations;

import java.util.Arrays;
import java.util.Scanner;

public class RightRotation {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String[] userNumbers = sc.nextLine().split(" ");
    int[] numbers = Arrays.stream(userNumbers).mapToInt(Integer::parseInt).toArray();

    int rotation = Integer.parseInt(sc.nextLine());

    int[] result = rotate(rotation, numbers);
    Arrays.stream(result).mapToObj(x -> x + " ").forEach(System.out::print);
  }

  private static int[] rotate(int rotation, int[] numbers) {
    int arrLen = numbers.length;

    int[] result = new int[arrLen];
    int j = rotation % arrLen;
    for (int number : numbers) {
      result[j] = number;
      j++;
      if (j == arrLen) {
        j = 0;
      }
    }

    return result;
  }
}
