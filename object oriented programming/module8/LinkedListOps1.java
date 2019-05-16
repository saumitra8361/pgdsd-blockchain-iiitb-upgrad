package com.company;

import java.util.*;

public class LinkedListOps1 {
  public static void main(String[] args) {
    LinkedList<Student7> studentList = new LinkedList<Student7>();
    Student7 s1 = new Student7("Sujit",1);
    Student7 s2 = new Student7("Siddharth",2);
    Student7 s3 = new Student7("Karanpreet",3);
    Student7 s4 = new Student7("Hari",5);
    Student7 s5 = new Student7("Tricha",4);

    studentList.add(s1);
    studentList.add(s2);
    studentList.add(s3);
    studentList.add(s4);

    studentList.remove(3);
    System.out.println("s1 contained?"+ studentList.contains(s1));
    System.out.println("s5 contained?"+ studentList.contains(s5));
    printStudentList(studentList);

  }

  public static void printStudentList(LinkedList<Student7> students) {
    for(Student7 s : students) {
      System.out.println(s.getDetails());
    }
  }
}

class Student7 {
  private final String name;
  private final int rollNumber;

  public Student7(String name, int rollNumber) {
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
