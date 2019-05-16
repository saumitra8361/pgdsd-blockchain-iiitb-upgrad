package com.company;

import java.util.*;

public class ArrayListOps1 {
  public static void main(String[] args) {
    ArrayList<Student4> studentList = new ArrayList<Student4>();
    studentList.add(new Student4("Sujit", 1));
    studentList.add(new Student4("Siddharth", 2));
    // studentList.add(10,new Student("Karanpreet", 3));  // this would lead to runtime error
    studentList.add(0,new Student4("Karanpreet", 3));
    studentList.add(new Student4("Hari", 5));
    studentList.add(new Student4("Tricha", 4));


    printStudentList(studentList);
  }

  public static void printStudentList(ArrayList<Student4> students) {
    for(Student4 s : students) {
      System.out.println(s.getDetails());
    }
  }
}

class Student4 {
  private final String name;
  private final int rollNumber;

  public Student4(String name, int rollNumber) {
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
