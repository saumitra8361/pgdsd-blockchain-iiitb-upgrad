package com.company;

import java.util.*;

public class Pracice2 {
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
        deleteLastNode();
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    // Method to delete the first node of the LinkedList
    static void deleteLastNode() {
        // Write your code here
        Node temp = head, first = head, second = null;
        int count = 0;

        while(first != null) {
            second = first;
            first = first.next;
            count++;
        }

        if(count == 1){
            head = null;
            return;
        }

        while(temp.next.next != null){
            temp = temp.next;
        }
        temp.next = null;

    }
}

