package com.company;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;
import java.util.Iterator;

public class WithListIterator1 {

  public static void main(String[] args) {

    List<Student9> studentList1 = new ArrayList<Student9>();
    Student9 s1 = new Student9("Sujit",1);
    Student9 s2 = new Student9("Siddharth",2);
    Student9 s3 = new Student9("Karanpreet",3);
    Student9 s4 = new Student9("Hari",5);
    Student9 s5 = new Student9("Tricha",4);

    studentList1.add(s1);
    studentList1.add(s2);
    studentList1.add(s3);
    studentList1.add(s4);
    studentList1.add(s5);

    iterateFwd(studentList1);
  }

  private static void iterateFwd(List<Student9> students) {
    ListIterator<Student9> it = students.listIterator(2);
    System.out.println("Printing student list...");
    while(it.hasNext()) {
      System.out.println(it.next().getDetails());
    }
  }
}
class Student9 {
  private final String name;
  private final int rollNumber;

  public Student9(String name, int rollNumber) {
    this.name = name;
    this.rollNumber = rollNumber;
  }

  public String getDetails() {
    return
      "name = " + this.name + '\n' +
      "roll number = " + this.rollNumber + '\n';
  }
}
