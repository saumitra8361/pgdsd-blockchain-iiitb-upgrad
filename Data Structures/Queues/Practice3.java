import java.util.LinkedList;
import java.util.Queue;

public class Practice3 {
    public static void main(String arg[]) {
        Queue<Integer> q = new LinkedList<Integer>();

        q.add(3);
        q.add(2);
        q.add(6);
        q.add(4);
        q.add(5);
        int val = q.peek();
        for (int i = 0; i < q.size(); i++) {
            int del = q.remove();
            if (val < del) {
                val = del;
            }
            q.add(del);
        }
        System.out.println(val);
    }
}
