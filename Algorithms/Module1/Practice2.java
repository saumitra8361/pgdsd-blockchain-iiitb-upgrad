package com.company;

import java.util.Scanner;

public class Practice2 {
    // function to calculate base^exponent
    // function to print the required pattern
    public static String func(int n) {
        //write your code here
        int temp = n;
        String str="";

        if(n>0) {
            func(n-1);

            while(temp>0){
                //System.out.print("*");
                str += "*";
                temp--;
            }
            //System.out.println("");
            str += "\n";
        }
        return str;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.print(func(n));
    }

}


