package com.shankardesigner.ecare.test;

import java.util.Hashtable;
import java.util.Map;

public class HashTableEg {
    public static void main(String[] args) {
        Hashtable<String,Integer> table = new Hashtable<String, Integer>();
        table.put("pen",10);
        table.put("Book",250);
        table.put("Clothes",400);
        table.put("Mobile",5000);

        System.out.println("hasTable:- " + table);

        table.computeIfAbsent("New Book", key -> 500);
        System.out.println("table after "  + table);
    }
}
