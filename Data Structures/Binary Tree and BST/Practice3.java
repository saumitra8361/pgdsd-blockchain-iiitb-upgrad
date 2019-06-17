/* Count total number of leaf nodes in Binary Tree */

import java.util.*;

class Practice3{
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

        public int func(Node5 node) {
            if (node == null)
                return 0;
            else {
                int lfunc = func(node.left);
                int rfunc = func(node.right);

                if (lfunc > rfunc)
                    return (lfunc + 1);
                else
                    return (rfunc + 1);
            }
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

        System.out.println(tree.func(tree.root));
    }
}


