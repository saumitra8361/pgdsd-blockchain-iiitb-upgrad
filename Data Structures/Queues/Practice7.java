/*
* You are given a queue. Your aim is to find the maximum element of the queue and move that element to the end of the queue.
*
* Example: if the queue contains [3, 5, 2, 6, 4] then you have to find out the max value in the queue which is ‘6’
* in this case and move that to the end of the queue. After making the required changes the queue should look like [3, 5, 2, 4, 6].
*
* Note: The queue in the below program is named as ‘q’
*/

import java.util.*;

public class Practice7 {
    static Queue<Integer> q = new LinkedList<Integer>();

    public static void func() {
        //write your code here
        Iterator value = q.iterator();

        int max = q.peek();
        int tempVal = 0;
        int size = q.size();

        while(value.hasNext()){
            tempVal = (int) value.next();
            if(tempVal > max){
                max = tempVal;
            }
        }

        for (int i = 0; i < size; i++){
            if(q.peek() != max)
                q.add(q.remove());
            else
                q.remove();
        }
        q.add(max);
    }

    public static void main(String arg[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        for (int j = 0; j < n; j++) {
            q.add(in.nextInt());
        }
        func();
        System.out.println(q);
    }
}
