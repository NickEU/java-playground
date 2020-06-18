package tf.nick.interviewCamp.ic02MatrixIslands;

import java.util.HashSet;

public class CounterB implements ICounter {

  public static void main(String[] args) {
    ICounter counter = new CounterB();
    CounterTest.runTestCases(counter);
  }

  private HashSet<Coordinate> landTiles;
  private char[][] map;

  // slow, but works.
  // goes over all the tiles one by one and marks all adjacent tiles of a land tile by putting
  // unique sets of coordinates in a HashSet. If an adjacent tile happens to
  // be already marked ( its coords are inside a hashset ) - skips it.
  @Override
  public int countIslands(char[][] map) {
    this.map = map;
    landTiles = new HashSet<>();
    int islandCount = 0;

    for (int i = 0; i < map.length; i++) {
      for (int j = 0; j < map[i].length; j++) {
        if (map[i][j] == '1') {
          Coordinate currentTile = new Coordinate(i, j);
          if (!landTiles.contains(currentTile)) {
            islandCount++;
            markTileAndItsConnections(currentTile);
          }
        }
      }
    }

    return islandCount;
  }

  private void markTileAndItsConnections(Coordinate tile) {
    landTiles.add(tile);
    int i = tile.getRow();
    int j = tile.getColumn();

    if (j < map[i].length - 1)
      ifTileIsLandMakeSureItsMarked(i, j + 1);
    if (j > 0)
      ifTileIsLandMakeSureItsMarked(i, j - 1);
    if (i < map.length - 1)
      ifTileIsLandMakeSureItsMarked(i + 1, j);
    if (i > 0)
      ifTileIsLandMakeSureItsMarked(i - 1, j);
  }

  private void ifTileIsLandMakeSureItsMarked(int i, int j) {
    if (map[i][j] == '1') {
      Coordinate adjacentTile = new Coordinate(i, j);
      if (!landTiles.contains(adjacentTile)) {
        markTileAndItsConnections(adjacentTile);
      }
    }
  }
}
