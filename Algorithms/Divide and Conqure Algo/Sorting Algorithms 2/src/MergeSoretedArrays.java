/*
Write a function that merges two sorted arrays in descending order, where the number of the elements is between 1 and 100,000 (0 < array size <= 100000).

This code will take the following inputs in the sequence mentioned here:

    The size of the first sorted array.
    The size of the second sorted array.
    Elements of the first sorted array.
    Elements of the second sorted array.
*/

import java.util.Scanner;
public class MergeSoretedArrays {

    public static void main(String ss[]) {
        Scanner scanner = new Scanner(System.in);
        int sizeArray1 = scanner.nextInt();
        int sizeArray2 = scanner.nextInt();
        int sortedArray1[] = getArrayInput(sizeArray1, scanner);
        int sortedArray2[] = getArrayInput(sizeArray2, scanner);

        int descendingMerge[]=mergeBothInDescendingOrder(sortedArray1, sortedArray2);

        //Write your code here
        printArray(descendingMerge);
    }

    private static int[] mergeBothInDescendingOrder(int[] sortedArray1, int[] sortedArray2) {
        int size1 = sortedArray1.length;
        int size2 = sortedArray2.length;
        int mergerdArray[] = new int[size1+size2];
        int k = 0;
        int i = size1-1;
        int j = size2-1;

        while (i>=0 && j>=0){
            if (sortedArray2[j] <= sortedArray1[i]) {
                mergerdArray[k] = sortedArray1[i];
                k++;
                i--;
            } else {
                mergerdArray[k] = sortedArray2[j];
                k++;
                j--;
            }
        }

        // Copy the remaining elements on sortedArray1 , if there are any
        while (i>=0) {
            mergerdArray[k] = sortedArray1[i];
            k++;
            i--;
        }

        // Copy the remaining elements on sortedArray2 , if there are any
        while (j>=0) {
            mergerdArray[k] = sortedArray2[j];
            k++;
            j--;
        }

        return mergerdArray;
    }

    private static int[] getArrayInput(int size, Scanner scanner) {
        int[] array = new int[size];
        int i=0;
        /*
        for(int i=0; i<size; i++){
            array[i] = scanner.nextInt();
        } */
        while(i<size && scanner.hasNext()) {
            array[i] = scanner.nextInt();
            i++;
        }
        return array;
    }

    public static void printArray(int array[]){
        for(int element: array){
            System.out.println(element);
        }

    }

}