package com.company;

class Student3 {
  private final String name;
  private int year;

  private static final int annualFees = 10000;

  public Student3(String name, int year) {
    this.name       = name;
    this.year       = year;
  }

  public String getDetails() {
    return "Name : "        + name           + '\n' + 
           "Fees : "        + computeFees() ;
  }

  public int computeFees () {
    return Student3.annualFees * year;
  }
}

class ResearchStudent3 extends Student3 {
  private String researchArea;
  private static final int annualFees = 10000;

  public ResearchStudent3(String name, int year, String researchArea) {
    super(name, year);
    this.researchArea = researchArea;

  }

  @Override
  public String getDetails() {
    return super.getDetails() + '\n' + "Research Area : " + this.researchArea;
  }
}





public class IandP5 {
  public static void main(String[] a) {


    Student s1 = new Student("karan", 3);
    System.out.println(s1.getDetails());
    ResearchStudent s2 = new ResearchStudent("siddharth", 4, "Software Engineering");
    System.out.println(s2.getDetails());
  }
}

