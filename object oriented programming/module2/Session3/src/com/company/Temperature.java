package com.company;

import java.util.Scanner;

public class Temperature {
    public static void main(String[] args) {
        System.out.println("Enter temperature in celcius:");
        Scanner i = new Scanner(System.in);
        int c = i.nextInt();
        System.out.println("The temperature in farenheit is: "+ (((9*c)/5)+32));
    }
}
