/*
* You are given a stack with n integers.
* You need to reverse the last half of the elements i.e.
* floor(n/2) elements from the bottom of the stack using recursion and print the elements of the stack.
* */

import java.util.*;

public class Practice4 {
    public static void main(String args[]) {
        Stack<Integer> stack = new Stack<>();
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        while (n-- > 0)
            stack.push(s.nextInt());
        reverseSecondHalf(stack);
    }

    // Method to reverse the last half of the elements from the bottom of the stack
    static void reverseSecondHalf(Stack<Integer> stack) {
        // Write your code here
        int size = stack.size();
        int i=0;
        Integer[] array = new Integer[size/2];
        while(i<size/2){
            array[i] = stack.pop();
            i++;
        }
        for (int x: array) {
            stack.push(x);
        }

        System.out.println("After reverse stack: "+stack);
    }
}