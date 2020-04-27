package com.shankardesigner.ecare.test.overloading;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ByChangingNoOfParameter {
    public int add(int a, int b) {
        int sum = a + b;
        return sum;
    }

    public float add(float a, int b) {
        return a + b ;
    }

    public static void main(String[] args) {
        ByChangingNoOfParameter byChangingNoOfParameter = new ByChangingNoOfParameter();
        System.out.println( " with two inputs " + byChangingNoOfParameter.add(5,10));
        System.out.println( " with three inputs " + byChangingNoOfParameter.add(5,10));

        String arr [] = {"hi","mg"};

        System.out.println(Arrays.asList(arr).contains("hi"));

        System.out.println(7+1+"lamo");

        for (String i : arr) {
            if(i.contains("hi")) {
                System.out.println("found");
            }
        }
    }
}
