package tf.nick.hypertrash.functional;

import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.IntBinaryOperator;

public class CustomReducer {
    static final BiFunction<Integer, IntBinaryOperator, IntBinaryOperator> REDUCE_INT_OPERATOR =
        (seed, fn) -> (start, end) -> {
            int result = seed;
            while (start <= end) {
                result = fn.applyAsInt(result, start++);
            }
            return result;
        };

    static final IntBinaryOperator SUM_OPERATOR =
        (start, end) -> REDUCE_INT_OPERATOR.apply(0, Integer::sum).applyAsInt(start, end);

    static final IntBinaryOperator PRODUCT_OPERATOR =
        (start, end) -> REDUCE_INT_OPERATOR.apply(1, (x, y) -> x * y).applyAsInt(start, end);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter two tiny integers separated by a space: ");
        String[] values = scanner.nextLine().split("\\s+");

        int l = Integer.parseInt(values[0]);
        int r = Integer.parseInt(values[1]);

        int sumReducer = REDUCE_INT_OPERATOR.apply(0, Integer::sum).applyAsInt(l, r);
        int sum = SUM_OPERATOR.applyAsInt(l, r);
        // products highly susceptible to overflow
        int prodReducer = REDUCE_INT_OPERATOR.apply(1, (x, y) -> x * y).applyAsInt(l, r);
        int prod = PRODUCT_OPERATOR.applyAsInt(l, r);

        System.out.println(String.format("Sums: %d %d\nProducts: %d %d", sumReducer, sum, prodReducer, prod));
    }
}
