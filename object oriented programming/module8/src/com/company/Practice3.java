package com.company;

import java.util.ArrayList;

public class Practice3 {

    public static void main(String[] args) {
        //Create an ArrayList using Generics here
        ArrayList<Float> random = new ArrayList<Float>();

        random.add((float)2);
        random.add((float)4);
        random.add((float)5);
        random.add((float)10);
        random.add((float)99.9);

        printArray(random);
    }

    public static void printArray(ArrayList<Float> r) {
        //Complete the method declaration here
        for(Float f: r){
            System.out.println(f);
        }
    }
}
