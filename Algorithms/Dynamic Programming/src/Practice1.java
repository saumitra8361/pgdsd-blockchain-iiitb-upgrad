/*
* A mathematical series where each element is the sum of the three preceding numbers, is given below:
0, 1, 2, 3, 6, 11, 20, 37, 68, ... n
Print the nth element in this series.
*/

import java.util.Scanner;
public class Practice1 {
    static int fib(int n) {
        int f=0,s=1,t=2,result = 0;
        /* Add the previous three numbers in the series, and store them */
        for (int i=3;i<n;i++){
            result = f+s+t;
            f=s;
            s=t;
            t=result;
        }
        /* Return the nth element in the series */
        return result;
    }

    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);
        // Enter the number n
        int n = scan.nextInt();
        System.out.println(fib(n));
        scan.close();
    }
}
