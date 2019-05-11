/*
* Write a program in Java that can return an array in descending order of elements using insertion sort.
The program will take the size of the array and the elements of the array as inputs.
* */

import java.util.Scanner;

public class InsertionSortDescending {

    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        int[] array = new int[size];
        int i=0;
        while(input.hasNextInt() && i<size){
            array[i] = input.nextInt();
            i++;
        }
        input.close();
        sort(array);
        print(array);
    }

    public static void sort(int arr[])
    {
        int n = arr.length;
        for (int i=1; i<n; ++i)
        {
            int j = i;

            while (j > 0 && arr[j-1] < arr[j])
            {
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
                j = j-1;
            }
        }
    }

    static void print(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.println(arr[i]);
    }
}

