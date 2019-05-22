import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Practice8 {
    static Queue<Integer> q = new LinkedList<Integer>();

    public static void func() {
        //write your code here
        Stack<Integer> s = new Stack<Integer>();
        int size = q.size();

        for(int i=0; i<size; i++){
            s.push(q.remove());
        }

        for(int j=0; j<size; j++){
            q.add(s.pop());
        }
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

