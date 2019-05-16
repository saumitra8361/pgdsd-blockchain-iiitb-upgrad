package com.company;

import java.util.ArrayList;

public class WithArrayList2 {

  public static void main (String[] args) {
    ArrayList studentList = new ArrayList();
    studentList.add(new Student2("Sujit", 1));
    studentList.add(new Student2("Siddharth", 2));
    studentList.add(new Student2("Karanpreet", 3));

    studentList.add(new Student2("Tricha", 4));
    printStudentList(studentList);
  }

  public static void printStudentList(ArrayList students) {
    for(Object o : students) {
      Student2 s = (Student2) o;
      System.out.println(s.getDetails());
    }
  }
}

class Student2 {
  private final String name;
  private final int rollNumber;

  public Student2(String name, int rollNumber) {
    this.name = name;
    this.rollNumber = rollNumber;
  }

  public String getDetails() {
    return
            "name = " + this.name + '\n' +
                    "roll number = " + this.rollNumber + '\n';
  }
}
