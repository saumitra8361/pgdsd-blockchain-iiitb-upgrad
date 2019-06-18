package com.company;

import java.lang.Comparable;

public interface MyPriorityQueue<T> {
  
  T removeMinimum();
  T minimum();
  void add(T element);
  boolean isEmpty();
  int size();
}
