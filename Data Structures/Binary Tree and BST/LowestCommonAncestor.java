/* You are given the root of the tree which is “root” in the program and nodes n1 and n2, you have to print the LCA of the nodes n1 and n2.
Note: Both the nodes n1 and n2 will be present in the tree. */

import java.util.*;

class Node3 {
    int data;
    Node3 left, right;

    Node3(int value) {
        data = value;
        left = right = null;
    }
}

class BST {
    Node3 root;

    BST() {
        root = null;
    }

    // Method to construct a binary tree from the given array
    public Node3 insertNode(int[] elementsArr, Node3 node, int i) {
        if(i < elementsArr.length){
            node = new Node3(elementsArr[i]);
            node.left = insertNode(elementsArr,node.left,2 * i + 1);
            node.right = insertNode(elementsArr,node.right,2 * i + 2);
        }
        return node;
    }

    // Method to find the lowest common ancestor of two nodes - n1 and n2
    Node3 lca(Node3 node, int n1, int n2) {
        // complete the code for this method
        if (root == null)
            return null;
        if (n1 <= node.data && n2 <= node.data){
            return lca(node.left,n1,n2);
        }
        if (n1 >= node.data && n2 >= node.data){
            return lca(node.right,n1,n2);
        }
        return node;
    }
}

// WARNING: Do not edit the code given below; otherwise the test cases might fail
class LowestCommonAncestor {
    public static void main(String[] x) {
        BST bst = new BST();

        int size;
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();

        int[] elementsArr = new int[size];
        for(int i = 0; i < size; i++) {
            elementsArr[i] = sc.nextInt();
        }

        bst.root = bst.insertNode(elementsArr, bst.root, 0);

        int n1 = sc.nextInt();
        int n2 = sc.nextInt();

        Node3 lca = bst.lca(bst.root, n1, n2);

        System.out.print(lca.data);
    }
}