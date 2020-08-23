package tf.nick.hypertrash.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

class HeightOfTree {
    private static int[] tree;

    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        AtomicInteger root = new AtomicInteger();
        tree = IntStream.range(0, sc.nextInt())
            .map(i -> {
                int parent = sc.nextInt();
                if (parent == -1) {
                    root.set(i);
                }
                return parent;
            })
            .toArray();

        int height = findTreeHeight(root.get(), 1);
        // the specs insist that the height
        // of a tree with 1 node ( root ) is 1
        System.out.println(height);
    }

    private static int findTreeHeight(int currNode, int height) {
        List<Integer> nodesToCheck = new ArrayList<>();
        int maxHeight = height;

        for (int i = 0; i < tree.length; i++) {
            if (tree[i] == currNode) {
                nodesToCheck.add(i);
            }
        }

        while (!nodesToCheck.isEmpty()) {
            int newHeight = findTreeHeight(
                nodesToCheck.remove(0), height + 1);
            if (newHeight > maxHeight) {
                maxHeight = newHeight;
            }
        }
        return maxHeight;
    }
}
