package tf.nick.spec;

import java.util.ArrayList;
import java.util.List;

public class FancyList {
  public static List<Integer> numbers;

  // Fancy schmancy initialization
  static {
    numbers = new ArrayList<>();
    for (int i = 1; i <= 50; i++) {
      int rem = i % 10;
      int number = rem == 0 ? 10 : rem;
      numbers.add(number);
    }
  }
}
