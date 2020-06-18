package tf.nick.interviewCamp.ic02MatrixIslands;

// basic steps:
// go over the map row by row
// each row - check tile by tile
// if you find land - check if has land on prev row
// do some magic!
// keep going until we find water.
// -- do the same for next row

public class CounterA implements ICounter {
  private static boolean traversingIsland;
  private static boolean noAdjacentLandFound;
  private static int islandCount;

  public static void main(String[] args) {
    ICounter counter = new CounterA();
    CounterTest.runTestCases(counter);
  }

  // bad initial solution, fails when faced with snake-shaped islands
  // that have two "tails" on one level;
  @Override
  public int countIslands(char[][] map) {
    if (map == null) {
      return 0;
    }
    islandCount = 0;
    traversingIsland = false;
    noAdjacentLandFound = true;
    for (int i = 0; i < map.length; i++) {
      char[] row = map[i];
      for (int j = 0; j < row.length; j++) {
        if (row[j] == '1') {
          traversingIsland = true;
          if (i > 0 && map[i - 1][j] == '1') {
            noAdjacentLandFound = false;
          }
        } else if (row[j] == '0') {
          increaseIslandCount();
          resetFlags();
        }
      }
      increaseIslandCount();
      resetFlags();
    }

    return islandCount;
  }

  private static void increaseIslandCount() {
    if (traversingIsland && noAdjacentLandFound) {
      islandCount++;
    }
  }

  private static void resetFlags() {
    noAdjacentLandFound = true;
    traversingIsland = false;
  }

}
