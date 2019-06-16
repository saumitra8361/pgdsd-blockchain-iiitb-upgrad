/* You are given a binary tree. You are required to print the spiral level-order traversal for the tree. */

import java.util.*;

class Node2 {
    int data;
    Node2 left, right;

    Node2(int value) {
        data = value;
        left = right = null;
    }
}

class Tree2 {
    Node2 root;
    boolean ltr = false;

    Tree2() {
        root = null;
    }

    // Method to construct a binary tree from the given array
    public Node2 insertNode(int[] elementsArr, Node2 node, int i) {
        if(i < elementsArr.length){
            node = new Node2(elementsArr[i]);
            node.left = insertNode(elementsArr,node.left,2 * i + 1);
            node.right = insertNode(elementsArr,node.right,2 * i + 2);
        }
        return node;
    }

    // Method to calculate height of a tree
    int height(Node2 root) {
        if (root == null)
            return 0;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        if (leftHeight > rightHeight)
            return leftHeight + 1;
        else
            return rightHeight + 1;
    }

    // Method to traverse the elements of a tree using BFS (level-order traversal) in the spiral order
    void spiralOrder() {
        // Write your code here
        int h = height(root);
        for (int i = 1; i <= h; i++){
            printNodesAtLevel(root, i, 1);
            if(ltr == false)
                ltr = true;
            else
                ltr = false;
        }
    }

    // Method to print nodes at the given level
    void printNodesAtLevel (Node2 root, int level, int currentLevel) {
        if (root == null)
            return;
        if (level == currentLevel)
            System.out.print(root.data + " ");
        if(ltr == true) {
            printNodesAtLevel(root.left, level, currentLevel + 1);
            printNodesAtLevel(root.right, level, currentLevel + 1);
        } else {
            printNodesAtLevel(root.right, level, currentLevel + 1);
            printNodesAtLevel(root.left, level, currentLevel + 1);
        }
    }
}

// WARNING: Do not edit the code given below; otherwise the test cases might fail
class SpiralOrderTraversal {
    public static void main(String[] x) {
        Tree2 tree = new Tree2();

        int size;
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();

        int[] elementsArr = new int[size];
        for(int i = 0; i < size; i++) {
            elementsArr[i] = sc.nextInt();
        }

        tree.root = tree.insertNode(elementsArr, tree.root, 0);

        tree.spiralOrder();
    }
}
