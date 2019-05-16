package com.company;

import java.util.ArrayList;

public class Practice5 {
    public static void main(String [] args){
        ArrayList<Float> random = new ArrayList<Float>();
        random.add(2f);
        random.add(4f);
        random.add(5f);
        random.add(10f);
        random.add(99.9f);

        System.out.println(random.contains(5f));
    }

}
