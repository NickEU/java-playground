package tf.nick.hypertrash.functional;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.IntUnaryOperator;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

class MultiFunctionalMapper {
    static final Function<List<IntUnaryOperator>, UnaryOperator<List<Integer>>> MULTIFUNCTIONAL_MAPPER =
        operators -> values -> values.stream()
            .map(val -> operators.stream()
                .reduce(IntUnaryOperator::andThen).orElse(IntUnaryOperator.identity())
                .applyAsInt(val))
            .collect(Collectors.toList());

    static final UnaryOperator<List<Integer>> IDENTITY_TRANSFORMATION =
        MULTIFUNCTIONAL_MAPPER.apply(Arrays.asList(x -> x, x -> x, x -> x));

    static final UnaryOperator<List<Integer>> MULT_TWO_AND_THEN_ADD_ONE_TRANSFORMATION =
        MULTIFUNCTIONAL_MAPPER.apply(Arrays.asList(x -> x * 2, x -> x + 1));

    static final UnaryOperator<List<Integer>> SQUARE_AND_THEN_GET_NEXT_EVEN_NUMBER_TRANSFORMATION =
        MULTIFUNCTIONAL_MAPPER.apply(Arrays.asList(x -> x * x, x -> x % 2 == 0 ? x + 2 : x + 1));

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] values = scanner.nextLine().split("\\s+");

        List<Integer> numbers = Arrays.stream(values)
            .mapToInt(Integer::parseInt)
            .boxed().collect(Collectors.toList());

        List<Integer> idMapper = MULTIFUNCTIONAL_MAPPER
            .apply(Arrays.asList(x -> x, x -> x, x -> x))
            .apply(numbers);

        List<Integer> idTransformation =
            IDENTITY_TRANSFORMATION.apply(numbers);

        List<Integer> mult2AndAdd1Mapper = MULTIFUNCTIONAL_MAPPER
            .apply(Arrays.asList(x -> x * 2, x -> x + 1))
            .apply(numbers);

        List<Integer> mult2AndAdd1Transformation =
            MULT_TWO_AND_THEN_ADD_ONE_TRANSFORMATION.apply(numbers);

        List<Integer> squareAndNextEvenMapper = MULTIFUNCTIONAL_MAPPER
            .apply(Arrays.asList(x -> x * x, x -> x % 2 == 0 ? x + 2 : x + 1))
            .apply(numbers);

        List<Integer> squareAndNextEvenNumberTransformation =
            SQUARE_AND_THEN_GET_NEXT_EVEN_NUMBER_TRANSFORMATION.apply(numbers);

        String space = "    ";
        String result = getStringFromList(idMapper) + space +
            getStringFromList(idTransformation) + space +
            getStringFromList(mult2AndAdd1Mapper) + space +
            getStringFromList(mult2AndAdd1Transformation) + space +
            getStringFromList(squareAndNextEvenMapper) + space +
            getStringFromList(squareAndNextEvenNumberTransformation);
        System.out.println(result);
    }

    private static String getStringFromList(List<Integer> numbers) {
        StringBuilder builder = new StringBuilder();
        for (int n : numbers) {
            builder.append(n).append(" ");
        }
        return builder.toString().stripTrailing();
    }
}
