package tf.nick.hypertrash.trees.fullTernaryTreePreorderTraversal;

import java.util.Scanner;

class PreorderTraversal {
    private static int targetDepth;
    private static int[] depthsToValues;

    public static void main(String[] args) {
        targetDepth = new Scanner(System.in).nextInt();
        initializeDepthsToValues();
        var tree = buildTree(0, new Tree(0, 0));
        traverseTreePreOrder(tree);
    }

    private static void initializeDepthsToValues() {
        depthsToValues = new int[targetDepth];
        int prevVal = 0;
        for (int i = 0; i < depthsToValues.length; i++) {
            int curVal = prevVal + (int) Math.pow(3, i);
            depthsToValues[i] = curVal;
            prevVal = curVal;
        }
    }

    // In the pre-order traversal, we first visit the current node,
    // then, we recursively visit the left child (if exists),
    // and after that, we visit the right child (if exists).
    private static void traverseTreePreOrder(Tree tree) {
        System.out.print(tree.value + " ");
        if (tree.left != null) {
            traverseTreePreOrder(tree.left);
        }
        if (tree.center != null) {
            traverseTreePreOrder(tree.center);
        }
        if (tree.right != null) {
            traverseTreePreOrder(tree.right);
        }
    }

    private static Tree buildTree(int depth, Tree tree) {
        if (depth < targetDepth) {
            depth++;
            tree.left = buildTree(depth, new Tree(depth, depthsToValues[tree.depth]++));
            tree.center = buildTree(depth, new Tree(depth, depthsToValues[tree.depth]++));
            tree.right = buildTree(depth, new Tree(depth, depthsToValues[tree.depth]++));
        }
        return tree;
    }
}

