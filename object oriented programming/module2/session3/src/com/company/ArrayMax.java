package com.company;

import java.util.Scanner;
public class ArrayMax
{
   public static void main(String[] args)
   {
       int num;
       Scanner scan = new Scanner(System.in);
       System.out.print("Enter number of elements in the array:");
       num = scan.nextInt();
       int array[] = new int[num];
       System.out.println("Enter elements of array: ");
       for(int index = 0; index < num; index++)
       {
           array[index] = scan.nextInt();
       }
       System.out.println("Max. element is " + max(array)); // You may see that array can be passed into a function by only its name.
       
   }
   
   public static int max(int array[])
   {
       int max = array[0];
       for(int index = 0; index < array.length; index++)  // array.length identifies the length of the array
       {
           if(max < array[index])
           {
               max = array[index];
           }
       }
       return max;
   }
}
