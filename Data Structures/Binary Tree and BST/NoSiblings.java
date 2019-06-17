/* A sibling is a node that has the same parent. In a Binary Tree, there can be at most one sibling.
Print all such nodes in a single line which do not have a sibling.﻿
*/

import java.util.*;

class Node6 {
    int data;
    Node6 left, right;

    Node6(int value) {
        data = value;
        left = right = null;
    }
}

class BinaryTree {
    Node6 root;

    BinaryTree() {
        root = null;
    }

    void printSingles(Node6 node) {
        // complete this function
        if(node == null)
            return;
        if(node.left == null && node.right != null)
            System.out.println(node.right.data);
        if(node.left != null && node.right == null)
            System.out.println(node.left.data);

        printSingles(node.left);
        printSingles(node.right);
    }
}

// WARNING: Do not edit code below this; failing which your solution may not pass the test case(s)
class NoSiblings {
    public static void main(String args[]) {
        BinaryTree tree = new BinaryTree();

        tree.root = new Node6(5);
        tree.root.left = new Node6(2);
        tree.root.right = new Node6(8);
        tree.root.right.right = new Node6(9);
        tree.root.left.left = new Node6(1);
        tree.root.left.right = new Node6(4);
        tree.root.left.right.left = new Node6(3);
        tree.printSingles(tree.root);
    }
}
