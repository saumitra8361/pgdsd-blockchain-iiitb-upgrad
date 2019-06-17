/* You are given a binary tree. You need to print the node which has the highest value in the binary tree.
And if the tree is empty, the output should be -1.*/

import java.util.*;

class Node4{
    int data;
    Node4 left,right;

    Node4(int value){
        data = value;
        left = right = null;
    }
}

class Tree4{
    Node4 root;

    Tree4(){
        root = null;
    }

    // Method to construct a binary tree from the given array
    public Node4 insertNode(int[] elementsArr, Node4 node, int i){
        if(i < elementsArr.length){
            node = new Node4(elementsArr[i]);
            node.left = insertNode(elementsArr,node.left,2 * i + 1);
            node.right = insertNode(elementsArr,node.right,2 * i + 2);
        }
        return node;
    }

    // Method to find the largest value in the tree
    public int findMax(Node4 node){
        // Write your code here
        
        if (node == null)
            return Integer.MIN_VALUE;

        int res = node.data;
        int lres = findMax(node.left);
        int rres = findMax(node.right);

        if (lres > res)
            res = lres;
        if (rres > res)
            res = rres;
        return res;

    }

    public void printNodes(Node4 node){
        // Write your code here

        if (node == null)
            return;

        // recursively go to left subtree
        printNodes(node.left);

        // visit the parent node (parent of left & right children)
        if(node.data%3 == 0){
            System.out.print(node.data+" ");
        }

        // recursively go to right subtree
        printNodes(node.right);
    }
}

// WARNING: Do not edit the code given below; otherwise the test cases might fail
class Practice2{
    public static void main(String[] x){
        Tree4 tree = new Tree4();

        int size;
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();

        int[] elementsArr = new int[size];
        for(int i = 0; i < size; i++){
            elementsArr[i] = sc.nextInt();
        }

        tree.root = tree.insertNode(elementsArr,tree.root,0);

        System.out.println(tree.findMax(tree.root));
    }
}
