import java.util.*;
public class QueuePalindromeString {

    Queue < Character > q = new LinkedList < Character > ();

    public void checkPalindrome(String input) {
        //Write your code here
        int size = input.length();
        int index = 0;
        boolean check = true;
        for(int i=0; i<size/2; i++){
            queueAdd(input.charAt(i));
        }
        if(size%2 != 0)
            index = size/2 + 1;
        else
            index = size/2;

        for(int j=0; j<size/2; j++){
            if(input.charAt(index+j) == q.remove())
                check = true;
            else
                check = false;
        }
        if(check == true)
            System.out.println("The given input is a palindrome");
        else
            System.out.println("The given input is not a palindrome");
    }

    private void queueAdd(char c) {
        q.add(c);
        for(int i=0; i<q.size()-1; i++){
            q.add(q.remove());
        }
    }

    public static void main(String[] args) {
        QueuePalindromeString obj = new QueuePalindromeString();
        Scanner in = new Scanner(System.in);
        String inputString = in .nextLine();
        obj.checkPalindrome(inputString);

    }
}


