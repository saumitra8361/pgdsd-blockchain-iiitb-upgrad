/*
* Write a program in Java that takes an array of strings as input and returns the sorted array. 4
* Assume that the sorting needs to be done based on the size of each string.
* So, a string with fewer characters should come before another string with more number of characters.
* Use the quicksort algorithm for the program.
*/

import java.util.Scanner;

public class Practice1 {

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        String[] array = new String[size];
        int i=0;

        while(i<array.length && input.hasNext()) {
            array[i] = input.next();
            i++;
        }

        quickSort(array,0,array.length-1);
        printArray(array);

    }

    public static void quickSort(String array[], int left, int right) {
        if (left < right) {
            int position = partition(array, left, right);
            quickSort(array, left, position - 1);
            quickSort(array, position + 1, right);
        }

    }

    public static int partition(String array[], int left, int right) {
        String pivot = array[right];
        int p = left;
        for(int i=left; i<right; i++){
            if (array[i].length() <= pivot.length()){
                String temp = array[i];
                array[i] = array[p];
                array[p] = temp;
                p++;
            }
        }
        String temp2 = array[right];
        array[right] = array[p];
        array[p]= temp2;

        return p;
    }

    static void printArray(String arr[])
    {
        for(String element: arr){
            System.out.println(element);
        }
    }
}