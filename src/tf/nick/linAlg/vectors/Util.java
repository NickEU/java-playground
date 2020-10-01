package tf.nick.linAlg.vectors;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class Util {
    public static void printVector(int[] vector, String name) {
        System.out.printf("Printing vector %s:\n", name);
        System.out.println(Arrays.toString(vector));
    }
    public static int dotProductOfVectors(int[] a, int[] b) {
        if (a.length != b.length) throw new IllegalArgumentException();
        return IntStream.range(0, a.length)
            .map(i -> a[i] * b[i])
            .sum();
    }

    public static int[] generateRandomVector(int size) {
        Random rnd = new Random();
        final int randomIntUpperBound = 100;
        return IntStream.generate(() -> rnd.nextInt(randomIntUpperBound))
            .limit(size)
            .toArray();
    }
}
