package com.company;

class Shape {
    public Shape() {
        super();
        System.out.println("inside Shape class default constructor");
    }
}

class Rectangle extends Shape {
    public Rectangle() {
        super();
        System.out.println("inside Rectangle class default constructor");
    }
}

class Square1 extends Rectangle {
    public Square1() {
        super();
        System.out.println("inside Square class default constructor");
    }
}

public class ConstructorChain {
    public static void main(String[] args) {
        Square1 sq = new Square1();
    }
}
