package com.company;

import java.util.*;

public class ArrayListOps3 {
  public static void main(String[] args) {
    ArrayList<Student6> studentList = new ArrayList<Student6>();
    Student6 s1 = new Student6("Sujit",1);
    Student6 s2 = new Student6("Siddharth",2);
    Student6 s3 = new Student6("Karanpreet",3);
    Student6 s4 = new Student6("Hari",5);
    Student6 s5 = new Student6("Tricha",4);

    studentList.add(s1);
    studentList.add(s2);
    studentList.add(s3);
    studentList.add(s4);

    printStudentList(studentList);

    System.out.println("s1 contained?"+ studentList.contains(s1));
    System.out.println("s5 contained?"+ studentList.contains(s5));

  }

  public static void printStudentList(ArrayList<Student6> students) {
    for(Student6 s : students) {
      System.out.println(s.getDetails());
    }
  }
}

class Student6 {
  private final String name;
  private final int rollNumber;

  public Student6(String name, int rollNumber) {
    this.name = name;
    this.rollNumber = rollNumber;
  }

  public String getDetails() {
    return
      "name = " + this.name + '\n' +
      "roll number = " + this.rollNumber + '\n';
  }
}

/*
  SUMMARY
  =======
  1. ArrayList Simple way to representation a dataset which is a collection of elementary data items.
  2. This is a type-safe approach of creating containers. Any attempt to add an element which is
      type-incompatible with the declared contained type will fail at the static type checking stage,
      resulting in a compile error.

*/
