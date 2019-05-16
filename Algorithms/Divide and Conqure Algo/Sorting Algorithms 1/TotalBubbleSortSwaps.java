/*
* Write a bubble sort program that prints the number of swaps made after M number of iterations. In this case, ‘M’ should be an input value. For example, if M = 0, the bubble sort program will perform 0 comparisons in 0 iterations. In bubble sort, an iteration is defined as the total number of times the outer loop runs. Assume that: 1) M <= the array size and 2) the program sorts in descending order. The code should ask the user to input the values for M, the array size, and finally the elements of the array.
So, there will be three types of inputs —

Input 1: The value of M
Input 2: The size of the array
Input 3: The elements inside the array
* */

import java.util.Scanner;

public class TotalBubbleSortSwaps {

    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int M = input.nextInt();
        int size = input.nextInt();
        if(M<=size){
            int[] arr = new int[size];
            int i=0;
            while (input.hasNextInt() && i<size)
            {
                // Read input values for array
                arr[i] = input.nextInt();
                i++;
            }
            input.close();
            System.out.println("Total number of Swaps for "+ M + " iterations: " +totalBubbleSortSwaps(arr,M));
        }
    }

    static int totalBubbleSortSwaps(int[] array, int M) {
        int size = array.length;
        int var = 0, temp = 0;
        int totalSwaps = 0;
        //Write your code here
        for (int i = 0; i < size; i++) {
            if(var == M){
                break;
            }
            for (int j = 1; j < (size - i); j++) {
                if (array[j - 1] < array[j]) {
                    //swap elements
                    temp = array[j-1];
                    array[j-1] = array[j];
                    array[j] = temp;
                    totalSwaps++;
                }
            }
            var++;
        }
        return totalSwaps;
    }
}

