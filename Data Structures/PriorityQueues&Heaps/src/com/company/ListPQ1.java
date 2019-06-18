package com.company;

import java.util.Comparator;
import java.util.List;

public class ListPQ1<T> extends ListPQ<T> {

  public ListPQ1(Comparator<T> comparator) {
    super(comparator);
  }

  public void add(T element) {
    this.list.add(element);
  }

  public T removeMinimum() {
    return this.list.remove(minIndex());
  }

  public T minimum() {
    return this.list.get(0);
  }

  private int minIndex() {
    int minIndex = 0;
    T min = this.list.get(0);
    for(int i = 0; i < this.list.size(); i++) {
      T e = this.list.get(i);
      if(this.comparator.compare(e, min) < 0) {
        min = e;
        minIndex = i;
      }
    }
    return minIndex;
  }
}
