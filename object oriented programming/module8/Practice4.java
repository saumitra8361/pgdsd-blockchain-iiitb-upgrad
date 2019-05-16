package com.company;

import java.util.*;

public class Practice4 {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        int n = s.nextInt();
        for (int i = 0; i < n; i++)
            list.add(s.nextInt());
        reverseArrayList(list);
        for (int i = 0; i < list.size(); i++)
            System.out.print(list.get(i) + " ");
    }

    // Method to reverse the ArrayList
    static void reverseArrayList(ArrayList<Integer> list) {
        // Write your code here
        for(int i = 0; i < list.size() / 2; i++){
            Integer temp = list.get(i);
            list.set(i, list.get(list.size()-i-1));
            list.set((list.size()-i-1), temp);
        }
    }
}