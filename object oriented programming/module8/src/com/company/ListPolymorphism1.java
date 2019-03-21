package com.company;

import java.util.*;

public class ListPolymorphism1 {
  public static void main(String[] args) {
    List<Student8> studentList1 = new ArrayList<Student8>();
    List<Student8> studentList2 = new LinkedList<Student8>();

    Student8 s1 = new Student8("Sujit",1);
    Student8 s2 = new Student8("Siddharth",2);
    Student8 s3 = new Student8("Karanpreet",3);
    Student8 s4 = new Student8("Hari",5);
    Student8 s5 = new Student8("Tricha",4);

    studentList1.add(s1);
    studentList1.add(s2);
    studentList1.add(s3);

    studentList2.add(s4);
    studentList2.add(s5);

    printStudentList(studentList1);
    printStudentList(studentList2);


  }

  public static void printStudentList(List<Student8> students) {
    System.out.println("Printing student details.....");
    for(Student8 s : students) {
      System.out.println(s.getDetails());
    }
  }
}

class Student8 {
  private final String name;
  private final int rollNumber;

  public Student8(String name, int rollNumber) {
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

  printStudents as a polymorphic function. It uses List (which is a super-class of ArrayList and List) 
    instead of ArrayList or List, thus inter-operates smoothly with both types.
*/
