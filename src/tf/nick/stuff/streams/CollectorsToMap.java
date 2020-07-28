package tf.nick.stuff.streams;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsToMap {
    static List<User> users = List.of(
            new User("Nick", 25),
            new User("Kate", 27),
            new User("Jane", 22),
            new User("Jane", 23)
    );

    public static void main(String[] args) {
        var map = users.stream()
                .collect(Collectors.toMap(
                        u -> u.name,
                        List::of,
                        (oldList, newList) -> Stream.of(oldList, newList)
                                .flatMap(Collection::stream)
                                .collect(Collectors.toList())
                ));
        map.forEach((k, v) -> System.out.println("Key: " + k + " Val: " + v));
    }


    static class User {
        private static int ids = 0;
        int id;
        String name;
        int age;

        User(String name, int age) {
            this.name = name;
            this.age = age;
            this.id = ids++;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
