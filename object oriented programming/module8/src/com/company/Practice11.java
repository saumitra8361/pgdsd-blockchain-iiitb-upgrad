package com.company;

import java.util.*;

public class Practice11 {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = s.nextInt();
        thirdMaxInteger(arr);
    }

    // Method to find the third maximum integer in the array
    static void thirdMaxInteger(int[] arr) {
        // Write your code here
        int count=1;

        if(arr.length<3){
            System.out.println("The array doesn't have a third maximum element");
            System.exit(0);
        }

        // Find first largest element
        int first = arr[0];
        for (int i = 1; i < arr.length ; i++) {
            if(arr[i] == first){
                count++;
            }
            if (arr[i] > first)
                first = arr[i];
        }

        if(count == arr.length) {
            System.out.println("The array doesn't have a third maximum element");
            System.exit(0);
        }

        // Find second largest element
        int second = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length ; i++) {
            if (arr[i] > second && arr[i] < first)
                second = arr[i];
        }

        // Find third largest element
        int third = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length ; i++) {
            if (arr[i] > third && arr[i] < second)
                third = arr[i];
        }

        System.out.println(third);
    }
}