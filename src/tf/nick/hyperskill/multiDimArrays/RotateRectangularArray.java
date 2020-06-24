package tf.nick.hyperskill.multiDimArrays;

import static tf.nick.hyperskill.multiDimArrays.spiralMatrix.FactoryControl.printMatrixToConsole;
import java.util.Scanner;

class RotateRectangularArray {
  public static void main(String[] args) {
    Scanner sc = new Scanner("3 4 \n" + "11 12 13 14 \n" + "21 22 23 24 \n" + "31 32 33 34 \n");
    int[][] userInput = setupMatrix(sc);

    System.out.println();
    printMatrixToConsole(userInput);

    int[][] rotatedBy90 = rotateMatrix(userInput);

    System.out.println();
    printMatrixToConsole(rotatedBy90);
  }

  private static int[][] rotateMatrix(int[][] userInput) {
    int rowCount = userInput[0].length;
    int columnCount = userInput.length;
    int[][] result = new int[rowCount][columnCount];

    for (int i = 0; i < rowCount; i++) {
      int oldColumn = i;
      int oldRow = userInput.length - 1;
      for (int j = 0; j < columnCount; j++) {
        result[i][j] = userInput[oldRow][oldColumn];
        oldRow--;
      }
    }

    return result;
  }

  private static int[][] setupMatrix(Scanner sc) {
    int rowCount = sc.nextInt();
    int columnCount = sc.nextInt();
    int[][] userMatrix = new int[rowCount][columnCount];

    for (int i = 0; i < rowCount; i++) {
      for (int j = 0; j < columnCount; j++) {
        userMatrix[i][j] = sc.nextInt();
      }
    }

    return userMatrix;
  }
}
