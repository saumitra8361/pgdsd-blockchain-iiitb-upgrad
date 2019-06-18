package com.company;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

public abstract class ListPQ<T> implements MyPriorityQueue<T> {
  protected final List<T> list = new ArrayList<T>();
  protected final Comparator<T> comparator;

  public ListPQ(Comparator<T> comparator) {
    this.comparator = comparator;
  }

  public boolean isEmpty() {
    return this.list.isEmpty();
  }

  public int size() {
    return this.list.size();
  }
}
