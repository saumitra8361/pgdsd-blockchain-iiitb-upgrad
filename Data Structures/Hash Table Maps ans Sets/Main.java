package com.company;

import java.util.*;
import java.util.Hashtable;        //import HashTable API
class Main{
    public static void main(String args[]){
        Hashtable<String,Integer> contacts=new Hashtable<String,Integer>();  //HashTable API provided by java (Initialize)

        contacts.put("Ross",24434);  //put function adds value to the hash table
        contacts.put("Rachel",24244);
        contacts.put("Chandler",12444);
        contacts.put("Monica",13144);


        //to check if some key is contained by the hashtable
        System.out.println(contacts.containsKey("Chandler"));    //returns a bool value

        //Let's search for some name in this phonebook.
        System.out.println(contacts.get("Chandler")); //get function gets the value for the key sent in the function.


        Set<String> keys = contacts.keySet();	//to get all the keys present in the hash table.
        for(String key: keys){
            System.out.println("Number of "+key+" is: "+contacts.get(key));
        }

        // to remove a entry from the hashtable.
        contacts.remove("Chandler");

        System.out.println(contacts.containsKey("Chandler")); //to check if key has been removed

        contacts.clear();   // to clear the hashtable completely.
    }
}