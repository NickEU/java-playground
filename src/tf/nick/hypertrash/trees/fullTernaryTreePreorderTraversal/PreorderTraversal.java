package tf.nick.hypertrash.trees.fullTernaryTreePreorderTraversal;

import java.util.Scanner;

class PreorderTraversal {
    private static int targetDepth;
    private static int[] depthsToValues;

    public static void main(String[] args) {
        targetDepth = new Scanner(System.in).nextInt();
        initializeDepthsToValues();
        var tree = buildTree(new Tree(0, 0));
        Tree.traversePreOrder(tree);
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

    private static Tree buildTree(Tree tree) {
        if (tree.depth < targetDepth) {
            tree.left = buildChild(tree);
            tree.center = buildChild(tree);
            tree.right = buildChild(tree);
        }
        return tree;
    }

    private static Tree buildChild(Tree tree) {
        return buildTree(new Tree(depthsToValues[tree.depth]++, tree.depth + 1));
    }
}

