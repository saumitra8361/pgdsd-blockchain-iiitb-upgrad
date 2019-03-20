package com.company;

import java.util.ArrayList;

public class Practice2 {
    public static void main(String[] args) {
        ArrayList mix = new ArrayList();
        mix.add("Hari");
        mix.add(2);
        printMixList(mix);
    }

    public static void printMixList(ArrayList elements) {
        for(Object o : elements) {
            System.out.println(o);
        }
    }
}
