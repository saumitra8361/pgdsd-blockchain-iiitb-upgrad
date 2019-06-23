/*
Suppose that you are given an array.
Write a program to decipher whether the array is a representation of a binary max-heap or not.
*/

import java.util.Arrays;
import java.io.*;
import java.util.*;
import java.util.Scanner;

class ArrayMaxHeap{
    public static boolean  isHeap(int[] arr,  int n){
        //Write your code here
        //Check if the array element is less than it's child element in the array,
        //and if they are less return false else return true
        boolean flag = false;
        for(int i=1; i<n; i++){
            if((arr[i]>=arr[2*i])){
                if(2*i < n)
                    return flag;
                flag = true;
            } else {
                flag = false;
                break;
            }

            if((arr[i]>=arr[2*i+1])){
                if((2*i + 1) < n)
                    return flag;
                flag = true;
            } else {
                flag = false;
                break;
            }
        }
        return flag;
    }
    public static int[] getArrayInput(int size, Scanner scanner) {
        int array[] = new int[size+1];
        for (int i = 1; i <= size; i++) {
            array[i] = scanner.nextInt();
        }
        return array;
    }

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sizeArray1 = scanner.nextInt();
        int arr[] = getArrayInput(sizeArray1, scanner);
        int n = arr.length;
        String x = isHeap(arr, n)? "Yes": "No";

        System.out.println(x);
    }

}
