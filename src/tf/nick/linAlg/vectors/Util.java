package tf.nick.linAlg.vectors;

import java.util.stream.IntStream;

public class Util {
    public static int dotProductOfVectors(int[] a, int[] b) {
        if (a.length != b.length) throw new IllegalArgumentException();
        return IntStream.range(0, a.length)
            .map(i -> a[i] * b[i])
            .sum();
    }
}
