package com.company;

import java.util.ArrayList;

public class Practice3 {

    public static void main(String[] args) {
        //Create an ArrayList using Generics here
        ArrayList<Integer> random = new ArrayList<Integer>();

        random.add(2);
        random.add(4);
        random.add(5);
        random.add(10);
        random.add(99);

        printArray(random);
    }

    public static void printArray(ArrayList<Integer> r) {
        //Complete the method declaration here
        r.add(2,11);
        r.remove(1);
        System.out.println(r.get(3));
        for(Integer f: r){
            System.out.println(f);
        }
    }
}
