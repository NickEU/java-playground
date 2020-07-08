package tf.nick.utility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Helpers {
    @SafeVarargs
    public static <T> List<T> listOf(T... objects) {
        return new ArrayList<>(Arrays.asList(objects));
    }
}
