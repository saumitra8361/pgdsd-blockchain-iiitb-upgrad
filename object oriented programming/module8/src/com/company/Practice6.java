package com.company;

import java.util.ArrayList;

public class Practice6 {

    public static void main(String[] args) {
        ArrayList<Float> random = new ArrayList<Float>();
        random.add(2f);
        random.add(4f);
        random.add(5f);
        random.add(10f);
        random.add(99.9f);

        //Write new statements here
        if(random.contains(10f)){
            random.remove(10f);
            random.add(3,15f);
        }

        printList(random);
    }

    public static void printList(ArrayList<Float> arr) {
        for(Float num : arr) {
            System.out.println(num);
        }
    }
}
