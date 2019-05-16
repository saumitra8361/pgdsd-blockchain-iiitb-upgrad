/* You are given a string and you have to print the reverse of the string using a stack. */

import java.util.Scanner;
import java.util.Stack;

public class Practice1 {
    public static void main(String arg[]) {
        Stack<String> s = new Stack<>();
        String word = "";
        Scanner in = new Scanner(System.in);
        String data = in.nextLine();
        //write your code here
        String[] result = data.split("");
        for(String w:result){
            s.push(w);
        }

        while(!s.empty()){
            word += s.pop();
        }
        System.out.println(word);
    }
}
