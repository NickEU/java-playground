package tf.nick.hypertrash.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class HeightOfTree2 {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] tree = sc.tokens().limit(size)
            .mapToInt(Integer::parseInt).toArray();

        int height = findHeight(tree);
        System.out.println(height);
    }

    private static int findHeight(int[] treeAsArr) {
        int height = 1;
        int parentNum = -1;
        for (int i = 0; i < treeAsArr.length; i++) {
            if (treeAsArr[i] == -1) {
                parentNum = i;
                break;
            }
        }
        if (parentNum == -1) {
            return 0;
        }
        SortedMap<Integer, List<Integer>> nodes = IntStream.range(0, treeAsArr.length)
            .boxed().collect(Collectors.toMap(
                i -> treeAsArr[i],
                List::of,
                (v1, v2) -> Stream.concat(v1.stream(), v2.stream()).collect(Collectors.toList()),
                TreeMap::new
            ));
        List<Integer> currLevelNodes = new ArrayList<>(List.of(parentNum));
        while (true) {
            List<Integer> nextLevelNodes = new ArrayList<>();
            for (int num : currLevelNodes) {
                if (nodes.get(num) != null) {
                    nextLevelNodes.addAll(nodes.get(num));
                }
            }

            if (nextLevelNodes.size() > 0) {
                height++;
                currLevelNodes = nextLevelNodes;
            } else {
                return height;
            }
        }
    }
}
