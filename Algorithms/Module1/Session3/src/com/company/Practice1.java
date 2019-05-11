package com.company;

public class Practice1 {
    void function(String st) {
        if ((st == null) || (st.length() <= 1))
            System.out.println(st);
        else {
            System.out.print(st.charAt(st.length() - 1));
            function(st.substring(0, st.length() - 1));
        }
    }

    public static void main(String[] args) {
        String st = "abc d efg";
        System.out.println(st.substring(0, st.length() - 1));
        Practice1 obj = new Practice1();
        obj.function(st);
    }
}