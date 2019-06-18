package com.company;
import java.util.Comparator;

public class Heap<T> implements MyPriorityQueue<T> {
  CompleteBinaryTree<T> tree;
  private Comparator<T> comparator;

  public Heap(Comparator comparator) {
    this.tree = new CompleteBinaryTree<T>(comparator);
    this.tree.add(null);
    this.comparator = comparator;
  }

  public int size() {
    return this.tree.size() - 1;
  }

  public boolean isEmpty() {
    return this.size() == 0;
  }

  public void add(T element) {
    this.tree.add(element);
    this.heapifyUp(this.tree.getLast());
  }

  public T minimum() {
    return this.tree.get(1).getKey();
  }

  public T removeMinimum() {
    this.tree.swap(this.tree.getRoot(), this.tree.getLast());
    Entry<T> entry = this.tree.remove();
    if(this.size() != 0) {
      this.heapifyDown(this.tree.getRoot());
    }
    return entry.getKey();
  }

  public void heapifyDown(Entry<T> entry) {
    Entry<T> minChild = this.tree.getMinChild(entry);
    if(minChild == null) {
      return;
    }
    if(this.comparator.compare(entry.getKey(), minChild.getKey()) > 0) {
      this.tree.swap(entry, minChild);
      this.heapifyDown(minChild);
    }
  }

  public void heapifyUp(Entry<T> entry) {
    Entry<T> parent = this.tree.getParent(entry);
    if(parent == null) {
      return;
    }
    if(this.comparator.compare(entry.getKey(), parent.getKey()) < 0) {
      this.tree.swap(entry, parent);
      this.heapifyUp(parent);
    }
  }
}

