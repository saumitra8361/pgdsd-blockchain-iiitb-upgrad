package com.company;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class MeanNumbers {
    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File("F:\\UpGrad_Blockchain\\Practice Sapce and Material\\iiitb-and-upgrad-blockchain-with-software-developemnt\\object oriented programming\\quiz_meanOfNumbers.txt");

        Scanner input = new Scanner(inputFile);
        int sum=0,count=0;
        int number=0;

        while(input.hasNext()){
            number = input.nextInt();
            sum = sum + number;
            count++;
        }
        float mean = sum/count;
        System.out.println("Sum: "+sum);
        System.out.println("Number count: "+count);
        System.out.printf("%f",mean);
    }
}
