package tf.nick.hypertrash.trees.fullTernaryTreePreorderTraversal;

class Tree {
    int value;
    int depth;

    public Tree(int value, int depth) {
        this.value = value;
        this.depth = depth;
    }

    Tree left;
    Tree center;
    Tree right;

    static void traversePreOrder(Tree tree) {
        System.out.print(tree.value + " ");
        if (tree.left != null) {
            Tree.traversePreOrder(tree.left);
        }
        if (tree.center != null) {
            Tree.traversePreOrder(tree.center);
        }
        if (tree.right != null) {
            Tree.traversePreOrder(tree.right);
        }
    }
}
