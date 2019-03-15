package com.company;

class Student {
  private final String name;
  private int year;
  private static final int annualFees = 10000;

  public Student(String name, int year) {
    this.name       = name;
    this.year       = year;
  }

  public String getDetails() {
    return "Name : "        + name           + '\n' + 
           "Fees : "        + this.computeFees() ;
  }

  public int computeFees () {
    return Student.annualFees * year;
  }
}

class ResearchStudent extends Student{
  private static final int annualFees = 10000;
  private String researchArea;

  public ResearchStudent(String name, int year, String researchArea) {
    super(name, year);
    this.researchArea = researchArea;
  }
}


public class IandP1 {
  public static void main(String[] a) {
    Student s1 = new Student("Sujit", 2);
    System.out.println(s1.getDetails());
    ResearchStudent s2 = new ResearchStudent("siddharth", 3, "Software Engineering");
    System.out.println(s2.getDetails());
  }
}

/*
  WHAT HAVE WE LEARNED
  --------------------
  - Inheriting using extends
  - Initialising the super-class object using 'super' keyword in the sub-class's constructor.
  - The fact that the super-class's methods (e.g. getDetails) are also part of the sub-class.
*/