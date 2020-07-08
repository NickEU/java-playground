package tf.nick.hypertrash.reflection.modifiers;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 Get list of public fields the object declares (inherited fields should be skipped).
 */
public class FieldGetter {
    String[] getPublicFields(Object object) {
        return Arrays.stream(object.getClass()
                .getDeclaredFields())
                .filter(f -> Modifier.isPublic(f.getModifiers()))
                .map(Field::getName).toArray(String[]::new);
    }

    public List<String> getPrivateFields(Object object) {
        return Arrays.stream(object.getClass().getDeclaredFields())
                .filter(f -> Modifier.isPrivate(f.getModifiers()))
                .map(Field::getName)
                .sorted()
                .collect(Collectors.toList());
    }
}
