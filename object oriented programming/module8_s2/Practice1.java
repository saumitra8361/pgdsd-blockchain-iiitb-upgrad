package com.company;

import java.util.*;

public class Practice1 {
    static Node head;

    static class Node {
        int data;
        Node next;

        Node(int n) {
            data = n;
            next = null;
        }
    }

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        head = null;
        if (n > 0) {
            head = new Node(s.nextInt());
            Node temp = head;
            for (int i = 1; i < n; i++) {
                temp.next = new Node(s.nextInt());
                temp = temp.next;
            }
        }
//        int k = s.nextInt();
//        System.out.println("Is element present: "+ search(k));

//        int l = s.nextInt();
//        addAtEnd(l);

//        int m = s.nextInt();
//        int index = s.nextInt();
//        addAtGivenIndex(m, index);

//        deleteNodeAtGivenIndex(index);

        deleteLastNode();

        System.out.println("LinkedList: ");
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    // Method to search for k in the given LinkedList
    static boolean search(int k) {
        // Write your code here
        Node temp = head;
       // boolean exist = false;
        while(temp != null) {
            if(temp.data == k){
                //exist = true;
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    // Method to add the element at the end of the list
    static void addAtEnd(int l) {
        // Write your code here
        Node last = head;
        while(last.next != null){
            last = last.next;
        }
        last.next = new Node(l);
    }

    // Method to add the element at the front of the LinkedList
    static void addAtGivenIndex(int m, int index) {
        // Write your code here
        int count = 0;
        Node temp = head;

        while(temp.next != null){
            temp = temp.next;
            count++;
        }

        if(index > count){
            Node new_node = new Node(m);
            new_node.next = temp.next;
            temp.next = new_node;
            return;
        }

        temp = head;
        count = 0;
        while(count < index-1){
            temp = temp.next;
            count++;
        }
        Node new_node = new Node(m);
        new_node.next = temp.next;
        temp.next = new_node;
    }

    // Method to delete the node at the given index of the LinkedList
    static void deleteNodeAtGivenIndex(int index) {
        // Write your code here
        Node temp = head, prev = null;
        int count = 0;

        while(temp != null){
            temp = temp.next;
            count++;
        }
        if(index > count){
            System.out.println("Count: "+count + "Returning No Deletion");
            return;
        }

        temp = head;
        count = 0;
        while(count < index-1){
            prev = temp;
            temp = temp.next;
            count++;
        }
        prev.next = temp.next;
    }

    // Method to delete the first node of the LinkedList
    static void deleteLastNode() {
        // Write your code here
        Node temp = head;
        int count = 0;

        if(temp != null){
            temp = temp.next;
            count++;
        }
        System.out.println(count);
        if(count == 1){
            temp.next = null;
        }
        while(temp.next.next != null){
            temp = temp.next;
        }
        temp.next = null;

    }

}

