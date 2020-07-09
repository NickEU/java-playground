package tf.nick.spec.spec5Supplier;

import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Supplier;

public class ExampleSupplier {
  public static <T extends Comparable<? super T>> boolean isGreater(T a, T b) {
    return a.compareTo(b) > 0;
  }

  public static String doFactoryStuff(Supplier<? extends Scanner> x) {
    Scanner sc = x.get();
    return sc.nextLine();
  }

  public static void main(String[] args) {
    String input = "Hello\nWorld\n";

    Function<String, Scanner> f = Scanner::new;
    Scanner sc = f.apply(input);
    System.out.println(sc.nextLine());

    System.out.println(doFactoryStuff(() -> new Scanner(input)));
    System.out.println(isGreater(5, 7));
    System.out.println(isGreater(12.9, 12.6));
    System.out.println(isGreater("abd", "abc"));
  }
}
