package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GradedQuestion1 {

    // DO NOT CHANGE THIS MAIN METHOD!
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLineCoordinates = br.readLine().split(" ");
        int a1 = Integer.parseInt(firstLineCoordinates[0]);
        int b1 = Integer.parseInt(firstLineCoordinates[1]);

        String[] secondLineCoordinates = br.readLine().split(" ");
        int a2 = Integer.parseInt(secondLineCoordinates[0]);
        int b2 = Integer.parseInt(secondLineCoordinates[1]);

        Line firstLine = new Line(a1, b1);
        Line secondLine = new Line(a2, b2);

        int totalSumOfLines = getTotalSumOfLines(firstLine, secondLine);
        System.out.println(totalSumOfLines);

        br.close();
    }

    private static int getTotalSumOfLines(Line firstLine, Line secondLine) {

        // Complete this method
        int firstLineSum=0,secondLineSum=0;

        if(firstLine.getA() > firstLine.getB()){
            firstLineSum = firstLine.getA() - firstLine.getB();
        } else {
            firstLineSum = firstLine.getB() - firstLine.getA();
        }

        if(secondLine.getA() > secondLine.getB()){
            secondLineSum = secondLine.getA() - secondLine.getB();
        } else {
            secondLineSum = secondLine.getB() - secondLine.getA();
        }

        return firstLineSum + secondLineSum;
    }

    public static class Line {
        private int a;
        private int b;

        public Line(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public int getA() {
            return a;
        }

        public int getB() {
            return b;
        }
    }
}
