package com.company;

public class MethodOverriding {
    public static void main(String[] args){
        Rectangle2 r1 = new Rectangle2(20,20);
        r1.area();
        r1.perimeter();
        Square2 s2 = new Square2(10);
        s2.area();
        s2.perimeter();
    }
}

class Rectangle2 {
    private double width;
    private double height;

    Rectangle2(double width, double height){
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public void area() {
        System.out.println("Area of Rectangle is: " +  (width * height) ) ;
    }

    public void perimeter() {
        System.out.println("Perimeter of Rectangle is: " + ( (2* width) +
                (2* height) ) ) ;
    }
}

class Square2 extends Rectangle2{

    Square2(double side){
        super(side,side);
    }

    public void area(){
        System.out.println("Area calling overridden function: " + (super.getWidth() * super.getHeight()));
    }

    public void perimeter(){
        System.out.println("Perimeter calling overridden function: " + ( (2* super.getWidth()) +
                (2* super.getHeight()) ) ) ;
    }
}