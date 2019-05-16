/*
* The array of integers has the following properties:
    1. With a known length N
    2. The array is sorted in an ascending order
    3. The array holds distinct integers (i.e. there are no repeating numbers)
    4. The array is 1-indexed, i.e. the first element is stored in A[1] (not A[0])

Find the first positive integer M (where 1 <= M <= N) such that when M is used as the array index, the result from the array is the the integer M itself. i.e. A[M] = M
In other words, find the first positive integer M where M is both a user’s ID and its index in the array of user ids.
Write a program to find M, if it exists, in O(log N) time. If M does not exist, please return NOT_FOUND

Please note that the code takes two inputs:
    1. First one being the size of the array
    2. Second one being the elements inside the array

So, to input an array having 5 elements, the first input will be 5 and the next 5 inputs will be the elements of the array.
* */

import java.util.Scanner;

public class SolutionA {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] array = new int[size+1];
        int i=1;

        while(i<size+1 && scanner.hasNext()) {
            array[i] = scanner.nextInt();
            i++;
        }

        SolutionA object = new SolutionA();
        object.Search(array);
    }

    public void Search(int[] inputArr) {

        int start = 1;
        int end = inputArr.length - 1;
        boolean success = false;
        int keyValue = 0;
        while (start <= end) {
            int mid = start + ((end - start) / 2);
            if (mid == inputArr[mid]) {
                success = true;
                keyValue = mid;
                break;
            }
            if (mid < inputArr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        if(success == true)
            System.out.println(keyValue);
        else
            System.out.println("NOT_FOUND");
    }
}
