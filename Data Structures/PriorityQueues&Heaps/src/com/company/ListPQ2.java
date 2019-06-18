package com.company;

import java.util.Comparator;
import java.util.List;

public class ListPQ2<T> extends ListPQ<T> {

  public ListPQ2(Comparator<T> comparator) {
    super(comparator);
  }

  public void add(T element) {
    if(!this.isEmpty()) {
      for(int i = 0; i < this.list.size(); i++) {
        T e = this.list.get(i);
        if(this.comparator.compare(e, element) >= 0) {
          this.list.add(i, element);
          return;
        }
      }
    }
    this.list.add(element);
  }

  public T removeMinimum() {
    return this.list.remove(0);
  }

  public T minimum() {
    return this.list.get(0);
  }
}
