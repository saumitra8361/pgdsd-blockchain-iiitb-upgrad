import java.util.*;

public class SortQueue {
    public static void main(String args[]) {
        Queue<Integer> queue = new LinkedList<Integer>();
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        while (n-- > 0)
            queue.add(s.nextInt());
        sort(queue);
    }

    // Method to sort the queue
    static void sort(Queue<Integer> queue) {
        // Write your code here
        Queue<Integer> tempQueue = new LinkedList<Integer>();
        int tempVar=0;
        while(!queue.isEmpty()){
            Iterator value = tempQueue.iterator();
            tempVar = queue.remove();
            System.out.println("tempVar: "+tempVar);
            while(!tempQueue.isEmpty() && value.hasNext()){
                if((int) value.next() > tempVar){
                    //int v = tempQueue.remove();
                    //System.out.println("v: "+v);
                    queue.add(tempQueue.remove());
                } else
                    tempQueue.add(tempQueue.remove());
            }
            tempQueue.add(tempVar);
            System.out.println("TempQueue: "+tempQueue);
        }
        System.out.println(tempQueue);
    }
}
