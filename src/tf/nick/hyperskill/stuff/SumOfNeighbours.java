package tf.nick.hyperskill.stuff;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class SumOfNeighbours {
  private static int[][] userInput;
  private static int[][] result;
  private static int rows;
  private static int columns;

  public static void main(String[] args) {
    getUserMatrix();
    buildResultMatrix();
    printResultMatrix();
  }

  private static void getUserMatrix() {
    Scanner sc = new Scanner(System.in);
    ArrayList<int[]> userRows = new ArrayList<>();

    while (sc.hasNextLine()) {
      String userLine = sc.nextLine();
      if ("end".equals(userLine.trim())) {
        break;
      }
      int[] row = Arrays.stream(userLine.split(" "))
              .mapToInt(Integer::parseInt).toArray();
      userRows.add(row);
    }

    rows = userRows.size();
    columns = userRows.get(0).length;

    userInput = new int[rows][columns];

    for (int i = 0; i < rows; i++) {
      int[] row = userRows.get(i);
      System.arraycopy(row, 0, userInput[i], 0, columns);
    }
  }

  private static void buildResultMatrix() {
    result = new int[rows][columns];

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        result[i][j] = sumAdjacentEls(i, j);
      }
    }
  }

  private static int sumAdjacentEls(int i, int j) {
    int sum = 0;

    int newIdx = getInboundIdx(i - 1, rows);
    sum += userInput[newIdx][j];
    newIdx = getInboundIdx(i + 1, rows);
    sum += userInput[newIdx][j];
    newIdx = getInboundIdx(j - 1, columns);
    sum += userInput[i][newIdx];
    newIdx = getInboundIdx(j + 1, columns);
    sum += userInput[i][newIdx];

    return sum;
  }

  private static int getInboundIdx(int newIndex, int limit) {
    return newIndex == limit ? 0
            : newIndex == -1 ? limit - 1
            : newIndex;
  }

  private static void printResultMatrix() {
    if (result == null) {
      System.out.println("Size can't be <= 0, amigo!");
      return;
    }
    StringBuilder finalOutput = new StringBuilder();
    for (int[] row : result) {
      StringBuilder rowOfNumbers = new StringBuilder();
      for (int el : row) {
        rowOfNumbers.append(String.format("%d", el));
        rowOfNumbers.append(" ");
      }
      finalOutput.append(rowOfNumbers.toString().trim()).append("\n");
    }
    System.out.println(finalOutput);
  }
}
