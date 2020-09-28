package tf.nick.linAlg.vectors.dotProduct;

public class DotProduct {
    public static void main(String[] args) {
        calculate(setupMatrix("A"), setupMatrix("B"));
    }

    private static int[][] setupMatrix(String name) {
        System.out.printf("Matrix %s:\n", name);
        Matrix a = Matrix.generate(4, 6);
        a.print();
        return a.getMatrix();
    }

    private static void calculate(int[][] a, int[][] b) {
        final int[] result = new int[a[0].length];

        for (int col = 0; col < a[0].length; col++) {
            int dotProduct = 0;
            for (int row = 0; row < a.length; row++) {
                dotProduct += a[row][col] * b[row][col];
            }
            result[col] = dotProduct;
        }

        System.out.println("Dot products: ");
        for (int dotProduct : result) {
            System.out.print(dotProduct+ " ");
        }
    }
}
