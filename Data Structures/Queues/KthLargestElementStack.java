/*
* Find kth largest element
Description
Write a code to find the kth largest number of the given sequence in a stack. Your program should take the following lines of input:
The number of elements in the input stack.
The elements in the input stack.
The value of ‘k’.
Note:
If the input stack is empty, your program should print “ the stack is empty”.
If the value of ‘k’ is greater than the number of elements in the input stack, then print “ invalid input”
Sample Input:

6

4 2 0 9 6 1

4  // k=4, therefore, the 4th largest element has to be found
*/
import java.util.*;

public class KthLargestElementStack {
    // This function returns the sorted stack
    public static Stack < Integer > sortStack(Stack < Integer > input) {
        //write your code here
        Stack<Integer> tempStack = new Stack<Integer>();
        int tempVar=0;
        while(!input.isEmpty()){
            tempVar = input.pop();
            while(!tempStack.isEmpty() && tempVar > tempStack.peek()){
                input.push(tempStack.pop());
            }
            tempStack.push(tempVar);
        }
        return tempStack;
    }

    public static void findKthLargestNum(Stack <Integer> sortedStack, int k) {
        //write your code here
        int counter=0,result=0;
        Iterator value = sortedStack.iterator();
        while(value.hasNext() && counter<k){
            result = (int) value.next();
            counter++;
        }
        System.out.println(result);
    }


    public static void main(String args[]) {
        Stack < Integer > inputStack = new Stack < Integer > ();
        Scanner in = new Scanner(System.in);
        int n = in .nextInt();
        for (int i = 0; i < n; i++) {
            inputStack.add( in .nextInt());
        }

        if (inputStack.isEmpty()) {
            System.out.println("stack is empty");
            System.exit(0);
        }

        int k = in .nextInt();
        if (k > inputStack.size()) {
            System.out.println("invalid input");
            System.exit(0);
        }

        // This is the temporary stack

        Stack < Integer > temp = sortStack(inputStack);
        findKthLargestNum(temp, k);

    }
}

