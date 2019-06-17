/* Print path from Root to all its leaf nodes separately*/

import java.util.*;

class RootToLeafPath{

    public static class Node
    {
        int data;
        Node left, right;

        Node(int item)
        {
            data = item;
            left = right = null;
        }
    }

    public static class BinaryTree
    {
        Node root;

        void printPaths(Node node)
        {
            int path[] = new int[1000];
            print(node, path, 0);
        }

        void print(Node node, int path[], int pathLen)
        {
            // complete this function...
            if(node == null)
                return;

            /* append this node to the path array */
            path[pathLen] = node.data;
            pathLen++;

            /* it's a leaf, so print the path that led to here  */
            if (node.left == null && node.right == null)
                printArray(path, pathLen);
            else
            {
                /* otherwise try both subtrees */
                print(node.left, path, pathLen);
                print(node.right, path, pathLen);
            }
        }

        void printArray(int ints[], int len)
        {
            int i;
            for (i = 0; i < len; i++)
            {
                System.out.print(ints[i] + " ");
            }
            System.out.println("");
        }

    }
    public static void main(String args[])
    {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(10);
        tree.root.left = new Node(8);
        tree.root.right = new Node(2);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(2);

        tree.printPaths(tree.root);
    }
}
