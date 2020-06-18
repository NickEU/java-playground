package tf.nick.interviewCamp.ic02MatrixIslands;

public class CounterTest {
  private static final char[][] testMap = new char[][]
          {{'1', '0', '1'},
           {'0', '1', '1'},
           {'0', '1', '1'}};

  private static final char[][] testMap2 = new char[][]
          {{'1', '1', '0'},
           {'0', '0', '1'},
           {'1', '1', '0'}};

  private static final char[][] testMap3 =
          {{'1','0','1','1','1'},
           {'1','0','1','0','1'},
           {'1','1','1','0','1'}};

  public static void runTestCases(ICounter counter) {
    System.out.println(counter.countIslands(testMap) == 2);
    System.out.println(counter.countIslands(testMap2) == 3);
    System.out.println(counter.countIslands(testMap3) == 1);
  }
}
