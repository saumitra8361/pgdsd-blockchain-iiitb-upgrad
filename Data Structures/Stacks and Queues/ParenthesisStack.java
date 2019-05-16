import java.util.Stack;
import java.util.LinkedList;
import java.util.EmptyStackException;

public class ParenthesisStack {
 /*
   NOTE
   ----
   We implement the parenthesis matching algorithm using a stack.   
 */

    // you could also initialise the stack from the inbuilt class
    // private static Stack<Character> stack = new Stack<Character>();

    private static MyStack<Character> stack = new MyStack<Character>();


    public static void main(String[] args) {
        try {
            System.out.println(match("()"));
            System.out.println(match("((((((()))))))"));
            System.out.println(match("(((((()))))))"));
            System.out.println(match("(((((()))))))"));
            System.out.println(match("(((()(((()))))))"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static boolean match(String parens) throws Exception {
        for (char c : parens.toCharArray()) {
            if (c == '(') {
                stack.push('(');
            } else if (c == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                throw new Exception("Unexpected character " + c);
            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}

class MyStack<T> {
    private LinkedList<T> list = new LinkedList<T>();

    public void push(T e) {
        this.list.add(e);
    }

    public T pop() {
        if (this.list.size() > 0) {
            T e = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            return e;
        }
        throw new EmptyStackException();
    }

    public Boolean isEmpty() {
        return this.list.size() == 0;
    }
}