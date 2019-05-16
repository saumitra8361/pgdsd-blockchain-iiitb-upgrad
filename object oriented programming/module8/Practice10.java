package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Practice10 {
    public static void main(String[] args){
        List<Integer> random = new ArrayList<Integer>();
        random.add(1);
        random.add(2);

        iterate(random);
    }
    public static void iterate(List<Integer> num) {
        ListIterator<Integer> it = num.listIterator();
        while(it.hasNext()) {
            System.out.print(it.next());
            it.previous();
        }
    }
}
