package tf.nick.hypertrash.functional;

import java.util.Scanner;
import java.util.function.Function;

public class CurryConcat {
    public static String calc(String[] values) {
        Function<String, Function<String, Function<String, Function<String, String>>>> stringFun =
            a -> b -> c -> d -> a.toLowerCase() + c.toUpperCase() + b.toLowerCase() + d.toUpperCase();
        return stringFun.apply(values[0]).apply(values[1]).apply(values[2]).apply(values[3]);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] values = scanner.nextLine().split("\\s+");
        System.out.println(calc(values));
    }
}
