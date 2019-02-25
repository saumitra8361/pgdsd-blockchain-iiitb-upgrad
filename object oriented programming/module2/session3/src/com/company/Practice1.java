package com.company;

public class Practice1 {
    public static void printBackwards(int[] numbers) {
        for(int i=numbers.length-1; i >= 0; i--) {
            System.out.println(numbers[i]);
        }
    }

    public static void main(String[] args){
        int array[] = {1,2,3,4,5};
        printBackwards(array);
    }
}
