/*
* You are given a queue with n integers and you need to print the fifth element from the tail of the queue.
* */

import java.util.*;

public class Practice2 {
    public static void main(String args[]) {
        Queue<Integer> queue = new LinkedList<Integer>();
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        while (n-- > 0)
            queue.add(s.nextInt());
        printFifthElementFromEnd(queue);
    }

    // Method to print the fifth element from the head of the queue
    static void printFifthElementFromEnd(Queue<Integer> queue) {
        // Write your code here
        int count=1,element=0;
        int size = queue.size();
        Iterator value = queue.iterator();

        if(size < 5){
            System.out.println("There are not enough elements in the queue");
        } else {
            while (value.hasNext()) {
                element = (int) value.next();
                if(count==size-4){
                    System.out.println(element);
                    break;
                }
                count++;
            }
        }
    }
}