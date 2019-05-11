package com.company;

import java.util.Scanner;

public class LinearSearchReverse{
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int count = input.nextInt();
        int array[] = new int[count];
        for (int i = 0; i < count; i++) {
            array[i] = input.nextInt();
        }
        int key = input.nextInt();
        input.close();
        //write your code here
        System.out.println(linearSearchReverse(array, key));
    }

    private static int linearSearchReverse(int[] array, int key) {
        int size = array.length, count = 0;
        for (int i = size-1; i >= 0; i--) {
            count++;
            if (array[i] == key) {
                return count;
            }
        }
        //This is the default value if the key is not found in the array.
        return 0;
    }
}

