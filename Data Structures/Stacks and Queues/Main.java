import java.util.Stack;

public class Main {

    public static void main(String arg[]) {
        Stack<Integer> s = new Stack<Integer>();
        System.out.println(s.empty());
        s.push(11);
        s.push(22);
        s.push(33);
        s.push(44);
        s.push(55);
        System.out.println(s);
        System.out.println(s.search(22));
        System.out.println(s.search(6));
        System.out.println(s.pop());
        System.out.println(s);
    }
}
