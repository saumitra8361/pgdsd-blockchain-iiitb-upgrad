package com.company;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class LargeListAdd1 {

  public static void main(String[] args) {
    List<Integer> list1 = new ArrayList<Integer>();
    for(int i = 0; i < 100000; i++) {
      list1.add(i);
    }
    List<Integer> list2 = new LinkedList<Integer>();
    for(int i = 0; i < 100000; i++) {
      list2.add(i);
    }

    final long time1 = estimatePerformance(list1);
    final long time2 = estimatePerformance(list2);

    // printing result
    System.out.println("ArrayList took " + time1 + " ns.");
    System.out.println("LinkedList took " + time2 + " ns.");
    System.out.println("Linked Lists faster by a factor of " + (time1/time2) + " times!");
  }

  private static long estimatePerformance(List<Integer> list){

    //estimating List performance
    final long start = System.nanoTime();
    for(int i = 0; i<100000; i++){
        list.add(0,1);
    }
    final long end = System.nanoTime();
    final long time = end - start;
    return time;
  }
 }

/*
  SUMMARY
  =======

*/
