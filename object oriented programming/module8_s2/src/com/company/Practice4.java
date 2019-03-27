package com.company;

import java.util.*;

public class Practice4 {
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
        int k = s.nextInt();
        kthNodeFromEnd(k);
    }

    // Method to find kth element from the end in the LinkedList
    static void kthNodeFromEnd(int k) {
        // Write your code here
        Node temp = head;
        int length = 0;

        while(temp != null){
            temp = temp.next;
            length++;
        }

        if(k>length){
            System.out.println("Not Possible");
            return;
        }

        Node start = head;
        for(int i = 0; i < (length - k); i++){
            start = start.next;
        }
        System.out.println(start.data);
    }
}
