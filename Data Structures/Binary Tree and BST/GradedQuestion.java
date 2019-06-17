import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

class Node7
{
    int value;
    Node7 leftchild, rightchild;

    Node7(int item)
    {
        value = item;
        leftchild = rightchild = null;
    }
}

class BinaryTree1
{
    Node7 root;
    static int preIndex = 0;
    static int index=0;

    Node7 constructTree(int in[], int pre[], int inStrt, int inEnd)
    {
        if (inStrt > inEnd)
            return null;

        Node7 tNode = new Node7(pre[preIndex++]);

        if (inStrt == inEnd)
            return tNode;

        int inIndex = search(in, inStrt, inEnd, tNode.value);

        tNode.leftchild = constructTree(in, pre, inStrt, inIndex - 1);
        tNode.rightchild = constructTree(in, pre, inIndex + 1, inEnd);

        return tNode;
    }

    int search(int arr[], int strt, int end, int value)
    {
        int i;
        for (i = strt; i <= end; i++)
        {
            if (arr[i] == value)
                return i;
        }
        return i;
    }

    int sumBinaryTree(Node7 node)
    {
        // Write the logic to recursively create Binary Tree consisting of sum of all its children
        if(node == null)
            return 0;

        node.value += sumBinaryTree(node.leftchild) + sumBinaryTree(node.rightchild);

        return node.value;
    }

    void printPostorder(Node7 node)
    {
        if (node == null)
            return;

        // first recur on left subtree
        printPostorder(node.leftchild);

        // then recur on right subtree
        printPostorder(node.rightchild);

        // now deal with the node
        System.out.print(node.value + " ");
    }

    void inOrder(Node7 node, int array[])
    {
        if (node == null)
            return;
        inOrder(node.leftchild, array);
        array[index++] = node.value;
        inOrder(node.rightchild, array);

    }

    Node7 ArrayToBST(int arr[], int start, int end) {
        // Write logic to convert the array representing Binary Tree to Binary Search Tree
        if(start > end)
            return null;

        /* Get the middle element and make it root */
        int mid = (start + end) / 2;
        Node7 node = new Node7(arr[mid]);

        /* Recursively construct the left subtree and make it left child of root */
        node.leftchild = ArrayToBST(arr,start,mid-1);

        /* Recursively construct the right subtree and make it right child of root */
        node.rightchild = ArrayToBST(arr,mid+1,end);

        return node;
    }
}
class GradedQuestion{

    // driver program to test above functions
    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int in[] = new int[len];
        int pre[] = new int[len];
        for(int i=0;i<len;i++){
            in[i] = scanner.nextInt();
        }
        for(int i=0;i<len;i++){
            pre[i] = scanner.nextInt();
        }
        BinaryTree1 tree = new BinaryTree1();
        Node7 root = tree.constructTree(in, pre, 0, len - 1);
        tree.sumBinaryTree(root);
        int inSumTree[] = new int[len];
        tree.inOrder(root, inSumTree);
        Arrays.sort(inSumTree);
        Node7 bstRoot = tree.ArrayToBST(inSumTree, 0, len-1);
        tree.printPostorder(bstRoot);

    }
}

