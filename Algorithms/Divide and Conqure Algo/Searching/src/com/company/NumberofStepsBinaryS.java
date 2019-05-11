/*
Write a code that returns the number of unsuccessful attempts made to search for an element in the array using binary search.
*/
package com.company;

import java.util.*;

public class NumberofStepsBinaryS {

    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        int array[] = new int[size];
        for(int i=0; i<size; i++){
            array[i] = input.nextInt();
        }
        int key = input.nextInt();
        input.close();
        NumberofStepsBinaryS obj = new NumberofStepsBinaryS();
        System.out.println(obj.getBinarySearchUnsuccessfulComparisonCount(array,key));
    }

    public int getBinarySearchUnsuccessfulComparisonCount(int[] inputArr, int key) {
        // Write your code here
        int end = inputArr.length - 1, count = 0, start = 0;
        while(start<=end){
            int mid = start + ((end - start)/2);
            if(inputArr[mid] == key){
                return count;
            } else if(inputArr[mid] < key){
                start = mid+1;
                count++;
            } else {
                end = mid-1;
                count++;
            }
        }
        return count;
    }
}
