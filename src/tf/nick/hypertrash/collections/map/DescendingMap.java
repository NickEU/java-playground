package tf.nick.hypertrash.collections.map;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class DescendingMap {
    public static void main(String[] args) {
        var map = new TreeMap<>(Map.of(1, "one",
                2, "two",
                3, "three",
                4, "four",
                5, "five",
                6, "six",
                7, "seven"));
        System.out.println(getSubMapA(map));
        map.put(0, "zero");
        System.out.println(getSubMapB(map));
    }

    public static Map<Integer, String> getSubMapB(TreeMap<Integer, String> map) {
        return map.firstKey() % 2 != 0
                ? map.headMap(map.firstKey() + 4, true).descendingMap()
                : map.tailMap(map.lastKey() - 4, true).descendingMap();
    }

    public static Map<Integer, String> getSubMapA(TreeMap<Integer, String> map) {
        TreeMap<Integer, String> result = new TreeMap<>(Collections.reverseOrder());

        boolean isFirstKeyEven = map.firstKey() % 2 == 0;
        int from = isFirstKeyEven ? map.lastKey() - 4 : map.firstKey();
        int to = isFirstKeyEven ? map.lastKey() + 1 : map.firstKey() + 5;

        result.putAll(map.subMap(from, to));
        return result;
    }
}
