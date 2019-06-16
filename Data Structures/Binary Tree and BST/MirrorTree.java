/* You are given a binary tree. You are required to convert this binary tree into its mirror image. */
import java.util.*;

class Node1 {
    int data;
    Node1 left, right;

    Node1(int value) {
        data = value;
        left = right = null;
    }
}

class Tree1 {
    Node1 root;

    Tree1() {
        root = null;
    }

    // Method to construct a binary tree from the given array
    public Node1 insertNode(int[] elementsArr, Node1 node, int i) {
        if(i < elementsArr.length){
            node = new Node1(elementsArr[i]);
            node.left = insertNode(elementsArr,node.left,2 * i + 1);
            node.right = insertNode(elementsArr,node.right,2 * i + 2);
        }
        return node;
    }

    // Method to print the tree in pre-order traversal
    void preOrderDFS(Node1 node) {
        if (node == null)
            return;

        // visit the parent node (parent of left & right children)
        System.out.print(node.data + " ");
        // recursively go to left subtree
        preOrderDFS(node.left);
        // recursively go to right subtree
        preOrderDFS(node.right);
    }

    // Method to convert a given binary tree into its mirror image
    public void mirror(Node1 node) {
        // Write your code here
        Node1 temp = new Node1(0);

        if (node == null)
            return;

        mirror(node.left);
        mirror(node.right);

        //swap left and right node
        temp = node.left;
        node.left = node.right;
        node.right = temp;
    }
}

// WARNING: Do not edit the code given below; otherwise the test cases might fail
class MirrorTree {
    public static void main(String[] x) {
        Tree1 tree = new Tree1();

        int size;
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();

        int[] elementsArr = new int[size];
        for(int i = 0; i < size; i++) {
            elementsArr[i] = sc.nextInt();
        }

        tree.root = tree.insertNode(elementsArr, tree.root, 0);

        tree.mirror(tree.root);

        tree.preOrderDFS(tree.root);
    }
}


