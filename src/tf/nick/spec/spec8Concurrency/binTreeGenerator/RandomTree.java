package tf.nick.spec.spec8Concurrency.binTreeGenerator;

import java.util.Random;

class RandomTree {
    static Random rnd = new Random();

    static TreeNode createNodeWithChildren(int totalDepth, int levelsRemaining) {
        int curDepthLvl = totalDepth - levelsRemaining;
        TreeNode base = genNewNode(curDepthLvl);
        boolean isBaseCase = levelsRemaining == 1;
        base.left = isBaseCase
            ? genNewNode(curDepthLvl)
            : createNodeWithChildren(totalDepth, levelsRemaining - 1);
        base.right = isBaseCase
            ? genNewNode(curDepthLvl)
            : createNodeWithChildren(totalDepth, levelsRemaining - 1);
        base.incTotal(base.left.getTotal() + base.right.getTotal());
        return base;
    }

    private static int genWeight() {
        return rnd.nextInt(20);
    }

    private static TreeNode genNewNode(int curDepth) {
        return new TreeNode(curDepth, genWeight());
    }
}
