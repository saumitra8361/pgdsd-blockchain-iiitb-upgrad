package com.company;

import java.util.Scanner;

public class IncomeTaxCalculator {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        //Enter Income
        double income = in.nextDouble();
        //Enter Age
        int age = in.nextInt();
        double tax,slabIncome;
        char token;

        if(age<60){
            token = 'A';
        }else if((60<=age) && (age<80)){
            token = 'B';
        }else{
            token = 'C';
        }

        switch(token){
            case 'A':
                if(income<=250000){
                    tax = 0;
                }else if((250000<income) && (income<=300000)){
                    slabIncome = income-250000;
                    tax = (slabIncome/10);
                }else if((300000<income) && (income<=500000)) {
                    slabIncome = income - 300000;
                    tax = (slabIncome/10) + 5000;
                }else if((500000<income) && (income<=1000000)){
                    slabIncome = income - 500000;
                    tax = (slabIncome/5) + 25000;
                }else {
                    slabIncome = income - 1000000;
                    tax = (slabIncome * (3/10)) + 125000;
                }
                System.out.println(tax);
                break;
            case 'B':
                if(income<=300000){
                    tax = 0;
                }else if((300000<income) && (income<=500000)) {
                    slabIncome = income - 300000;
                    tax = (slabIncome/10);
                }else if((500000<income) && (income<=1000000)){
                    slabIncome = income - 500000;
                    tax = (slabIncome/5) + 20000;
                }else {
                    slabIncome = income - 1000000;
                    tax = (slabIncome * (3/10)) + 120000;
                }
                System.out.println(tax);
                break;
            case 'C':
                if(income<=500000){
                    tax = 0;
                }else if((500000<income) && (income<=1000000)){
                    slabIncome = income - 500000;
                    tax = (slabIncome/5);
                }else {
                    slabIncome = income - 1000000;
                    tax = (slabIncome * (3/10)) + 100000;
                }
                System.out.println(tax);
                break;
            default:
                System.out.println("Enter choice within A B or C");
                break;
        }
    }
}
