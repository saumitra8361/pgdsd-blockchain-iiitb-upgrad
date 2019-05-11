package com.company;

import java.util.Scanner;
public class Sequence1 {

    public int fibonacci(int n) {
        if (n < 2)
            return n;
        else
            return (fibonacci(n - 1) + fibonacci(n - 2))%10;
    }

    public static void main(String args[]) {
        System.out.println("Enter the fibonacci number to be generated : ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Sequence1 sequence = new Sequence1();
        int number = sequence.fibonacci(n);
        System.out.println("Fibonacci number:  " + number);
    }
}
