package com.company;

import java.util.ArrayList;                  //ArrayList library imported

public class Practice1 {
    public static void main(String[] args) {
      //  int random[ ] = {2, 4, 5, 10};
        //Declare and create an object of the ArrayList class named 'random', in place of the line above
        ArrayList random = new ArrayList();

        //Add the first four elements to this 'random' ArrayList

        random.add(2);
        random.add(4);
        random.add(5);
        random.add(10);

        random.add(99);                    //Command for adding a new element
        printArray(random);
    }

    public static void printArray(ArrayList arr) {   //Change the type of the parameter to ArrayList
        for(Object o : arr) {
            //Change the data type of 'a' from 'int' to 'Object'
            int a = (int) o;
            System.out.println(a);
        }
    }
}