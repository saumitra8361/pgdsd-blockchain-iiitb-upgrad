package com.company;

import java.util.Scanner;
import java.io.FileWriter;

public class WriteFile {

    public static void main(String args[]) {

        Scanner scan = new Scanner(System.in);
        try {

            FileWriter writer = new FileWriter("F:\\UpGrad_Blockchain\\Practice Sapce and Material\\iiitb-and-upgrad-blockchain-with-software-developemnt\\object oriented programming\\WriteToFile.txt"); // Specify the path of the file where you wish to store the output of this code
            Boolean write = true;

            System.out.print("Enter what you wish to write ");
            String line = scan.nextLine(); // read the line

            // write the input line to the file.
            writer.write(line);
            writer.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Done");
    }

}
