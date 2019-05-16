package com.company;

public class ModOperation {
    public static void main(String[] args){
        int num = 23456;
        int remainder;
        int val,i=1;

        while (num%10 > 0) {
            remainder = num%10;
            val = remainder;
            num = (num - remainder)/10;
            val = val*i;
            System.out.println(val);
            i=i*10;
        }
    }
}
