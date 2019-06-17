/* Count total number of leaf nodes in Binary Tree */

import java.util.*;

class CountLeafNodes{
    public static class Node5
    {
        int data;
        Node5 left, right;

        public Node5(int item)
        {
            data = item;
            left = right = null;
        }
    }

    public static class BinaryTree
    {
        Node5 root;
        int count = 0;

        int getLeafCount()
        {
            return getLeafCount(root);
        }

        int getLeafCount(Node5 node)
        {
            // complete the code here...
            if(node.left == null && node.right == null)
                return 1;

            count += getLeafCount(node.left) + getLeafCount(node.right);

            return count;
        }


    }
    public static void main(String[] args)
    {

        BinaryTree tree = new BinaryTree();
        tree.root = new Node5(20);
        tree.root.left = new Node5(8);
        tree.root.right = new Node5(22);
        tree.root.left.left = new Node5(4);
        tree.root.left.right = new Node5(12);
        tree.root.left.right.left = new Node5(10);
        tree.root.left.right.right = new Node5(14);

        System.out.println(tree.getLeafCount());
    }
}

