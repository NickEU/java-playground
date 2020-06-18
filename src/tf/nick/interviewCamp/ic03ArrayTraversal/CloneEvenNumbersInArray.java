package tf.nick.interviewCamp.ic03ArrayTraversal;

import java.util.Arrays;

public class CloneEvenNumbersInArray {
  public static void main(String[] args) {
    processArray(new Integer[] {1, 2, 3, 4, 5, null, null});
    processArray(new Integer[] {2, 2, null, null});
    processArray(new Integer[] {1, 1});
    processArray(new Integer[] {1});
    processArray(new Integer[] {2, null});
    processArray(new Integer[0]);
    processArray(null);
  }

  private static void processArray(Integer[] arr) {
    if (arr == null) {
      System.out.println("Your array variable points to null!");
      System.out.println("----------");
      return;
    }

    System.out.println(Arrays.toString(arr));

    // find idx of the last non-null element
    int idxOfLastNumber = -1;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == null) {
        idxOfLastNumber = i - 1;
        break;
      }
    }

    // traverse backwards and double tap even numbers
    // ptrNum - goes through all the elements that initially hold numbers right-to-left
    // ptrEl - goes over all the array elements right-to-left
    // and updates their values accordingly.
    // ptrEl changes two els in one ptrNum step if pointer ptrNum is over an even number
    for (int ptrNum = idxOfLastNumber, ptrEl = arr.length - 1; ptrNum >= 0; ptrNum--) {
      arr[ptrEl--] = arr[ptrNum];

      if (arr[ptrNum] % 2 == 0) {
        arr[ptrEl--] = arr[ptrNum];
      }
    }

    System.out.println(Arrays.toString(arr));
    System.out.println("----------");
  }
}
