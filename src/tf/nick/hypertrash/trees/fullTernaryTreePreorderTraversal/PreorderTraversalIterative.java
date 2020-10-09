package tf.nick.hypertrash.trees.fullTernaryTreePreorderTraversal;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Scanner;

public class PreorderTraversalIterative {
    public static void main(String[] args) {
        int targetDepth = new Scanner(System.in).nextInt();
        var tree = generateTree(targetDepth);
        Tree.traversePreOrder(tree);
    }

    private static Tree generateTree(int targetDepth) {
        Queue<Tree> queue = new LinkedList<>();
        int value = 0;
        var result = new Tree(value++, 0);
        queue.add(result);
        while (true) {
            var curNode = queue.poll();
            if (Objects.requireNonNull(curNode).depth == targetDepth) {
                break;
            }
            curNode.left = buildChild(curNode, queue, value++);
            curNode.center = buildChild(curNode, queue, value++);
            curNode.right = buildChild(curNode, queue, value++);
        }

        return result;
    }

    private static Tree buildChild(Tree curNode, Queue<Tree> queue, int value) {
        var child = new Tree(value, curNode.depth + 1);
        queue.add(child);
        return child;
    }
}
