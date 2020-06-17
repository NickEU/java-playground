package tf.nick.interviewCamp.matrixIslands;

import java.util.HashSet;

public class IC02bMatrixIslands {

  public static void main(String[] args) {
    IC02bMatrixIslands counter = new IC02bMatrixIslands();
    char[][] testMap = new char[][] {{'1', '0', '1'},
                                     {'0', '1', '1'},
                                     {'0', '1', '1'}};

    System.out.println(counter.countIslands(testMap) == 2);

    char[][] testMap2 = new char[][] {{'1', '1', '0'},
                                      {'0', '0', '1'},
                                      {'1', '1', '0'}};

    System.out.println(counter.countIslands(testMap2) == 3);

    char[][] testMap3 = {{'1','0','1','1','1'},
                         {'1','0','1','0','1'},
                         {'1','1','1','0','1'}};
    System.out.println(counter.countIslands(testMap3) == 1);
  }

  private HashSet<IC02bCoordinate> landTiles;
  private char[][] map;

  // slow, but works.
  // goes over all the tiles one by one and marks all adjacent tiles of a land tile by putting
  // unique sets of coordinates in a HashSet. If an adjacent tile happens to
  // be already marked ( its coords are inside a hashset ) - skips it.
  private int countIslands(char[][] map) {
    this.map = map;
    landTiles = new HashSet<>();
    int islandCount = 0;

    for (int i = 0; i < map.length; i++) {
      for (int j = 0; j < map[i].length; j++) {
        if (map[i][j] == '1') {
          IC02bCoordinate currentTile = new IC02bCoordinate(i, j);
          if (!landTiles.contains(currentTile)) {
            islandCount++;
            markAllConnectedTiles(currentTile);
          }
        }
      }
    }

    return islandCount;
  }

  private void markAllConnectedTiles(IC02bCoordinate tile) {
    landTiles.add(tile);
    int i = tile.getRow();
    int j = tile.getColumn();

    if (j < map[i].length - 1)
      checkTile(i, j + 1);
    if (j > 0)
      checkTile(i, j - 1);
    if (i < map.length - 1)
      checkTile(i + 1, j);
    if (i > 0)
      checkTile(i - 1, j);
  }

  private void checkTile(int i, int j) {
    if (map[i][j] == '1') {
      IC02bCoordinate adjacentTile = new IC02bCoordinate(i, j);
      if (!landTiles.contains(adjacentTile)) {
        markAllConnectedTiles(adjacentTile);
      }
    }
  }
}
