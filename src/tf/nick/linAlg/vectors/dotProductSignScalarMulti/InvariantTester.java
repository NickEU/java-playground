package tf.nick.linAlg.vectors.dotProductSignScalarMulti;

import java.util.stream.IntStream;

public class InvariantTester {
    public static void main(String[] args) {
        var a = new int[]{2, 3, 4};
        var aScalar = -5;
        var b = new int[]{-7, -9, 5};
        var bScalar = 4;

        int dotProduct = dotProductOfVectors(a, b);
        scaleVector(a, aScalar);
        scaleVector(b, bScalar);
        int dotProductScaled = dotProductOfVectors(a, b);
        // in general, the sign of the dot product
        // is not invariant to scalar multiplication
        // --> scalar * has an effect on the sign of the dot product
        System.out.println("Original dot product: " + dotProduct);
        System.out.println("Scaled dot product  : " + dotProductScaled);
    }

    private static void scaleVector(int[] vector, int scalar) {
        IntStream.range(0, vector.length)
            .forEach(i -> vector[i] = scalar * vector[i]);
    }

    private static int dotProductOfVectors(int[] a, int[] b) {
        if (a.length != b.length) throw new IllegalArgumentException();
        return IntStream.range(0, a.length)
            .map(i -> a[i] * b[i])
            .sum();
    }
}
