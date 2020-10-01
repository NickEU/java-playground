package tf.nick.linAlg.vectors.dotProductCommutative;

import java.util.Arrays;

import static tf.nick.linAlg.vectors.Util.dotProductOfVectors;
import static tf.nick.linAlg.vectors.Util.generateRandomVector;
import static tf.nick.linAlg.vectors.Util.printVector;

public class PropertyTester {
    public static void main(String[] args) {
        final int vectorSize = 100;

        var a = generateRandomVector(vectorSize);
        printVector(a, "A");

        var b = generateRandomVector(vectorSize);
        printVector(b, "B");

        int dotProductAB = dotProductOfVectors(a, b);
        int dotProductBA = dotProductOfVectors(b, a);

        System.out.printf("Dot product is%s commutative",
            dotProductAB == dotProductBA ? "" : " not");
    }
}
