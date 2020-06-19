package tf.nick.hyperskill.multiDimArrays;

import java.util.HashSet;
import java.util.Scanner;

public class SudokuSolver {
  private static int[][] sudokuTable;
  private static int sudokuTableSize;
  private static Scanner sc;

  public static void main(String[] args) {
    sc = new Scanner(System.in);

    String result = isSudokuTableFilledCorrectly() && isSudokuValid()
            ? "YES" : "NO";

    System.out.println(result);
  }

  private static boolean isSudokuTableFilledCorrectly() {
    sudokuTableSize = sc.nextInt();
    int matrixSize = sudokuTableSize * sudokuTableSize;
    sudokuTable = new int[matrixSize][matrixSize];

    for (int i = 0; i < sudokuTable.length; i++) {
      for (int j = 0; j < sudokuTable[i].length; j++) {
        int userInput = sc.nextInt();
        if (userInput > matrixSize) {
          return false;
        }
        sudokuTable[i][j] = userInput;
      }
    }

    return true;
  }

  private static boolean isSudokuValid() {
    return rowsAreSolved()
            && tablesAreSolved()
            && columnsAreSolved();
  }

  private static boolean tablesAreSolved() {
    int i = 0;
    int j = 0;
    while (j < sudokuTable.length) {
      if (!tableIsSolved(i, j)) {
        return false;
      }
      i += sudokuTableSize;
      if (i >= sudokuTable.length) {
        i = 0;
        j += sudokuTableSize;
      }
    }
    return true;
  }

  private static boolean tableIsSolved(int startI, int startJ) {
    HashSet<Integer> encounteredNumbers = new HashSet<>();
    for (int i = startI; i < startI + sudokuTableSize; i++) {
      for (int j = startJ; j < startJ + sudokuTableSize; j++) {
        if (!encounteredNumbers.add(sudokuTable[i][j])) {
          return false;
        }
      }
    }
    return true;
  }

  private static boolean rowsAreSolved() {
    for (int[] row : sudokuTable) {
      HashSet<Integer> encounteredNumbers = new HashSet<>();
      for (int value : row) {
        if (!encounteredNumbers.add(value)) {
          return false;
        }
      }
    }
    return true;
  }

  private static boolean columnsAreSolved() {
    for (int j = 0; j < sudokuTable.length; j++) {
      HashSet<Integer> encounteredNumbers = new HashSet<>();
      for (int[] row : sudokuTable) {
        if (!encounteredNumbers.add(row[j])) {
          return false;
        }
      }
    }
    return true;
  }
}

