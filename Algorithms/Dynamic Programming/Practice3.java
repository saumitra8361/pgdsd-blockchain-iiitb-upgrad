/*
* Problem Statement:
Write a code that gives an output of the minimum number of jumps needed to reach the destination provided.
*/

import java.util.Scanner;

public class Practice3 {
    public static int minJump(int n)
    {
        int f[] = new int[n+1];
        int remDist = n, jumpCount=0;
        /* Declare an array to store the minimum jumps. */
        /* Initialise the base condition */
        f[0] = 0;
        f[1] = 0;

        /* Fill in the array to find Minimum Jumps from a certain distance */
        for (int j=2; j<=n; j++){
            f[j] = j-1;
        }

       // for (int j = 0; j < 3; j++) {
            for (int i = 2; i <= n; i++) {

                if(i%3==0 && f[i%3]+1<f[i]){
                    f[i] = f[i%3]+1;
                }
                if(i%2==0 && f[i%2]+1<f[i]){
                    f[i] = f[i%2]+1;
                }
            }
       // }

        for (int i: f) {
            System.out.print(i+" ");
        }

        return f[n];
    }

    public static void main (String args[])
    {
        Scanner scan = new Scanner(System.in);
        int distance = scan.nextInt();
        System.out.println("\n"+minJump(distance));

    }
}
