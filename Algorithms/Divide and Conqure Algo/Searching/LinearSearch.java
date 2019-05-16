package com.company;

public class LinearSearch {

    public static int linearSearch(int[] arr, int key) {

        int size = arr.length;
        for (int i = 0; i < size; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        //This is the default value if the key is not found in the array.
        return -1;
    }

    public static void main(String a[]) {

        int[] arr1 = {23, 45, 21, 55, 234, 1, 34, 90};
        int searchKey = 34;
        System.out.println("Key " + searchKey + " found at index: " + linearSearch(arr1, searchKey));
        int[] arr2 = {123, 445, 421, 595, 2134, 41, 304, 190};
        searchKey = 421;
        System.out.println("Key " + searchKey + " found at index: " + linearSearch(arr2, searchKey));
    }
}
