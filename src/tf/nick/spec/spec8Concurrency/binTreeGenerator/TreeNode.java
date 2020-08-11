package tf.nick.spec.spec8Concurrency.binTreeGenerator;

class TreeNode {
    TreeNode left;
    TreeNode right;
    int weight;
    int total;
    int depthLvl;

    TreeNode(int depthLvl, int weight) {
        this.depthLvl = depthLvl;
        this.weight = weight;
        total = weight;
    }

    int getWeight() {
        return weight;
    }

    int getDepthLvl() {
        return depthLvl;
    }

    int getTotal() {
        return total;
    }

    void incTotal(int amount) {
        total += amount;
    }

    @Override
    public String toString() {
        StringBuilder tree = new StringBuilder();
        if (left != null) {
            tree.insert(0, left);
        }

        if (right != null) {
            tree.insert(0, right);
        }

        tree.insert(0, String.format("D=%d W=%d ", getDepthLvl(), getWeight()));
        return tree.toString();
    }
}
