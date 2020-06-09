package tf.nick.spec4FunctionalInterface;

import java.util.function.DoubleFunction;

public class Functions {
    private final int inputNum;

    public Functions(int inputNum) {
        this.inputNum = inputNum;
    }

    private double calcResult(DoubleFunction<Double> f) {
        return f.apply(inputNum);
    }

    private double calcResult(MathFunction f) {
        return f.calc(inputNum);
    }

    public void printResults() {
        String formattedOutput = "%.2f%n";
        System.out.printf(formattedOutput, calcResult(Math::sin));
        System.out.printf(formattedOutput, calcResult(Math::sqrt));
        System.out.println(calcResult((DoubleFunction<Double>) x -> x + 5 - 2));
    }
}
