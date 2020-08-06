package tf.nick.spec.spec8Concurrency.binTreeGenerator;

class Launcher {
    public static void main(String[] args) {
        int treeDepth = 4;
        TreeNode tree = RandomTree.createNodeWithChildren(treeDepth, treeDepth);
        System.out.println(tree);
        System.out.println("Total weight: " + tree.getTotal());
    }
}
