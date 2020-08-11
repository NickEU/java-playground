package tf.nick.spec.spec8Concurrency.binTreeGenerator;

class Launcher {
    public static void main(String[] args) {
        int treeDepth = 9;
        TreeNode tree = RandomTree.createNodeWithChildren(treeDepth, treeDepth);
        System.out.println(tree);
        System.out.println("Total weight(internal): " + tree.getTotal());
        System.out.println("Total weight(traversal): " + sumWeightOfAllNodes(tree));
    }

    private static int sumWeightOfAllNodes(TreeNode node) {
        int totalWeight = node.getWeight();
        if (node.left != null) {
            totalWeight += sumWeightOfAllNodes(node.left);
        }

        if (node.right != null) {
            totalWeight += sumWeightOfAllNodes(node.right);
        }

        return totalWeight;
    }
}
