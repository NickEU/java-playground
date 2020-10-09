package tf.nick.hypertrash.trees.fullTernaryTreePreorderTraversal;

import java.util.Scanner;

class PreorderTraversal {
    private static int targetDepth;
    private static int[] depthsToValues;

    public static void main(String[] args) {
        targetDepth = new Scanner(System.in).nextInt();
        initializeDepthsToValues();
        var tree = buildTree(new Tree(0, 0));
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

    private static Tree buildTree(Tree tree) {
        if (tree.depth < targetDepth) {
            tree.left = buildChild(tree);
            tree.center = buildChild(tree);
            tree.right = buildChild(tree);
        }
        return tree;
    }

    private static Tree buildChild(Tree tree) {
        return buildTree(new Tree(tree.depth + 1, depthsToValues[tree.depth]++));
    }
}

