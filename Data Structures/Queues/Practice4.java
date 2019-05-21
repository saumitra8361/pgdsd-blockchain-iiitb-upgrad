import java.util.*;

import static java.lang.System.exit;

public class Practice4 {

    /*implementing queue using linked list */
    Queue < Integer > q = new LinkedList < Integer > ();

    /* Push operation of stack using queue*/
    void push(int x) {
        //write your code here
        q.add(x);

        for(int i=0; i<q.size()-1; i++){
            q.add(q.remove());
        }
    }

    /*Removes the top element of the stack*/

    int pop() {
        //write your code here
        if(q.isEmpty()){
            System.out.println("Stack is empty");
            return -1;
        }
        return q.remove();
    }


    /*Returns the element at the top of the stack */
    int top() {
        //write your code here
        if(q.isEmpty()){
            System.out.println("Stack is empty");
            exit(0);
        }
        return q.peek();
    }


    public static void main(String[] args) {
        Practice4 obj = new Practice4();
        Scanner in = new Scanner(System.in);

        /*Enter the number of elements you want to add in the stack */
        int n = in.nextInt();
        if(n==0){
            System.out.println("Stack is empty");
            exit(0);
        }

        /*Enter the elements of the stack */
        for (int i = 0; i < n; i++) {
            obj.push( in .nextInt());
        }

        System.out.println(obj.top());
        obj.pop();
        System.out.println(obj.top());
    }
}
