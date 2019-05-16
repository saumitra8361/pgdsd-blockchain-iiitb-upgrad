package com.company;

import java.util.List;
import java.util.ArrayList;
import java.util.ListIterator;

public class Practice7 {

    public static void main(String[] args) {
        List<Float> random = new ArrayList<Float>();
        random.add(2f);
        random.add(4f);
        random.add(5f);
        random.add(10f);
        random.add(99.9f);
        random.add(101f);

        printList(random);
    }

    public static void printList(List<Float> arr) {
        ListIterator<Float> l = arr.listIterator(arr.size());
        while(l.hasPrevious()){
            System.out.println(l.previous());
        }
    }
}
