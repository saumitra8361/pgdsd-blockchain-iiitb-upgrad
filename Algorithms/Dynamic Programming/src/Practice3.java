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

        while (remDist > 1) {
            if((remDist<3 && remDist>0) || (((remDist-1)%3)==0) || (((remDist-1)%2)==0)){
                jumpCount++;
                remDist = remDist-1;
            }
            if(remDist%3 == 0 && remDist>0){
                jumpCount++;
                remDist = remDist/3;
            }
            if(remDist%2 == 0 && remDist>0){
                jumpCount++;
                remDist = remDist/2;
            }
        }
        if (jumpCount<f[n]){
            f[n] = jumpCount;
        }

        return f[n];
    }

    public static void main (String args[])
    {
        Scanner scan = new Scanner(System.in);
        int distance = scan.nextInt();
        System.out.println(minJump(distance));

    }
}
