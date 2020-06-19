package tf.nick.hyperskill.multiDimArrays.spiralMatrix;

import java.util.Arrays;

public class MatrixFactory {
  private int i;
  private int j;
  private Action action;
  private int[][] matrix;

  public int[][] createSpiralForm(int size) {
    if (size <= 0) {
      return null;
    }
    matrix = new int[size][size];

    action = Action.NOTHING;
    j = 0;
    i = 0;
    int counter = 1;

    while (counter <= size * size) {
      moveCursor();

      if (cursorWasOutOfBounds()) {
        continue;
      }

      if (matrix[i][j] == 0) {
        matrix[i][j] = counter;
        counter++;
      } else {
        make90DegreeTurn();
      }
    }

    return Arrays.stream(matrix).map(int[]::clone).toArray(int[][]::new);
  }

  private void make90DegreeTurn() {
    switch (action) {
      case GO_LEFT:
        j++;
        action = Action.GO_UP;
        break;
      case GO_RIGHT:
        j--;
        action = Action.GO_DOWN;
        break;
      case GO_DOWN:
        i--;
        action = Action.GO_LEFT;
        break;
      case GO_UP:
        i++;
        action = Action.GO_RIGHT;
        break;
      default:
        break;
    }
  }

  private boolean cursorWasOutOfBounds() {
    if (i >= matrix.length) {
      // hit the wall Y going down
      i--;
      action = Action.GO_LEFT;
      return true;
    } else if (i < 0) {
      // hit the wall Y going up
      i++;
      action = Action.GO_RIGHT;
      return true;
    } else if (j >= matrix[i].length) {
      // hit the wall X going to the right
      j--;
      action = Action.GO_DOWN;
      return true;
    } else if (j < 0) {
      // hit the wall X going to the left
      j++;
      action = Action.GO_UP;
      return true;
    }
    return false;
  }

  private void moveCursor() {
    switch (action) {
      case GO_LEFT:
        j--;
        break;
      case GO_RIGHT:
        j++;
        break;
      case GO_DOWN:
        i++;
        break;
      case GO_UP:
        i--;
        break;
      case NOTHING:
        action = Action.GO_RIGHT;
        break;
      default:
        break;
    }
  }
}
