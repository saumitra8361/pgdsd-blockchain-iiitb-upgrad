import java.util.*;

public class FindDuplicateParanthesis {

    private static Stack<Character> stack = new Stack<Character>();

    public static String findDuplicateParenthesis(String inputString) {
        //write your code here
        String result = null;
        int count=0;
        for(int i=0;i<inputString.length();i++) {
            char ch = inputString.charAt(i);
            if ( ch != ')'){
                stack.push(inputString.charAt(i));
            } else {
                char top = stack.peek();
                stack.pop();
                count=0;
                while(top != '('){
                    top = stack.peek();
                    stack.pop();
                    count++;
                }
               // System.out.println("count: "+count);
                if (count<=1){
                    return "Input string contains duplicate parenthesis";
                }
            }
//            System.out.println("stack: "+stack);
        }
        return "Input string does not contain duplicate parenthesis";
    }


    public static void main(String[] args){
        FindDuplicateParanthesis obj = new FindDuplicateParanthesis();
        String inputString = new String();
        Scanner in = new Scanner(System.in);
        inputString = in.nextLine();
        System.out.println(obj.findDuplicateParenthesis(inputString));
    }

}


