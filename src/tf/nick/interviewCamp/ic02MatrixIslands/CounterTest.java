package tf.nick.interviewCamp.ic02MatrixIslands;

import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class CounterTest {
  private static final HashMap<char[][], Integer> testCases = new HashMap<>();

  static {
    testCases.put(
        new char[][] {
          {'1', '0', '1'},
          {'0', '1', '1'},
          {'0', '1', '1'}
        },
        2);
    testCases.put(
        new char[][] {
          {'1', '1', '0'},
          {'0', '0', '1'},
          {'1', '1', '0'}
        },
        3);
    testCases.put(
        new char[][] {
          {'1', '0', '1', '1', '1'},
          {'1', '0', '1', '0', '1'},
          {'1', '1', '1', '0', '1'}
        },
        1);
    testCases.put(new char[][] {{'0'}}, 0);
    testCases.put(new char[][] {{'1'}}, 1);
  }

  public static void runTestCases(ICounter counter) {
    AtomicBoolean allTestsOK = new AtomicBoolean(true);
    testCases.forEach(
        (input, expectedResult) -> {
          int actualResult = counter.countIslands(input);
          boolean testHasFailed = actualResult != expectedResult;
          if (testHasFailed) {
            allTestsOK.set(false);
            System.out.println("Test has failed. Input:");
            for (char[] row : input) {
              System.out.println(Arrays.toString(row));
            }
            System.out.println("Expected result: " + expectedResult);
            System.out.println("Actual result: " + actualResult);
          }
        });
    if (allTestsOK.get()) {
      System.out.println("All tests have passed!");
    }
  }
}
