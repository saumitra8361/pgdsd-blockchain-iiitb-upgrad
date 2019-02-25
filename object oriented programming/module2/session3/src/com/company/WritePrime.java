package com.company;

import java.util.Scanner;
import java.io.*;
import java.io.File;

public class WritePrime {

    public static void main(String args[]) {

        Scanner scan = new Scanner(System.in);
        try {

            FileWriter writer = new FileWriter("F:\\UpGrad_Blockchain\\Practice Sapce and Material\\iiitb-and-upgrad-blockchain-with-software-developemnt\\object oriented programming\\outputPrime.txt"); // Specify the path of the file where you wish to write the output
            writer.write("");
            Boolean write = true;

            for (int num = 2; num <= 1000; num++) {
                boolean primecheck = true;
                for (int i = 2; i <= Math.sqrt(num); i++) {
                    // condition for non-prime number
                    if (num % i == 0) {
                        primecheck = false;
                        break;
                    }
                }

                if (primecheck == true) {
                    writer.write(num + " "); // write this to the file.
                }
            }

            writer.close();
            
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Done");
    }
}
