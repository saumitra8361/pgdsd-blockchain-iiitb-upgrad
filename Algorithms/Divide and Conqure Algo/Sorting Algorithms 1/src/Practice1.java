/*
Insertion Sort
Description
There is a total of N students in Professor X’s school for mutants. Each student has a first name as well as a last name, maintained separately in two separate database columns. One day, Professor X asks a student named Logan to copy the items of both these columns in two separate arrays and sort them using insertion sort. However, the first names should be in ascending order and the last names in descending order. Logan never used insertion sort on an array of strings, so he’s seeking for help. Write a function that takes an array of strings as input and returns the sorted array as output. Assume that the names can only be in lowercase.

The first and second arrays will store the first names and last names, respectively. So, while providing the input for two persons, the first two entries you provide will be considered first names and the next two entries will be considered last names.

HINT: You can use the compareTo() method to compare two strings lexically.
 */

import java.util.Scanner;

public class Practice1 {

    public static void main(String ss[]) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        String firstNames[] = new String[size];
        String lastNames[] = new String[size];
        for (int i = 0; i < size; i++) {
            firstNames[i] = scanner.next().toLowerCase();
        }
        for (int i = 0; i < size; i++) {
            lastNames[i] = scanner.next().toLowerCase();
        }

        //Write your code here
        sortAscending(firstNames);
        print(firstNames);

        sortDescending(lastNames);
        print(lastNames);
    }

    public static void sortAscending(String arr[])
    {
        int n = arr.length;
        for (int i=1; i<n; ++i)
        {
            int j = i;

            while (j > 0 && ((arr[j-1].compareTo(arr[j])) > 0))
            {
                String temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
                j = j-1;
            }
        }
    }

    public static void sortDescending(String arr[])
    {
        int n = arr.length;
        for (int i=1; i<n; ++i)
        {
            int j = i;

            while (j > 0 && ((arr[j-1].compareTo(arr[j])) < 0))
            {
                String temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
                j = j-1;
            }
        }
    }

    static void print(String arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.println(arr[i]);
    }
}
