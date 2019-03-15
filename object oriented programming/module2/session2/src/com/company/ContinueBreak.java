package com.company;

public class ContinueBreak {
    public static void main(String args[]) {
        for (int i = 1; i <= 12; i++) {
            System.out.println(i);

            if(i > 4 && i < 8) {
                continue;
            }
            else if (i == 5) {
                break;
            }
        }
    }
}
