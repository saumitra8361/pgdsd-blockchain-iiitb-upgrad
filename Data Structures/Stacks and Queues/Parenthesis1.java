public class Parenthesis1 {
    /*
      NOTE
      ----
    */
    public static void main(String[] args) {
        try {
            System.out.println(match("()"));
            System.out.println(match("((((((()))))))"));
            System.out.println(match("(((((()))))))"));
            System.out.println(match("(((((()))))))"));
            System.out.println(match("(((()(((()))))))"));
        } catch (Exception e) {
            // catch the exception thrown by the method match() in try block;
            // e.getMessage() will get the exception message
            System.out.println(e.getMessage());
        }
    }

    public static boolean match(String parens) throws Exception {
        int count = 0;
        char[] chars = parens.toCharArray();
        for (char c : chars) {
            if (c == '(') {
                count++;
            } else if (c == ')') {
                if (count > 0) {
                    count--;
                } else {
                    return false;
                }
            } else {
                throw new Exception("Invalid character " + c);
            }
        }
        if (count == 0) {
            return true;
        } else {
            return false;
        }
    }
}
