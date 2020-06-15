package tf.nick.hyperskill.spiralMatrix;

import java.util.Scanner;

class ProgramSpiralMatrix {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the size of your matrix: ");
    int userInput = sc.nextInt();
    MatrixFactory matrixFactory = new MatrixFactory();
    int[][] matrix = matrixFactory.createSpiralForm(userInput);
    printMatrixToConsole(matrix);
  }

  private static void printMatrixToConsole(int[][] matrix) {
    if (matrix == null) {
      System.out.println("Size can't be <= 0, amigo!");
      return;
    }
    StringBuilder finalOutput = new StringBuilder();
    for (int[] row : matrix) {
      StringBuilder rowOfNumbers = new StringBuilder();
      for (int el : row) {
        rowOfNumbers.append(String.format("%-3d", el));
        rowOfNumbers.append(" ");
      }
      finalOutput.append(rowOfNumbers.toString().trim()).append("\n");
    }
    System.out.println(finalOutput);
  }
}
