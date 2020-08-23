package tf.nick.hypertrash.trees;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class FullBinaryTree {
    // Given a tree represented as a list of pairs of adjacent nodes.
    // Write a program that checks whether the given tree is a full binary tree.
    //
    // Input: the first line contains an integer n  the number of edges in the tree.
    // Each of the following nn lines contains a pair of two integers representing an edge.
    // The first integer is a parent node, the second one is a child.
    // The node numbered 00 is a root. It is guaranteed that the input corresponds to a correct tree.
    //
    // Output: print "yes" if the given tree is a full binary and "no" otherwise.

    // example of input :
    // 2
    // 0 1
    // 0 2

    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        int edges = sc.nextInt();
        List<Integer> parents = new ArrayList<>();
        for (int i = 0; i < edges; i++) {
            parents.add(sc.nextInt()); // read parent node
            sc.nextInt(); // read child, we don't care about it
        }
        String result = new HashSet<>(parents).size() * 2 == parents.size()
            ? "yes" : "no";
        System.out.println(result);
    }
}
