package com.company;

import java.lang.Comparable;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

public class Sort {

    public static void main(String[] args) {
        t1();
        t2();

    }

    public static void t1() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(300);
        list.add(500);
        list.add(100);
        list.add(400);
        list.add(200);
        list.add(600);

        class DefaultComparator<T extends Comparable> implements Comparator<T> {

            public int compare(T o1, T o2) {
                return -o1.compareTo(o2);
            }
        }


        MyPriorityQueue<Integer> pq = new Heap<Integer>(new DefaultComparator());

        while(list.isEmpty() == false) {
            pq.add(list.remove(0));
        }

        while(pq.isEmpty() == false) {
            list.add(pq.removeMinimum());
        }
        for(Integer i : list) {
            System.out.println(i);
        }
        System.out.println("");
    }


    static class Ticket {

        public static final  int ClubTicket    =  1; // highest priority
        public static final  int SeasonTicket  =  2;
        public static final  int OnlineTicket  =  3;
        public static final  int CounterTicket =  4; // lowest priority

        public final String name;
        public final int ticketType;

        public Ticket(String name, int ticketType){
            this.name = name;
            this.ticketType = ticketType;
        }
        public String toString(){
            return this.name;
        }
    }



    public static void t2() {
        List<Ticket> list = new ArrayList<Ticket>();
        list.add(new Ticket("Rashmi", Ticket.SeasonTicket));
        list.add(new Ticket("Jai", Ticket.ClubTicket));
        list.add(new Ticket("Monica", Ticket.OnlineTicket));
        list.add(new Ticket("Chander", Ticket.CounterTicket));
        list.add(new Ticket("Phani", Ticket.SeasonTicket));
        list.add(new Ticket("Rahman", Ticket.CounterTicket));

        for (Ticket a : list ) {
            System.out.println("Name: " + a.name + "   TicketType: " + a.ticketType);
        }
        System.out.println("");

        class TicketComparator<T extends Ticket> implements  Comparator<T>{
            public int compare(T o1, T o2){
                Ticket a1= (Ticket) o1;
                Ticket a2= (Ticket) o2;
                if(a1.ticketType < a2.ticketType){
                    return -1;
                }
                else if(a1.ticketType > a2.ticketType){
                    return 1;
                }
                else if(a1.ticketType == a2.ticketType){
                    return -1;
                }
                else {
                    return 0;
                }
            }
        }
        MyPriorityQueue<Ticket> pq = new Heap<Ticket>(new TicketComparator<Ticket>());

        while(list.isEmpty() == false) {
            pq.add(list.remove(0));
        }

        while(pq.isEmpty() == false) {
            list.add(pq.removeMinimum());
        }
        for(Ticket a : list) {
            System.out.println(a);
        }
        System.out.println("");
    }


}
