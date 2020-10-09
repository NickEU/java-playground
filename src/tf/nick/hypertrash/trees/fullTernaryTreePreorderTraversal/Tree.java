package tf.nick.hypertrash.trees.fullTernaryTreePreorderTraversal;

class Tree {
    int value;
    int depth;

    public Tree(int depth, int value) {
        this.value = value;
        this.depth = depth;
    }

    Tree left;
    Tree center;
    Tree right;
}
