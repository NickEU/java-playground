package tf.nick.linAlg.vectors.dotProduct;

import tf.nick.hyperskill.multiDimArrays.spiralMatrix.FactoryControl;

import java.util.Random;

public class Matrix {
    private final int[][] matrix;

    public Matrix(int[][] matrix) {
        // TODO: make a deep copy
        this.matrix = matrix;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public static Matrix generate(int rows, int cols) {
        var rnd = new Random();
        int[][] mat = new int[rows][cols];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                mat[i][j] = rnd.nextInt(101);
            }
        }
        return new Matrix(mat);
    }

    public void print() {
        FactoryControl.printMatrixToConsole(getMatrix());
    }
}
