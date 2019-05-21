/*
* You are given a stack with n integers.
* You need to sort the elements of the stack in ascending order such that the minimum value is at the bottom-most
* position of the stack.
* The expected input is the the number of elements and the elements of the stack,
* you need to print the elements in the stack after they are sorted in ascending order.
*/

import java.util.*;

public class Practice5 {
    public static void main(String args[]) {
        Stack<Integer> stack = new Stack<>();
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        while (n-- > 0)
            stack.push(s.nextInt());
        sort(stack);
    }

    // Method to sort the elements of the stack in ascending order
    static void sort(Stack<Integer> stack) {
        // Write your code here
        int size = stack.size();
        int[] array = new int[size];
        int i=0;
        while (!stack.empty()){
            array[i] = stack.pop();
            i++;
        }

        Arrays.sort(array);

        for(int j=0;j<size;j++){
            stack.push(array[j]);
        }
        System.out.println(stack);
    }
}
