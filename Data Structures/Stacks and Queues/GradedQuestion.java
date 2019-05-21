/*
* You are given a stack with n integers.
* You need to delete floor(n/2) elements from the bottom of the stack and print the remaining elements of the stack.
* The remaining elements should be printed in the order that they are inserted into the stack.
*
* floor(3.5) will give the output as 3, greatest integer less than or equal to the input.
*/

import java.util.*;

public class GradedQuestion {
    public static void main(String args[]) {
        Stack<Integer> stack = new Stack<>();
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        while (n-- > 0)
            stack.push(s.nextInt());
        deleteFirstHalf(stack);
    }

    // Method to delete the first half of the elements from the bottom of the stackand print the remaining elements
    static void deleteFirstHalf(Stack<Integer> stack) {
        // Write your code here
        int size = stack.size();
        int deleteSize = size/2, remainingSize = size-deleteSize;
        int[] array = new int[remainingSize];
        for(int i=0;i<remainingSize;i++){
            array[i] = stack.pop();
        }

        for (int j=0; j<deleteSize; j++){
            stack.pop();
        }

        for(int k=remainingSize-1; k>=0; k--){
            stack.push(array[k]);
        }
        System.out.println(stack);
    }
}
