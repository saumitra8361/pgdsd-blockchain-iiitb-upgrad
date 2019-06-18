package com.company;

import java.util.ArrayList;
import java.util.Comparator;

public class CompleteBinaryTree<T> {
    private final ArrayList<Entry<T>> array = new ArrayList<Entry<T>>();
    private final Comparator<T> comparator;

    public CompleteBinaryTree(Comparator comparator) {
        this.comparator = comparator;
    }

    public void add(T value) {
        this.array.add(new Entry<T>(value, this.array.size()));
    }

    public Entry<T> remove() {
        return this.array.remove(this.size() - 1);
    }

    public int size() {
        return this.array.size();
    }

    public Entry<T> get(int i) {
        return this.array.get(i);
    }

    public Entry<T> getRoot() {
        return this.array.get(1);
    }

    public Entry<T> getLast() {
        return this.array.get(this.size() - 1);
    }

    public Entry<T> getParent(Entry<T> entry) {
        if(entry.getIndex() == 1) {
            return null;
        }
        return this.array.get(entry.getIndex() / 2);
    }

    public Entry<T> getLeftChild(Entry<T> entry) {
        int pos = 2 * entry.getIndex();
        if(pos >= this.size()) {
            return null;
        }
        return this.array.get(pos);
    }

    public Entry<T> getRightChild(Entry<T> entry) {
        int pos = 2 * entry.getIndex() + 1;
        if(pos >= this.size()) {
            return null;
        }
        return this.array.get(pos);
    }

    public Entry<T> getMinChild(Entry<T> entry) {
        if(this.getRightChild(entry) == null) {
            return this.getLeftChild(entry);
        }
        else {
            if(this.comparator.compare(this.getLeftChild(entry).getKey(), this.getRightChild(entry).getKey()) <= 0) {
                return this.getLeftChild(entry);
            }
            else {
                return this.getRightChild(entry);
            }
        }
    }

    public void swap(Entry<T> e1, Entry<T> e2) {
        T key = e1.getKey();
        e1.setKey(e2.getKey());
        e2.setKey(key);
    }
}

class Entry<T> {
    private T key;
    private int index;

    public Entry(T key, int index) {
        this.key = key;
        this.index = index;
    }

    public T getKey() {
        return this.key;
    }

    public int getIndex() {
        return this.index;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String toString() {
        return "Entry(key = " + this.key + ", index = " + this.index + ")";
    }
}
