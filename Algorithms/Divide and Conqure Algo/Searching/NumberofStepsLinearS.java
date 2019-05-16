/*
Write a code that returns the number of unsuccessful attempts made to search for an element in the array using linear search.
*/
package com.company;

import java.util.Scanner;

public class NumberofStepsLinearS {

    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        int array[] = new int[size];
        for(int i=0; i<size; i++){
            array[i] = input.nextInt();
        }
        int key = input.nextInt();
        input.close();
        NumberofStepsLinearS obj = new NumberofStepsLinearS();
        System.out.println(obj.getLinearSearchUnsuccessfulComparisonCount(array,key));
    }

    public int getLinearSearchUnsuccessfulComparisonCount(int[] inputArr, int key) {
        // Write your code here
        int length = inputArr.length, count = 0;
        for(int i=0;i<length;i++){
            if(key == inputArr[i]){
                return count;
            }
            count++;
        }
        return count;
    }
}

