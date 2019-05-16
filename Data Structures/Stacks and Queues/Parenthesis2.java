public class Parenthesis2 {
    public static void main(String[] args) {
        try {
            System.out.println(match("(()")); // not balanced
            System.out.println(match("{{}}")); //balanced
            System.out.println(match("(){}")); //balanced
            System.out.println(match("(({}())")); // not balanced
            System.out.println(match("{{()}}")); // balanced
            System.out.println(match("{{(})}")); // Incorrect/not balanced, but identified as correct by the algorithm below
        } catch (Exception e) {
            // catch the exception thrown by the method match() in try block;
            // e.getMessage() will get the exception message
            System.out.println(e.getMessage());
        }
    }

    public static boolean match(String parens) throws Exception {
        int count1 = 0, count2 = 0;
        char[] chars = parens.toCharArray();
        for (char c : chars) {
            if (c == '(') {
                count1++;
            } else if (c == ')') {
                if (count1 > 0) {
                    count1--;
                } else if (c == '{') {
                    count2++;
                } else if (c == '}') {
                    if (count2 > 0) {
                        count2--;
                    } else {
                        return false;
                    }
                } else {
                    throw new Exception("Invalid character " + c);
                }
            }
        }

        if (count1 == 0 && count2 == 0) {
            return true;
        } else {
            return false;
        }
    }
}

