/*
* The array of integers have the following properties:
    1. The array is sorted is an ascending order
    2. The array holds distinct integers (i.e. there are no repeating numbers)
    3. The array is 1-indexed, i.e. the first element is stored in A[1] (not A[0])

However the length of the array, N, is unknown (i.e. you don’t know how long the array is and arrayName.length is not available to you). In short, you can not use the length of the array to apply binary search.
Since the length of the array is unknown, an error “ArrayIndexOutOfBoundsException” is returned if you try to index into the array with an integer greater than N.

Find a function to find positive integer M in the array A and write a program to find M (if M exists) in O(log N) time.
    1. If M exists, please print the index of M using System.out.println().
    2. If M does not exist, please print the String "NOT_FOUND" using System.out.println().
* */

import java.util.Scanner;

public class SolutionB {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int key = scanner.nextInt();
        int[] array = new int[size+1];
        int i=1;

        while(i<size+1 && scanner.hasNext()) {
            array[i] = scanner.nextInt();
            i++;
        }

        SolutionB object = new SolutionB();
        object.Search(array, key, size);
    }

    public void Search(int[] inputArr, int key, int size) {

        int start = 1;
        int end = size;
        boolean success = false;
        int index = 0;
        try {
            while (start <= end) {
                int mid = start + ((end - start) / 2);
                if (key == inputArr[mid]) {
                    success = true;
                    index = mid;
                    break;
                }
                if (key < inputArr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("The index you have entered is invalid");
        }

        if(success == true)
            System.out.println(index);
        else
            System.out.println("NOT_FOUND");
    }
}

